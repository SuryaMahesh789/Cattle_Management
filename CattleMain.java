
import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Event.*;
import java.util.ArrayList;

//cattle vaccination class

class cattle_vaccination
{
	public	String date_of_vaccination;
	public	String vaccination_type;
	public String vaccination_amount;
    
    public cattle_vaccination(String dov,String vtype,String vamount)
    {
    	date_of_vaccination=dov;
    	vaccination_type=vtype;
    	vaccination_amount=vamount;
    }
	
}

//Cattle_Vaccination_Class:
//Date_to_be_vaccination,vaccination_type, vaccination amount
//vaccination amount = AMOUNT TO BE PAID FOR THE VACCINATION OF CATTLE
//vaccination_type = TYPE OF THE VACCINE , DEFAULT PROVIDED THREE TYPES OF VACCINES
//date_of_vaccination = CATTLE D=SHOULD BE VACCINATED IN THAT DATE
//end of cattle vaccination class


//Cattle_FeedInfo_Class:
//Date_to_be_purchase = CATTLE PURCHASED DAE 
//Quantity,Price= NUMBER OF CATTLE BOUGHT,PRICE OF CATTLE RESPECTIVELY
//,Type of feedm = FEEDING TYPE ,CATEGORIES OF FOOD ITEMS CATTLE PREFERS TO EAT
//DETAILS REGARDING THE FEEDING OF THE CATTLE

class feed_info
{
	public	String date_of_purchase;
	public	String quantity;
	public	String price;
	public	String feed_type;
	
	public feed_info(String dop,String quan,String pri,String ftype)
	{
		 date_of_purchase=dop;
		 quantity=quan;
		 price=pri;
		 feed_type=ftype;
	}
	
	
}
////Cattle_FeedInfo_Class ends


//REGARDING THE INSURANCE OF THE CATTLE
//DATE ASSINGED FOR THE CATTLE TO BE INSURANCED
//DATE DUE FOR THE VACCINATION OF THE CATTLE
//Cattle_Insurance Class:
//Insurance_done_date,Insurance_due_date

class cattle_insurance
{
	public	String insurance_done_date;
	public	String insurance_due_date;
	
	
	public cattle_insurance(String idone,String idue)
	{
		 insurance_done_date=idone;
		 insurance_due_date=idue;
	}
	
}
//Cattle_Insurance Class: endss


//Cattle_Info_Class
// contain cattle_name, cattle_ID, cattle_type, Cattle_Insuranceobject,
// Cattle_Vaccinationobject, Cattle_Feedinfoobject.

class cattle_info
{
	
String cattle_name;
String cattle_id;
String cattle_type;

cattle_vaccination cv;
feed_info fi;
cattle_insurance ci;

public cattle_info(String cname,String cid,String ctype)
{
	
	cattle_name=cname;
	cattle_id=cid;
	cattle_type=ctype;	
}



public String display()
{
	
	
	String s= " CATTLE NAME :"+cattle_name+"\n  CATTLE ID :"+cattle_id+"\n CATTLE TYPE :"+cattle_type;
	s+="\n DATE OF VACCINATION : "+cv.date_of_vaccination;
	s+="\n VACCINATION TYPE  : "+cv.vaccination_type;
	s+="\n VACCINATION AMOUNT : "+cv.vaccination_amount+"  $";
	s+="\n DATE OF PURCHASE   :"+fi.date_of_purchase;
	s+="\n QUANTITY   :"+fi.quantity;
	s+="\n PRICE  :"+fi.price;
	s+="\n FEED TYPE   :"+fi.feed_type;
	s+="\n INSURANCE DONE DATE  :"+ci.insurance_done_date;
	s+="\n INSURANCE DUE DATE  :"+ci.insurance_due_date;
	
	System.out.println(" CATTLE DETAILS : "+s);
	return s;
	
}

}

//and if any details missed out
//needs to throw an user defined exception with an appropriate message.
// MSG IS THE STRING PASSED AS THE REFFERENCE FOR THE TYPE OF THE EXCEPTION 

