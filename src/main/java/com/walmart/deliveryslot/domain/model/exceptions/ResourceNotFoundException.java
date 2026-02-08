package com.walmart.deliveryslot.domain.model.exceptions;

public class ResourceNotFoundException extends DeliverySlotsChallengeException {

	private static final long serialVersionUID = -2467292437913403038L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
