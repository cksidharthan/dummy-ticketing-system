package com.ticket.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "asset_id", referencedColumnName = "id")
	@JsonIgnoreProperties("ticket")
    private Asset asset;
	
	@Column(name="closed_at")
	private Date closedAt;

	public Ticket() {
		super();
	}

	public Ticket(String subject, String description, Date createdAt, Date closedAt) {
		super();
		this.subject = subject;
		this.description = description;
		this.createdAt = createdAt;
		this.closedAt = closedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Date getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(Date closedAt) {
		this.closedAt = closedAt;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", subject=" + subject + ", description=" + description + ", createdAt=" + createdAt
				+ ", closedAt=" + closedAt + "]";
	}

}
