package com.walmart.deliveryslot.domain.service;

import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.model.exceptions.DeliverySlotsChallengeException;

public interface DeliveryOrderService {

	String placeDeliveryOrder(DeliveryOrderDto order) throws DeliverySlotsChallengeException;

}
