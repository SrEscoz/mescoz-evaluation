package net.escoz.mescozevaluation.services;

import net.escoz.mescozevaluation.models.Player;

import java.util.List;

public interface PlayerService {

	List<Player> getPlayers();

	Player getPlayer(long id);

}
