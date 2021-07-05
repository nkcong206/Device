package com.example.Device.controller;


import com.example.Device.services.DeviceService;
import com.example.Device.custom_exception.DeviceIdnotFound;
import com.example.Device.custom_exception.DeviceTypeException;
import com.example.Device.entities.Device;
import com.example.Device.entities.DeviceType;
import com.example.Device.models.AddDeviceRequest;
import com.example.Device.models.AddDeviceTypeRequest;
import com.example.Device.models.AddDeviceTypeResponse;
import com.example.Device.repositories.DeviceRepository;
import com.example.Device.repositories.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @ExceptionHandler(DeviceTypeException.class)
    @RequestMapping(method = RequestMethod.POST, value = "/device_type")
    public ResponseEntity<AddDeviceTypeResponse> AddNewDeviceType(@RequestBody AddDeviceTypeRequest addTypeRequest) {
        try {
            //DeviceType deviceType = deviceService.checkDeviceTypeByTitle(addTypeRequest.getTitle());
            DeviceType deviceType = deviceService.checkDeviceTypeByTitle(addTypeRequest.getTitle());
            deviceTypeRepository.save(deviceType);
            AddDeviceTypeResponse response = new AddDeviceTypeResponse("Add device success");
            return ResponseEntity.status(200).body(response);
        } catch (Exception err) {
            AddDeviceTypeResponse response = new AddDeviceTypeResponse(err);
            return ResponseEntity.status(500).body(response);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/devices")
    public ResponseEntity<AddDeviceTypeResponse> AddNewDevice(@RequestBody AddDeviceRequest addDeviceRequest) {
        try{
            Optional<DeviceType> deviceType = deviceTypeRepository.findById(addDeviceRequest.getDeviceTypeId());
            Device device = new Device(addDeviceRequest.getName(), addDeviceRequest.getWattage());
            device.setDeviceType(deviceType.get());
            this.deviceRepository.save(device);
            AddDeviceTypeResponse response = new AddDeviceTypeResponse("Add device success");
            return ResponseEntity.status(200).body(response);
        }catch (Exception err){
             AddDeviceTypeResponse response = new AddDeviceTypeResponse(err);
            return ResponseEntity.status(500).body(response);
        }
    }

    @ExceptionHandler({DeviceIdnotFound.class})
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    public ResponseEntity<?> getDeviceInfor(@RequestParam Integer type) {
        try {
            List<Device> device = this.deviceService.getDeviceByType(type);
            return ResponseEntity.status(200).body(device);
        } catch (DeviceIdnotFound err) {
            return ResponseEntity.status(500).body(err.getMessage());
        }
    }
}
