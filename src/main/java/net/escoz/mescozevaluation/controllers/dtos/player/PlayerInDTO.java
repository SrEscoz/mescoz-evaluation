package net.escoz.mescozevaluation.controllers.dtos.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInDTO {

	private String name;
	private String surname;
	private Integer age;
	private String email;
	private List<String> positions;
	private Long teamId;
}
