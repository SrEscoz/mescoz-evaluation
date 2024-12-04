package net.escoz.mescozevaluation.mappers;

import net.escoz.mescozevaluation.controllers.dtos.player.PlayerMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamInDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamOutDTO;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import net.escoz.mescozevaluation.services.PlayerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerService.class})
public interface TeamMapper {

	TeamOutDTO toDTO(Team team);

	TeamMinOutDTO toMinDTO(Team team);

	List<TeamMinOutDTO> toMinDTOs(List<Team> teams);

	@Mapping(target = "id", ignore = true)
	Team toEntity(TeamInDTO teamInDTO);

	@Mapping(target = "team", ignore = true)
	PlayerMinOutDTO playerToPlayerMinOutDTO(Player player);

	default String mapPlayerToString(Player player) {
		if (player == null) return null;

		return player.getName();
	}
}
