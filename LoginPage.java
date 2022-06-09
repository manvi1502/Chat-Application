package com.Manvi.chatapp.userview;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginPage extends JFrame {
int count;JLabel welcome;
	public LoginPage(){
		count=0;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		setTitle("Login");
		setLocationRelativeTo(null);
		 welcome=new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(150, 20,400,100);
		container.add(welcome);
		JButton button=new JButton("Count");
		button.setBounds(150,200, 100, 70);
		container.add(button);
		button.addActionListener(new Handler());
		
		
	}
	
	class Handler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			count++;
			welcome.setText("Counter is "+count);
			
		}
		
	}
	public static void main(String[] args) {
		LoginPage jf=new LoginPage();

	}

}
