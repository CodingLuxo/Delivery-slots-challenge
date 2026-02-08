package com.walmart.deliveryslot.domain.service;

import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.model.dto.OrderPlacedDto;
import com.walmart.deliveryslot.domain.model.exceptions.DeliverySlotsChallengeException;

public interface DeliveryOrderService {

	OrderPlacedDto placeDeliveryOrder(DeliveryOrderDto order) throws DeliverySlotsChallengeException;

}
