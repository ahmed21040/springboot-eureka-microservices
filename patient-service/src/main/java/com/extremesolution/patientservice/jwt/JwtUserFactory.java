package com.extremesolution.patientservice.jwt;


import com.extremesolution.patientservice.models.Doctor;
import com.extremesolution.patientservice.models.Patient;





 
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static Patient create(Patient user) {
        return new Patient(
                user.getId(), user.getPatientName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword()
                );
    }

//    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
//        return authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .collect(Collectors.toList());
//    }
}
