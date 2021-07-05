package com.example.Device.repositories;

import com.example.Device.entities.DeviceType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeviceTypeRepository extends CrudRepository<DeviceType, Integer> {
    DeviceType findByTitle(String title);
    Optional<DeviceType> findById(Integer id);
}
