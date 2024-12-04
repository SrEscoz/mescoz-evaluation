package net.escoz.mescozevaluation.services;

import net.escoz.mescozevaluation.models.Team;

import java.util.List;

public interface TeamService {

	List<Team> getTeams();

	Team getTeam(long id);

	Team addTeam(Team team);

	void deleteTeam(long id);
}
