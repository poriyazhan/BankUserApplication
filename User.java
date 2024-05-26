package com.ABC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
	private String username,password,phoneNo,address,accType,proofID,panID,accNo;
	private double balance,depositAmount,withdrawalAmount;
	public double getDepositAmount() {
		return depositAmount;
	}
	public double getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public void setWithdrawalAmount(double withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public String getAccType() {
		return accType;
	}
	public String getProofID() {
		return proofID;
	}
	public String getPanID() {
		return panID;
	}
	public String getAccNo() {
		return accNo;
	}
	public double getBalance() {
		return balance;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public void setProofID(String proofID) {
		this.proofID = proofID;
	}
	public void setPanID(String panID) {
		this.panID = panID;
	}
	public void setAccNo(String accNo) {
		this.accNo=accNo;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String setAccountNo() throws Exception {
		Connection connect=BankDb.getConnection();
		String query="select count(*) from user_data";
		Statement st=connect.createStatement();
		ResultSet rst=st.executeQuery(query);
		int noOfUser = 100000001;
   
        String newAccountNumber=null;
        if (rst.next()) {
            noOfUser += rst.getInt(1);
            String accNoPrefix = "41038";
            newAccountNumber = accNoPrefix + noOfUser;
            
        }
        return newAccountNumber;
    }

	
	
}
