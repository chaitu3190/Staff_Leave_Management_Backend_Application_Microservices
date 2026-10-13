package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Leave_details;


public interface Leave_DetailsRepository extends JpaRepository<Leave_details,Integer>{
	List<Leave_details>findByStaffId(int staffId);
}

