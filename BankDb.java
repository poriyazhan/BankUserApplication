package com.ABC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class BankDb {

	private static final String url="jdbc:mysql://localhost:3306/abc_bank_sample";
	private static final String dbUsername="root";
	private static final String dbPassword=null;
	
	
	public static Connection getConnection() throws Exception{
		
		return DriverManager.getConnection(url,dbUsername,dbPassword);
		
	}
	
	public static void insertUserData(User user) throws Exception {
		
		Connection connect=getConnection();
		String query="insert into user_data values(?,?,?,?,?,?,?,?,?)";
	    PreparedStatement pst=connect.prepareStatement(query);
		String username=user.getUsername(),password=user.getPassword(),address=user.getAddress(),phoneNum=user.getPhoneNo(),accType=user.getAccType(),proofID=user.getProofID()
			,panID=user.getPanID(),accNo=user.setAccountNo();
		double balance=user.getDepositAmount();
		System.out.println(accNo);
		pst.setString(1, username);
		pst.setString(2, password);
		pst.setString(3, accNo);
		pst.setString(4, address);
		pst.setString(5, phoneNum);
		pst.setString(6, accType);
		pst.setString(7, proofID);
		pst.setString(8, panID);
		pst.setDouble(9, balance);
		int resultSet=pst.executeUpdate();
		if(resultSet==1) {
		JDialog display=new JDialog();
		JLabel details=new JLabel("Your account number: "+accNo);
		JLabel details1=new JLabel("Your password: "+user.getPassword());
		details.setBounds(50,50,300,30);
		details1.setBounds(50,85,200,50);
		display.add(details);
		display.add(details1);
		
		display.setSize(500,300);
		display.setLayout(null);
		display.setVisible(true);
		}
		
		
		
	}
	
	public static boolean verifyUser(User verifyUser) throws Exception{
		Connection connect=getConnection();
		Statement st=connect.createStatement();
		String query="select user_account_number,user_password from user_data where user_account_number='"+verifyUser.getAccNo()+"' and user_password='"+verifyUser.getPassword()+"'";
		System.out.println(query);
		ResultSet rst=st.executeQuery(query);
		if(rst.next()) {
			return true;
		}else {
			return false;
		}
		
		
		
	}

	public static boolean updateBalance(User balance,char update)throws Exception{
		Connection connect=getConnection();
		Statement st=connect.createStatement();
		if(verifyUser(balance)) {
		String query="select * from user_data";
		
		if(update=='+') {
			query="update user_data set user_balance=user_balance+"+balance.getDepositAmount()+" where user_account_number='"+balance.getAccNo()+"'";
		}else if(update=='-'){
			query="update user_data set user_balance=user_balance-"+balance.getWithdrawalAmount()+" where user_account_number='"+balance.getAccNo()+"'";
		}
		
		int rows=st.executeUpdate(query);
		if(rows==1) {
			return true;
		}else {
			return false;
		}}
		return false;
	}
	
	public static double getBalanceDb(User balance)throws Exception{
		Connection connect=getConnection();
		Statement st=connect.createStatement();
		String query="select user_balance from user_data where user_account_number='"+balance.getAccNo()+"'";
		
		ResultSet rst=st.executeQuery(query);
		if(rst.next()) {
			return rst.getDouble(1);
		}else {
			return 0;
		}
		
		
		
		
	}
}
