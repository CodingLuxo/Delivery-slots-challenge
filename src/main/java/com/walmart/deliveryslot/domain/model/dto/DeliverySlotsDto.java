package com.walmart.deliveryslot.domain.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


public record DeliverySlotsDto(long id, LocalTime start, LocalTime end, int availability, BigDecimal price, @JsonIgnore LocalDate date) {};
