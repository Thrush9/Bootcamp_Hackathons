package com.digitalcom.service;

import java.util.List;
import java.util.Map;

import com.digitalcom.repo.DigitalcomRepository;
import com.digitalcom.repo.iDigitalcomRepo;

public class UserService implements iUserService {

	iDigitalcomRepo digitalcomrepo = new DigitalcomRepository();

	@Override
	public String gameSearch(String gamename) {
		String result = digitalcomrepo.gameSearchinGameList(gamename);
		return result;
	}

	@Override
	public String authorSearch(String authorname) {
		String result = digitalcomrepo.authorSearchinGameList(authorname);
		return result;
	}

	@Override
	public void viewAll() {
		digitalcomrepo.viewAllGames();
	}

	@Override
	public void viewBasket() {
		List<Map<String, String>> basketList = digitalcomrepo.viewBasket();
		if (!basketList.isEmpty()) {
			for (Map<String, String> map : basketList) {
				for (String key : map.keySet()) {
					String value = map.get(key);
					System.out.print(key + " = " + value + " ");
				}
				System.out.print("\n");
			}
		} else {
			System.out.println("No searched Games to show!");
		}
	}

}
