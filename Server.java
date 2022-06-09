package com.Manvi.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.Manvi.chatapp.utils.ConfigReader;

public class Server {
	ArrayList<ServerWorker> workers=new ArrayList<>();
	ServerSocket ss;
	public Server() throws IOException{
		int port=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		 ss=new ServerSocket(port);
		System.out.println("waiting for client");
		handleClientRequest();
	}
		public void handleClientRequest() throws IOException {
			while(true) {
			Socket clientsocket=ss.accept();
			ServerWorker serverworker=new ServerWorker(clientsocket,this);
			workers.add(serverworker);
			serverworker.start();
			}
		}
		
		/*System.out.println("connection established between client and server");
		InputStream in=socket.getInputStream();
		byte arr[]=in.readAllBytes();
		String s=new String(arr);
		System.out.println("message received from client is "+s);
		in.close();
		socket.close();
		*/
	

	public static void main(String[] args) throws IOException {
		Server server=new Server();

	}

}
