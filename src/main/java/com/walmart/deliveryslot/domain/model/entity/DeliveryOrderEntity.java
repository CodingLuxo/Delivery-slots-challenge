package com.walmart.deliveryslot.domain.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_orders")
public class DeliveryOrderEntity implements Serializable {

	private static final long serialVersionUID = 7434710760172855829L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "client",nullable = false)
	private String client;
	
	@Column(name="delivery_date",nullable = false)
	private LocalDate deliveryDate;
	
	@Column(name = "delivery_window_start",nullable = false)
	private LocalTime deliveryWindowStart;
	
	@Column(name = "delivery_window_end",nullable = false)
	private LocalTime deliveryWindowEnd;
	
	@Column(name = "client_address")
	private String clientAddress;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "geographic_zone_id", referencedColumnName = "id")
	private GeographicZoneEntity geographicZone;
	
	@Column(name = "delivery_price")
	private BigDecimal deliveryPrice;
	
	@Column(name = "date_created")
	private LocalDateTime dateCreated;

	public UUID getId() {
		return this.id;
	}
	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalTime getDeliveryWindowStart() {
		return deliveryWindowStart;
	}

	public void setDeliveryWindowStart(LocalTime deliveryWindowStart) {
		this.deliveryWindowStart = deliveryWindowStart;
	}

	public LocalTime getDeliveryWindowEnd() {
		return deliveryWindowEnd;
	}

	public void setDeliveryWindowEnd(LocalTime deliveryWindowEnd) {
		this.deliveryWindowEnd = deliveryWindowEnd;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public GeographicZoneEntity getGeographicZone() {
		return geographicZone;
	}

	public void setGeographicZone(GeographicZoneEntity geographicZone) {
		this.geographicZone = geographicZone;
	}

	public BigDecimal getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(BigDecimal deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	@PrePersist
	void prePersist() {
		this.dateCreated = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "DeliveryOrderEntity [id=" + id + ", client=" + client + ", deliveryDate=" + deliveryDate
				+ ", deliveryWindowStart=" + deliveryWindowStart + ", deliveryWindowEnd=" + deliveryWindowEnd
				+ ", clientAddress=" + clientAddress + ", geographicZone=" + geographicZone + ", deliveryPrice="
				+ deliveryPrice + "]";
	}
}
