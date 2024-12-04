package net.escoz.mescozevaluation.services;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.controllers.dtos.team.TeamInDTO;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
import net.escoz.mescozevaluation.exceptions.UnprocessableEntityException;
import net.escoz.mescozevaluation.mappers.TeamMapper;
import net.escoz.mescozevaluation.models.Player;
import net.escoz.mescozevaluation.models.Team;
import net.escoz.mescozevaluation.repositories.TeamRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor(onConstructor_ = {@Lazy})
public class TeamServiceImpl implements TeamService {

	private final TeamRepository teamRepository;
	private final PlayerService playerService;

	@Lazy
	private final TeamMapper teamMapper;


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
	@Transactional
	public Team updateTeam(TeamInDTO teamInDTO, long id) {
		try {
			Team updatedTeam = teamMapper.updateTeam(getTeam(id), teamInDTO);

			for (Long playerId : teamInDTO.getPlayers()) {
				Player player = playerService.getPlayer(playerId);

				if (player.getTeam() != null) {
					throw new UnprocessableEntityException("El jugador con ID: " + player.getId() + " ya tiene equipo");

				} else {
					player.setTeam(updatedTeam);
					updatedTeam.getPlayers().add(player);
				}
			}

			return teamRepository.save(updatedTeam);

		} catch (TransactionSystemException e) {
			Throwable cause = e.getCause().getCause();

			if (cause instanceof ConstraintViolationException)
				throw new UnprocessableEntityException(((ConstraintViolationException) cause).getConstraintViolations().iterator().next().getMessage());
			else
				throw e;
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
