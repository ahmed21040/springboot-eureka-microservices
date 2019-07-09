package com.extremesolution.doctorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolution.doctorservice.models.Doctor;
import com.extremesolution.doctorservice.services.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService ;
	
	
	@CrossOrigin
	@RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
	public String register(@RequestParam(value = "doctorname") String doctorname, @RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username, @RequestParam(value = "password") String password
			) {
		return doctorService.registerDoctor(doctorname, email, password, username);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/loginDoctor", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

		return doctorService.loginDoctor(username, password);
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/getdoctorbytoken", method = RequestMethod.POST)
	public Doctor checkUserByToken(@RequestParam(value = "token") String token) {

		return doctorService.checkUserByToken(token);
	}
}
