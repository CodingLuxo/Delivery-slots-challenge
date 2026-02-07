package com.walmart.deliveryslot.domain.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="delivery_slots")
public class DeliverySlotEntity implements Serializable  {

	private static final long serialVersionUID = -2708042687193589882L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JoinColumn(name = "geographic_zone_id",referencedColumnName = "id")
	@ManyToOne(optional = false)
	private GeographicZoneEntity geographicZone;
	
	@JoinColumn(name = "window_id",referencedColumnName = "id")
	@ManyToOne(optional = false)
	private WindowEntity window;
	
	@Column(name = "delivery_date",nullable = false)
	private LocalDate deliveryDate;
	
	@Column(name = "availability",nullable = false)
	private Integer availability;
	
	@Column(name = "price")
	private BigDecimal price;

	public Long getId() {
		return id;
	}

	public GeographicZoneEntity getGeographicZone() {
		return geographicZone;
	}

	public WindowEntity getWindow() {
		return window;
	}

	public LocalDate getDate() {
		return deliveryDate;
	}

	public Integer getAvailability() {
		return availability;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "DeliverySlotEntity [id=" + id + ", geographicZone=" + geographicZone + ", window=" + window + ", date="
				+ deliveryDate + ", availability=" + availability + ", price=" + price + "]";
	}
	
	
	
}
