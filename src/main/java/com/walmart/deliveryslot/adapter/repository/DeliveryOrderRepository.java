package com.walmart.deliveryslot.adapter.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.deliveryslot.domain.model.entity.DeliveryOrderEntity;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrderEntity, UUID> {

}
