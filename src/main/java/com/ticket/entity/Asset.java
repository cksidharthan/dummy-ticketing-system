package com.ticket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="asset")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="asset_name")
	private String assetName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@OneToOne(mappedBy = "asset", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("asset")
    private Ticket ticket;

	public Asset() {
		super();
	}

	public Asset(String assetName, String description, String customerName, String customerEmail) {
		super();
		this.assetName = assetName;
		this.description = description;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", assetName=" + assetName + ", description=" + description + ", customerName="
				+ customerName + ", customerEmail=" + customerEmail + ", ticket=" + ticket + "]";
	}

}
