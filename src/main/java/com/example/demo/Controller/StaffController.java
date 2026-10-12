package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StaffService;
import com.example.demo.dto.Login_Credentials;

@RestController
public class StaffController {

	private StaffService ss;

	public StaffController(StaffService ss) {
		super();
		this.ss = ss;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> welcome(@RequestBody Login_Credentials lc) {
		String result = ss.login(lc);
		if(result.equals("Not Found") || result.equals("Invalid credentials")) {
			return ResponseEntity.status(401).body(result);
		}
		return ResponseEntity.ok(result);
	}
}
