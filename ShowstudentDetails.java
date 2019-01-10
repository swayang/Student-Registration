package org.oecm19.studentApp;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.oecm19.task.SuccessPage;

public class ShowstudentDetails extends JFrame
	{
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	static JTextField t1,nm,ph,em,ag,cl,ct,st,pin,gd;
	JButton b1,b2,b3;
	
	
	public ShowstudentDetails()
	{
		initcompinents();
	}
	

	private void initcompinents() 
	{
		String id=ShowstudentId.id.getText();
		int sId=Integer.parseInt(id);
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String showqry="select * from project2.studentregis where s_id="+"'"+sId+"'";
		
		
		System.out.println(showqry);
		
		
		
		try {
			
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(showqry);
			rs=pstmt.executeQuery();
			
			
			
			if(rs.next())
			{
				if(sId==rs.getInt(1))
				{
					String uid=Integer.toString(rs.getInt(1));
					String sname=rs.getString(2);
					String sphone=rs.getString(3);
					String semail=rs.getString(4);
					String sage=Integer.toString(rs.getInt(5));
					String sclas=rs.getString(6);
					String scity=rs.getString(7);
					String sstate=rs.getString(8);
					String spin=Integer.toString(rs.getInt(9));
					String sgender=rs.getString(10);
					
					
					f=new JFrame("STUDENT DETAILS");
					
					l1=new JLabel("STUDENT_ID");
					l1.setBounds(50, 80, 90, 30);
					t1=new JTextField(uid);
					t1.setBounds(200, 80, 160, 30);
					t1.setEditable(false);
					
					l2=new JLabel("s_name");
					l2.setBounds(50, 120, 90, 30);
					nm=new JTextField(sname);
					nm.setBounds(200, 120, 160, 30);
					nm.setEditable(false);
					
					l3=new JLabel("s_phone");
					l3.setBounds(50, 160, 90, 30);
					ph=new JTextField(sphone);
					ph.setBounds(200, 160, 160, 30);
					
					l4=new JLabel("s_email");
					l4.setBounds(50, 200, 90, 30);
					em=new JTextField(semail);
					em.setBounds(200, 200, 160, 30);
					
					l5=new JLabel("s_age");
					l5.setBounds(50, 240, 90, 30);
					ag=new JTextField(sage);
					ag.setBounds(200, 240, 160, 30);
					
					l6=new JLabel("s_class");
					l6.setBounds(50, 280, 90, 30);
					cl=new JTextField(sclas);
					cl.setBounds(200, 280, 160, 30);
					cl.setEditable(false);
					
					l7=new JLabel("s_city");
					l7.setBounds(50, 320, 90, 30);
					ct=new JTextField(scity);
					ct.setBounds(200, 320, 160, 30);
					 
					l8=new JLabel("s_state");
					l8.setBounds(50, 360, 90, 30);
					st=new JTextField(sstate);
					st.setBounds(200, 360, 160, 30);
					
					l9=new JLabel("s_pin");
					l9.setBounds(50, 400, 90, 30);
					pin=new JTextField(spin);
					pin.setBounds(200, 400, 160, 30);
					
					l10=new JLabel("s_gender");
					l10.setBounds(50, 440, 90, 30);
					gd=new JTextField(sgender);
					gd.setBounds(200, 440, 90, 30);
					gd.setEditable(false);
					
					
					b1=new JButton("BACK");
					b1.setBackground(Color.green);
					b1.setBounds(90, 520, 90, 30);
					b1.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e)
						{
							backButton(e);
						}
					});
					

					b2=new JButton("UPDATE");
					b2.setBackground(Color.ORANGE);
					b2.setBounds(300, 520, 90, 30);
					b2.addActionListener(new ActionListener() 
					{
						
						@Override
						public void actionPerformed(ActionEvent e)
						{
							updateButton(e);
						}
					});
					
					b3=new JButton("EXIT");
					b3.setBackground(Color.magenta);
					b3.setBounds(510, 520, 90, 30);
					b3.addActionListener(new ActionListener()
					{
						
						@Override
						public void actionPerformed(ActionEvent arg0) 
						{
							exitButton(arg0);
						}
					});
					
					
					
					f.add(l1);
					f.add(l2);
					f.add(l3);
					f.add(l4);
					f.add(l5);
					f.add(l6);
					f.add(l7);
					f.add(l8);
					f.add(l9);
					f.add(l10);
					f.add(t1);
					f.add(nm);
					f.add(ph);
					f.add(em);
					f.add(ag);
					f.add(cl);
					f.add(ct);
					f.add(st);
					f.add(pin);
					f.add(gd);
					f.add(b1);
					f.add(b2);
					f.add(b3);
					
					f.setSize(800, 1000);
					f.setLayout(null);
					f.setVisible(true);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(rootPane, "ID NOT FOUND");

			}
			
			
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	protected void exitButton(ActionEvent arg0)
	{
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		ShowstudentDetails sd=new ShowstudentDetails();
		sd.setVisible(false);
		this.dispose();

	}


	protected void updateButton(ActionEvent e)
	{
		Updatestudent sd=new Updatestudent();
		sd.setVisible(true);
		this.dispose();
	}


	protected void backButton(ActionEvent e) 
	{
		Homepage hp=new Homepage();
		hp.setVisible(true);
		this.dispose();
	}


	public static void main(String[] args) 
	{
		new ShowstudentDetails();
	}

}
