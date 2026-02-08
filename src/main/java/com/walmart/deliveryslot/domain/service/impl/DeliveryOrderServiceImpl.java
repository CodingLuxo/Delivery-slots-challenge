package com.walmart.deliveryslot.domain.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.walmart.deliveryslot.application.util.Messages;
import com.walmart.deliveryslot.domain.dao.DeliveryOrderDao;
import com.walmart.deliveryslot.domain.dao.DeliverySlotDao;
import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.model.dto.OrderPlacedDto;
import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;
import com.walmart.deliveryslot.domain.model.exceptions.DeliverySlotsChallengeException;
import com.walmart.deliveryslot.domain.model.exceptions.ResourceNotFoundException;
import com.walmart.deliveryslot.domain.model.exceptions.UnavailableSlotException;
import com.walmart.deliveryslot.domain.service.DeliveryOrderService;

import jakarta.transaction.Transactional;

@Service
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

	private final DeliverySlotDao deliverySlotDao;
	private final DeliveryOrderDao deliveryOrderDao;
	
	public DeliveryOrderServiceImpl(DeliverySlotDao deliverySlotDao,DeliveryOrderDao deliveryOrderDao) {
		this.deliverySlotDao = deliverySlotDao;
		this.deliveryOrderDao = deliveryOrderDao;
	}
	
	@Override
	@Transactional
	public OrderPlacedDto placeDeliveryOrder(DeliveryOrderDto order) throws DeliverySlotsChallengeException {
		DeliverySlotEntity slot = this.deliverySlotDao.findSlotById(order.deliverySlotId());
		
		if(Objects.isNull(slot)) {
			throw new ResourceNotFoundException(Messages.notValidSlotMessage(order.deliverySlotId()));
		}
		
		if(slot.isUnavailable()) {
			throw new UnavailableSlotException(Messages.UNAVAILABLE_STOCK_MESSAGE);
		}
		
		final String orderId = this.deliveryOrderDao.placeDeliveryOrder(order, slot);
		
		this.deliverySlotDao.decrementSlotAvailability(slot);
		
		return new OrderPlacedDto(orderId);
	}
	
}
