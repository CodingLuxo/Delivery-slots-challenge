package com.walmart.deliveryslot.domain.service;

import java.util.List;

import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;

public interface GeographicZoneService {

	List<GeographicZoneDto> getGeographicZones();
}
