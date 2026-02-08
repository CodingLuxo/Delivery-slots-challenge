package com.walmart.deliveryslot.adapter.rest;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.walmart.deliveryslot.adapter.rest.model.ErrorResponse;
import com.walmart.deliveryslot.domain.model.exceptions.ResourceNotFoundException;
import com.walmart.deliveryslot.domain.model.exceptions.UnavailableSlotException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("RESOURCE_NOT_FOUND", 404, ex.getMessage()), HttpStatusCode.valueOf(404));
    }
    
    @ExceptionHandler(UnavailableSlotException.class)
    public ResponseEntity<ErrorResponse> handleUnavailableSlotException(UnavailableSlotException ex, HttpServletRequest request) {
    	return new ResponseEntity<ErrorResponse>(new ErrorResponse("UNAVAILABLE_DELIVERY_SLOT", 422, ex.getMessage()),HttpStatusCode.valueOf(422));
    }
}
