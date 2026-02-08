package com.walmart.deliveryslot.adapter.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.deliveryslot.domain.model.dto.DeliverySlotsDto;
import com.walmart.deliveryslot.domain.service.DeliverySlotService;

@RestController
@RequestMapping(value = "delivery-slots")
public class DeliverySlotsController {

	private final DeliverySlotService deliverySlotService;
	public DeliverySlotsController(DeliverySlotService deliverySlotService) {
		this.deliverySlotService = deliverySlotService;
	}
	@GetMapping(value = "geographic-zone/{geographicZoneId}")
	public Map<LocalDate, List<DeliverySlotsDto>> getGeographicZoneDeliverySlotsByDateBetween(
			@PathVariable Long geographicZoneId,
			@RequestParam String dateFrom, @RequestParam String dateTo){
		return this.deliverySlotService.findDeliverySlotsByGeographicZoneAndRange(geographicZoneId, LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
	}
}
