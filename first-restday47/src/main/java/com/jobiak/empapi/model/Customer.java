package com.jobiak.empapi.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer {
	@Id
	@GeneratedValue
	private Long cusid;
	private String name;
	private double balance;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getCusid() {
		return cusid;
	}

	public void setCusid(Long id) {
		this.cusid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}