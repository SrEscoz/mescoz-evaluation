package net.escoz.mescozevaluation.controllers.dtos.player;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerMinOutDTO {

	private long id;
	private String name;
	private Integer age;
	private String email;
	private String team;
}
