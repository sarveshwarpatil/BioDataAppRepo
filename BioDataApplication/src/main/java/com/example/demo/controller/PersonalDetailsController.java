package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.PersonalDetails;
import com.example.demo.service.PersonalDetailsService;

@RestController
@RequestMapping("api/pd")
public class PersonalDetailsController 
{
	@Autowired
	private PersonalDetailsService personalDetailsService;
	
	@PostMapping("/create")
	public ResponseEntity<PersonalDetails> createPersonalDetails( @RequestBody PersonalDetails personalDetails)
	{
		//System.out.println(1/0);
		return ResponseEntity.ok(personalDetailsService.createPersonalDetails(personalDetails));
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PersonalDetails> getPersonalDetailsById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(personalDetailsService.getPersonalDetailsById(id));
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<PersonalDetails>> getAllPersonalDetails()
	{
		return ResponseEntity.ok(personalDetailsService.getAllPersonalDetails());
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<PersonalDetails> deletePersonalDetailsById(@PathVariable("id") Integer id)
	{
		personalDetailsService.deletePersonalDetails(id);
		System.out.println("Details are deleted successfuly");
		return ResponseEntity.badRequest().build();
		
	}
	
	
	
}
