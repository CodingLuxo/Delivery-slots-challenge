package com.walmart.deliveryslot.domain.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.walmart.deliveryslot.adapter.repository.DeliverySlotRepository;
import com.walmart.deliveryslot.domain.converter.DeliverySlotsConverter;
import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;

@Component
public class DeliverySlotDao {

	private final DeliverySlotRepository deliverySlotRepository;
	
	public DeliverySlotDao(DeliverySlotRepository deliverySlotRepository) {
		this.deliverySlotRepository = deliverySlotRepository;
	}
	
	public List<DeliverySlotsDto> findDeliverySlotsByGeographicZoneAndRange(Long geographicZoneId, LocalDate dateFrom, LocalDate dateTo){
		
		List<DeliverySlotEntity> slots = this.deliverySlotRepository.findSlotsByGeographicZoneAndRangeBetween(geographicZoneId, dateFrom, dateTo);
		
		return slots.stream()
				.filter(DeliverySlotEntity::hasAValidWindow)
				.map(DeliverySlotsConverter::fromEntityToDto)
				.toList();
	}
	
	public DeliverySlotEntity findSlotById(Long id) {
		return this.deliverySlotRepository.findAvailableSlotById(id);
	}
	
	public void decrementSlotAvailability(DeliverySlotEntity entity) {
		entity.decrementAvailability();
		this.deliverySlotRepository.save(entity);
	}
}
