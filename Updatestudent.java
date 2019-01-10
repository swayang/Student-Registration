package org.oecm19.studentApp;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("unchecked")
public class Updatestudent extends JFrame
	{
	public Updatestudent()
	{
		updation();
	}

	private void updation() 
	{
		String id=ShowstudentId.id.getText();
		int sid=Integer.parseInt(id);
		
		String phone=ShowstudentDetails.ph.getText();
		if(phone.length()>10 || phone.length()<10)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID PHONE NUMBER");
			return;
		}
		
		String emailId=ShowstudentDetails.em.getText();
		if(emailId.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER EMAIL ID");
			return;
		}
		
		String age=ShowstudentDetails.ag.getText();
		if(age.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "AGE CAN NOT BE EMPTY");
			return;
		}
		
		String city=ShowstudentDetails.ct.getText();
		if(city.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER CITY DETAILS");
			return;
		}
		
		String state=ShowstudentDetails.st.getText();
		if(state.length()==0)
		{
			JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STATE NAME");
			return;
		}
		
		String pincode=ShowstudentDetails.pin.getText();
		if(pincode.length()>6 || pincode.length()<6)
		{
			JOptionPane.showMessageDialog(rootPane, "PINCODE MUST BE OF 6 DIGITS");
			return;
		}
		
		
		
		Connection con=null;
		Statement stmt=null;
		
		
		String upqry  ="update project2.studentregis set s_phone="+"'"+phone+"'"+",s_email= "+"'"+emailId+"'"
							+" ,s_age="+"'"+age+"'"+ " ,s_city="+"'"+city+"'"+",s_state="+"'"+state+"'"
							+",s_pin="+"'"+pincode+"'";
		
		
		
				      
				      System.out.println(upqry);
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			stmt=con.createStatement();
			stmt.executeUpdate(upqry);
			
			
			JOptionPane.showMessageDialog(rootPane, "UPDATED SUCCESSFULLY");
			
			} 
		
		catch (ClassNotFoundException | SQLException e)
		
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
			System.out.println("closed all the costly resources");
		}
	}

	public static void main(String[] args)
	{
		new Updatestudent();
	}

}
