package com.extremesolution.appointmentservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.extremesolution.appointmentservice.models.Appointment;
import com.extremesolution.appointmentservice.models.Doctor;

@Repository
@Transactional
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceContext
	private EntityManager em;


	@Override
	public boolean addApointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
		Appointment curAppointment = em.merge(appointment);

		if (curAppointment != null) {
			return true;
		} else {
			return false;
		}

		
	}

	@Override
	public List<Appointment> showDoctorAppointment(long doctorId) {
		
		String hql = "from Appointment as a where a.doctor.id=:doctorId and  a.patient=null";
		List<Appointment> appointments = em.createQuery(hql, Appointment.class).setParameter("doctorId", doctorId).getResultList();

	
		return appointments;
	}

	@Override
	public boolean patientMakeAppointment(Appointment appointment) {
		Appointment curAppointment = em.merge(appointment);

		if (curAppointment != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Appointment findAppointment(long appointmentId) {
		// TODO Auto-generated method stub
		
		
		String hql = "from Appointment as a where a.id=:appointmentId";
		List<Appointment> appointments = em.createQuery(hql, Appointment.class).setParameter("appointmentId", appointmentId).getResultList();

	

		if (!appointments.isEmpty()) {
			return appointments.get(0);
		} else {
			return null;
		}

	}

}
