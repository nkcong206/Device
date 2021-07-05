package com.example.Device.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "devicetype")
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String title;

    @OneToMany(mappedBy="devicetype")
    private Set<Device> devices;

    public DeviceType() {
    }

    public DeviceType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
