package com.walmart.deliveryslot.adapter.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;

import jakarta.persistence.LockModeType;

public interface DeliverySlotRepository extends JpaRepository<DeliverySlotEntity, Long> {

	@Query("SELECT dse FROM DeliverySlotEntity dse "
			+ "WHERE dse.geographicZone.id = :geographicZoneId "
			+ "AND dse.deliveryDate BETWEEN :dateFrom AND :dateTo "
			+ "ORDER BY dse.window.startTime")
	List<DeliverySlotEntity> findSlotsByGeographicZoneAndRangeBetween(Long geographicZoneId, LocalDate dateFrom, LocalDate dateTo);

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("Select dse FROM DeliverySlotEntity dse "
			+ "WHERE dse.id = :id")
	DeliverySlotEntity findAvailableSlotById(Long id);
}
