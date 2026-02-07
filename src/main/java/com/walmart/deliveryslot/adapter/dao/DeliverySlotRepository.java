package com.walmart.deliveryslot.adapter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.deliveryslot.domain.model.entity.DeliverySlotEntity;

public interface DeliverySlotRepository extends JpaRepository<DeliverySlotEntity, Long> {

}
