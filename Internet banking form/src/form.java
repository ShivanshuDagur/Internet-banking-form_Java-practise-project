package open_ended;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class UiUx implements ActionListener
{
	JFrame frame = new JFrame("Internet Banking Form");
	Container con = frame.getContentPane();
	JLabel lhead,lname,lemail,lmobile,lgender,ldob,lset_pass,lconfirm_pass,lacc_no,ladd,lcity,lstate,lpincode,laadhar,lacc_type;
	JTextField tname,temail,tmobile,tacc_no,tadd,tcity,tpincode,taadhar,tstate;
	
	JPasswordField pass,confirm_pass;
	
	JRadioButton  r1,r2,r3,r4;
	ButtonGroup gender = new ButtonGroup();
	ButtonGroup acc_type = new ButtonGroup();
	
	JComboBox day,month,year;
	JCheckBox term;
	JTextArea display;
	JButton add,reset,update,next,previous;
	
	
	
	UiUx()
	{
		frame.setBounds(100,50,740,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(null);
		con.setBackground(Color.YELLOW);
		
		//Heading
		Font f = new Font("Arial",Font.BOLD,30);
		lhead = new JLabel("Internet Banking Form");
		lhead.setBounds(200,5,400,35);
		lhead.setFont(f);
		con.add(lhead);
		
		//
		lname = new JLabel("Name");
		lname.setBounds(50,50,60,30);
		con.add(lname);
		
		lgender = new JLabel("Gender");
		lgender.setBounds(50,80,60,30);
		con.add(lgender);
		
		ldob = new JLabel("Date of birth");
		ldob.setBounds(50,110,100,30);
		con.add(ldob);
		
		
		lemail = new JLabel("Email");
		lemail.setBounds(50,140,60,30);
		con.add(lemail);
		
		lmobile = new JLabel("Mobile");
		lmobile.setBounds(50,170,60,30);  
		con.add(lmobile);
		
		lacc_no = new JLabel("Account Number");
		lacc_no.setBounds(50,200,100,30);
		con.add(lacc_no);
		
		lacc_type = new JLabel("Account Type");
		lacc_type.setBounds(50,230,100,30);
		con.add(lacc_type);
		
		lset_pass = new JLabel("Password");
		lset_pass.setBounds(50,260,60,30);
		con.add(lset_pass);
		
		lconfirm_pass = new JLabel("Confirm Password");
		lconfirm_pass.setBounds(50,290,120,30);
		con.add(lconfirm_pass);
		
		ladd = new JLabel("Address");
		ladd.setBounds(50,320,60,30);
		con.add(ladd);
		
		lcity = new JLabel("City");
		lcity.setBounds(50,350,60,30);
		con.add(lcity);
		
		lstate = new JLabel("State");
		lstate.setBounds(50,380,60,30);
		con.add(lstate);
		
		lpincode = new JLabel("Pincode");
		lpincode.setBounds(50,410,60,30);
		con.add(lpincode);
		
		laadhar = new JLabel("Aadhar Number");
		laadhar.setBounds(50,440,100,30);
		con.add(laadhar);
		
		tname = new JTextField();
		tname.setBounds(160,53,180,20);
		con.add(tname);
		
		r1 = new JRadioButton("Male");
		r1.setBounds(160,83,80,30);
		r1.setBackground(Color.YELLOW);
		con.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(270,83,80,30);
		r2.setBackground(Color.YELLOW);
		con.add(r2);
		
		gender.add(r1);
		gender.add(r2);
		
		r3 = new JRadioButton("Savings");
		r3.setBounds(160,233,80,30);
		r3.setBackground(Color.YELLOW);
		con.add(r3);
		
		r4 = new JRadioButton("Current");
		r4.setBounds(270,233,80,30);
		r4.setBackground(Color.YELLOW);
		con.add(r4);
		
		acc_type.add(r3);
		acc_type.add(r4);
		
		
		
		temail = new JTextField();
		temail.setBounds(160,143,230,20);
		con.add(temail);
		
		tmobile = new JTextField();
		tmobile.setBounds(160,173,150,20);
		con.add(tmobile);
		
		taadhar = new JTextField();
		taadhar.setBounds(160,443,150,20);
		con.add(taadhar);
		
		tacc_no = new JTextField();
		tacc_no.setBounds(160,203,150,20);
		con.add(tacc_no);
		
		tadd = new JTextField();
		tadd.setBounds(160,323,200,20);
		con.add(tadd);
		
		tcity = new JTextField();
		tcity.setBounds(160,353,180,20);
		con.add(tcity);
		
		tpincode = new JTextField();
		tpincode.setBounds(160,413,100,20);
		con.add(tpincode);
		
		 pass = new JPasswordField();
		 pass.setBounds(160,263,180,20);
		 con.add(pass);
		 
		 confirm_pass = new JPasswordField();
		 confirm_pass.setBounds(160,293,180,20);
		 con.add(confirm_pass);
		 
		 String days[] = new String[31];
		 for(int i = 1;i <= 31; i++)
		 {
			 days[i-1] = Integer.toString(i) ;
		 }
		 day = new JComboBox(days);
		 day.setBounds(160,113,40,25);
		 day.setEditable(true);
		 con.add(day);
		 
		 String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		 month = new JComboBox(months);
		 month.setBounds(220,113,60,25);
		 month.setEditable(true);
		 con.add(month);
		 
		 String years[] = new String [100];
		 for(int i = 1951;i < 2051; i++)
		 {
			 years[i -1951] = Integer.toString(i);
		 }
		 
		 year = new JComboBox(years);
		 year.setBounds(300,113,60,25);
		 year.setEditable(true);
		 con.add(year);
		 
		 tstate = new JTextField();
		 tstate.setBounds(160,383,150,25);
		 con.add(tstate);
		 
		 term = new JCheckBox("I acccept terms and conditions.");
		 term.setBounds(70,470,250,25);
		 term.setBackground(Color.YELLOW);
		 con.add(term);
		 
		 add = new JButton("ADD");
		 add.setBounds(100,500,80,25);
		 con.add(add);
		 
		 reset = new JButton("RESET");
		 reset.setBounds(200,500,80,25);
		 con.add(reset);
		 
		 Color cc = new Color(170,170,170);
		 display = new JTextArea();
		 display.setBounds(400,50,300,440);
		 con.add(display);
		 display.setBackground(cc);
		 display.setForeground(Color.WHITE);
		 display.setEditable(false);
		 
		 update = new JButton("UPDATE");
		 update.setBounds(400,500,80,25);
		 con.add(update);
		 
		 next = new JButton("NEXT");
		 next.setBounds(500,500,80,25);
		 con.add(next);
		 
		 previous = new JButton("PREVIOUS");
		 previous.setBounds(600,500,100,25);
		 con.add(previous);
		 
		 add.addActionListener(this);
		 reset.addActionListener(this);
		 update.addActionListener(this);
		 next.addActionListener(this);
		 previous.addActionListener(this);
}
	 public void actionPerformed(ActionEvent e)
	 {
	 try
		{
		//get a connection to database 
		Connection myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","shivanshu","root");
		// create a statement
		Statement mystmt = myconn.createStatement();
		//execute sql query
		ResultSet myRs = null;
		
		String name,gender,dob,email,acc_no,mobile,acc_type,passw,con_pass;
		String add,city,state,pin,aadhar;
		
		 String ch = e.getActionCommand();
		 if(ch == "ADD")
		 {
			 passw = pass.getText();
			 con_pass = confirm_pass.getText();
			 
			 if (pass.equals(con_pass))
			 {
				 display.setText("Passwords don't match");
			 }
			 else
			 {
				 name = tname.getText();
				 email = temail.getText();
				 mobile = tmobile.getText();
				 acc_no = tacc_no.getText();
				 add = tadd.getText();
				 city = tcity.getText();
				 state = tstate.getText();
				 pin = tpincode.getText();
				 aadhar = taadhar.getText();
				 
				 gender = "Male";
				 if (r2.isSelected())
					 gender = "Female";
				 
				 acc_type = "savings";
				 if (r4.isSelected())
					 acc_type = "current";
				 
//				 myRs = mystmt.executeQuery("select * from abc");
				 
				 myRs = mystmt.executeQuery(" INSERT INTO `customers` VALUE ('"+pid+"','"+tid+"','"+rid+"',"+tspent+",'"+des+"') ");
				 
				 
			 
			 
			 }
		 }
		 else if(ch == "RESET")
		 {
			 tname.setText(null);
			 tadd.setText(null);
			 taadhar.setText(null);
			 tcity.setText(null);
			 tstate.setText(null);
			 tpincode.setText(null);
			 tname.setText(null);
			 temail.setText(null);
			 tmobile.setText(null);
			 tacc_no.setText(null);
			 pass.setText(null);
			 confirm_pass.setText(null);
			 gender.clearSelection();
			 term.setSelected(false);
			 day.setSelectedIndex(0);
			 month.setSelectedIndex(0);
			 year.setSelectedIndex(0);
		 }
		 else if(ch == "UPDATE")
		 {
			 
		 }
		 else if(ch == "PREVIOUS")
		 {
			 
		 }
		 else if(ch == "NEXT")
		 {
			 
		 }
	}//try
		 
		catch (Exception exc)
			{
				exc.printStackTrace();
			}
			
	 }
	 
	 
	
}

public class Registration
{
	public static void main(String args[])
	{
		UiUx ob = new UiUx();
	}

}
