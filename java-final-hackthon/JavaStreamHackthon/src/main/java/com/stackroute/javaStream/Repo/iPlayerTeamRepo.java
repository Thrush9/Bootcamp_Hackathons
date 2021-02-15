package com.stackroute.javaStream.Repo;

import java.util.List;

import com.stackroute.javaStream.Model.Player;

public interface iPlayerTeamRepo {

	public List<Player> fetchPlayers();

	public Player findPlayer(String playerId);

}
