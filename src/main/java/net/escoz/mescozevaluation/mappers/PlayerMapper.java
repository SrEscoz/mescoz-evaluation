package net.escoz.mescozevaluation.mappers;

import net.escoz.mescozevaluation.controllers.dtos.PlayerMinOutDTO;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

	PlayerMinOutDTO toMinOutDTO(Player player);

	List<PlayerMinOutDTO> toMinOutDTOs(List<Player> players);

	default String mapTeamToString(Team team) {
		return team.getName();
	}
}
