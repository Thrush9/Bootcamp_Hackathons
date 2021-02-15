package com.digitalcom.repo;

import java.util.List;
import java.util.Map;

import com.digitalcom.model.User;

public interface iDigitalcomRepo {
	
	static String[][] gamesList={{"Tubix","Danny","300"},{"FreshFood","Ram","450"},{"Batman","Kate","400"},{"Pacman","Steeve","600"}, {"YammyTommy","Narayan","350"}};

	public boolean IsAuthenticated(String userid, String password, String usertype);

	public void addUser(String name, String password, String type);
	
	public List<User> getUsersList();

	public String gameSearchinGameList(String gamename);

	public String authorSearchinGameList(String authorname);

	public void viewAllGames();

	public List<Map<String, String>> viewBasket();

}
