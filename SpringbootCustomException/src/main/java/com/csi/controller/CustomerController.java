package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.signUp(customer));
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword){
        return ResponseEntity.ok(customerService.signIn(custEmailId,custPassword));
    }

    @GetMapping("/findbyid/{custID}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId){
        return ResponseEntity.ok(customerService.findById(custId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PutMapping("/update/{custId}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @RequestBody Customer customer){
        Customer customer1= customerService.findById(custId).orElseThrow(()-> new RecordNotFoundException("Customer ID does not exists:"));
        customer1.setCustName(customer.getCustName());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustPassword(customer.getCustPassword());
        customer1.setCustEmailId(customer.getCustEmailId());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAddress(customer.getCustAddress());

        return ResponseEntity.ok(customerService.update(customer1));
    }

    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String > deleteById(@PathVariable int custID){
        customerService.deleteById(custID);
        return ResponseEntity.ok("Data deleted successfully");
    }
}
