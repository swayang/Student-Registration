package org.oecm19.studentApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Database 
{
	private Connection con;
	private PreparedStatement pstmt;
	private java.sql.Statement stmt;
	private ResultSet rs;
	
	public Database() 
	{
		createConection();
	}
	
	public void createConection() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void insertQuery(Connection con,String qry) throws SQLException
	{
		 pstmt=con.prepareStatement(qry);
	}
	public void updateQuery(String qry) throws SQLException
	{
		stmt=con.createStatement();
		stmt.executeUpdate(qry);
		
	}
	public void deleteQuery(String qry) throws SQLException
	{
		stmt=con.createStatement();
		stmt.executeUpdate(qry);
	}

	public Connection getConnection() 
	{
		return con;
	}
	public PreparedStatement getInsert()
	{
		return pstmt;
	}
	public Statement getUpdate()
	{
		return  stmt;
	}
	
}