class DataInsufficient extends Exception
{
	
	public DataInsufficient(String msg)
	{
		System.out.println(" DataInsufficient EXCEPTION RAISED - FILL ALL THE FIELDS ");
		System.out.println(msg);
	}
	
	public String displaymsg(String msg)
	{
		String mm="";
		mm+=" EXCEPTION DUE TO INSUFFICIENT DATA - "+msg;
		return mm;
		
	}
	
	public String toString()
	{
		return " DataInsufficient EXCEPTION RAISED - FILL ALL THE FIELDS ";
	}
}



//JFramewindow with the following swing components
//1. Required Text Fields to get the Cattle information
//2. Three Buttons with caption Submit, Alert and PeriodicSummary
//3. One Text Area to display the alert information and cattle information.

class cattle_details implements ActionListener
{
	
	private static final String EXIT_ON_CLOSE = null;
	JFrame jf,jf2;
	JTextField jt,jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10;;
	JLabel jlb,jlb1,jlb2,jlb3,jlb4,jlb5,jlb6,jlb7,jlb8,jlb9,jlb10,jll1,jll2,jll3,jll4;
	JTextArea jta,jta1,jta2;
	JList jl,jl1,jl2,jl3;
	JCheckBox jc1,jc2,jc3,jc4,jc5,jc6;
	JButton jb,jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8;
	JRadioButton jr1,jr2,jr3,jr4,jr5,jr6,jr7,jr8,jr9;
	ButtonGroup bg,bg2,bg3;

	JComboBox <String>jcb,jcb1,jcb2;
	JList <String> jlist;
	JScrollPane jsp;
	JMenuBar jmb;
	JMenu jm;
	JMenuItem i1,i2,i3,i4,i5;
	JComboBox  month, year;
	
	ArrayList<cattle_info>l=new ArrayList<cattle_info>();
	
