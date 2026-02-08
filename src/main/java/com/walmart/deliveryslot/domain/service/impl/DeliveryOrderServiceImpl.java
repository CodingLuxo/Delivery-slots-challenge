package com.walmart.deliveryslot.domain.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.walmart.deliveryslot.domain.dao.DeliveryOrderDao;
import com.walmart.deliveryslot.domain.dao.DeliverySlotDao;
import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;
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
	public String placeDeliveryOrder(DeliveryOrderDto order) {
		DeliverySlotEntity slot = this.deliverySlotDao.findSlotById(order.deliverySlotId());
		
		if(Objects.isNull(slot)) {
			throw new RuntimeException("Slot no válido");
		}
		
		if(slot.isUnavailable()) {
			throw new RuntimeException("Ya se agotaron las reservas para este horario, intenta en otro horario");
		}
		
		final String orderId = this.deliveryOrderDao.placeDeliveryOrder(order, slot);
		
		this.deliverySlotDao.decrementSlotAvailability(slot);
		
		return orderId;
	}

}
