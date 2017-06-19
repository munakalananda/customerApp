package com.cts.sample.dao;

public class Customer {
	
	public String customerName;
	public String customerId;
	public String customerAddress;
	public String getCustomerName() {
		return customerName;
	}
	public Customer(){
		
	}
	public Customer(String customerName, String customerId, String customerAddress) {
		
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerAddress = customerAddress;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerAddress="
				+ customerAddress + "]";
	}

}
