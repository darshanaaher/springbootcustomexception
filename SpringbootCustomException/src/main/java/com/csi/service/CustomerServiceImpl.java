package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer signUp(Customer customer) {
        return customerRepo.save(customer);
    }

    public boolean signIn(String custEmailId, String custPassword) {
        boolean flag = false;
        for (Customer customer : findAll()) {
            if (customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
                flag = true;
            }
        }
        return flag;
    }

    public Optional<Customer> findById(int custId) {
        return customerRepo.findById(custId);
    }


    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    public Customer update(Customer customer){
        return customerRepo.save(customer);
    }

    public void deleteById(int custId){
        customerRepo.deleteById(custId);
    }
}
