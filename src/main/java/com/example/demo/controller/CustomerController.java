package com.example.demo.controller;

import com.example.demo.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Device;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private DeviceRepository deviceRepository;

    @GetMapping("/customer")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomers(@PathVariable("customerId") final Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) {
        final Customer customer = new Customer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
    }

    @PutMapping("/link/{customerId}/{deviceId}")
    public Device link(@PathVariable final Integer customerId, @PathVariable final Integer deviceId) {
        Device device = deviceRepository.findById(deviceId).get();
        Customer customer = customerRepository.findById(customerId).get();
        device.setCustomer(customer);
        deviceRepository.save(device);
        return device;
    }

}
