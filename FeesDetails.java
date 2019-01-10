package org.oecm19.studentApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FeesDetails extends JFrame
{			
		JFrame f;
		JLabel l1,l2,l3,l4;
		JTextField sid,famt,fdp,ramt;
		JButton b1;
		
 	
	
		public FeesDetails()
		{
			initcomponents();
		}
	private void initcomponents() 
	    {
		f=new JFrame("FEES STRUCTURE");
		l1=new JLabel("Student id :");
		l1.setBounds(50,80,90,30);
		sid=new JTextField();
		sid.setBounds(200, 80, 90, 30);
		
		l2=new JLabel("Fees amount :");
		l2.setBounds(50, 120, 90, 30);
		famt=new JTextField();
		famt.setBounds(200, 120, 90, 30);
		famt.setText("50000");
		famt.setVisible(true);
		famt.setEditable(false);
		
		l3=new JLabel("Fees deposit :");
		l3.setBounds(50, 160, 90, 30);
		fdp=new JTextField();
		fdp.setBounds(200, 160, 90, 30);
		
		l4=new JLabel("Rest amount :");
		l4.setBounds(50, 200, 90, 30);
		ramt=new JTextField();
		ramt.setBounds(200, 200, 90, 30);
		
		b1=new JButton("SUBMIT");
		b1.setBounds(120, 250, 90, 30);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				submitButton(arg0);
			}
		});
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(sid);
		f.add(famt);
		f.add(fdp);
		f.add(ramt);
		f.add(b1);
		f.setSize(700, 600);
		f.setLayout(null);
		f.setVisible(true);
		
		
		
		
		
		
		
		}
	protected void submitButton(ActionEvent arg0) 
	{
		
		String stid=sid.getText();
		int id=Integer.parseInt(stid);
		
		String famount=famt.getText();
		int fees_amt=Integer.parseInt(famount);
		
		String fdeposit=fdp.getText();
		int fees_dep=Integer.parseInt(fdeposit);
		
		int rt= (fees_amt - fees_dep);
		System.out.println(rt);
		ramt.setText(String.valueOf(rt));
		ramt.setVisible(true);
		ramt.setEditable(false);
		
		
		
		
		String upqry="insert into project2.feesdetails values(?,?,?,?)";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			PreparedStatement pstmt=con.prepareStatement(upqry);
			pstmt.setInt(1, id);
			pstmt.setInt(2, fees_amt);
			pstmt.setInt(3, fees_dep);
			pstmt.setInt(4, rt);
			
			pstmt.executeUpdate();
			
			JOptionPane.showMessageDialog(rootPane, "FEES UPDATED  ");


			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args)
	{
		new FeesDetails();
	}

}
