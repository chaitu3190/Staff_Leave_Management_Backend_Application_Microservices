package com.example.demo.dto;

import java.time.LocalDate;

public class Apply_Leave_Details {
	LocalDate ld;

	public Apply_Leave_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apply_Leave_Details(LocalDate ld) {
		super();
		this.ld = ld;
	}

	public LocalDate getLd() {
		return ld;
	}

	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	
}
