package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Customer;
import com.poly.repository.CustomerRepository;
import com.poly.request.CustomerRequest;
import com.poly.response.CustomerResponse;
import com.poly.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> mapper.map(customer, CustomerResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getByIdCustomer(Integer id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException("Customer not found", 404));
        return mapper.map(customer, CustomerResponse.class);
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = customerRepository.save(Customer.builder()
                .fullName(request.getFullName())
                .createdDate(request.getCreatedDate())
                .phoneNumber(request.getPhoneNumber())
                .group(request.getGroup())
                .build());
        return mapper.map(customer, CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(Integer id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new AppException("Customer not found", 404));
        customer.setFullName(request.getFullName());
        customer.setGroup(request.getGroup());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setCreatedDate(request.getCreatedDate());
        return mapper.map(customer, CustomerResponse.class);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
