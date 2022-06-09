package com.Manvi.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CommonDAO {
public static Connection createConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String Connection_string="jdbc:mysql://localhost:3306/chatdb";
	String userId="root";
	String password="Gmail@123";
	Connection con=DriverManager.getConnection(Connection_string,userId,password);
	if(con!=null) {
		System.out.println("Connection established");
		//con.close();
	}
	return con;
	
}
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//CommonDAO commondao=new CommonDAO();
	//commondao.createConnection();
}
}
