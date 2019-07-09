package com.extremesolution.appointmentservice.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.extremesolution.appointmentservice.models.Appointment;
import com.extremesolution.appointmentservice.models.Doctor;
import com.extremesolution.appointmentservice.services.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@CrossOrigin
	@RequestMapping(value = "/addAppointment", method = RequestMethod.POST)
	public String addAppointment(@RequestParam(value = "doctortoken") String doctortoken,
			@RequestParam(value = "appointmentdate") Date appointmentdate) {
		return appointmentService.addApointment(appointmentdate, doctortoken);
	}

	@CrossOrigin
	@RequestMapping(value = "/showAppointment", method = RequestMethod.POST)
	public List<Appointment> showAppointment(@RequestParam(value = "patienttoken") String patienttoken,
			@RequestParam(value = "doctorid") long doctorid) {
		return appointmentService.showAppointment(patienttoken, doctorid);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/patientmakeappointment", method = RequestMethod.POST)
	public String patientMakeAppointment(@RequestParam(value = "patienttoken") String patienttoken,
			@RequestParam(value = "appointmentid") long appointmentid) {
		return appointmentService.patientMakeApointment(appointmentid, patienttoken);
	}

	
}
