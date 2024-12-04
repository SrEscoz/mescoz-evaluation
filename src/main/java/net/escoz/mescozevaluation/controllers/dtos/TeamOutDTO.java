package net.escoz.mescozevaluation.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamOutDTO {

	private long id;
	private String name;
	private List<PlayerMinOutDTO> players;
}
