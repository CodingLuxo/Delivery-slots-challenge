package com.walmart.deliveryslot.domain.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.model.exceptions.DeliverySlotsChallengeException;

public interface DeliverySlotService {

	Map<LocalDate, List<DeliverySlotsDto>> findDeliverySlotsByGeographicZoneAndRange(Long geographicZone, LocalDate dateFrom, LocalDate dateTo)  throws DeliverySlotsChallengeException ;
}
