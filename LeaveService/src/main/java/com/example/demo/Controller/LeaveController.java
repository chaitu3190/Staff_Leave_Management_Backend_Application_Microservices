package com.example.demo.Controller;

import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Leave_details;
import com.example.demo.Service.LeaveService;
import com.example.demo.dto.Apply_Leave_Details;
import com.example.demo.dto.UpdateStatus;


@RestController
@RequestMapping("/login")
public class LeaveController {
	
	LeaveService ls;
	
    public LeaveController(LeaveService ls) {
		this.ls = ls;
	}

	@PostMapping("/apply")
	public String applyleave(@AuthenticationPrincipal Jwt jwt, @RequestBody Apply_Leave_Details ald) {
		int staffId = Integer.parseInt(jwt.getSubject());
		return ls.applyleave(staffId, ald.getLd());
	}
	
	@GetMapping("/viewleavestatus")
	public List<Leave_details> viewleavestatus(@AuthenticationPrincipal Jwt jwt) {
		int staffId = Integer.parseInt(jwt.getSubject());
		return ls.viewleavestatus(staffId);
	}
	
	@GetMapping("/viewallleaverequests")
	public List<Leave_details> viewallleaverequests() {
		return ls.viewallleaverequests();
	}
	
	@PutMapping("/updateleave")
	public String updateleavestatus(@RequestBody UpdateStatus us) {
		return ls.updatestatus(us.getId(), us.getLeave_status());
	}
}
