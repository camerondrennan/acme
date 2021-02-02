package com.example.demo.controller;

import com.example.demo.model.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/device")
    public Iterable<Device> getDevices() {
        return deviceRepository.findAll();
    }

    @PostMapping("/device/{name}")
    public Device addDevice(@PathVariable final String name) {
        return deviceRepository.save(new Device(name));
    }
}
