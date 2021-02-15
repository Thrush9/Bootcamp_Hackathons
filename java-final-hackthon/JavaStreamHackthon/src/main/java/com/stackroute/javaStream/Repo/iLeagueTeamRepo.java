package com.stackroute.javaStream.Repo;

import java.util.List;

import com.stackroute.javaStream.Model.LeagueTeam;
import com.stackroute.javaStream.Model.Player;
import com.stackroute.javaStream.Model.PlayerTeam;

public interface iLeagueTeamRepo {

	public List<LeagueTeam> fetchLeagueTeams();

	public List<PlayerTeam> getAllRegisteredPlayers();

	public List<PlayerTeam> registerPlayerToLeague(Player player, LeagueTeam team);

	public LeagueTeam findTeam(String teamTitle);

	public int getExistingNumberOfPlayersInTeam(String teamTitle);

}
