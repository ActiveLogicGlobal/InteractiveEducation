package knowledgepoint;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.*;

public class FinalRegisterStudent implements KeyListener,MouseListener,ActionListener ,FocusListener ,WindowListener
{connect c;
int row;
String d=null,m=null,y=null,date=null;
JFrame f;
JLabel lpic,bkgd,dt;
JPanel p;
JComboBox day ,month ,year,tcourse ; 
JLabel register,name,dob,course,rollno,address,eid,gender,contact,usr,createp,confirmp;
JLabel err,err1,agen ,altname,alteid ,acourse,aroll, acont, acreate,aadr,auid,adob ;
JTextField tname,taddr ,troll,teid,tcont,tusr;
JPasswordField tcreate,tconfirm;
JRadioButton male ,female;
ButtonGroup b;
JButton submit ,reset ,exit,home;
Date dd;
SimpleDateFormat ft;

	FinalRegisterStudent()
	{ 
           dd=new Date();
            dt=new JLabel();
         
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm:ss a zzz");
            dt.setText(ft.format(dd));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));

	 f=new JFrame();
	 p=new JPanel();
         bkgd=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w3.jpg"));
	 lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\p5.jpg"));
	 usr=new JLabel("USER ID");	usr.setFont(new Font("Times New Roman",0,18)); 
         home=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\hm.png"));
         home.setFont(new Font("Times New Roman",0,12));     home.setForeground(new Color(0,0,153));
	altname=new JLabel(" ");    altname.setForeground(new Color(204,0,0));
	acourse=new JLabel();       acourse.setForeground(new Color(204,0,0));
	aroll=new JLabel();         aroll.setForeground(new Color(204,0,0));
	acont=new JLabel() ;        acont.setForeground(new Color(204,0,0));
	acreate=new JLabel() ;      acreate.setForeground(new Color(204,0,0));
        err=new JLabel();           err.setForeground (new Color(204,0,0));
        err1=new JLabel();           err1.setForeground (new Color(204,0,0));
	alteid=new JLabel();        alteid.setForeground(new Color(204,0,0));
	aadr=new JLabel();          aadr.setForeground(new Color(204,0,0));
	agen=new JLabel();          agen.setForeground(new Color(204,0,0));
        adob=new JLabel();          adob.setForeground(new Color(204,0,0));
        
	tusr=new JTextField();      tusr.setEditable(false);
	//auid=new JLabel();	 	auid.setForeground(new Color(204,0,0));
	register=new JLabel("REGISTER YOURSELF HERE");      register.setFont(new Font("Times New Roman",0,26));     register.setForeground(new Color(0, 0,153));
        name=new JLabel("NAME");	name.setFont(new Font("Times New Roman",0,18)); 
	dob=new JLabel("D.O.B.");	dob.setFont(new Font("Times New Roman",0,18)); 
	course=new JLabel("COURSE");	course.setFont(new Font("Times New Roman",0,18)); 
        rollno=new JLabel("ROLL NO.");	rollno.setFont(new Font("Times New Roman",0,18)); 
	address=new JLabel("ADDRESS");	address.setFont(new Font("Times New Roman",0,18)); 
	eid=new JLabel("E-MAIL ID");	eid.setFont(new Font("Times New Roman",0,18)); 
	gender=new JLabel("GENDER");	gender.setFont(new Font("Times New Roman",0,18)); 
	contact=new JLabel("CONTACT");	contact.setFont(new Font("Times New Roman",0,18)); 
	createp=new JLabel("CREATE PASSWORD");	createp.setFont(new Font("Times New Roman",0,18)); 
	confirmp=new JLabel("CONFIRM PASSWORD");confirmp.setFont(new Font("Times New Roman",0,18)); 
	submit=new JButton("SUBMIT");	submit.setFont(new Font("Times New Roman",0,18)); 
	reset =new JButton("RESET");	reset.setFont(new Font("Times New Roman",0,18)); 
	exit=new JButton("EXIT");	exit.setFont(new Font("Times New Roman",0,18));// exit.setBackground(Color.WHITE);
	b=new ButtonGroup();
	
	 tname=new JTextField();
	 day=new JComboBox();
         day.setModel(new DefaultComboBoxModel(new String[]{"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
         month=new JComboBox();
         month.setModel(new DefaultComboBoxModel(new String[]{"month","JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"}));
         year=new JComboBox(); 
         year.setModel(new DefaultComboBoxModel(new String[]{"year","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006",}));
         tcourse=new JComboBox(); 
         tcourse.setModel(new DefaultComboBoxModel(new String[]{"Course","B.Tech","M.Tech","BCA","MCA","B.SC.","Hotel Management","Any Other"}));
	 troll=new JTextField();
	 taddr=new JTextField();
	 teid=new JTextField();	
	 male=new JRadioButton("Male");	male.setFont(new Font("Times New Roman",0,18)); 
	 female=new JRadioButton("Female");	female.setFont(new Font("Times New Roman",0,18)); 
	 tcont=new JTextField();
	 tcreate=new JPasswordField();
	 tconfirm=new JPasswordField();
	 b.add(male);
	 b.add(female);
//	 p.setBackground(new Color(255,204,204));	
	 f.setTitle("Knowledge Point");	
	 f.add(p);
	p.add(bkgd);
	f.setVisible(true);
	f.setSize(1369,729);
	//p.setLayout(null);

	register.setBounds(250,50,600,20);          home.setBounds(1000,60,154,32);          home.setIconTextGap(2); home.setMargin(new java.awt.Insets(2, 2, 2, 2));
        usr.setBounds(100,110,100,20);          tusr.setBounds(350,110,250,20); //	auid.setBounds(650,500,200,20);
	name.setBounds(100,160,100,20);     tname.setBounds(350,160,250,20);	altname.setBounds(650,160,250,20);	
	dob.setBounds(100,205,100,20);	day.setBounds(350,205,60,20);	month.setBounds(420,205,100,20);	year.setBounds(530,205,70,20);	adob.setBounds(650,205,80,20);

	course.setBounds(100,250,100,20);	tcourse.setBounds(350,250,250,20);	acourse.setBounds(650,250,250,20);
	rollno.setBounds(100,300,100,20);	troll.setBounds(350,300,250,20);	aroll.setBounds (650,300,200,20);
	address.setBounds(100,350,100,20);	taddr.setBounds(350,350,250,20);	aadr.setBounds(650,350,200,20);
	eid.setBounds(100,400,100,20);          teid.setBounds(350,400,250,20);		alteid.setBounds(650,400,250,30); 
	gender.setBounds(100,450,100,20);	male.setBounds(350,450,100,20);         female.setBounds(500,450,100,20); agen.setBounds(650,450,100,20);	
	contact.setBounds(100,500,100,20);	tcont.setBounds(350,500,250,20);	acont.setBounds(650,500,200,20);
	createp.setBounds(100,550,250,20);	tcreate.setBounds(350,550,250,20);	acreate.setBounds(650,550,200,20);
	confirmp.setBounds(100,600,250,20);	tconfirm.setBounds(350,600,250,20);     err.setBounds (400,630,250,30);     err1.setBounds (400,630,250,30);
	submit.setBounds(150,660,150,20);	reset.setBounds(400,660,150,20);	exit.setBounds(650,660,150,20);
	lpic.setBounds(900,200,200,301);    
        bkgd.setBounds(0,0,1369,729);
	bkgd.add(register);
        bkgd.add(home);             home.addActionListener((ActionListener)this);home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	bkgd.add(name);	
	bkgd.add(dob);	
	bkgd.add(course);
	bkgd.add(rollno);
	bkgd.add(address);
	bkgd.add(eid);
	bkgd.add(gender);
	bkgd.add(contact);
	bkgd.add(usr);
	bkgd.add(createp);
	bkgd.add(confirmp);
	bkgd.add(submit);          submit.addMouseListener((MouseListener)this);
                                   submit.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        bkgd.add(reset);           reset.addMouseListener((MouseListener)this);
                                   reset.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	bkgd.add(exit);            exit.addActionListener((ActionListener)this);exit.addMouseListener ((MouseListener)this);
	bkgd.add(tname);           tname.addKeyListener((KeyListener)this);        tname.addFocusListener((FocusListener)this);
	bkgd.add(day);             day.addFocusListener((FocusListener)this);day.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkgd.add(month);           month.addFocusListener((FocusListener)this);month.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkgd.add(year);            year.addFocusListener((FocusListener)this);year.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bkgd.add(adob);
	bkgd.add(tcourse);         tcourse.addFocusListener((FocusListener)this);
	bkgd.add(troll);           troll.addKeyListener((KeyListener)this);        troll.addFocusListener((FocusListener)this);
	bkgd.add(taddr);           taddr.addKeyListener((KeyListener)this);        taddr.addFocusListener((FocusListener)this);
	bkgd.add(teid);            teid.addKeyListener((KeyListener)this);         teid.addFocusListener((FocusListener)this);
	bkgd.add(male);            male.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	bkgd.add(female);          female.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	bkgd.add(tusr);           // tusr.addFocusListener((FocusListener)this);
	bkgd.add(tcont);           tcont.addKeyListener((KeyListener)this);        tcont.addFocusListener((FocusListener)this);
	bkgd.add(tcreate);         tcreate.addFocusListener((FocusListener)this);
	bkgd.add(tconfirm);	tconfirm.addFocusListener((FocusListener)this);
	bkgd.add(lpic);
	bkgd.add(altname);

	bkgd.add(alteid);
	bkgd.add(acourse);
	bkgd.add(aroll);
	bkgd.add(agen);
	bkgd.add(acont);
//	p.add(auid);
	bkgd.add(acreate);

	bkgd.add(aadr);
        bkgd.add(err);
        bkgd.add(err1);
         Connection con;
    int row;
   
        try
        {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from name");
        rs.last();
        row=rs.getRow();
         autogen(row);
        }
        catch(Exception e)
        {
    
        }
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);

        }
void autogen(int row)
  {
      try
      {
          if(row<=8)
          {
              tusr.setText("S00"+String.valueOf(row+1));
          }
          
          else if((row>=9)||(row<=98))
          {
              tusr.setText("S0"+String.valueOf(row+1));
          }
          else if((row>=99))//||row<=999)
          {
              tusr.setText("S"+String.valueOf(row+1));
          }
              
      }
      catch(Exception e)
      {
        //  System.out.println("catched auto gen error = "+e.getMessage());
      }
  }
  
    
      public void windowClosing(WindowEvent e)
      {  
	int a=JOptionPane.showConfirmDialog(f,"Are you sure to exit?");  
	if(a==JOptionPane.YES_OPTION)
        {  
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}  
     }  
      public void windowDeactivated(WindowEvent e){}
      public void windowActivated(WindowEvent e){}
      public void windowDeiconified(WindowEvent e){}
      public void windowIconified(WindowEvent e){}
      public void windowClosed(WindowEvent e){}
      public void windowOpened(WindowEvent e){}
      

     @Override
     public void focusLost(FocusEvent e)
     {               Object o=e.getSource();
        
        if((o==day)||(o==month)||(o==year))
                {
                    if((day.getSelectedItem()=="Day")||(month.getSelectedItem()=="month")||(year.getSelectedItem()=="year"))
                            {
                            adob.setText(" ! Invalid dob");
                            }
                    else
                    {
                            adob.setText("");
                    }
                }
        
     
                    if(o==tname) 
                         {
                            if(tname.getText().length()<=2)
                                {altname.setText("Enter name");}
                        }
                     if((o==day)&&(o==month)&&(o==year))
                     {
                        if((day.getSelectedItem()=="Day")||(month.getSelectedItem()=="month")||(year.getSelectedItem()=="year"))
                        {
                        adob.setText("! Invalid dob");
                        }
                        else
                        {adob.setText("");}
                            }
                     if(o==tcourse)
                     {
                     if(tcourse.getSelectedItem()=="Course")
                     {
                     acourse.setText("! Invalid Course");
                     }
                     else
                     {
                     acourse.setText("");
                     }
                     }
                     if(o==taddr)
                         {
                                      if(taddr.getText().length()<=1)
                                                             {
                                                                             aadr.setText("Enter your home address");
                                                              }
                         }
                          if(o==troll)
                        {
                            if(troll.getText().length()==0)
                            {
                                             aroll.setText("Enter rollno");
                             }
                         }
                     if(o==teid)
                        {
                                                   if(teid.getText().length()==0)
                                                                {
                                                                   alteid.setText("Enter email id");
                                                                               }
                                                      if(teid.getText().length()!=0)
                                                           {
                                                            Pattern MyPattern =Pattern.compile("^[a-z]+[a-z.0-9-]+@[a-z.-]+(\\.[A-Za-z0-9]+)$");
                                                             Matcher MyMatcher=MyPattern.matcher(teid.getText());
                                                               Boolean MyBoolean =MyMatcher.matches();
                                                                                  if(MyBoolean==true)
                                                                                             {
                     
                                                                                                alteid.setText("");
                                                                                                }
                                                                                    else
                                                                                   {
                                                                                    alteid.setText("Enter valid email id ");
                                                                                         }
                                                             }
          
                         }
                           if(o==tcont)
                                 {
                                                     if((tcont.getText().length()>10)||(tcont.getText().length()<10))
                                                                {acont.setText("! Enter valid no.");}
                                   } 
                             if(o==tcreate)
                                  {
                                      if(tcreate.getText().length()<6)
                                                                       {
                                                                       acreate.setText("password length should atleast 6");
                                                                          }
                                     }
                                  if(o==tconfirm)
                                    {
                                                                   if((tcreate.getText()).equals(tconfirm.getText()))
                                                                 {
                                                                    acreate.setText("");
                                                                            }
                                                                      else
                                                                          {
                                                                          acreate.setText("Password Mismatch");
                                                                               tcreate.setText("");
                                                                                tconfirm.setText("");
                                                                            }
                                              }
   }
        @Override
        public void focusGained(FocusEvent e)
        {Object o=e.getSource();
        
        }
        @Override
	public void keyPressed(KeyEvent e) {}  
        @Override
 	public void keyReleased(KeyEvent e) {}  
        @Override
	public void keyTyped(KeyEvent e) 
	{  
	Object o=e.getSource();
	
        if(o==tname)
	{	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		
		altname.setText("! Enter characters only .");
		
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		altname.setText("");
		}
	}
        
        if(o==troll)
        {
        char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
                aroll.setForeground(new Color(204,0,0));
		aroll.setText("! Enter valid Roll number ");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		aroll.setText("");
		}
	}
       if(o==taddr)
	{
		char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		aadr.setText("! Enter valid character ");
		}
		if((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		aadr.setText("");
		}
	}
	if(o==tcourse)
	{
		char c=e.getKeyChar();
if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		acourse.setText("! Enter valid character ");
		}	
