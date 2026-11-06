package com.example.demo.Entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Staff {
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	@Enumerated(EnumType.STRING)
	private Role role;
	public Staff() {
		super();
	}
	public Staff(int id, String name, String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id), name, password, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& role == other.role;
	}
	
	
}

