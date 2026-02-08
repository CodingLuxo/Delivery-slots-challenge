package com.walmart.deliveryslot.domain.model.exceptions;

public abstract class DeliverySlotsChallengeException extends Exception {
	
	private static final long serialVersionUID = -7649260195728101705L;
	
	public DeliverySlotsChallengeException(String message) {
		super(message);
	}

}
