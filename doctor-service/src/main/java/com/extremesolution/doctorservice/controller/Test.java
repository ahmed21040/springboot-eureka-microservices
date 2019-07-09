package com.extremesolution.doctorservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

	    @GetMapping("/movies")
	    public ResponseEntity<?> getMovies() {
	        return ResponseEntity.ok("ok");
	    }
}
