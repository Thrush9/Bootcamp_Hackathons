package com.digitalcom.service;

import java.util.List;

import com.digitalcom.model.User;
import com.digitalcom.repo.DigitalcomRepository;
import com.digitalcom.repo.iDigitalcomRepo;

public class userRegistrationService implements Inter_Validate{

	 iDigitalcomRepo digitalcomrepo = new DigitalcomRepository();
	
	@Override
	public boolean IsAuthenticated(String userid, String password, String usertype) {
		boolean result = digitalcomrepo.IsAuthenticated(userid,password,usertype);
		System.out.println(result);
		return result;
	}

	@Override
	public void addUser(String name, String password, String type) {
		digitalcomrepo.addUser(name,password,type);
	}

}
