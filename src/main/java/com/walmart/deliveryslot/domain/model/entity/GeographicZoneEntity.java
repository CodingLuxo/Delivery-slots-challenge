package com.walmart.deliveryslot.domain.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "geographic_zones")
public class GeographicZoneEntity implements Serializable{

	private static final long serialVersionUID = 170509993009468704L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "township")
	private String township;
	
	@Column(name = "area")
	private String area;

	public Long getId() {
		return id;
	}

	public String getTownship() {
		return township;
	}

	public String getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "GeographicZoneEntity [id=" + id + ", township=" + township + ", area=" + area + "]";
	}
	
	
}
