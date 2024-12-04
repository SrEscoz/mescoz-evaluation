package net.escoz.mescozevaluation.controllers.dtos.player;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerInDTO {

	@NotBlank(message = "El nombre no ha de estar vacío")
	private String name;

	@NotBlank(message = "Los apellidos no han de estar vacíos")
	private String surname;

	@NotNull(message = "La edad no ha de estar vacía")
	private Integer age;

	@Email(message = "El email no cumple el formato")
	@NotBlank(message = "El mail no ha de estar vacío")
	private String email;

	private List<String> positions;

	private Long teamId;
}
