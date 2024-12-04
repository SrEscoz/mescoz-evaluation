package net.escoz.mescozevaluation.controllers.dtos.team;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamInDTO {

	@NotBlank(message = "El nombre no ha de estar vacío")
	private String name;

	private List<Long> players;

}
