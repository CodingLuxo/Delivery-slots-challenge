package com.walmart.deliveryslot.domain.service;

import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;

public interface DeliveryOrderService {

	String placeDeliveryOrder(DeliveryOrderDto order);

}
