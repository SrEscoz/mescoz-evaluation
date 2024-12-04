package net.escoz.mescozevaluation.mappers;

import net.escoz.mescozevaluation.controllers.dtos.player.PlayerInDTO;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerOutDTO;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import net.escoz.mescozevaluation.services.TeamService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamService.class})
public interface PlayerMapper {

	PlayerMinOutDTO toMinOutDTO(Player player);

	PlayerOutDTO toOutDTO(Player player);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "team", source = "teamId")
	Player toEntity(PlayerInDTO playerInDTO);

	List<PlayerMinOutDTO> toMinOutDTOs(List<Player> players);

	default String mapTeamToString(Team team) {
		return team.getName();
	}
}
