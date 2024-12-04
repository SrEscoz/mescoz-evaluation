package net.escoz.mescozevaluation.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "EQUIPOS")
public class Team {

	@Id
	@Column(name = "id_equipo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@OneToMany(mappedBy = "team")
	private Set<Player> players = new LinkedHashSet<>();

}