package net.escoz.mescozevaluation.services;

import lombok.AllArgsConstructor;
import net.escoz.mescozevaluation.exceptions.NotFoundException;
import net.escoz.mescozevaluation.models.Team;
import net.escoz.mescozevaluation.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
