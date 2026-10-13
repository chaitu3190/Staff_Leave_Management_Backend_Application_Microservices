package com.example.demo.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AdminService;
import com.example.demo.dto.UpdateStatus;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private AdminService as;

	public AdminController(AdminService as) {
		super();
		this.as = as;
	}
	
	@GetMapping("/viewallleaverequests")
	public ResponseEntity<String> viewallleaverequests(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
		return as.viewallleaverequests(token);
	}
	
	@PutMapping("/updateleavestatus")
	public ResponseEntity<String>updateleavestatus(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestBody UpdateStatus us) {
		return as.updateleavestatus(token,us);
	}
}
