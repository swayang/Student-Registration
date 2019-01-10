package org.oecm19.studentApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ShowstudentId  extends JFrame
{
	JFrame f;
	static JLabel l1;
	static JTextField id;
	JButton b1,b2,b3;
	
	public ShowstudentId()
	{
		f=new JFrame("STUDENT OPERATION");
		l1=new JLabel("student_id");
		l1.setBounds(70,80,90,30);
		id=new JTextField();
		id.setBounds(200, 80, 90, 30);
		
		b1=new JButton("SHOW");
		b1.setBounds(90, 150, 90, 30);
		b1.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				showButton(arg0);
			}
		});
		
		b2=new JButton("EDIT");
		b2.setBounds(230, 150, 90, 30);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				editButton(arg0);
			}
		});
		
		f.add(l1);
		f.add(id);
		f.add(b1);
		f.add(b2);
		f.setSize(600, 400);
		f.setLayout(null);
		f.setVisible(true);
		
		}
	protected void editButton(ActionEvent arg0)
	{
		ShowstudentDetails sd=new ShowstudentDetails();
		sd.setVisible(true);
		this.dispose();
	}
	protected void showButton(ActionEvent arg0)
	{
		ShowstudentDetails sd=new ShowstudentDetails();
		sd.setVisible(true);
		this.dispose();
	}
	public static void main(String[] args)
	{
		new ShowstudentId();
	}

}
