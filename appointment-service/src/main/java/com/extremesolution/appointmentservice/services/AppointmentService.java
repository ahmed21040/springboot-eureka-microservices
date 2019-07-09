package com.extremesolution.appointmentservice.services;

import java.awt.Paint;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.extremesolution.appointmentservice.dao.AppointmentDao;
import com.extremesolution.appointmentservice.models.Appointment;
import com.extremesolution.appointmentservice.models.Doctor;
import com.extremesolution.appointmentservice.models.Patient;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentDao appointmentDao;

	@Autowired
	RestTemplate restTemplate;

	public String addApointment(Date appointmentDate, String doctorToken) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("token", doctorToken);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		Doctor doctor = (Doctor) restTemplate.postForObject("http://doctor-service/getdoctorbytoken", request,
				Doctor.class);

		if (doctor != null) {
			Appointment appointment = new Appointment();
			appointment.setAppointmentDate(appointmentDate);
			appointment.setDoctor(doctor);

			boolean res = appointmentDao.addApointment(appointment);

			if (res) {
				return "add successfully";
			} else {
				return "not Added";
			}
		} else {
			return "unvalid doctor";
		}
	}

	public String patientMakeApointment(long appointmentId, String patientToken) {
		
		
		Patient patient = getPatient(patientToken);

		if (patient != null) {
			
			Appointment appointment=appointmentDao.findAppointment(appointmentId);
			
			if(appointment !=null){
				appointment.setPatient(patient);
				boolean res=appointmentDao.patientMakeAppointment(appointment);
				if (res) {
					return "add successfully";
				} else {
					return "not Added";
				}
				
			}else{
				return "appointment not found";
			}
			

		} else {
			throw new RuntimeException("patient not Login");
		}
	}

	public List<Appointment> showAppointment(String patientToken, long doctorId) {

		Patient patient = getPatient(patientToken);

		if (patient != null) {
			List<Appointment> appointments = appointmentDao.showDoctorAppointment(doctorId);
			return appointments;

		} else {
			throw new RuntimeException("patient not Login");
		}

	}

	private Patient getPatient(String patientToken) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("token", patientToken);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		Patient patient = restTemplate.postForObject("http://patient-service/getpatientbytoken", request,
				Patient.class);

		return patient;
	}


}
