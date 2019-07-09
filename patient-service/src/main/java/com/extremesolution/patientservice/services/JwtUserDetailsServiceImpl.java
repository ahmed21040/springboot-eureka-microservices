package com.extremesolution.patientservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.extremesolution.patientservice.jwt.JwtUserFactory;
import com.extremesolution.patientservice.models.Doctor;
import com.extremesolution.patientservice.models.Patient;






/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    
    
    @Autowired
    private PatientService patientService;

    @Override
    public UserDetails loadUserByUsername(String patientName) throws UsernameNotFoundException {
    	Patient user = patientService.findPatient(patientName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", patientName));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
