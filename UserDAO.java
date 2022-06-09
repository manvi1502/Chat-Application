package com.Manvi.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Manvi.chatapp.dto.UserDTO;
import com.Manvi.chatapp.utils.Encryption;


public class UserDAO {
	public boolean isLogin(UserDTO userdto) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		Connection connection=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		String sql="select userid from users where userid=? and password=? and email=? and contact=? and city=?";
		try {
		connection=CommonDAO.createConnection();
		psmt=connection.prepareStatement(sql);
		psmt.setString(1,userdto.getUserid());
		String encryptedPassword=Encryption.encryptPassword(new String(userdto.getPassword()));
		psmt.setString(2, encryptedPassword);
		psmt.setString(3,userdto.getEmail());
		psmt.setString(4,userdto.getContact());
		psmt.setString(5,userdto.getCity());
		rs=psmt.executeQuery();
		if(rs.next()) {
			return true;
		}return false;
		}finally {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null) {
				psmt.close();
			}
			if(connection!=null) {
			connection.close();
			}
			
		}
		
	}
	public int add(UserDTO userdto) throws ClassNotFoundException, SQLException,Exception {
		System.out.println("Received "+userdto.getUserid()+" "+userdto.getPassword()+" "+userdto.getEmail()+" "+userdto.getContact()+" "+userdto.getCity());
		
		Connection connection=null;
		Statement stmt=null;
		try {
		connection=CommonDAO.createConnection();
		stmt=connection.createStatement();
		int record=stmt.executeUpdate("insert into users(userid,password,email,contact,city) values('"+userdto.getUserid()+"','"+Encryption.encryptPassword(new String(userdto.getPassword()))+"','"+userdto.getEmail()+"','"
		+userdto.getContact()+"','"+userdto.getCity()+"')");
		return record;
		}finally {
			if(connection!=null) {
			connection.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
		}
		
	}

	public static void main(String[] args) {
		

	}

}
