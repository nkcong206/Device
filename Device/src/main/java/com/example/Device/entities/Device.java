package com.example.Device.entities;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "wattage", nullable = false)
    private Integer wattage;

    @ManyToOne
    @JoinColumn(name="devicetype_id", referencedColumnName = "id", nullable=false)
    private DeviceType deviceType;


    public Device(){
    }

    public Device(String name, Integer wattage){
        this.name = name;
        this.wattage = wattage;
    }

    public Device(String name, Integer wattage, DeviceType deviceType){
        this.name = name;
        this.wattage = wattage;
        this.deviceType = deviceType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWattage() {
        return wattage;
    }

    public void setWattage(Integer wattage) {
        this.wattage = wattage;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
