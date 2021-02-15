package com.stackroute.javaStream.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.stackroute.javaStream.Model.LeagueTeam;
import com.stackroute.javaStream.Model.Player;
import com.stackroute.javaStream.Model.PlayerTeam;
import com.stackroute.javaStream.Repo.LeagueTeamRepo;
import com.stackroute.javaStream.Repo.PlayerTeamRepo;
import com.stackroute.javaStream.Repo.iLeagueTeamRepo;
import com.stackroute.javaStream.Repo.iPlayerTeamRepo;

public class LeagueTeamServiceImpl implements iLeagueTeamService {

	static iLeagueTeamRepo leagueService = new LeagueTeamRepo();
	static iPlayerTeamRepo playerService = new PlayerTeamRepo();

	public  List<Player> fetchPlayers() {
		List<Player> allPlayers = playerService.fetchPlayers();
		return allPlayers;
	}

	public  List<LeagueTeam> fetchLeagueTeams() {
		List<LeagueTeam> allTeams = leagueService.fetchLeagueTeams();
		return allTeams;
	}

	public  List<PlayerTeam> getAllRegisteredPlayers() {
		List<PlayerTeam> allRegPlayers = leagueService.getAllRegisteredPlayers();
		return allRegPlayers;

	}

	public List<PlayerTeam> registerPlayerToLeague(String playerId, String teamTitle) {
		Player search = playerService.findPlayer(playerId);
		LeagueTeam team = leagueService.findTeam(teamTitle);
		List<PlayerTeam> addPlayer = leagueService.registerPlayerToLeague(search,team);
		return addPlayer;
	}

	public int getExistingNumberOfPlayersInTeam(String teamTitle) {
		int result = 0;
		result = leagueService.getExistingNumberOfPlayersInTeam(teamTitle);
		return result;

	}

	public  void storePlayerTeamData(String fileName) throws IOException {
		List<PlayerTeam> allRegPlayers = leagueService.getAllRegisteredPlayers();
		fileName = "output.txt";
		FileWriter fout = new FileWriter(fileName);
		BufferedWriter bwrite = new BufferedWriter(fout);
		for (PlayerTeam player : allRegPlayers) {
			bwrite.write(player.toString());
		}
		bwrite.close();
	}
	
	
}
