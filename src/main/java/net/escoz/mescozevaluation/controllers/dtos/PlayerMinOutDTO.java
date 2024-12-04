package net.escoz.mescozevaluation.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerMinOutDTO {

	private long id;
	private String name;
	private Integer age;
	private String email;
	private String team;
}
