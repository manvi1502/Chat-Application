package com.Manvi.chatapp.userview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SplashScreen extends JWindow {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Timer timer;
	public void runProgressBar() {
		 timer=new Timer(50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				progressBar.setValue(count);
				count++;
				if(count>100) {
					if(timer!=null) {
					timer.stop();
					SplashScreen.this.setVisible(false);
					SplashScreen.this.dispose();
					UserScreen userscreen=new UserScreen();
					userscreen.setVisible(true);
					}
				}
				
			}
		});
		 timer.start();
	}
	private int count=0;
	JProgressBar progressBar = new JProgressBar();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressBar();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		progressBar.setForeground(Color.RED);
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		progressBar.setBounds(95, 378, 543, 24);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("0%");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/splash.jpg")));
		lblNewLabel.setBounds(0, 0, 682, 433);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
