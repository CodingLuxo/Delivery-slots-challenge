package com.walmart.deliveryslot.application.util;

public class Messages {

	private Messages() {
		
	}
	
	public static final String UNAVAILABLE_STOCK_MESSAGE = "Ya se agotaron las reservas para este horario, por favor, intente nuevamente en otro bloque horario";
	
	public static String notValidSlotMessage(Long slotId) {
		return "El bloque horario" + slotId +"no es válido";
	}
	
	public static String notValidGeoZoneMessage(Long geographicZoneId) {
		return "No se ha encontrado una zona geográfica asociada al id : " + geographicZoneId;
	}
}
