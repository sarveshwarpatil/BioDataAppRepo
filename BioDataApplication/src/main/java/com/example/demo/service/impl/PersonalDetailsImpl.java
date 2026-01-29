package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonalDetails;
import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.entity.PersonalDetails;
import com.example.demo.repository.PersonalDetailsRepository;
import com.example.demo.service.PersonalDetailsService;

@Service
public class PersonalDetailsImpl implements PersonalDetailsService {

	@Autowired
	private PersonalDetailsRepository personalDetailsRepo;
	
	@Override
	public PersonalDetails createPersonalDetails(PersonalDetails personalDetails) {
		
		return personalDetailsRepo.save(personalDetails);
	}

	@Override
	public PersonalDetails getPersonalDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return personalDetailsRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Personal Details not found with id: " + id
        ));
	}

	@Override
	public List<PersonalDetails> getAllPersonalDetails() {
		// TODO Auto-generated method stub
		return personalDetailsRepo.findAll();
	}

	@Override
	public void deletePersonalDetails(Integer PersonalDetailsId) 
	{
		if (!personalDetailsRepo.existsById(PersonalDetailsId)) {
		    throw new RuntimeException("User not found");
		}
		personalDetailsRepo.deleteById(PersonalDetailsId);
	}

	

}
