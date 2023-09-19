package com.example.msproduct.controller

import com.example.msproduct.dto.OrderDto
import com.example.msproduct.service.OrderService
import com.example.msproduct.service.imp.OrderServiceImp
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/orders")
class OrderController (val orderService: OrderService){

    @GetMapping
    fun findAll() : List<OrderDto>
        = orderService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id : UUID) : OrderDto
        = orderService.findById(id)

    @PostMapping
    fun create(@RequestBody orderDto: OrderDto) : OrderDto {
        println(orderDto)
        return orderService.create(orderDto)}

    @PutMapping("/{id}/addProduct")
    fun addProduct(@RequestBody orderDto: OrderDto, @PathVariable("id") id : UUID) :OrderDto
        = orderService.addProduct(orderDto, id)

    @PutMapping("/{id}/deleteProduct")
    fun deleteProduct(@RequestBody orderDto: OrderDto, @PathVariable("id") id : UUID) :OrderDto
            = orderService.deleteProduct(orderDto, id)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id : UUID)
        = orderService.delete(id)
}