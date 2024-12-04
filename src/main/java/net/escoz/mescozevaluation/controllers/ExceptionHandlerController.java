package net.escoz.mescozevaluation.controllers;

import net.escoz.mescozevaluation.controllers.dtos.CustomError;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
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
		CustomError error = CustomError.builder()
				.timestamp(new Date())
				.httpCode(HttpStatus.NOT_FOUND.value())
				.message(ex.getMessage())
				.build();

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
}