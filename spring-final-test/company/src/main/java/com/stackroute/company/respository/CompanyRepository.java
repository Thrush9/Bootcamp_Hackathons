package com.stackroute.company.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.company.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
	
	public Company findByCompanyname(String name);

}
