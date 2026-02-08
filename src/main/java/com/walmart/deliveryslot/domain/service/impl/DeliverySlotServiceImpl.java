package com.walmart.deliveryslot.domain.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.walmart.deliveryslot.application.util.Messages;
import com.walmart.deliveryslot.domain.dao.DeliverySlotDao;
import com.walmart.deliveryslot.domain.dao.GeographicZoneDao;
import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.model.exceptions.DeliverySlotsChallengeException;
import com.walmart.deliveryslot.domain.model.exceptions.ResourceNotFoundException;
import com.walmart.deliveryslot.domain.service.DeliverySlotService;

@Service
public class DeliverySlotServiceImpl implements DeliverySlotService {

	private final DeliverySlotDao deliverySlotDao;
	private final GeographicZoneDao geographicZoneDao;
	
	public DeliverySlotServiceImpl(DeliverySlotDao deliverySlotDao,GeographicZoneDao geographicZoneDao) {
		this.deliverySlotDao = deliverySlotDao;
		this.geographicZoneDao = geographicZoneDao;
		
	}
	@Override
	public Map<LocalDate, List<DeliverySlotsDto>> findDeliverySlotsByGeographicZoneAndRange(Long geographicZone,
			LocalDate dateFrom, LocalDate dateTo) throws DeliverySlotsChallengeException {
		
		this.validateGeographicZone(geographicZone);
		final Map<LocalDate, List<DeliverySlotsDto>> response = new LinkedHashMap<>();
		final List<DeliverySlotsDto> deliverySlots = this.deliverySlotDao.findDeliverySlotsByGeographicZoneAndRange(geographicZone, dateFrom, dateTo);
		
		for(DeliverySlotsDto slot : deliverySlots) {
			if(Objects.isNull(response.get(slot.date()))) {
				List<DeliverySlotsDto> dateSlotList = new ArrayList<>();
				dateSlotList.add(slot);
				response.put(slot.date(), dateSlotList);
			}
			else {
				response.get(slot.date()).add(slot);
			}
		}
		
		return response;
		
	}
	
	private void validateGeographicZone(Long geographicZone) throws ResourceNotFoundException {
		final boolean validatedZone = this.geographicZoneDao.isAValidGeographicZone(geographicZone);
		if(!validatedZone) {
			throw new ResourceNotFoundException(Messages.notValidGeoZoneMessage(geographicZone));  
		}
	}

}
