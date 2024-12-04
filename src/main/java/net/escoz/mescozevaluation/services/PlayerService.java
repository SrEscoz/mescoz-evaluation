package net.escoz.mescozevaluation.services;

import net.escoz.mescozevaluation.controllers.dtos.player.PlayerInDTO;
import net.escoz.mescozevaluation.models.Player;

import java.util.List;

public interface PlayerService {

	List<Player> getPlayers();

	Player getPlayer(long id);

	Player addPlayer(Player player);

	Player updatePlayer(PlayerInDTO playerInDTO, long id);

	void deletePlayer(long id);

}
