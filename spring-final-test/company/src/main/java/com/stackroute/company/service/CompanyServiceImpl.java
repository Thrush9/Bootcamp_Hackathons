package com.stackroute.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.company.exception.AlreadyExistException;
import com.stackroute.company.exception.NotFoundException;
import com.stackroute.company.model.Company;
import com.stackroute.company.respository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepo;
	
	@Override
	public Company addCompany(Company company) throws AlreadyExistException {
		Company added = null;
		Optional<Company> search = companyRepo.findById(company.getId());
		if(search.isPresent()) {
			throw new AlreadyExistException("Company Already Exists");
		}else {
		added = companyRepo.save(company);
		}
		return added;
	}

	@Override
	public List<Company> getComanyList() {
		List<Company> companies = companyRepo.findAll();
		return companies;
	}

	@Override
	public Company findCompanyByName(String name) throws NotFoundException {
		Company search = companyRepo.findByCompanyname(name);
		if (search != null) {
		return search;
		} else {
			throw new NotFoundException("Search Company Not Found");
		}
	}

}
