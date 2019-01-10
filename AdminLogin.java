package org.oecm19.studentApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin extends JFrame
	{
	JFrame f;
	JLabel l1,l2;
	JTextField uid;
	JPasswordField pwd;
	JButton b1;
		public AdminLogin()
		{
			f=new JFrame("ADMIN LOGIN");
			
			l1=new JLabel("User-Id  :");
			l1.setBounds(60, 80, 90, 30);
			uid=new JTextField();
			uid.setBounds(140, 80, 130, 30);
			
			
			l2=new JLabel("Password  :");
			l2.setBounds(60, 120, 90, 30);
			pwd=new JPasswordField();
			pwd.setBounds(140, 120, 130, 30);
			
			b1=new JButton("LOGIN");
			b1.setBackground(Color.orange);
			b1.setBounds(130,200,90,30);
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					loginButton(arg0);
				}
			});
					
			
			
			f.add(l1);
			f.add(uid);
			f.add(l2);
			f.add(pwd);
			f.add(b1);
			f.setSize(600, 400);
			f.setLayout(null);
			f.setVisible(true);
			
			
		}
	private void loginButton(ActionEvent arg0)
	
		{
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		 String unm=uid.getText();
		 String pasword=pwd.getText();
		 
		 String qry="select * from project2.login where username="+"'"+unm+"'"+"and password="+"'"+pasword+"'";
		 System.out.println(qry);
		 
		 
		 try
		 {
			 
			 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			
			
			
			
			if(rs.next())
			{
				
				if(unm.equalsIgnoreCase(rs.getString("username")) && pasword.equalsIgnoreCase(rs.getString("password")))
				{
					
					Homepage pg=new Homepage();
					pg.setVisible(true);
					this.dispose();
					
				}
				
				
			}
			
			
				else if(unm.length()==0 && pasword.length()==0)
				{
					
					JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER USERNAME AND PASSWORD.", "ALERT",
							JOptionPane.WARNING_MESSAGE);
					this.dispose();
					
				}
			
			
				else if(unm.length()!=0 && pasword.length()==0)
				{
					
					JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER PASSWORD.", "ALERT",
							JOptionPane.WARNING_MESSAGE);
					this.dispose();
					
				}
			
				else if(unm.length()==0 && pasword.length()!=0)
				{
					
					JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER USERNAME.", "ALERT",
							JOptionPane.WARNING_MESSAGE);
					this.dispose();
					
				}
			
			
				else
				{
					
					JOptionPane.showMessageDialog(rootPane, "ERROR INPUT .", "ALERT",
							JOptionPane.WARNING_MESSAGE);
					this.dispose();
				}
			
		} 
		 catch (ClassNotFoundException | SQLException e) 
		 {
			 e.printStackTrace();
		}
		
				
		
		}
	public static void main(String[] args)
	{
		new AdminLogin();
	}

}
