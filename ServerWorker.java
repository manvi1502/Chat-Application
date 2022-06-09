package com.Manvi.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerWorker extends Thread{
	private Socket clientsocket;
	private InputStream in;
	private OutputStream out;
	private Server server;
	public ServerWorker(Socket clientsocket,Server server) throws IOException {
		this.server=server;
		this.clientsocket=clientsocket;
		in=clientsocket.getInputStream();
		out=clientsocket.getOutputStream();
		System.out.println("New client comes");
	}
	public void run() {
		//read data from client and broadcast to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while(true) {
			line=br.readLine();
			System.out.println("Line read "+line);
			if(line.equalsIgnoreCase("quit")) {
				break;
			}
			for(ServerWorker serverworker: server.workers) {
				line=line+"\n";
				serverworker.out.write(line.getBytes());//broadcast
			}
			//out.write(line.getBytes());//one client
		} 
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			try {
			if(br!=null) {
				br.close();
			}if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(clientsocket!=null) {
				clientsocket.close();
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

//	public static void main(String[] args) {
//		
//
//	}

}
