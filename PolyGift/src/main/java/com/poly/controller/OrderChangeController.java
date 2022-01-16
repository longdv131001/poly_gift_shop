package com.poly.controller;

import com.poly.dto.OrderChangeDTO;
import com.poly.entity.OrderChange;
import com.poly.service.OrderChangeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/rest/orderchange")
public class OrderChangeController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderChangeService orderChangeService;

    @GetMapping
    public List<OrderChangeDTO> getAllOderChange(){
        return orderChangeService.getAllOrderChange().stream().map(o -> modelMapper.map(o,OrderChangeDTO.class)).collect(Collectors.toList());
    }

    @PostMapping
    public OrderChangeDTO createOrderChange(@RequestBody OrderChangeDTO orderChangeDTO){
        OrderChange orderChange = modelMapper.map(orderChangeDTO,OrderChange.class);
        return  modelMapper.map(orderChangeService.createOrderChange(orderChange),OrderChangeDTO.class);
    }

    @PutMapping
    public OrderChangeDTO updateOrderChange(@RequestBody OrderChangeDTO orderChangeDTO){
        OrderChange orderChange = modelMapper.map(orderChangeDTO,OrderChange.class);
        return  modelMapper.map(orderChangeService.createOrderChange(orderChange),OrderChangeDTO.class);
    }

    @GetMapping("{id}")
    public List<OrderChangeDTO> getOrderChangeByOrderId(@PathVariable("id") Integer id){
        return orderChangeService.getOrderChangeByOrderId(id).stream().map(o -> modelMapper.map(o,OrderChangeDTO.class)).collect(Collectors.toList());
    }
    @DeleteMapping("{id}")
    public void deleteOrderChange(@PathVariable("id") Integer id){
        orderChangeService.deleteOrderChange(id);
    }
}
