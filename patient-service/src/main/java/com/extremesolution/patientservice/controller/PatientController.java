package com.extremesolution.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolution.patientservice.models.Patient;
import com.extremesolution.patientservice.services.PatientService;

@RestController
public class PatientController {

	@Autowired
	private PatientService patientService ;
	
	
	@CrossOrigin
	@RequestMapping(value = "/registerPatient", method = RequestMethod.POST)
	public String register(@RequestParam(value = "patientname") String patientname, @RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password
			) {
		return patientService.registerPatient(patientname, email, password, username);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/loginPatient", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

		return patientService.loginPatient(username, password);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getpatientbytoken", method = RequestMethod.POST)
	public Patient checkUserByToken(@RequestParam(value = "token") String token) {

		return patientService.checkUserByToken(token);
	}
}
