package com.stackroute.javaStream.Repo;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.javaStream.Model.Player;

public class PlayerTeamRepo implements iPlayerTeamRepo {

	Player dhoni, rohit, virat, dhawan, warner, rahul, samson, dk;
	static List<Player> playerList = new ArrayList<>();

	public PlayerTeamRepo() {
		dhoni = new Player("7", "Dhoni", "csk", 15);
		rohit = new Player("45", "Rohit", "mi", 8);
		virat = new Player("18", "Virat", "rcb", 10);
		dhawan = new Player("27", "Dhawan", "dc", 11);
		warner = new Player("12", "Warner", "srh", 9);
		rahul = new Player("1", "Rahul", "kxip", 6);
		samson = new Player("28", "Samson", "rr", 5);
		dk = new Player("27", "DK", "kkr", 12);
		playerList.add(dhoni);
		playerList.add(rohit);
		playerList.add(virat);
		playerList.add(dhawan);
		playerList.add(warner);
		playerList.add(rahul);
		playerList.add(samson);
		playerList.add(dk);
	}

	@Override
	public List<Player> fetchPlayers() {
		List<Player> list = playerList;
		return list;
	}

	@Override
	public Player findPlayer(String playerId) {
		Player result = playerList.stream().filter((play) -> play.getPlayerId().equalsIgnoreCase(playerId)).findAny()
				.get();
		return result;
	}

}
