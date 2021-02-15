package com.stackroute.javaStream.Repo;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.javaStream.Model.LeagueTeam;
import com.stackroute.javaStream.Model.Player;
import com.stackroute.javaStream.Model.PlayerTeam;

public class LeagueTeamRepo implements iLeagueTeamRepo {

	LeagueTeam csk, mi, rcb, dc;
	PlayerTeam cskPlayer, miPlayer, rcbPlayer, dcPlayer;
	static List<LeagueTeam> teamList = new ArrayList<>();
	static List<PlayerTeam> playerTeamList = new ArrayList<>();

	public LeagueTeamRepo() {
		csk = new LeagueTeam("CSK", 2020, "13");
		mi = new LeagueTeam("MI", 2020, "13");
		rcb = new LeagueTeam("RCB", 2020, "13");
		dc = new LeagueTeam("DC", 2020, "13");
		teamList.add(csk);
		teamList.add(mi);
		teamList.add(rcb);
		teamList.add(dc);

		cskPlayer = new PlayerTeam("7", "CsK", "13", "15");
		miPlayer = new PlayerTeam("45", "MI", "13", "8");
		rcbPlayer = new PlayerTeam("18", "RCB", "13", "10");
		dcPlayer = new PlayerTeam("27", "DC", "13", "11");
		playerTeamList.add(cskPlayer);
		playerTeamList.add(miPlayer);
		playerTeamList.add(rcbPlayer);
		playerTeamList.add(dcPlayer);
	}

	@Override
	public List<LeagueTeam> fetchLeagueTeams() {
		List<LeagueTeam> list = teamList;
		return list;
	}

	@Override
	public List<PlayerTeam> getAllRegisteredPlayers() {
		List<PlayerTeam> list = playerTeamList;
		return list;
	}


	@Override
	public LeagueTeam findTeam(String teamTitle) {
		LeagueTeam search = teamList.stream().filter((team) -> team.getTeamTitle().equalsIgnoreCase(teamTitle))
				.findAny().get();
		return search;
	}
	
	@Override
	public List<PlayerTeam> registerPlayerToLeague(Player player, LeagueTeam team) {
		PlayerTeam addMember = new PlayerTeam(player.getPlayerId(), team.getTeamTitle(), team.getSeason(),
				String.valueOf(player.getYearExpr()));
		playerTeamList.add(addMember);
		return playerTeamList;
	}

	@Override
	public int getExistingNumberOfPlayersInTeam(String teamTitle) {
		Long count  = playerTeamList.stream().filter((team) -> team.getTeamTitle().equalsIgnoreCase(teamTitle)).count(); 
		int result = count.intValue();
		return result;
	}

}
