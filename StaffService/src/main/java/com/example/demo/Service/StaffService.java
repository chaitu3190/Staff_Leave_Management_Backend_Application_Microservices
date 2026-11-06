package com.example.demo.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtClaimAccessor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.Staff;
import com.example.demo.Repository.StaffRepository;
import com.example.demo.dto.Login_Credentials;
import jakarta.servlet.http.HttpSession;

@Service
public class StaffService {
	
	private StaffRepository sr;
	private JwtEncoder je; 
	
	public StaffService(StaffRepository sr, JwtEncoder je) {
		super();
		this.sr = sr;
		this.je = je;
	}

	public String login(Login_Credentials lc) {
		Staff staff = sr.findByName(lc.getName()).orElse(null);
		if(staff == null) {
			return "Not Found";
		}
		if(!staff.getPassword().equals(lc.getPassword())) {
			return "Invalid Credentials";
		}
		Instant now = Instant.now();
		JwtClaimsSet claims = JwtClaimsSet.builder().issuer("staff_service").issuedAt(now).expiresAt(now.plus(30, ChronoUnit.MINUTES)).subject(String.valueOf(staff.getId())).claim("role",staff.getRole().name()).build();
		return je.encode(JwtEncoderParameters.from(org.springframework.security.oauth2.jwt.JwsHeader.with(MacAlgorithm.HS256).build(),claims)).getTokenValue();
	}
}