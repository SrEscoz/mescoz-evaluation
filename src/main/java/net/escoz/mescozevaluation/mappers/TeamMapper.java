package net.escoz.mescozevaluation.mappers;

import net.escoz.mescozevaluation.controllers.dtos.player.PlayerMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamOutDTO;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {

	TeamOutDTO toDTO(Team team);

	TeamMinOutDTO toMinDTO(Team team);

	List<TeamMinOutDTO> toMinDTOs(List<Team> teams);

	@Mapping(target = "team", ignore = true)
	PlayerMinOutDTO playerToPlayerMinOutDTO(Player player);

	default String mapPlayerToString(Player player) {
		return player.getName();
	}
}
