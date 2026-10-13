package com.example.demo.Service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.example.demo.dto.UpdateStatus;

@Service
public class AdminService {
	private RestClient restClient;
	
	public AdminService(RestClient.Builder builder) {
		this.restClient = builder.baseUrl("http://localhost:8082").build();
	}
	
	public ResponseEntity<String> viewallleaverequests(String token) {
		try {
			String response = restClient.get().uri("/login/viewallleaverequests").header(HttpHeaders.AUTHORIZATION, token).retrieve().body(String.class);
			return ResponseEntity.ok(response);
		} catch(HttpClientErrorException.Unauthorized e) {
			return ResponseEntity.status(401).body("Invalid or Expired token");
		} catch(HttpClientErrorException.Forbidden e) {
			return ResponseEntity.status(403).body("You are not authorized to view all leave requests");
		}
	}
	
	public ResponseEntity updateleavestatus(String token, UpdateStatus us) {
		try {
			String response = restClient.put().uri("/login/updateleave").header(HttpHeaders.AUTHORIZATION,token).body(us).retrieve().body(String.class);
		    return ResponseEntity.ok(response);
		} catch(HttpClientErrorException.Unauthorized e) {
			return ResponseEntity.status(401).body("Invalid or Expired token");
		} catch(HttpClientErrorException e) {
			return ResponseEntity.status(403).body("You are not authorized to update leave status");
		}
	}
}
