package com.walmart.deliveryslot.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.deliveryslot.domain.dao.GeographicZoneDao;
import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;
import com.walmart.deliveryslot.domain.service.GeographicZoneService;

@Service
public class GeographicZoneServiceImpl implements GeographicZoneService {

	private final GeographicZoneDao geographicZoneDao;
	
	public GeographicZoneServiceImpl(GeographicZoneDao geographicZoneDao) {
		this.geographicZoneDao = geographicZoneDao;
	}
	
	@Override
	public List<GeographicZoneDto> getGeographicZones() {
		return this.geographicZoneDao.getGeographicZones();
	}

}
