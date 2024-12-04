package net.escoz.mescozevaluation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "JUGADORES")
public class Player {

	@Id
	@Column(name = "id_jugador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "nombre")
	private String name;

	@NotBlank
	@Column(name = "apellidos")
	private String surname;

	@NotNull
	@Column(name = "edad", nullable = false)
	private Integer age;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;

	@ElementCollection
	@Column(name = "posicion")
	@CollectionTable(name = "POSICIONES_JUGADOR", joinColumns = @JoinColumn(name = "id_jugador"))
	private List<String> positions = new ArrayList<>();

	@JoinColumn(name = "id_equipo")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Team team;

}