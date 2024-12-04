package net.escoz.mescozevaluation.services;

import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private final PlayerRepository playerRepository;

	@Override
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayer(long id) {
		return playerRepository.findById(id)
				.orElse(null);
	}
}
