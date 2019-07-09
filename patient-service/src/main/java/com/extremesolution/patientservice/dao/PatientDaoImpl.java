package com.extremesolution.patientservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.extremesolution.patientservice.models.Doctor;
import com.extremesolution.patientservice.models.Patient;

@Repository
@Transactional
public class PatientDaoImpl implements PatientDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean regiterPatient(Patient patient) {
		Patient curPatient = em.merge(patient);

		if (curPatient != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Patient loginPatient(String username, String password) {
		String hql = "from Patient where username=:username and password=:password";
		List<Patient> patients = em.createQuery(hql, Patient.class).setParameter("username", username)
				.setParameter("password", password).getResultList();

		if (!patients.isEmpty()) {
			return patients.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Patient findPatient(String patientName) {

		String hql = "from Patient where username=:username ";
		List<Patient> patients = em.createQuery(hql, Patient.class).setParameter("username", patientName).getResultList();

		if (!patients.isEmpty()) {
			return patients.get(0);
		} else {
			return null;
		}

	}

}
