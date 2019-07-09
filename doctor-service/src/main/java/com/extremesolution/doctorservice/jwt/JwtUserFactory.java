package com.extremesolution.doctorservice.jwt;


import com.extremesolution.doctorservice.models.Doctor;





 
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static Doctor create(Doctor user) {
        return new Doctor(
                user.getId(), user.getDoctorName(),
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
