package net.escoz.mescozevaluation.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerOutDTO {

	private long id;
	private String name;
	private String surname;
	private Integer age;
	private String email;
	private List<String> positions;
	private String team;
}
