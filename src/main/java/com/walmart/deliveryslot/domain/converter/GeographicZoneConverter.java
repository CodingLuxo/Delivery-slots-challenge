package com.walmart.deliveryslot.domain.converter;

import com.walmart.deliveryslot.domain.model.dto.GeographicZoneDto;
import com.walmart.deliveryslot.domain.model.entity.GeographicZoneEntity;

public class GeographicZoneConverter {

	public static GeographicZoneDto fromEntityToDto(GeographicZoneEntity entity) {
		return new GeographicZoneDto(entity.getId(), entity.getTownship(), entity.getArea());
	}
}
