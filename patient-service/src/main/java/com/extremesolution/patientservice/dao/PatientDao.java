package com.extremesolution.patientservice.dao;

import com.extremesolution.patientservice.models.Doctor;
import com.extremesolution.patientservice.models.Patient;

public interface PatientDao {
	
	public boolean regiterPatient(Patient  patient);
	
	public Patient loginPatient(String username, String password);
	
	public Patient findPatient(String patientName);
	
	
	

}
