package com.extremesolution.appointmentservice.dao;

import java.util.List;

import com.extremesolution.appointmentservice.models.Appointment;
import com.extremesolution.appointmentservice.models.Doctor;

public interface AppointmentDao {
	
	public boolean addApointment(Appointment appointment);
	
	public List<Appointment> showDoctorAppointment(long doctorId);
	
	public boolean patientMakeAppointment(Appointment appointment);
	
	public Appointment findAppointment(long appointmentId);
	
	
	

}
