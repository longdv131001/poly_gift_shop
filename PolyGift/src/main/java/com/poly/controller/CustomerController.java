package com.poly.controller;

import com.poly.dto.CustomerDTO;
import com.poly.entity.Customer;
import com.poly.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<CustomerDTO> getAllCustomer(){
        return customerService.getAllCustomer().stream().map(c -> modelMapper.map(c,CustomerDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public  CustomerDTO getOneCustomer(@PathVariable("id") Integer id){
        Customer customer = customerService.getByIdCustomer(id);
        return  modelMapper.map(customer,CustomerDTO.class);
    }

    @PostMapping
    public  CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        return  modelMapper.map(customerService.createCustomer(customer),CustomerDTO.class);
    }

    @PutMapping
    public  CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        return  modelMapper.map(customerService.updateCustomer(customer),CustomerDTO.class);
    }

    @DeleteMapping("{id}")
    public  void  deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
    }
}
