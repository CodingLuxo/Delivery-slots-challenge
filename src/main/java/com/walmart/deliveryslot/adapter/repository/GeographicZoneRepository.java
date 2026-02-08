package com.walmart.deliveryslot.adapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.deliveryslot.domain.model.entity.GeographicZoneEntity;

public interface GeographicZoneRepository extends JpaRepository<GeographicZoneEntity, Long>{

}
