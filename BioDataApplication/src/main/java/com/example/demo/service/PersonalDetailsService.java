package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.PersonalDetails;

public interface PersonalDetailsService 
{
   PersonalDetails createPersonalDetails(PersonalDetails personalDetails);
   
   PersonalDetails getPersonalDetailsById(Integer PersonalDetailsId);
   
   List<PersonalDetails> getAllPersonalDetails();
   
   void deletePersonalDetails(Integer PersonalDetailsId); 
}
