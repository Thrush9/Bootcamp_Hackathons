package com.stackroute.company.service;

import java.util.List;

import com.stackroute.company.exception.AlreadyExistException;
import com.stackroute.company.exception.NotFoundException;
import com.stackroute.company.model.Company;

public interface CompanyService {

	public Company addCompany(Company company) throws AlreadyExistException;
	
	public List<Company> getComanyList();
	
	public Company findCompanyByName(String name) throws NotFoundException;
}
