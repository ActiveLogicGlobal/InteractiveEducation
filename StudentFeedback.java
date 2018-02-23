package knowledgepoint;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.*;

public class StudentFeedback implements KeyListener , MouseListener, ActionListener ,WindowListener
{JLabel err1;
    Connection conn;
JFrame f;
JPanel p;//,pfeed;
JLabel b,lq,name,usr,ll,err,l,dt,lp;
JLabel lt[],ln[],lg[],li[],lf,lfa;
JTextArea ques;
JTextArea feed,feedans;
JTextField uid,tname;
JButton  srchfeed,submit,reset,logout,back,bck;
String sname=null,usrid=null;
Date d;
SimpleDateFormat ft;

    StudentFeedback(String s,String u)
    {   
            srchfeed=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\srchfeed.png"));
            srchfeed.setBounds(425,100,172,46);
            d=new Date();
            dt=new JLabel();
            lp=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w31.jpg"));
            lp.setBounds (350,70,600,500);
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));
        sname=s;
        usrid=u;
	f=new JFrame();
        f.setVisible(true);

	p=new JPanel();
       // pfeed=new JPanel();
        l=new JLabel("Feedback");
        l.setFont(new Font("Times New Roman",0,30));
	l.setForeground(new Color(0,0,153));
	
        b=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\sss.png"));
	lq=new JLabel("FEEDBACK");
	lq.setFont(new Font("Times New Roman",0,18));
	lq.setForeground(new Color(0,0,153));
	name=new JLabel("NAME");
	name.setFont(new Font("Times New Roman",0,18));
	name.setForeground(new Color(0,0,153));
	usr=new JLabel("USER ID");
	usr.setFont(new Font("Times New Roman",0,18));
	usr.setForeground(new Color(0,0,153));
        err=new JLabel();err.setForeground(new Color(204,0,0));
	submit =new JButton("SUBMIT");
	submit.setFont(new Font("Times New Roman",0,15));
	submit.setForeground(new Color(0,0,153));

	reset=new JButton("RESET");
	reset.setFont(new Font("Times New Roman",0,15));
	reset.setForeground(new Color(0,0,153));

        logout=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\logout.jpg"));
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        srchfeed.setBorder(BorderFactory.createEmptyBorder());
        srchfeed.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        back=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa1.png"));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));

        bck=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa2.png"));
        bck.setBorder(BorderFactory.createEmptyBorder());
        bck.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));

	ques=new JTextArea();
	ques.setFont(new Font("Times New Roman",0,18));
	ques.setForeground(new Color(0,0,0));
	ques.setLineWrap(true);
	
	tname=new JTextField();
	tname.setFont(new Font("Times New Roman",0,18));
	tname.setForeground(new Color(0,0,0));

	uid=new JTextField();
	uid.setFont(new Font("Times New Roman",0,18));
	uid.setForeground(new Color(0,0,0));

	f.setTitle("Knowledge Point");
	l.setBounds(100,30,200,30);        
        logout.setBounds (450,50,105,36);
        logout.setIconTextGap(2);
        logout.setMargin(new java.awt.Insets(2, 2, 2, 2));
       
        srchfeed.setIconTextGap(2);
        srchfeed.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        back.setBounds (20,65,80,26);
        back.setIconTextGap(2);
        back.setMargin(new java.awt.Insets(2, 2, 2, 2));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        bck.setIconTextGap(2);
        bck.setMargin(new java.awt.Insets(2, 2, 2, 2));
        bck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ques.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
    
	usr.setBounds(50,150,95,30);	uid.setBounds(180,150,310,30);      //vans.setBounds(20,120,130,25);  
        name.setBounds(50,200,95,30);	tname.setBounds(180,200,310,30); 
	lq.setBounds(50,250,120,30);	ques.setBounds(180,250,310,120);
        err.setBounds (230,370,300,20);
	submit.setBounds(100,400,120,30);reset.setBounds(290,400,120,30);
	
        f.add(p);
        p.add(b);
        b.add(lp);
        lp.add(l);
	lp.add(name);	
	lp.add(lq);
	lp.add(usr);
        lp.add(err);
        lp.add(submit);      submit.addKeyListener((KeyListener)this);submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lp.add(tname);
        tname.setText(sname); tname.setEditable(false);
	lp.add(ques);
	lp.add(uid); uid.setText(usrid);uid.setEditable(false);
	lp.add(reset);       reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	lp.add(logout);   lp.add(srchfeed)  ;
        lp.add(back);
