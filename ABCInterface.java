package com.ABC;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ABCInterface  {
	
	public static void newUserLogin() {
		
		final JFrame newLogin=new JFrame();
	    newLogin.setTitle("ABC Bank-New User Login Page");
		newLogin.setVisible(true);
		JLabel head=new JLabel("Enter Your Details");
		head.setBounds(250, 50, 350, 30);
		JLabel name=new JLabel("Name");
		final JTextField inName=new JTextField("Enter your Name");
		name.setBounds(150,100, 110, 30);
		inName.setBounds(270,100, 300, 30);
		
		
		
		JLabel phno=new JLabel("Phone number");
		final JTextField inPhno=new JTextField("Enter your phone number(Number should be linked to your ID)");
		phno.setBounds(150,200, 110, 30);
		inPhno.setColumns(10);
		inPhno.setBounds(270,200, 300, 30);
		
		JLabel address=new JLabel("Address");
		final JTextArea inAddress=new JTextArea("Enter your address");
		address.setBounds(150,250, 110, 30);
		inAddress.setBounds(270,250, 300, 50);
		
		JLabel proof=new JLabel("Select proof type");
		ButtonGroup group1=new ButtonGroup();
		final JRadioButton perId=new JRadioButton("Personal ID");
		final JRadioButton drivLice=new JRadioButton("Driving Licence");
		final JRadioButton panProof=new JRadioButton("PAN Card");
		group1.add(perId);
		group1.add(drivLice);
		group1.add(panProof);
		proof.setBounds(150,310, 300, 30);
		perId.setBounds(270,310, 90, 20);
		drivLice.setBounds(370,310, 95, 20);
		panProof.setBounds(470,310, 100, 20);

		JLabel panId=new JLabel("PAN number");
		final JTextField inPanID=new JTextField("Enter PAN ID number");
	    panId.setBounds(150,350, 110, 30);
		inPanID.setBounds(270,350, 300, 30);
				
		JLabel accType=new JLabel("Account type");
		ButtonGroup group2=new ButtonGroup();
		final JRadioButton savingsAcc=new JRadioButton("Savings");
		final JRadioButton currentAcc=new JRadioButton("Current");
		final JRadioButton depositAcc=new JRadioButton("Deposit");
		group2.add(savingsAcc);
		group2.add(currentAcc);
		group2.add(depositAcc);
		accType.setBounds(150,400, 300, 30);
		savingsAcc.setBounds(270,400, 95, 20);
		currentAcc.setBounds(370,400, 95, 20);
		depositAcc.setBounds(470,400, 100, 20);
		

		JLabel password=new JLabel("Password");
		final JTextArea inPassword=new JTextArea("Set your strong password");
	    password.setBounds(150,450, 300, 30);
	    inPassword.setBounds(270,450,300,30);
		
	    JLabel amount=new JLabel("Amount");
		final JTextArea inDepositAmount=new JTextArea("Amount in Rs(min Rs.500)");
		amount.setBounds(150,500, 300, 30);
	    inDepositAmount.setBounds(270,500,300,30);
	    
		final JButton createAccount=new JButton("Create Account");
		createAccount.setBounds(230, 550, 200, 20);
		
		newLogin.add(head);
		newLogin.add(name);
		newLogin.add(inName);
		
		
		newLogin.add(phno);
		newLogin.add(inPhno);
		
		newLogin.add(address);
		newLogin.add(inAddress);

		newLogin.add(proof);
		newLogin.add(perId);
		newLogin.add(drivLice);
		newLogin.add(panProof);
		
		newLogin.add(panId);
		newLogin.add(inPanID);
		
		newLogin.add(accType);
		newLogin.add(savingsAcc);
		newLogin.add(currentAcc);
		newLogin.add(depositAcc);
		
		newLogin.add(password);
		newLogin.add(inPassword);
		
		newLogin.add(amount);
		newLogin.add(inDepositAmount);
		
		newLogin.setLayout(null);
		newLogin.add(createAccount);
		newLogin.setSize(600,600);
		newLogin.setVisible(true);
		
		newLogin.getContentPane().setBackground(Color.orange);
		
		createAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
				
			
				User user=new User();
				user.setUsername(inName.getText());
				user.setPhoneNo(inPhno.getText());
				user.setAddress(inAddress.getText());
				if(perId.isSelected()) {
					user.setProofID("Personal ID");
				}else if(drivLice.isSelected()) {
					user.setProofID("Driving License");
				}else
				{
					user.setProofID("PAN ID");
				}
				
				user.setPanID(inPanID.getText());

				if(savingsAcc.isSelected()) {
					user.setAccType("Savings Account");
				}else if(currentAcc.isSelected()) {
					user.setAccType("Current Account");
				}else
				{
					user.setAccType("Deposit Account");
				}

			    user.setPassword(inPassword.getText());
			    user.setDepositAmount(Double.parseDouble(inDepositAmount.getText()));
			   
			    
			   
			    try {
					confirmInfo(user);
					newLogin.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		
	});

		
	}
	
	public static void confirmInfo(final User user) throws Exception {
		
		
			final JDialog userDetails=new JDialog();
			
			JLabel head=new JLabel("Your Details");
			head.setBounds(250, 50, 350, 30);
			JLabel uname=new JLabel("Username: "+ user.getUsername());
			uname.setBounds(150,100,400, 30);
			
			JLabel phno=new JLabel("Phone number: "+user.getPhoneNo());
			phno.setBounds(150,150,400, 30);
			
			JLabel uaddress=new JLabel("Address: "+user.getAddress());
			
			uaddress.setBounds(150,200,400, 30);
			
			
			JLabel uproof=new JLabel("Select proof type: "+user.getProofID());
			uproof.setBounds(150,250,400, 30);
			
			
			
			JLabel panId=new JLabel("PAN number: "+user.getPanID());
			panId.setBounds(150,300,400, 30);
			
			
			JLabel uaccType=new JLabel("Account type: "+user.getAccType());
			uaccType.setBounds(150,350,400, 30);
			
			JLabel upassword=new JLabel("Password: "+user.getPassword());
			upassword.setBounds(150,400,400, 30);
		    
			JLabel amount=new JLabel("Amount: "+user.getDepositAmount());
			amount.setBounds(150,450,400, 30);
		    
			
			final JButton confirm=new JButton("Confirm");
			confirm.setBounds(150,500,150, 20);
		    
			final JButton reEnter=new JButton("Re-Enter");
			reEnter.setBounds(350,500,300, 20);
		    
			userDetails.add(uname);
			userDetails.add(upassword);
			userDetails.add(amount);
			userDetails.add(uaccType);
			userDetails.add(uproof);
			userDetails.add(panId);
			userDetails.add(uaddress);
			userDetails.add(phno);
			userDetails.add(uaccType);
			
			userDetails.add(confirm);
			userDetails.add(reEnter);
		    userDetails.setSize(750,750);
			userDetails.setLayout(null);

			userDetails.setVisible(true);
			String yes=confirm.getActionCommand();
			
			
			confirm.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
						try {
							BankDb.insertUserData(user);
							userDetails.dispose();
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				}
				
			});
			
			
			
			
			reEnter.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					newUserLogin();
					userDetails.dispose();
					
				}
			});
			
			
			}
	
	public static void loginUser() throws Exception{
		
		final User verifyUser=new User();
		final JFrame mainFrame=new JFrame();
		
		JLabel greet=new JLabel("Welcome! Please use the application safe and secure");
		greet.setBounds(515, 210, 350, 30);
		JLabel accNo=new JLabel("Account number: ");
		final TextField inAccountNo=new TextField("Enter your account number");
		
		accNo.setBounds(460,260, 110, 30);
		inAccountNo.setBounds(575,260, 300, 30);
		
		
		JLabel pwd=new JLabel("Password: ");
		final JTextField inPassword=new JTextField("Enter your password");
		pwd.setBounds(460, 300, 110, 30);
		inPassword.setBounds(575, 300, 300, 30);
		
		JButton login=new JButton("Login");
		pwd.setBounds(460, 300, 110, 30);
		inPassword.setBounds(575, 300, 300, 30);
		login.setBounds(510, 360, 95, 20);
		JButton newUser=new JButton("New User? Create Account");
		newUser.setBounds(610, 360, 250, 20);
		JButton exit=new JButton("Exit");
		exit.setBounds(410, 400, 100, 50);

		
		mainFrame.add(greet);
		greet.setBackground(Color.white);
		mainFrame.add(accNo);
		mainFrame.add(inAccountNo);
		mainFrame.add(pwd);
		mainFrame.add(inPassword);
		mainFrame.add(login);
		mainFrame.add(newUser);
		mainFrame.add(exit);		
		mainFrame.setLayout(null);
		mainFrame.setTitle("ABC Bank Application");
		
		mainFrame.getContentPane().setBackground(Color.yellow);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		
		login.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				verifyUser.setAccNo(inAccountNo.getText());
				verifyUser.setPassword(inPassword.getText());
				
				try {
					if(BankDb.verifyUser(verifyUser)){
						
						mainFrame.dispose();
						userOptions(verifyUser);
						

					}else {
						final JDialog msgAlert=new JDialog();
						JLabel msg=new JLabel("Please enter credentials correctly");
						JButton ok=new JButton("OK");
						ok.setBounds(100, 75, 30, 20);
						
						msg.setBounds(50,50,150,30);
						msgAlert.add(msg);
						msgAlert.add(ok);
						msgAlert.setSize(200,200);
						msgAlert.setLayout(null);
						msgAlert.setVisible(true);
						ok.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									msgAlert.dispose();
									loginUser();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
						
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});		
		newUser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				newUserLogin();
		 
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					mainFrame.dispose();
				
				
			}
		});

	
	
	}
	
	public static void userOptions(final User verifyUser) {
		JFrame mainFrame=new JFrame("ABC Bank Application");
		JButton inDeposit=new JButton("Deposit");
		inDeposit.setBounds(400,300,100,50);
		
		JButton inWithDraw=new JButton("Withdraw");
		inWithDraw.setBounds(600,300,100,50);
		
		JButton inPassBook=new JButton("Passbook");
		inPassBook.setBounds(800,300,100,50);
		JButton exit=new JButton("exit");
		exit.setBounds(600, 500, 100, 50);
		
		
	
		mainFrame.add(inDeposit);
		mainFrame.add(inWithDraw);
		mainFrame.add(inPassBook);
		mainFrame.add(exit);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setLayout(null);
		mainFrame.setVisible(true);
		
		inDeposit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				depositAmount(verifyUser);
			}
		});
		
		inWithDraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				withdrawalAmount(verifyUser);
				
			}
		});
		
		inPassBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loginUser();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

	}
	public static void depositAmount(User verifyUser) {
		final User depositAmount=verifyUser;
		final JFrame amountDeposit=new JFrame("Amount Deposit");
		JLabel amount=new JLabel("Amount");
		amount.setBounds(100,100,100,50);
		final JTextField inAmount=new JTextField("Enter amount");
		inAmount.setBounds(100,160,100,50);
		

		JLabel pwd=new JLabel("Password: ");
		final JTextField inPassword=new JTextField("Enter your password");
		pwd.setBounds(100, 210, 100, 30);
		inPassword.setBounds(100, 260, 100, 30);
		
		final JButton deposit=new JButton("Deposit");
		
		deposit.setBounds(100, 310, 100, 30);
		
JButton depositCancel=new JButton("Cancel");
depositCancel.setBounds(250, 310, 100, 30);
		
		
		amountDeposit.add(amount);
		amountDeposit.add(inAmount);
		
		amountDeposit.add(inPassword);
		amountDeposit.add(pwd);
		
		amountDeposit.add(deposit);
		amountDeposit.add(depositCancel);
		
		amountDeposit.setLayout(null);
		amountDeposit.setSize(800,500);
		amountDeposit.setLayout(null);
		amountDeposit.setVisible(true);
		
		deposit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				depositAmount.setDepositAmount(Double.parseDouble(inAmount.getText()));
				depositAmount.setPassword(inPassword.getText());
				char update='+';
				try {
					if(BankDb.updateBalance(depositAmount,update)) {
						depositAmount.setBalance(BankDb.getBalanceDb(depositAmount));
						final JDialog msgAlert=new JDialog();
						JLabel msg1=new JLabel("Amount withdrawn successfully");
						msg1.setBounds(50, 55, 190, 20);
						
						JLabel msg2=new JLabel("Your current balance"+depositAmount.getBalance());
						msg2.setBounds(50, 110, 190, 20);
						JButton ok=new JButton("OK");
						ok.setBounds(150, 150, 100, 20);
						msgAlert.add(msg1);
						msgAlert.add(msg2);
						msgAlert.add(ok);
						msgAlert.setSize(200,200);
						msgAlert.setLayout(null);
						msgAlert.setVisible(true);
						ok.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									userOptions(depositAmount);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
					});
						}
					else {
						final JDialog msgAlert=new JDialog();
						JLabel msg=new JLabel("Please enter credentials correctly");
						JButton ok=new JButton("OK");
						ok.setBounds(100, 75, 30, 20);
						
						msg.setBounds(50,50,150,30);
						msgAlert.add(msg);
						msgAlert.add(ok);
						msgAlert.setSize(200,200);
						msgAlert.setLayout(null);
						msgAlert.setVisible(true);
						ok.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									depositAmount(depositAmount);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
						
	
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		depositCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			amountDeposit.dispose();
				
			}
		});
		
	}	
	
	public static void withdrawalAmount(User verifyUser) {
		final User withdrawAmount=verifyUser;
		final JFrame withdrawalAmount=new JFrame("Amount Withdrawal");
		JLabel amount=new JLabel("Amount");
		amount.setBounds(150,100,100,50);
		final JTextField inAmount=new JTextField("Enter amount");
		inAmount.setBounds(150,160,100,50);
		

		JLabel pwd=new JLabel("Password: ");
		final JTextField inPassword=new JTextField("Enter your password");
		pwd.setBounds(150, 210, 100, 30);
		inPassword.setBounds(150, 260, 200, 30);
		
		final JButton withdraw=new JButton("Withdraw");
		
		withdraw.setBounds(100, 310, 100, 30);
		
JButton withdrawCancel=new JButton("Cancel");
withdrawCancel.setBounds(250, 310, 100, 30);
		
		
		withdrawalAmount.add(amount);
		withdrawalAmount.add(inAmount);
		
		withdrawalAmount.add(inPassword);
		withdrawalAmount.add(pwd);
		
		withdrawalAmount.add(withdraw);withdrawalAmount.add(withdrawCancel);
		
		withdrawalAmount.setLayout(null);
		withdrawalAmount.setSize(800,500);
		withdrawalAmount.setLayout(null);
		withdrawalAmount.setVisible(true);
		
		withdraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				withdrawAmount.setWithdrawalAmount(Double.parseDouble(inAmount.getText()));
				withdrawAmount.setPassword(inPassword.getText());
				char update='-';
				try {
					if(BankDb.updateBalance(withdrawAmount,update)) {
						withdrawAmount.setBalance(BankDb.getBalanceDb(withdrawAmount));
						final JDialog msgAlert=new JDialog();
						JLabel msg1=new JLabel("Amount withdrawn successfully");
						msg1.setBounds(50, 55, 190, 20);
						
						JLabel msg2=new JLabel("Your current balance"+withdrawAmount.getBalance());
						msg2.setBounds(50, 110, 190, 20);
						JButton ok=new JButton("OK");
						ok.setBounds(150, 150, 100, 20);
						msgAlert.add(msg1);
						msgAlert.add(msg2);
						msgAlert.add(ok);
						msgAlert.setSize(200,200);
						msgAlert.setLayout(null);
						msgAlert.setVisible(true);
						ok.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									userOptions(withdrawAmount);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
					});
						}
					else {
						final JDialog msgAlert=new JDialog();
						JLabel msg=new JLabel("Please enter credentials correctly");
						JButton ok=new JButton("OK");
						ok.setBounds(100, 75, 30, 20);
						
						msg.setBounds(50,50,150,30);
						msgAlert.add(msg);
						msgAlert.add(ok);
						msgAlert.setSize(200,200);
						msgAlert.setLayout(null);
						msgAlert.setVisible(true);
						ok.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									withdrawalAmount(withdrawAmount);
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
						});
						
						
	
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		withdrawCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			withdrawalAmount.dispose();
				
			}
		});
		
	}
	public static void main(String[] args) throws Exception {
		loginUser();
		
		
	}
}