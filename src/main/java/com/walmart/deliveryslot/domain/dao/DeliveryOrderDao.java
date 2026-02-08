package com.walmart.deliveryslot.domain.dao;

import org.springframework.stereotype.Component;

import com.walmart.deliveryslot.adapter.repository.DeliveryOrderRepository;
import com.walmart.deliveryslot.domain.model.dto.DeliveryOrderDto;
import com.walmart.deliveryslot.domain.model.entity.DeliveryOrderEntity;
import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;

@Component
public class DeliveryOrderDao {

	private final DeliveryOrderRepository deliveryOrderRepository;
	
	public DeliveryOrderDao(DeliveryOrderRepository deliveryOrderRepository) {
		this.deliveryOrderRepository = deliveryOrderRepository;
	}
	
	public String placeDeliveryOrder(DeliveryOrderDto order, DeliverySlotEntity slot) {
		
		DeliveryOrderEntity deliveryOrder = new DeliveryOrderEntity();
		deliveryOrder.setClient(order.clientName());
		deliveryOrder.setClientAddress(order.clientAddress());
		deliveryOrder.setDeliveryDate(slot.getDate());
		deliveryOrder.setDeliveryPrice(slot.getPrice());
		deliveryOrder.setGeographicZone(slot.getGeographicZone());
		deliveryOrder.setDeliveryWindowStart(slot.getWindow().getStartTime());
		deliveryOrder.setDeliveryWindowEnd(slot.getWindow().getEndTime());

		return this.deliveryOrderRepository.save(deliveryOrder).getId().toString();
	}

}
