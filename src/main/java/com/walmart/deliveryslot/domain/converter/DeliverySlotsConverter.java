package com.walmart.deliveryslot.domain.converter;

import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;

public class DeliverySlotsConverter {

	public static DeliverySlotsDto fromEntityToDto(DeliverySlotEntity entity) {	
		return new DeliverySlotsDto(entity.getId(), entity.getWindow().getStartTime(), entity.getWindow().getEndTime(), entity.getAvailability(), entity.getPrice(),entity.getDate());
	}
}
