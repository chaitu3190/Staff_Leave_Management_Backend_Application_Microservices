package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Leave_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="staff_id")
	private int staffId;
	@Column
	private LocalDate leave_date;
	@Column
	@Enumerated(EnumType.STRING)
	private LeaveStatus leave_status;
	
	public Leave_details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave_details(int staffId, LocalDate leave_date, LeaveStatus leave_status) {
		super();
		this.staffId = staffId;
		this.leave_date = leave_date;
		this.leave_status = leave_status;
	}

	public Leave_details(int id, int staffId, LocalDate leave_date, LeaveStatus leave_status) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.leave_date = leave_date;
		this.leave_status = leave_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public LocalDate getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(LocalDate leave_date) {
		this.leave_date = leave_date;
	}

	public LeaveStatus getLeave_status() {
		return leave_status;
	}

	public void setLeave_status(LeaveStatus leave_status) {
		this.leave_status = leave_status;
	}

	@Override
	public String toString() {
		return "Leave_details [id=" + id + ", staffId=" + staffId + ", leave_date=" + leave_date + ", leave_status="
				+ leave_status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id), leave_date, leave_status, Integer.valueOf(staffId));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leave_details other = (Leave_details) obj;
		return id == other.id && Objects.equals(leave_date, other.leave_date) && leave_status == other.leave_status
				&& staffId == other.staffId;
	}

}
