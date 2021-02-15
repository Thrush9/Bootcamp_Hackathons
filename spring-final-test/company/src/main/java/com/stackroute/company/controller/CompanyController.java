package com.stackroute.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.company.exception.AlreadyExistException;
import com.stackroute.company.exception.NotFoundException;
import com.stackroute.company.model.Company;
import com.stackroute.company.service.CompanyService;

@RestController
@RequestMapping("/mytest/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping("/addCompany")
	public ResponseEntity<?> addCompany(@RequestBody() Company company){
		try {
			Company addedComp = companyService.addCompany(company);
			return new ResponseEntity<Company>(addedComp,HttpStatus.CREATED);
		} catch (AlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<?> getAllCompanies(){
		try {
			List<Company> companies = companyService.getComanyList();
			return new ResponseEntity<List<Company>>(companies,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/viewByName/{cname}")
	public ResponseEntity<?> getCompanyByName(@PathVariable("cname") String name){
		try {
			Company search = companyService.findCompanyByName(name);
			return new ResponseEntity<Company>(search,HttpStatus.OK);
		} catch (NotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

}
