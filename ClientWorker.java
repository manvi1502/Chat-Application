package com.Manvi.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

//client data read
public class ClientWorker extends Thread {
	private InputStream in;
	JTextArea textarea;
	public ClientWorker(InputStream in,JTextArea textarea) {
		this.in=in;
		this.textarea=textarea;
	}
public void run() {
	BufferedReader br=new BufferedReader(new InputStreamReader(in));
	String line;
	try {
	while(true) {
		
			line=br.readLine();
			System.out.println("Line read "+line);
			textarea.setText(textarea.getText()+line+"\n");
		}
	}catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

