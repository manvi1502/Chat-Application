package com.Manvi.chatapp.userview;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;



import com.Manvi.chatapp.dao.UserDAO;
import com.Manvi.chatapp.dto.UserDTO;
import com.Manvi.chatapp.utils.UserInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UserScreen extends JFrame{
	
	private JTextField userFieldlb;
	private JTextField passwordFieldlb;
	private JPasswordField passwordField;

	
	
	  UserDAO userdao=new UserDAO();
	  private JTextField emailField;
	  private JTextField contactField;
	  private JTextField cityField;
	 public void doLogin() {
		
		 String Userid=userFieldlb.getText();
			char[] Password= passwordField.getPassword();
			System.out.println(Userid+" "+Password);
			String Phone=contactField.getText();
			String Place=cityField.getText();
			String Mail=emailField.getText();
			
			UserDTO userdto=new UserDTO(Userid,Password,Mail,Phone,Place);
			try {
				String message="";
				
				if(userdao.isLogin(userdto)) {
					message="Welcome "+Userid+" !";
			UserInfo.User_name=Userid;
					JOptionPane.showMessageDialog(this, message);
					setVisible(false);
					dispose();
					Dashboard db=new Dashboard(message);
					db.setVisible(true);
					
				}
				else{
					message="Invalid details";
					JOptionPane.showMessageDialog(this, message);
				}
				
			} catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	 }
	 public void clearDetails() {
		    userFieldlb.setText("");
			contactField.setText("");
			cityField.setText("");
			 
			emailField.setText("");
			
			passwordField.setText("");
			
		 
	 }
	public void register() {
		String Userid=userFieldlb.getText();
		String Phone=contactField.getText();
		String Place=cityField.getText();
		String Mail=emailField.getText();
		char[] Password= passwordField.getPassword();
		System.out.println(Userid+" "+Password+" "+Place+" "+Phone+" "+Mail);
		
		UserDTO userdto=new UserDTO(Userid,Password,Mail,Phone,Place);
		try {
		int result=userdao.add(userdto);
		if(result>0) {
			
			JOptionPane.showMessageDialog(this,"Register Success!");
		}else {
			JOptionPane.showMessageDialog(this, "Register failed");
		}
		}catch(ClassNotFoundException  | SQLException ex) {
			System.out.println("DB issue");
			ex.printStackTrace();
		}catch(Exception e) {
			System.out.println("Generic issue");
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
					UserScreen window = new UserScreen();
					
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		setVisible(true);
		setBounds(100, 100, 666, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(273, 56, 234, 65);
		getContentPane().add(lblNewLabel);
		
		userFieldlb = new JTextField();
		userFieldlb.setBounds(273, 171, 234, 36);
		getContentPane().add(userFieldlb);
		userFieldlb.setColumns(10);
		
		
		
		JLabel UserId = new JLabel("UserId");
		UserId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserId.setBounds(131, 171, 132, 32);
		getContentPane().add(UserId);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password.setBounds(131, 228, 120, 32);
		getContentPane().add(Password);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		Login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Login.setBounds(84, 515, 105, 36);
		getContentPane().add(Login);
		
		JButton Register = new JButton("Register");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		Register.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Register.setBounds(201, 515, 154, 36);
		getContentPane().add(Register);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(273, 231, 234, 36);
		getContentPane().add(passwordField);
		
		JLabel Email = new JLabel("Email ");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Email.setBounds(131, 286, 132, 32);
		getContentPane().add(Email);
		
		JLabel Contact = new JLabel("Contact");
		Contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Contact.setBounds(131, 348, 132, 32);
		getContentPane().add(Contact);
		
		JLabel City = new JLabel("City");
		City.setFont(new Font("Tahoma", Font.PLAIN, 20));
		City.setBounds(131, 407, 132, 32);
		getContentPane().add(City);
		
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDetails();
			}
		});
		Clear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Clear.setBounds(379, 515, 105, 36);
		getContentPane().add(Clear);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(273, 289, 234, 36);
		getContentPane().add(emailField);
		
		contactField = new JTextField();
		contactField.setColumns(10);
		contactField.setBounds(273, 351, 234, 36);
		getContentPane().add(contactField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(273, 410, 234, 36);
		getContentPane().add(cityField);
	}
}
