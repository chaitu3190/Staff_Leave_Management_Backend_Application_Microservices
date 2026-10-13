package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.LeaveStatus;
import com.example.demo.Entity.Leave_details;
import com.example.demo.Repository.Leave_DetailsRepository;

@Service
public class LeaveService {
	
	private Leave_DetailsRepository ldr;
	
	public LeaveService(Leave_DetailsRepository ldr) {
		this.ldr = ldr;
	}
	
	public String applyleave(int staffId, LocalDate date) {
		if(date == null) {
			return "Levae date is required";
		}
		
		Leave_details ld = new Leave_details();
		
		ld.setStaffId(staffId);
		ld.setLeave_date(date);
		ld.setLeave_status(LeaveStatus.PENDING);
		
		ldr.save(ld);
		return "Leave Applied Successfully";
	}
	
	public List<Leave_details> viewleavestatus(int staffId) {
		return ldr.findByStaffId(staffId);
	}
	
	public List<Leave_details> viewallleaverequests(){
		return ldr.findAll();
	}
	
	public String updatestatus(int id, String leave_status) {
		Optional<Leave_details>ld = ldr.findById(id);
		if(ld.isEmpty()) {
			return "no leave request found";
		}
		Leave_details leavedetails = ld.get();
		leavedetails.setLeave_status(LeaveStatus.valueOf(leave_status));
		ldr.save(leavedetails);
		return "Status Updated Successfully";
	}
}
