package com.Manvi.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.Manvi.chatapp.utils.ConfigReader;

public class Client {
	InputStream in;
	OutputStream out;
	ClientWorker worker;
	JTextArea textarea;
public Client(JTextArea textarea) throws UnknownHostException, IOException {
	String address=ConfigReader.getValue("SERVER_IP");
	int port=Integer.parseInt(ConfigReader.getValue("PORTNO"));
	Socket clientSocket=new Socket(address,port);
	out=clientSocket.getOutputStream();
	in=clientSocket.getInputStream();
	this.textarea=textarea;
	readMessage();
//	System.out.println("Client comes");
//	System.out.println("enter the msg for the server");
//	Scanner sc=new Scanner(System.in);
//	String message=sc.nextLine();
//	OutputStream out=clientSocket.getOutputStream();
//	out.write(message.getBytes());
//	System.out.println("message sent to the server");
//	out.close();
//	sc.close();
//	clientSocket.close();
}
public void sendMessage(String message) throws IOException {
	message=message+"\n";
	out.write(message.getBytes());
}
public void readMessage() {
	worker=new ClientWorker(in,textarea); //calling a read thread
	worker.start();
}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		//Client client=new Client();
//
//	}

}
