package com.walmart.deliveryslot.adapter.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;

@RestController
@RequestMapping(value = "geographic-zones")
public class GeographicZoneController {

	@GetMapping()
	public List<GeographicZoneDto> getGeographicZones(){
		return new ArrayList<>();
	}
}
