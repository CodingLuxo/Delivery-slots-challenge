package com.walmart.deliveryslot.domain.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.walmart.deliveryslot.domain.dao.DeliverySlotDao;
import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.service.DeliverySlotService;

@Service
public class DeliverySlotServiceImpl implements DeliverySlotService {

	private final DeliverySlotDao deliverySlotDao;
	
	public DeliverySlotServiceImpl(DeliverySlotDao deliverySlotDao) {
		this.deliverySlotDao = deliverySlotDao;
		
	}
	@Override
	public Map<LocalDate, List<DeliverySlotsDto>> findDeliverySlotsByGeographicZoneAndRange(Long geographicZone,
			LocalDate dateFrom, LocalDate dateTo) {
		
		final Map<LocalDate, List<DeliverySlotsDto>> response = new LinkedHashMap<>();
		final List<DeliverySlotsDto> deliverySlots = this.deliverySlotDao.findDeliverySlotsByGeographicZoneAndRange(geographicZone, dateFrom, dateTo);
		
		for(DeliverySlotsDto slot : deliverySlots) {
			if(Objects.isNull(response.get(slot.date()))) {
				response.put(slot.date(), new ArrayList<>());
			}
			else {
				response.get(slot.date()).add(slot);
			}
		}
		
		return response;
		
	}

}
