package com.extremesolution.doctorservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.extremesolution.doctorservice.dao.DoctorDao;
import com.extremesolution.doctorservice.jwt.JwtTokenUtil;
import com.extremesolution.doctorservice.models.Doctor;

@Service
public class DoctorService {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public Doctor findDoctor(String doctorName) {
		return doctorDao.findDoctor(doctorName);
	}

	public String registerDoctor(String doctorname, String email, String password, String username) {
		// TODO Auto-generated method stub
		Doctor existDoctor = findDoctor(username);
		if (existDoctor == null) {
			Doctor doctor = new Doctor();
			doctor.setDoctorName(doctorname);
			doctor.setEmail(email);
			doctor.setUsername(username);
			doctor.setPassword(password);

			boolean res = doctorDao.regiterDoctor(doctor);

			if (res) {
				return "ok";
			} else {
				return "not Added";
			}
		} else {
			return "username exist";
		}
	}

	public String loginDoctor(String username, String password) {
		// TODO Auto-generated method stub
		
		Doctor doctor= doctorDao.loginDoctor(username, password);
		if(doctor!=null){
			String token = jwtTokenUtil.generateToken(doctor);
			return token;
		}else{
			return "user not exist";
		}
		
		
	}

	public Doctor checkUserByToken(String token) {
		String userName=jwtTokenUtil.getUsernameFromToken(token);
		Doctor doctor =doctorDao.findDoctor(userName);
		
		return doctor;
	}

}
