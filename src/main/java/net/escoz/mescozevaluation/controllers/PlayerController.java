package net.escoz.mescozevaluation.controllers;

import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerInDTO;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.player.PlayerOutDTO;
import net.escoz.mescozevaluation.mappers.PlayerMapper;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@AllArgsConstructor
public class PlayerController {

	private final PlayerService playerService;
	private final PlayerMapper playerMapper;

	@GetMapping
	public ResponseEntity<List<PlayerMinOutDTO>> getAllPlayers() {
		return ResponseEntity
				.ok()
				.body(playerMapper.toMinOutDTOs(playerService.getPlayers()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayerOutDTO> getPlayerById(@PathVariable long id) {
		return ResponseEntity
				.ok()
				.body(playerMapper.toOutDTO(playerService.getPlayer(id)));
	}

	@PostMapping
	public ResponseEntity<PlayerOutDTO> postPlayer(@RequestBody PlayerInDTO playerRequest) {
		Player player = playerMapper.toEntity(playerRequest);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(playerMapper.toOutDTO(playerService.addPlayer(player)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<BasicResponse> deletePlayerById(@PathVariable long id) {
		playerService.deletePlayer(id);

		return ResponseEntity
				.ok()
				.body(new BasicResponse("Jugador con id: " + id + " eliminado"));
	}
}