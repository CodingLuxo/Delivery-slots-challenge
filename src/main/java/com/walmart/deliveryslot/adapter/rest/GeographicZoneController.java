package com.walmart.deliveryslot.adapter.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;
import com.walmart.deliveryslot.domain.service.GeographicZoneService;

@RestController
@RequestMapping(value = "geographic-zones")
public class GeographicZoneController {

	private final GeographicZoneService geographicZoneService;
	public GeographicZoneController(GeographicZoneService geographicZoneService) {
		this.geographicZoneService = geographicZoneService;
		
	}
	@GetMapping()
	public List<GeographicZoneDto> getGeographicZones(){
		return this.geographicZoneService.getGeographicZones();
	}
}
