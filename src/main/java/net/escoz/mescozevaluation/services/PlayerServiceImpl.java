package net.escoz.mescozevaluation.services;

import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
import net.escoz.mescozevaluation.exceptions.UnprocessableEntityException;
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
				.orElseThrow(() -> new NotFoundException("Jugador con ID: " + id + " no encontrado"));
	}

	@Override
	public Player addPlayer(Player player) {
		try {
			return playerRepository.save(player);

		} catch (ConstraintViolationException e) {
			throw new UnprocessableEntityException(e.getConstraintViolations().iterator().next().getMessage());
		}
	}

	@Override
	public void deletePlayer(long id) {
		playerRepository.delete(getPlayer(id));
	}
}
