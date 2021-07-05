package com.example.Device.controller;

import com.example.Device.entities.Device;
import com.example.Device.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devices")

public class FindDeviceContronller {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping
    ResponseEntity<List<Device>> findAll() {
        return (ResponseEntity<List<Device>>) deviceRepository.findAll();
    }
}
