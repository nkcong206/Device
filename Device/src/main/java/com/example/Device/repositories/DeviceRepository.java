package com.example.Device.repositories;

import com.example.Device.entities.Device;
import com.example.Device.entities.DeviceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends CrudRepository<Device, Integer> {
    List<Device> findAllByDeviceType(Optional<DeviceType> deviceType);
}
