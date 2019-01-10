package org.oecm19.studentApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Collection;
import java.util.Enumeration;

import javax.swing.*;

public class StudentRegistration extends JFrame
	{
	JLabel lid,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JFrame f;
	JRadioButton jb;
	JTextField sid,nm,ph,em,ag,cl,se,ct,st,gd,pin;
	JRadioButton jb1,jb2;
	ButtonGroup bg;
	JButton b1;
	
	 private  int st_ID=400;
	
	
	
	
	StudentRegistration()
	{
		 
		 
		   int id1;
		   
		   
	         
             Database databaseManager= new Database();
	        
	       
	      
	         ResultSet rs;
			try {
				 Statement st=databaseManager.getConnection().createStatement();
				 rs = st.executeQuery("select max(s_id) as s_id from project2.studentregis");
				 while(rs.next())
		         {
		        	 
		         id1=rs.getInt("s_id");
		         st_ID= ++id1;
		         
		         System.out.println(st_ID);
		         
		         }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         
	         
	        
	 		
	 		
	 		    
	         
	         initialization();   
		 
	}

	private void initialization() 
	{
		
		f=new JFrame("STUDENT REGISTRATION FORM");
		
		lid=new JLabel("Student-ID  :");
		lid.setBounds(50, 40, 90, 30);
		sid=new JTextField();
        sid.setText(""+st_ID);
        sid.setVisible(true);
        sid.setBounds(200, 40, 120, 30);
        sid.setEditable(false);
        
		
		
		l1=new JLabel("NAME  :");
		l1.setBounds(50, 80, 90, 30);
		nm=new JTextField();
		nm.setBounds(200, 80, 120, 30);
		
		l2=new JLabel("PHONE  :");
		l2.setBounds(50	, 120, 90, 30);
		ph=new JTextField();
		ph.setBounds(200, 120, 120, 30);
		
		l3=new JLabel("EMAIL  :");
		l3.setBounds(50, 160, 90, 30);
		em=new JTextField();
		em.setBounds(200, 160, 120, 30);
		
		l4=new JLabel("AGE  :");
		l4.setBounds(50, 200, 90, 30);
		ag=new JTextField();
		ag.setBounds(200, 200, 120, 30);
		
		l5=new JLabel("CLASS  :");
		l5.setBounds(50, 240, 90, 30);
		cl=new JTextField();
		cl.setBounds(200, 240, 120, 30);
		
		l6=new JLabel("CITY  :");
		l6.setBounds(50, 280, 90, 30);
		ct=new JTextField();
		ct.setBounds(200, 280, 120, 30);
		
		l7=new JLabel("STATE  :");
		l7.setBounds(50, 320, 90, 30);
		st=new JTextField();
		st.setBounds(200, 320, 120, 30);
		
		l8=new JLabel("PIN  :");
		l8.setBounds(50, 360, 90, 30);
		pin=new JTextField();
		pin.setBounds(200, 360, 120, 30);
		
		l9=new JLabel("GENDER");
		l9.setBounds(50, 400, 90, 30);
		
		bg=new ButtonGroup();
		jb1=new JRadioButton("MALE");
		jb1.setSelected(true);
		jb1.setBounds(200, 400, 90, 30);
		
		bg.add(jb1);
		jb2=new JRadioButton("FEMALE");
		jb2.setBounds(290, 400, 90, 30);
		bg.add(jb2);
		
		
		b1=new JButton("SUBMIT");
		b1.setBounds(100, 600, 90, 30);
		b1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				submitButton(e);
			}
		});
		
		
		
		f.add(lid);
		f.add(sid);
		f.add(l1);
		f.add(nm);
		f.add(l2);
		f.add(ph);
		f.add(l3);
		f.add(em);
		f.add(l4);
		f.add(ag);
		f.add(l5);
		f.add(cl);
		f.add(l6);
		f.add(ct);
		f.add(l7);
		f.add(st);
		f.add(l8);
		f.add(pin);
		f.add(l9);
		f.add(jb1);
		f.add(jb2);
		f.add(b1);
		f.setSize(600, 700);
		f.setLayout(null);
		f.setVisible(true);
		
		
		
		
		
	}

	

	private void submitButton(ActionEvent e)
	{
		
		//String stdid=sid.getText();
		//int id2=Integer.parseInt(stdid);
		
	String name=nm.getText();
	if(name.length()==0)
	{
		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STUDENT NAME");
		return;
	}
	

	String phone=ph.getText();
	if(phone.length()>10 || phone.length()<10)
	{
		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER VALID PHONE NUMBER");
		return;
	}
	
	
	String email=em.getText();
	if(email.length()==0)
	{
		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STUDENT  EMAILID");
		return;
	}
	
	String clas=cl.getText();
	if(clas.length()==0)
	{

		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STUDENT  CLASS");
		return;
	}
	
	String city=ct.getText();
	if(city.length()==0)
	{

		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER CORRECT  CITY DETAILS");
		return;
	}
	
	String state=st.getText();
	if(state.length()==0)
	{

		JOptionPane.showMessageDialog(rootPane, "PLEASE ENTER STATE DETAILS");
		return;
	}
	
	String pincode=pin.getText();
	if(pincode.length()>6 || pincode.length()<6)
	{

		JOptionPane.showMessageDialog(rootPane, " PINCODE MUST BE OF 6 DIGITS");
		return;
	}
	
	String gender=null;
	Enumeration enm = bg.getElements();
	while (enm.hasMoreElements())
	{
		AbstractButton ab = (AbstractButton) enm.nextElement();
		if (bg.isSelected(ab.getModel())) {
			gender = ab.getText();
		}
	}
	
	
	Connection con1=null;
	PreparedStatement pstmt1=null;
	String inqry="insert into project2.studentregis (s_id,s_name,s_phone,s_email,s_age,s_class,s_city,s_state,s_pin,s_gen)"
			+ "values(?,?,?,?,?,?,?,?,?,?)";

	
	
   try
   {
	   
	Class.forName("com.mysql.jdbc.Driver");
	con1=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
	pstmt1=con1.prepareStatement(inqry);
	
	
	
	
	pstmt1.setInt(1, st_ID);
	pstmt1.setString(2, name);
	pstmt1.setString(3, phone);
	pstmt1.setString(4, email);
	pstmt1.setInt(5, Integer.parseInt(ag.getText()));
	pstmt1.setString(6, clas);
	pstmt1.setString(7, city);
	pstmt1.setString(8, state);
	pstmt1.setInt(9	, Integer.parseInt(pin.getText()));
	pstmt1.setString(10, gender);
	
	
	
	

	pstmt1.executeUpdate();

	JOptionPane.showMessageDialog(rootPane, "STUDENT  is registered");

	
	
	
	
   }
   catch (ClassNotFoundException | SQLException e1)
   {
	e1.printStackTrace();
   }
	
	
	
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello");
		new StudentRegistration();
	}

}