//        b.add(vans);        vans.addActionListener((ActionListener)this);vans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tname.addKeyListener((KeyListener) this);
	reset.addMouseListener((MouseListener) this);
        logout.addMouseListener((MouseListener)this);
        back.addMouseListener((MouseListener)this);
        srchfeed.addMouseListener((MouseListener)this);
        submit.addMouseListener((MouseListener)this);
        f.setSize(1369,729);
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);

    }
    public void srchFeed()
    {
        lq.setVisible(false);        name.setVisible(false);        usr.setVisible(false);      submit.setVisible(false);
        ques.setVisible(false);      uid.setVisible(false);         tname.setVisible(false);    reset.setVisible(false);
        lf=new JLabel("Feedback");      feed=new JTextArea();           feed.setLineWrap(true);
        lfa=new JLabel("Answer");        feedans=new JTextArea();       feedans.setLineWrap(true);
        lf.setFont(new Font ("Times New Roman",0,20));              lf.setForeground(new Color(0,0,153));
        feed.setFont(new Font ("Times New Roman",0,18));            feed.setForeground(new Color(153,0,153));
        lfa.setFont(new Font ("Times New Roman",0,20));              lfa.setForeground(new Color(0,0,153));        
        feedans.setFont(new Font ("Times New Roman",0,18));              feedans.setForeground(new Color(153,0,153));        
        bck.setBounds(20,120,30,30);
        lf.setBounds(50,150,80,30);         feed.setBounds(130,150,400,90);      feed.setEditable(false);
        lfa.setBounds(50,260,80,30);        feedans.setBounds(130,260,400,150);   feedans.setEditable(false);
        lp.add(bck);                        bck.addActionListener((ActionListener)this);
        err1 =new JLabel();
        err1.setBounds(130,150,400,90);
        err1.setFont(new Font("Times New Roman",0,20));
        err1.setForeground(new Color(204,0,0));
        lp.add(err1);
        try
        {
            connect c=new connect();
                Statement st;
                st=c.conn.createStatement();
                ResultSet res=st.executeQuery("select * from adminfeed where uid='"+uid.getText().toString()+"'");
         String fdbck=null,fdbckans=null;                
                while(res.next())
                {
                fdbck=res.getString(3);
                fdbckans=res.getString(4);
                feed.setText(fdbck);
                feedans.setText(fdbckans);
              //  lp.add(lf);     lp.add(lfa);     lp.add(feed);     lp.add(feedans);
                }
                
        }
            catch(Exception ex)
            {
                System.out.println("==="+ex.getMessage());
            }
               lp.add(lf);     lp.add(lfa);     lp.add(feed);     lp.add(feedans);
       if(feed.getText().length()==0)
        {
            lf.setVisible(false);    lfa.setVisible(false);  feed.setVisible(false);   feedans.setVisible(false);
            err1.setText("No Results Found");
        }
        else
       {
           lf.setVisible(true);    lfa.setVisible(true);  feed.setVisible(true);   feedans.setVisible(true);
           err1.setText("");
       }
        }
      public void windowClosing(WindowEvent e)
      {  
	int a=JOptionPane.showConfirmDialog(f,"Do you want to exit Knowledge Point?","Knowledge Point",JOptionPane.INFORMATION_MESSAGE);  
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
 public void mouseClicked(MouseEvent e)
	{
	Object o=e.getSource();
  	if (o==reset)
		{
		ques.setText("");
		}  
        if(o==srchfeed)
        {
            srchfeed.setEnabled(false);
            srchFeed();
            
        }
        if(o==logout)
            {
               StudentLog sp=new StudentLog();        
               f();
            }
       if(o==back)
            {
               Stud sp=new Stud(sname,usrid);        
               f();
            }        
        if(o==submit)
        {
            if(ques.getText().length()>=4)
            {
                try
                            {
                   //             System.out.println("try BLock");
        Connection con;
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                              PreparedStatement ps,ps1;
                              ps=con.prepareStatement("insert into feedback values(?,?,?,?)");
                              ps.setString(1,uid.getText().toString());
                              ps.setString(2,tname.getText().toString());
                              ps.setString(3,ques.getText().toString());
                              ps.setString(4,dt.getText().toString());
                             
                                int i=ps.executeUpdate();
                                if((i==1)&&(ques.getText().length()!=0))
                                {   
                                    err.setText("");
                                 submit.setEnabled(false);
                                 f.setVisible(false);
                                 Stud ff=new Stud(sname ,usrid);
                                }
                                else
                                {
                                     }
                             }
                            catch(Exception ex)
                           {
                                  err.setText(" ! Please fill all blocks ..  "+ex.getMessage());
                               //   System.out.println("error :- "+ex.getMessage());
                                  Stud s=new Stud(sname,usrid);
                                  f.setVisible(false);
                           }    
            }
            else
            {
            err.setText("Please enter your Feedback");
            }
            }
        }
 public void f()
 {
 f.setVisible(false);
 }

 @Override
 public void mousePressed(MouseEvent e){}
 @Override
 public void mouseReleased(MouseEvent e){}
 @Override
 public void mouseEntered(MouseEvent e)
 { }
@Override
 public void mouseExited(MouseEvent e) 
 { }
 @Override
	public void keyPressed(KeyEvent e) {    }  
 @Override
	public void keyReleased(KeyEvent e) {}  
 @Override
	public void keyTyped(KeyEvent e) {}
@Override
        public void actionPerformed (ActionEvent e)
        {
            Object o=e.getSource();
            if(o==bck)
            {
                StudentFeedback sf=new StudentFeedback(tname.getText(),uid.getText());
                f.setVisible(false);
            }
        }
}
