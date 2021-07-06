package com.example.Device.services;

import com.example.Device.custom_exception.DeviceIdnotFound;
import com.example.Device.custom_exception.DeviceTypeException;
import com.example.Device.entities.Device;
import com.example.Device.entities.DeviceType;
import com.example.Device.repositories.DeviceRepository;
import com.example.Device.repositories.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public DeviceType checkDeviceTypeByTitle(String title){
        try{
            DeviceType deviceType = deviceTypeRepository.findByTitle(title);
            if(deviceType != null){
                throw new DeviceTypeException("Da co Device Type");
            }
            return new DeviceType(title);
        }catch (Exception err){
            throw err;
        }
    }

    public List<Device> getDeviceByType(Integer devicetype_id){
        try{
            Optional<DeviceType> deviceType = deviceTypeRepository.findById(devicetype_id);
            List<Device> device = deviceRepository.findAllByDeviceType(deviceType);
            if(device.isEmpty()){
                throw new DeviceIdnotFound("not found");
            }
            return device;
        }catch (Exception err){
            throw err;
        }
    }
}