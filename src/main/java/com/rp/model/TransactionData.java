package com.rp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionData {
	private int amount;
	private String description;
	private Date date;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonFormat(pattern="dd-MMM-yyyy")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
