package org.oecm19.studentApp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Homepage extends JFrame
{
	JFrame f;
	MenuBar mbar;
	Menu m1,m2,m3;
	MenuItem i1,i2,i3;
	JLabel l;
	JTextArea txt;
	
	public Homepage()
	{
		initcomponents();
	}

	private void initcomponents()
	{
		
		f=new JFrame("HOMEPAGE");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon image=new ImageIcon();
		l=new JLabel();
		mbar=new MenuBar();
		
		
		txt=new JTextArea();
		txt.setBackground(Color.red);
		txt.setText("   STUDENT INVENTORY SYSTEM   ");
		txt.setBounds(50, 80, 200, 40);
		
		
		m1=new Menu("Registration");
		i1=new MenuItem("StudentRegistration");
		m1.add(i1);
		
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				studentregismenuItem(e);
			}
		});
		
		m2=new Menu("FeesStructure");
		i2=new MenuItem("StudentPayment");
		m2.add(i2);
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				studentpaymentButton(e);
			}
		});
		
		m3=new Menu("ShowDetails");
		i3=new MenuItem("StudentDetails");
		m3.add(i3);
		
		i3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				studentdetailsShow(arg0);
			}
		});
		
		
		
		f.setMenuBar(mbar);
		f.add(txt);
		mbar.add(m1);
		mbar.add(m2);
		mbar.add(m3);
		f.add(l);
		f.setSize(600, 400);
		f.setLayout(null);;
		f.setVisible(true);
		
		
	}

	protected void studentpaymentButton(ActionEvent e) 
	{
		FeesDetails fd=new FeesDetails();
		fd.setVisible(true);
		this.dispose();
	}

	protected void studentdetailsShow(ActionEvent arg0) 
	{
		ShowstudentId sd=new ShowstudentId();
		sd.setVisible(true);
		this.dispose();
	}

	

	private void studentregismenuItem(ActionEvent e)
	{
		StudentRegistration sr=new StudentRegistration();
		sr.setVisible(true);
		this.dispose();
	}

	private void studentloginmenuItem(ActionEvent e)
	{
		JOptionPane.showMessageDialog(rootPane, "THIS PAGE IS UNDER CONSTRUCTION.", "ALERT",
				JOptionPane.WARNING_MESSAGE);
						this.dispose();
	}

	private void adminloginmenuItem(ActionEvent e)
	{
		AdminLogin ad=new AdminLogin();
		ad.setVisible(true);
		this.dispose();
	}

	public static void main(String[] args) 
	
	{
		new Homepage();
	}

}
