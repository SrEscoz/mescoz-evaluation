package net.escoz.mescozevaluation.controllers.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomError {

	private Date timestamp;
	private int httpCode;
	private String message;
}
