package com.extremesolution.doctorservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.extremesolution.doctorservice.jwt.JwtUserFactory;
import com.extremesolution.doctorservice.models.Doctor;






/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    
    
    @Autowired
    private DoctorService doctorService;

    @Override
    public UserDetails loadUserByUsername(String doctorName) throws UsernameNotFoundException {
        Doctor user = doctorService.findDoctor(doctorName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", doctorName));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
