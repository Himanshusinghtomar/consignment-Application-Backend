package com.consignment.consignmentApplication.dao;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consignment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer consignmentId;
	private String consignmentCategory;
	private String deleveryPartner;
	private String consignmentStatus;
	
	
	public Integer getConsignmentId() {
		return consignmentId;
	}
	public void setConsignmentId(Integer consignmentId) {
		this.consignmentId = consignmentId;
	}
	public String getConsignmentCategory() {
		return consignmentCategory;
	}
	public void setConsignmentCategory(String consignmentCategory) {
		this.consignmentCategory = consignmentCategory;
	}
	public String getDeleveryPartner() {
		return deleveryPartner;
	}
	public void setDeleveryPartner(String deleveryPartner) {
		this.deleveryPartner = deleveryPartner;
	}
	public String getConsignmentStatus() {
		return consignmentStatus;
	}
	public void setConsignmentStatus(String consignmentStatus) {
		this.consignmentStatus = consignmentStatus;
	}
	
	
	
	
	

}
