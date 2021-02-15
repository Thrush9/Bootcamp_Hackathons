package com.digitalcom.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.digitalcom.model.User;

public class DigitalcomRepository implements iDigitalcomRepo {

	User userOne, userTwo;
	static List<User> userList = new ArrayList<>();
	static String[][] games = iDigitalcomRepo.gamesList;
	static List<Map<String, String>> cartlist = new ArrayList<>();

	public DigitalcomRepository() {
		userOne = new User("John", "Doe", "user");
		userTwo = new User("Admin", "hjk", "admin");
		userList.add(userOne);
		userList.add(userTwo);
	}

	@Override
	public List<User> getUsersList() {
		List<User> list = userList;
		return list;
	}

	@Override
	public boolean IsAuthenticated(String userid, String password, String usertype) {
		boolean result = false;
		List<User> serachlist = getUsersList();
		for (User user : serachlist) {
			if (user.getUserId().equals(userid) && user.getPassword().equals(password)
					&& user.getUserType().equals(usertype))
				result = true;
		}
		return result;
	}

	@Override
	public void addUser(String name, String password, String type) {
		User newuser = newUser(name, password, type);
		userList.add(newuser);
	}

	@Override
	public String gameSearchinGameList(String gamename) {
		String result = "Display Not Found";
		for (int i = 0; i < games.length; i++) {
			if (games[i][0].equals(gamename)) {
				result = games[i][1];
				// add searched game
				addSearchedGame(games[i][0], games[i][1], games[i][2]);
			}
		}
		return result;
	}

	public User newUser(String name, String password, String type) {
		User newuser = new User(name, password, type);
		return newuser;
	}

	public void addSearchedGame(String name, String author, String cost) {
		Map<String, String> map = new HashMap<>();
		map.put("game", name);
		map.put("author", author);
		map.put("cost", cost);
		cartlist.add(map);
	}

	@Override
	public String authorSearchinGameList(String authorname) {
		String result = "Display Not Found";
		for (int i = 0; i < games.length; i++) {
			if (games[i][1].equals(authorname)) {
				result = games[i][0];
				// add searched game
				addSearchedGame(games[i][0], games[i][1], games[i][2]);
			}
		}
		return result;
	}

	@Override
	public void viewAllGames() {

		List<Map<String, String>> list = new ArrayList<>();
		for (int i = 0; i < games.length; i++) {
			Map<String, String> map = new HashMap<>();
			map.put("game", games[i][0]);
			map.put("author", games[i][1]);
			map.put("cost", games[i][2]);
			list.add(map);
		}
		for (Map<String, String> map : list) {
			for (String key : map.keySet()) {
				String value = map.get(key);
				System.out.print(key + " = " + value + " ");
			}
			System.out.print("\n");
		}
	}

	@Override
	public List<Map<String, String>> viewBasket() {
		return cartlist;
	}

}
