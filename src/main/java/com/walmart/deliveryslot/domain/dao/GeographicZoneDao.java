package com.walmart.deliveryslot.domain.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.walmart.deliveryslot.adapter.repository.GeographicZoneRepository;
import com.walmart.deliveryslot.domain.converter.GeographicZoneConverter;
import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;
import com.walmart.deliveryslot.domain.model.entity.GeographicZoneEntity;

@Component
public class GeographicZoneDao {

	private final GeographicZoneRepository geographicZoneRepository;
	
	public GeographicZoneDao(GeographicZoneRepository geographicZoneRepository) {
		this.geographicZoneRepository = geographicZoneRepository;
	}

	public List<GeographicZoneDto> getGeographicZones() {
		List<GeographicZoneDto> response = new ArrayList<>();
		List<GeographicZoneEntity> result = this.geographicZoneRepository.findAll();
		
		for(GeographicZoneEntity entity : result) {
			response.add(GeographicZoneConverter.fromEntityToDto(entity));
		}
		
		return response;
	}
	
	public boolean isAValidGeographicZone(Long geographicZoneId) {
		return this.geographicZoneRepository.existsById(geographicZoneId);
	}
}
