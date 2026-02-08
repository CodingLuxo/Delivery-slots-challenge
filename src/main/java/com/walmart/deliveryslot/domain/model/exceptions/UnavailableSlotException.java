package com.walmart.deliveryslot.domain.model.exceptions;

public class UnavailableSlotException extends DeliverySlotsChallengeException {

	private static final long serialVersionUID = -952097986970734202L;
	
	public UnavailableSlotException(String message) {
		super(message);
	}

}
