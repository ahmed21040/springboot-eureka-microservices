package com.extremesolution.doctorservice.dao;

import com.extremesolution.doctorservice.models.Doctor;

public interface DoctorDao {
	
	public boolean regiterDoctor(Doctor  doctor);
	
	public Doctor loginDoctor(String username, String password);
	
	public Doctor findDoctor(String doctorName);
	
	
	

}