if((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		acourse.setText(" ");
		}

	}
	if(o==tcont)
	{
	char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		acont.setText("! Enter valid number ");
		}
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		acont.setText(" ");
		}
	}
      
}
        @Override
 	 public void mouseClicked(MouseEvent e) 
	{
	Object o=e.getSource();
		if (o==reset)
		{
         
		tname.setText("");
		day.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);
                taddr.setText("");
                tcourse.setSelectedIndex(0);
		troll.setText("");
		teid.setText("");
		tcont.setText("");
		b.clearSelection();
		tcreate.setText("");
		tconfirm.setText("");
                err.setText("");
                err1.setText("");
                agen.setText("");
                altname.setText("");
                alteid.setText("");
                acourse.setText("");
                aroll.setText("");
                acont.setText("");
                acreate.setText("");
                aadr.setText("");
                auid.setText("");
                adob.setText("");

		}
                
                if(o==submit)
               {   
                           d=day.getSelectedItem().toString();
                           m=month.getSelectedItem().toString();                
                           y=year.getSelectedItem().toString(); 
                           date=d+"/"+m+"/"+y;
                            if((tname.getText().length()==0)||(taddr.getText().length()==0)||(tcourse.getSelectedItem().toString()=="Course")||(troll.getText().length()==0)||(teid.getText().length()==0)||(tcont.getText().length()==0)||(tusr.getText().length()==0)||(day.getSelectedItem()==null)||(month.getSelectedItem()==null)||(year.getSelectedItem()==null)||(acreate.getText()=="Password Mismatch"))
                                 {//System.out.println("invalid data ");
                                  err.setText("please fill all blocks .");
                                 }
                                 else{         
                            try
                            {
                              connect c=new connect();
                              PreparedStatement ps,ps1;
                              ps=c.conn.prepareStatement("insert into name values(?,?,?,?,?,?,?,?,?,?,?)");
                          
                              ps.setString(1,tname.getText().toString());
                              
                              ps.setString(2,date.concat("").toString());
                           
                              ps.setString(3,tcourse.getSelectedItem().toString());
                              ps.setString(4,troll.getText().toString());
        
                              ps.setString(5,taddr.getText().toString());
                              ps.setString(6,teid.getText().toString());
                   
                          if(male.isSelected())
                                                {
                                                       ps.setString(7,male.getText().toString());
                                                 }
                            if(female.isSelected())
                                                {
                                                  ps.setString(7,female.getText().toString());
                                                }
               ps.setString(8,tcont.getText().toString());
                   
                     ps.setString(10,tusr.getText().toString());
                   
                 ps.setString(9,tconfirm.getText().toString());
                 ps.setString (11,dt.getText().toString());
                                int i=ps.executeUpdate();

                                if(i==1)
                                {
                                 err.setText("Record Inserted");
                                 JOptionPane.showMessageDialog(null,"Please remember your User Id '"+tusr.getText()+"'");
                                 StudentLog r=new StudentLog();
                                 f.setVisible(false);
                                err.setText("");
                                err1.setText("record inserted");err1.setForeground (new Color(0,0,153));
                                }
                                else
                                {
                                     err.setText("Record cant be submitted . ");
                                }                          }
                            catch(Exception ex)
                           {
                                  err.setText("else catched no recordsto insert");
                            }    
               }}
}
	@Override
	public void mouseEntered(MouseEvent e)
        { Object o=e.getSource();
        if(o==exit)
        {  exit.setForeground(Color.WHITE);
           exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
           exit.setBackground(new Color(204,0,0));
           exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        if(o==submit)
        {         submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
                  submit.setBackground(new Color(82,203,65));
                  submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));   
          }
        if(o==reset)
        {  reset.setForeground(Color.WHITE);
           reset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)));
           reset.setBackground(new Color(1,191,224));
           reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        }
        }
        @Override 
	public void mouseExited(MouseEvent e) 
        {
        Object o=e.getSource();
        if(o==exit)
        {
           exit.setBackground(null);
           exit.setForeground(Color.BLACK);
           exit.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
         
        }
        if(o==reset)
        { // reset.setBounds(400,660,150,20);
           reset.setBackground(null);
           reset.setForeground(Color.BLACK);
           reset.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
         
        }
        if(o==submit)
        {
        submit.setBackground(null);
        submit.setForeground(Color.BLACK);
        submit.setBorder(javax.swing.BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }   
        }
        @Override
	public void mousePressed(MouseEvent e) {}  
        @Override
	public void mouseReleased(MouseEvent e){} 
        @Override
	public void actionPerformed (ActionEvent e)
	{
		Object o=e.getSource();
		if(o==exit)
		{
                    StudentLog sl=new StudentLog();
                 f.setVisible(false);
		}
                if(o==home)
                {
                StudentLog s=new StudentLog();
                f.setVisible(false);
                }
        }
        
	
}