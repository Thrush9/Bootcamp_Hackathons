package com.stackroute.javaStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.stackroute.javaStream.Model.LeagueTeam;
import com.stackroute.javaStream.Model.Player;
import com.stackroute.javaStream.Model.PlayerTeam;
import com.stackroute.javaStream.Service.LeagueTeamServiceImpl;

public class LeagueTeamServiceImplTests {

	private LeagueTeamServiceImpl ServiceImpl;

	private List<LeagueTeam> teamList;
	private static List<PlayerTeam> ptList;
	private List<Player> playerList;
	LeagueTeam csk, mi, rcb, dc;
	PlayerTeam cskPlayer, miPlayer, rcbPlayer, dcPlayer;
	Player dhoni, rohit, virat, dhawan, warner, rahul, samson, dk;

	@BeforeEach
	public void setUp() {
		teamList = new ArrayList<>();
		ptList = new ArrayList<>();
		playerList = new ArrayList<>();
		ServiceImpl = new LeagueTeamServiceImpl();

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
		ptList.add(cskPlayer);
		ptList.add(miPlayer);
		ptList.add(rcbPlayer);
		ptList.add(dcPlayer);
	}

	@AfterEach
	public void tearDown() {
		teamList = new ArrayList<>();
		ptList = new ArrayList<>();
		playerList = new ArrayList<>();
		ServiceImpl = null;
	}
	
	@Test
	public void getPlayersListSuccess() {
		assertEquals(playerList.toString(), ServiceImpl.fetchPlayers().toString(), "All Players Should be Listed");
	}
	
	@Test
	public void getTeamsListSuccess() {
		assertEquals(teamList.toString(), ServiceImpl.fetchLeagueTeams().toString(), "All Teams Should be Listed");
	}
	
	@Test
	public void getRegPlayersListSuccess() {
		assertEquals(ptList.toString(), ServiceImpl.getAllRegisteredPlayers().toString(), "All Reg Team Players Should be Listed");
	}
	
	@Test
	public void getPlayersCountSuccess() {
		assertEquals(1, ServiceImpl.getExistingNumberOfPlayersInTeam("RCB"), "Return no of players in team");
	}
	
//	@Test
//	public void getAddPlayerSuccess() {
//		PlayerTeam addplayer = new PlayerTeam("1", "RCB", "13", "6");
//		List<PlayerTeam> test = ptList ;
//		test.add(addplayer);
//		assertEquals(test.toString(), ServiceImpl.registerPlayerToLeague("1", "RCB").toString(), "Added Player Should reflect in list");
//	}

}
