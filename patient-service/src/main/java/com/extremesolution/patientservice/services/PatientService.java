package com.extremesolution.patientservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremesolution.patientservice.dao.PatientDao;
import com.extremesolution.patientservice.jwt.JwtTokenUtil;
import com.extremesolution.patientservice.models.Doctor;
import com.extremesolution.patientservice.models.Patient;

@Service
public class PatientService {

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public Patient findPatient(String patientName) {
		return patientDao.findPatient(patientName);
	}

	public String registerPatient(String patientname, String email, String password, String username) {
		// TODO Auto-generated method stub
		Patient existPatient = findPatient(username);
		if (existPatient == null) {
			Patient patient = new Patient();
			patient.setPatientName(patientname);
			patient.setEmail(email);
			patient.setUsername(username);
			patient.setPassword(password);

			boolean res = patientDao.regiterPatient(patient);

			if (res) {
				return "ok";
			} else {
				return "not Added";
			}
		} else {
			return "username exist";
		}
	}

	public String loginPatient(String username, String password) {
		// TODO Auto-generated method stub
		
		Patient patient= patientDao.loginPatient(username, password);
		if(patient!=null){
			String token = jwtTokenUtil.generateToken(patient);
			return token;
		}else{
			return "user not exist";
		}
		
		
	}

	public Patient checkUserByToken(String token) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		Patient patient =patientDao.findPatient(userName);
		
		return patient;
		
	}

}
