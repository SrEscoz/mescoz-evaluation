package net.escoz.mescozevaluation.controllers;

import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.controllers.dtos.BasicResponse;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamOutDTO;
import net.escoz.mescozevaluation.mappers.TeamMapper;
import net.escoz.mescozevaluation.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {

	private final TeamService teamService;
	private final TeamMapper teamMapper;

	@GetMapping
	public ResponseEntity<List<TeamMinOutDTO>> getAllTeams() {
		return ResponseEntity
				.ok()
				.body(teamMapper.toMinDTOs(teamService.getTeams()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<TeamOutDTO> getTeamById(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(teamMapper.toDTO(teamService.getTeam(id)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponse> deleteTeamById(@PathVariable long id) {
		teamService.deleteTeam(id);

		return ResponseEntity
				.ok()
				.body(new BasicResponse("Equipo con ID: " + id + " eliminado"));
	}
}
