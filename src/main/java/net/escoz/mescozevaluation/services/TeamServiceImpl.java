package net.escoz.mescozevaluation.services;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
import net.escoz.mescozevaluation.exceptions.UnprocessableEntityException;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import net.escoz.mescozevaluation.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;

	@Override
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

	@Override
	public Team getTeam(long id) {
		return teamRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Equipo con ID: " + id + " no encontrado"));
	}

	@Override
	@Transactional
	public Team addTeam(Team team) {
		try {
			for (Player player : team.getPlayers()) {
				if (Objects.nonNull(player.getTeam()))
					throw new UnprocessableEntityException("El jugador con ID: " + player.getId() + " ya tiene equipo");
				else
					player.setTeam(team);
			}

			return teamRepository.save(team);

		} catch (ConstraintViolationException e) {
			throw new UnprocessableEntityException(e.getConstraintViolations().iterator().next().getMessage());
		}
	}

	@Override
	public void deleteTeam(long id) {
		Team team = getTeam(id);
		team.getPlayers()
				.forEach(player -> player.setTeam(null));

		teamRepository.delete(team);
	}
}
