package net.escoz.mescozevaluation.controllers.dtos.team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerMinOutDTO;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamOutDTO {

	private long id;
	private String name;
	private List<PlayerMinOutDTO> players;
}