	public cattle_details()
	{
		
		jf=new JFrame();
		jf.setVisible(true);
		jf.setLayout(new FlowLayout());
		jf.setSize(500,500);
		jf.setTitle(" CATTLE-DETAILS ");
	    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    jlb=new JLabel("CATTLE - DETAILS - FORM  ");
	    jlb.setForeground(Color.RED);
	    jf.add(jlb);
	    
	    jlb1=new JLabel("\n ENTER CATTLE NAME ");
	    jlb1.setForeground(Color.BLUE);
	    jf.add(jlb1);
	    
	    jt1=new JTextField(10);
	    jf.add(jt1);
	    
	    jlb2=new JLabel("\n ENTER CATTLE ID  ");
	    jlb2.setForeground(Color.BLUE);
	    jf.add(jlb2);
	    
	    jt2=new JTextField(10);
	    jf.add(jt2);
	    
	    jlb3=new JLabel("SELECT CATTLE TYPE");
	    jlb3.setForeground(Color.BLUE);
	    jf.add(jlb3);
	    
	       jr1=new JRadioButton("AMERICAN-BEEF");
		   jf.add(jr1);
		   
		   jr2=new JRadioButton("AUSTRALIAN-BEEF");
		   jf.add(jr2);
		   
		   jr3=new JRadioButton("ASIAN-BEEF");
		   jf.add(jr3);
		   
		   bg=new ButtonGroup();
		   bg.add(jr1);
		   bg.add(jr2);
		   bg.add(jr3);
		   
		   
		   jlb4=new JLabel("\n ENTER CATTLE PRICE ");
		    jlb4.setForeground(Color.BLUE);
		    jf.add(jlb4);
		    
		    jt4=new JTextField(5);
		    jf.add(jt4);
		    
		    jlb5=new JLabel("\n ENTER CATTLE QUANTITY ");
		    jlb5.setForeground(Color.BLUE);
		    jf.add(jlb5);
		    
		    jt5=new JTextField(5);
		    jf.add(jt5);
		    
		    jlb6=new JLabel("\n ENTER VACCINATION AMOUNT ");
		    jlb6.setForeground(Color.BLUE);
		    jf.add(jlb6);
		    
		    jt6=new JTextField(5);
		    jf.add(jt6);
		    
		    jll1=new JLabel("SELECT FEED TYPE");
		    jll1.setForeground(Color.BLUE);
		    jf.add(jll1);
		    
		    
		    String feeding[]= {"GRASS","FLOOR","POWDER","GREENGRAMS","WET GRASS"};
		    jcb=new<String> JComboBox(feeding);
		    jcb.setForeground(Color.BLUE);
		    jcb.setFont(new Font("ARIAL",Font.ITALIC,20));
		    
		   
		    	jcb.setMaximumRowCount(2);
		    	jcb.setEditable(true);
		    	jf.add(jcb);
		    	jcb.addActionListener(this);
		    
		    	   jll3=new JLabel("SELECT VACCINATION TYPE");
				    jll3.setForeground(Color.BLUE);
				    jf.add(jll3);
		    	 
			    String vaccination_type[]= {"COVACCINE","COVISHIELD","MASTERDOSE"};
			    jcb1=new<String> JComboBox(vaccination_type);
			    jcb1.setForeground(Color.BLUE);
			    	
			    
			    jcb1.setMaximumRowCount(2);
		    	jcb1.setEditable(true);
		    	jf.add(jcb1);
		    	jcb1.addActionListener(this);
		    
			    
		    	jlb7=new JLabel("\n ENTER DATE OF VACCINATION ");
			    jlb7.setForeground(Color.BLUE);
			    jf.add(jlb7);
			    
			    jt7=new JTextField(10);
			    jf.add(jt7);
			    
		    	jlb8=new JLabel("\n ENTER DATE OF PURCHASE ");
			    jlb8.setForeground(Color.BLUE);
			    jf.add(jlb8);
			    
			    jt8=new JTextField(10);
			    jf.add(jt8);
		    
		    	jlb9=new JLabel("\n ENTER INSURANCE DONE DATE ");
			    jlb9.setForeground(Color.BLUE);
			    jf.add(jlb9);
			    
			    jt9=new JTextField(10);
			    jf.add(jt9);
			    
		    	jlb10=new JLabel("\n ENTER INSURANCE DUE DATE ");
			    jlb10.setForeground(Color.BLUE);
			    jf.add(jlb10);
			    
			    jt10=new JTextField(10);
			    jf.add(jt10);
			    
			    
			    
		   jb=new JButton("SUBMIT");
		    jf.add(jb);
		    jb.addActionListener(this);
		    
		    jb1=new JButton("ALERT");
		    jf.add(jb1);
		    jb1.addActionListener(this);
		    
		    jb2=new JButton("PERIODIC-SUMMARY");
		    jf.add(jb2);
		    jb2.addActionListener(this);
		   
		   
		    
		    jta=new JTextArea();
			 jf.add(jta); 
			 
			 jll2=new JLabel("");
			    jll2.setForeground(Color.MAGENTA);
			    jf.add(jll2);
		
		
	}


