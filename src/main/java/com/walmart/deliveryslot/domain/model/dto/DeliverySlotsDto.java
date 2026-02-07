package com.walmart.deliveryslot.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalTime;


public record DeliverySlotsDto(long id, LocalTime start, LocalTime end, int availability, BigDecimal price) {};
