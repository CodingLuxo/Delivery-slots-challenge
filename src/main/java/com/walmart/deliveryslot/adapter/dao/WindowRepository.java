package com.walmart.deliveryslot.adapter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.deliveryslot.domain.model.entity.WindowEntity;

public interface WindowRepository extends JpaRepository<WindowEntity, Long> {

}