	public void actionPerformed(ActionEvent e)
	{
		
	jta.setText("");
	jll2.setText("");
	
	String cname=jt1.getText();
	String cid=jt2.getText();
	String ctype="";
	
	
	if(jr1.isSelected())
	{
		ctype="AMERICAN-BEEF";
	}
	else if(jr2.isSelected())
	{
		ctype="AUSTRALIAN-BEEF";
	}
	else 
		if(jr3.isSelected())
		{
			ctype="ASIAN-BEEF";
		}
	
	
	
	String vamount=jt6.getText();
		String dov=jt7.getText();
		  String feedtype=(String)jcb.getSelectedItem();
		  String vacctype=(String)jcb1.getSelectedItem();
		 
			
		String dop=jt8.getText();
		String pri=jt4.getText();
		String quan=jt5.getText();
		String idone=jt9.getText();
		String idue=jt10.getText();
	
	int l1=cname.length();
	int l2=cid.length();
	int l3=ctype.length();
	   int l4=vamount.length();
				int l5=dov.length();
			
			//	int l6=feedtype.length();
			//	int l7=vacctype.length();
	int l8=dop.length();
	int l9=pri.length();
	int l10=quan.length();
	int l11=idone.length();
	int l12=idue.length();
		

		
//	When submit button is pressed		
if(e.getActionCommand().equals("SUBMIT"))
{
	//Need to store the Cattle_Info object in Array list and if any details missed out
	//needs to throw an user defined exception with an appropriate message.
	try
	{
		if(l1==0)
		{
			throw new DataInsufficient("NAME FIELD EMPTY");
		}
		if(l2==0)
		{
			throw new DataInsufficient("ID FIELD EMPTY");
		}
		if(l3==0)
		{
			throw new DataInsufficient("TYPE FIELD NOT SELECTED ");
		}
		if(l4==0)
		{
			throw new DataInsufficient("VACCINATION AMOUNT  FIELD EMPTY");
		}
		if(l5==0)
		{
			throw new DataInsufficient("DATE OF VACCINATION FIELD EMPTY");
		}
		
		if(l8==0)
		{
			throw new DataInsufficient("DATE OF PURCHASE FIELD EMPTY");
		}
		if(l9==0)
		{
			throw new DataInsufficient("PRICE FIELD  EMPTY ");
		}
		if(l10==0)
		{
			throw new DataInsufficient("QUANTITY FIELD EMPTY");
		}
		if(l11==0)
		{
			throw new DataInsufficient("INSURANCE DONE DATE FIELD EMPTY");
		}
		if(l12==0)
		{
			throw new DataInsufficient("INSURANCE DUE DATE FIELD EMPTY");
			
		}
	}
	catch(Exception te)
	{
		System.out.println(te);
	}
	
	//if any details missed out
	//needs to throw an user defined exception with an appropriate message.
	
	
	if(l1!=0 && l2!=0 && l3!=0 && l4!=0 && l5!=0  && l8!=0 && l9!=0 && l10!=0 && l11!=0 && l12!=0)
	{
		cattle_info cob=new cattle_info(cname,ctype,cid);
		cob.ci=new cattle_insurance(idone,idue);
		//cob.ci.insurance_done_date=idone;
	//	cob.ci.insurance_due_date=idue;
		
		cob.cv=new cattle_vaccination(dov,vacctype,vamount);
	//	cob.cv.date_of_vaccination=dov;
	//	cob.cv.vaccination_amount=vamount;
	//	cob.cv.vaccination_type=vacctype;
		
		cob.fi=new feed_info(dop,quan,pri,feedtype);
		//cob.fi.date_of_purchase=dop;
		//cob.fi.feed_type=feedtype;
		//cob.fi.price=pri;
		//cob.fi.quantity=quan;
		l.add(cob);
		jll2.setText(" CATTLE ADDED INTO RECORDS ");
		jta.setText(" CLICK PERIODIC SUMMARY BUTTON TO GET THE DETAILS ");	
	}
	
	
}


//When alert button is pressed
//1. Cattle_Vaccination_Alerts–display how many days left to vaccination
//2. Cattle_Feed_Alerts-display how many days left to purchase
//3. Cattle_Insurance_Alerts-display how many days left to renew insurance.
//The above said alert information has to be displayed in text area for the given Cattle ID

if(e.getActionCommand().equals("ALERT"))
{

	try
	{
		if(l1!=0 && l2!=0 && l3!=0 && l4!=0 && l5!=0   && l8!=0 && l9!=0 && l10!=0 && l11!=0 && l12!=0)
		{
			cattle_info cob=new cattle_info(cname,ctype,cid);
			cob.ci=new cattle_insurance(idone,idue);
			//cob.ci.insurance_done_date=idone;
		//	cob.ci.insurance_due_date=idue;
			
			cob.cv=new cattle_vaccination(dov,vacctype,vamount);
		//	cob.cv.date_of_vaccination=dov;
		//	cob.cv.vaccination_amount=vamount;
		//	cob.cv.vaccination_type=vacctype;
			
			cob.fi=new feed_info(dop,quan,pri,feedtype);
			//cob.fi.date_of_purchase=dop;
			//cob.fi.feed_type=feedtype;
			//cob.fi.price=pri;
			//cob.fi.quantity=quan;
			
		String alert="\n TODAY'S DATE - 10- FEBRUARY - 2022";;


		alert+="\n CATTLE_VACCINATION ALERTS  \n ";
		alert+="\n VACCINATED DATE - "+cob.cv.date_of_vaccination;
		alert+="\n STAY ALERT VERY FEW DAYS LEFT.. - "+"FROM 10- FEBRUARY - 2022  TO "+cob.cv.date_of_vaccination+"\n";

		alert+="\n CATTLE_FEED ALERTS  \n ";
		alert+="\n CATLLE TO BE PURCHASED  ON  - "+cob.fi.date_of_purchase;
		alert+="\n STAY ALERT VERY FEW DAYS LEFT.. - "+"FROM 10- FEBRUARY - 2022 TO"+cob.fi.date_of_purchase+"\n";


		alert+="\n CATTLE_INSURANCE ALERTS  \n ";
		alert+="\n CATLLE TO BE INUSURANCED  ON  - "+cob.ci.insurance_done_date;
		alert+="\n STAY ALERT VERY FEW DAYS LEFT.. - "+"FROM 10- FEBRUARY - 2022 TO"+cob.ci.insurance_done_date+"\n";
		alert+=" LAST DATE OF VACCINTION IS "+cob.ci.insurance_due_date;


		alert+="\n KINDLY CHECK THE INTERFACE FREQUENTLY.....";
		jta.setText(alert);
		jta.append("\n AS PER CATTLE DETAILS IN THE RECORD \n ");
		}
		
		else
		{
			throw new DataInsufficient(" FIELDS  MUST NOT BE EMPTY");
		}	
	}
	catch(Exception alerte)
	{
		System.out.println(alerte);
	}

}		

//When button PeriodicSummary is pressed
// Display all the details of given Cattle ID

if(e.getActionCommand().equals("PERIODIC-SUMMARY"))
{
	
	try
	{
		if(l1!=0 && l2!=0 && l3!=0 && l4!=0 && l5!=0  && l8!=0 && l9!=0 && l10!=0 && l11!=0 && l12!=0)
		{
			cattle_info cob=new cattle_info(cname,ctype,cid);
			cob.ci=new cattle_insurance(idone,idue);
			//cob.ci.insurance_done_date=idone;
		//	cob.ci.insurance_due_date=idue;
			
			cob.cv=new cattle_vaccination(dov,vacctype,vamount);
		//	cob.cv.date_of_vaccination=dov;
		//	cob.cv.vaccination_amount=vamount;
		//	cob.cv.vaccination_type=vacctype;
			
			cob.fi=new feed_info(dop,quan,pri,feedtype);
			//cob.fi.date_of_purchase=dop;
			//cob.fi.feed_type=feedtype;
			//cob.fi.price=pri;
			//cob.fi.quantity=quan;
			
			
		String disp=cob.display();

		jta.setText(disp);
		jta.append("\n CATTLE DETAILS IN THE RECORD \n ");	

		}
		
		else
		{
			throw new DataInsufficient(" FIELDS  MUST NOT BE EMPTY");
		}	
	}
	catch(Exception alerte)
	{
		System.out.println(alerte);
	}
	
}		
	
	}
	
	
	
}

//CATTLE MAIN CLASS TO CREATE GUI FRAME FOR THE CATTLE DETAILS

public class CattleMain
{

public static void main(String[] args) {
	cattle_details cd=new cattle_details();
}
}