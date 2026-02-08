package com.walmart.deliveryslot.adapter.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.service.DeliveryOrderService;

@RestController
@RequestMapping(value="delivery-order")
public class DeliveryOrderController {

	private final DeliveryOrderService deliveryOrderService;
	public DeliveryOrderController(DeliveryOrderService deliveryOrderService) {
		this.deliveryOrderService = deliveryOrderService;
	}
	
	@PostMapping()
	@ResponseStatus(value = HttpStatus.CREATED)
	public String placeDeliveryOrder(@RequestBody DeliveryOrderDto order) {
		return this.deliveryOrderService.placeDeliveryOrder(order);
	}
}
