package com.walmart.deliveryslot.domain.model.entity;

import java.io.Serializable;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "windows")
public class WindowEntity implements Serializable{

	private static final long serialVersionUID = 3419540715961650043L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "startTime")
	private LocalTime startTime;
	
	@Column(name = "endTime")
	private LocalTime endTime;

	public Long getId() {
		return id;
	}


	public LocalTime getStartTie() {
		return startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	@Override
	public String toString() {
		return "WindowEntity [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
