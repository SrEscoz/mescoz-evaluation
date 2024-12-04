package net.escoz.mescozevaluation.controllers;

import net.escoz.mescozevaluation.controllers.dtos.CustomError;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
import net.escoz.mescozevaluation.exceptions.UnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {NotFoundException.class})
	protected ResponseEntity<CustomError> handleNotFoundException(NotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(buildCustomError(HttpStatus.NOT_FOUND, ex.getMessage()));
	}

	@ExceptionHandler(value = {UnprocessableEntityException.class})
	protected ResponseEntity<CustomError> handleUnprocessableEntityException(UnprocessableEntityException ex) {
		return ResponseEntity
				.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(buildCustomError(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage()));
	}

	private CustomError buildCustomError(HttpStatus status, String message) {
		return CustomError.builder()
				.timestamp(new Date())
				.httpCode(status.value())
				.message(message)
				.build();
	}
}
