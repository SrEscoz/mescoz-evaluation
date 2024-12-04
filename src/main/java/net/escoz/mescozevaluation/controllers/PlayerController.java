package net.escoz.mescozevaluation.controllers;

import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.controllers.dtos.PlayerMinOutDTO;
import net.escoz.mescozevaluation.controllers.dtos.PlayerOutDTO;
import net.escoz.mescozevaluation.mappers.PlayerMapper;
import net.escoz.mescozevaluation.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}