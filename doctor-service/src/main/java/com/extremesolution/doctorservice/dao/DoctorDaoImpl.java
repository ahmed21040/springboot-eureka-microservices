package com.extremesolution.doctorservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.extremesolution.doctorservice.models.Doctor;

@Repository
@Transactional
public class DoctorDaoImpl implements DoctorDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean regiterDoctor(Doctor doctor) {
		Doctor curDoctor = em.merge(doctor);

		if (curDoctor != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Doctor loginDoctor(String username, String password) {
		String hql = "from Doctor where username=:username and password=:password";
		List<Doctor> doctors = em.createQuery(hql, Doctor.class).setParameter("username", username)
				.setParameter("password", password).getResultList();

		if (!doctors.isEmpty()) {
			return doctors.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Doctor findDoctor(String doctorName) {

		String hql = "from Doctor where username=:username ";
		List<Doctor> doctors = em.createQuery(hql, Doctor.class).setParameter("username", doctorName).getResultList();

		if (!doctors.isEmpty()) {
			return doctors.get(0);
		} else {
			return null;
		}

	}

}
