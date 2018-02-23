package knowledgepoint;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.*;
import java.util.Date;
import java.text.*;
class StudentLog implements ActionListener ,MouseListener ,WindowListener ,FocusListener
{
JFrame f;
JPanel p ,pa1,pa2,pt;
JLabel b,l,lid,lpas,ldes,ldev,lpic ,err,err1,dt,dt1;
JTextField tid;
JPasswordField pas;
JButton blog;
JRadioButton ba,bf,bs;
ButtonGroup bg;
JButton sreg,treg;
JTabbedPane tp;
JTextArea pboard;
Date d;
SimpleDateFormat ft,ft1;
        StudentLog()
	{
             d=new Date();
            dt=new JLabel();
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy ");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));
            f=new JFrame("Knowledge Point ");
		p=new JPanel();                             pt=new JPanel();
                pboard=new JTextArea();     pa1=new JPanel();           pa2=new JPanel();
                ba=new JRadioButton("ADMIN");               ba.setFont(new Font("Times New Roman",0,12));   
                bf=new JRadioButton("FACULTY");             bf.setFont(new Font("Times New Roman",0,12));
                bs=new JRadioButton("STUDENT");             bs.setFont(new Font("Times New Roman",0,12));
                bg=new ButtonGroup();                       
                b=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w3.jpg"));
                pt.setLayout(null);
                pa1.setLayout(null);                pa2.setLayout(null);
              	l=new JLabel("Knowledge Point");
            	l.setFont(new Font("Times New Roman",0,35));
                l.setForeground(new Color(0,0,153));
                sreg=new JButton("New Student");       sreg.setForeground(new Color(0,0,153));sreg.setFont(new Font("Times New Roman",0,15));
                treg=new JButton("New Faculty");       treg.setForeground(new Color(0,0,153));treg.setFont(new Font("Times New Roman",0,15));
		lid=new JLabel("User ID");                       lid.setFont(new Font("Times New Roman",0,15));
		lpas=new JLabel("Password");                     lpas.setFont(new Font("Times New Roman",0,15));
                err=new JLabel();                                err.setForeground (new Color(204,0,0));err.setFont(new Font("Times New Roman",0,15));
                err1=new JLabel();                                err1.setForeground (new Color(204,0,0));err1.setFont(new Font("Times New Roman",0,15));
                lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\log1.png"));
		tid=new JTextField();
		pas=new JPasswordField();	
		blog=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\lgn.jpg"));
                tp=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
                ldes = new JLabel("<html>&nbsp; Very often students don't ask questions in class because they don't want to be seen <br>&nbsp;&nbsp;asking a question. The Knowledge Point gives an opportunity to the students , to  <br>&nbsp;&nbsp;clear their doubts. Students can increase their knowledge by asking their questions. <br> &nbsp; Thus, the faculty members will answer.<br><br>&nbsp;<B> Answers Just Ahead! Keep Asking</B><br></html>");
                ldev = new JLabel("<html><B>Developed By:-</B><br> Simrandeep Kaur . . . . Kirandeep Kaur<br> B.Tech(CSE) <t> . . . . . . . . . MCA</html>");
                tp.setBounds (0,0,540,350);
                pt.setBounds(100,205,540,355);
                pa1.setBounds (50,205,550,350);
                pa2.setBounds (50,205,550,350);
                pboard.setBounds(2,0,532,350);
                pboard.setFont(new Font("Times New Roman",4,20));
                pboard.setForeground(new Color(0,204,204));
                pboard.setLineWrap(true);
                pboard.setEditable(false);
                dt.setBounds(100,600,400,30);
                try
                {
                connect c=new connect();
                Statement st;
                st=c.conn.createStatement();
                ResultSet res=st.executeQuery("select * from msg");
                String name=null;
                while(res.next())
                {
                    name=res.getString(1);
                }
                pboard.setText(name);
               }
                catch(Exception ex)
                {
                }
                ldes.setBounds (0,0,500,160); ldes.setForeground(new Color(0,0,153));ldes.setFont (new Font("Times New Roman",0,15));
                ldev.setBounds (200,200,400,100);ldev.setForeground(new Color(0,0,153));ldev.setFont (new Font("Times New Roman",0,15));
                l.setBounds(100,20,640,53);
		lpic.setBounds(800,130,400,500);
		
                lid.setBounds(20,200,70,30);
		lpas.setBounds(20,250,70,30);
		tid.setBounds(120,200,200,30);	
		pas.setBounds(120,250,200,30);
                ba.setBounds(20,300,90,30);         bf.setBounds(123,300,90,30);        bs.setBounds(226,300,90,30);
                treg.setBounds(50,400,100,25);      sreg.setBounds(200,400,100,25);
            	blog.setBounds(130,345,103,37);     blog.setBorder(BorderFactory.createEmptyBorder());
                err.setBounds (50,430,300,20);      err1.setBounds (50,450,300,20);
                f.add(p);
                p.add(b);
                b.add(l);
		b.add(lpic);
                b.add(pt);
                b.add(dt);
                pt.add(tp);
                tp.add("BULLETIN BOARD" , pa2);             tp.setFont(new Font("Times New Roman",0,15));
                tp.add("ABOUT US",pa1);              
               pa1.setBackground(Color.WHITE);
                pa1.add(ldes);
                pa1.add(ldev);
                pa2.add(pboard);
                lpic.add(sreg);
                lpic.add(treg);
		lpic.add(lid);
		lpic.add(lpas);
		lpic.add(tid);          tid.addFocusListener((FocusListener)this);
		lpic.add(pas);
                bg.add(ba);             bg.add(bf);         bg.add(bs);
                ba.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                bf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                bs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                lpic.add(ba);           ba.addMouseListener((MouseListener)this);
                lpic.add(bf);           bf.addMouseListener((MouseListener)this);
                lpic.add(bs);           bs.addMouseListener((MouseListener)this);
                lpic.add(err);          lpic.add(err1);
		lpic.add(blog);         blog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		blog.addActionListener ((ActionListener)this);	
sreg.addActionListener ((ActionListener)this);sreg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));sreg.setMargin(new java.awt.Insets(2, 2, 2, 2));
treg.addActionListener ((ActionListener)this);treg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));treg.setMargin(new java.awt.Insets(2, 2, 2, 2));
		f.setSize(1369,729);
		f.setVisible(true);
                tp.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI()
                        {
                        protected int calculateTableHeight(int tabPlacement,int tabIndex,int fontHeight)
                        {return 50;}
                        }
                );
                    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);

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
      
      public void focusLost(FocusEvent e){}
      public void focusGained(FocusEvent e)
      {
      Object o=e.getSource();
      if(o==tid)
      {
      err.setText("");
      err1.setText("");
      }
      }

@Override
	public void actionPerformed(ActionEvent e)
	{
       		Object o=e.getSource();
		if(o==blog)
		{	String user=null,pass=null;
                Boolean bu=false ,bp=false;
                       user=tid.getText();
                       pass=pas.getText();
         if(ba.isSelected())
          {
             try
            {
                connect c=new connect();               
                Statement st;
                st=c.conn.createStatement();
     
                ResultSet res=st.executeQuery("select * from admin");
                String  password=null,userid=null;
                while(res.next())
                {
                    if( (pass.equals(res.getString(2)))    &&(user.equalsIgnoreCase(res.getString(1))))
                    {
                     bu=true;
                    bp=true;
                    password=res.getString(2);
                    userid=res.getString(1);
                    }
                }
                if((bu==true)&&(bp==true))
                {   
			AdminPortal spl=new AdminPortal();
                        f.setVisible(false);
                }
                else
                {
                     err.setText(" ! User ID or Password is incorrect ");
                     tid.setText("");
                     pas.setText("");
                     bg.clearSelection();
                     err1.setText("");
                     
                }
                 }
            catch(Exception ex)
            {
              //  System.out.println(ex.getMessage());
            }
         
                       }
          if(bf.isSelected())
          {
                               try
                   {
                connect c=new connect();               
                Statement st;
                st=c.conn.createStatement();
     
                ResultSet res=st.executeQuery("select * from facreg");
                String name=null,password=null,userid=null;
                while(res.next())
                {
                    if( (pass.equals(res.getString(9)))    &&(user.equalsIgnoreCase(res.getString(10))))
                    {
                     bu=true;
                    bp=true;
                    name=res.getString(1);
                    password=res.getString(9);
                    userid=res.getString(10);
                    }
                }
                if((bu==true)&&(bp==true)&&(pas.getText()!=null)&&(password.length()!=0))
                {            
            dt1=new JLabel();
            ft1 =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm:ss a zzz");
            dt1.setText(ft1.format(d));
                    
//insert into table 
                    try
                    {
                    connect co=new connect();
                PreparedStatement ps;
                ps=c.conn.prepareStatement("insert into log values(?,?,?)");
                ps.setString(1,userid.toString());
                ps.setString(2,name.toString());
                ps.setString(3,dt1.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {
                //    System.out.println("record inserted");
                }
     
                    }
                    catch(Exception ex)
                    {
                  //  System.out.println("exception insert to log = "+ex.getMessage());
                    }
          
			Fac spl=new Fac(name,userid);
                        f.setVisible(false);
                }
                else if ((pas.getText()==null))
                {
                     err.setText("Your User ID has been blocked .");
                }
                else
                {
                     err.setText(" ! User ID or Password is incorrect ");
                     tid.setText("");
                     pas.setText("");
                     bg.clearSelection();
                     err1.setText("");
                if(password.length()==0)
                {
                err.setText("your id has been blocked");
                err1.setText("");
                }
                if((password.length()==0)&&(pas.getText()!=null))
                {
                err.setText("id blocked ");
                }

                }
                 }
                    catch(Exception ex)
                    {
                    //System.out.println(ex.getMessage());
                   }
         
           }
                       if(bs.isSelected())
                       {
                          try
                    {
                    connect c=new connect();               
               
                    Statement st;
                st=c.conn.createStatement();
     
                ResultSet res=st.executeQuery("select * from name");
                String name=null,password=null,userid=null;
                while(res.next())
                {
                    if( (pass.equals(res.getString(9)))    &&(user.equalsIgnoreCase(res.getString(10))))
                    {
                     bu=true;
                    bp=true;
                    name=res.getString(1);
                    password=res.getString(9);
                    userid=res.getString(10);
         
                    }
                }
                
                if((bu==true)&&(bp==true)&&(pas.getText()!=null)&&(password.length()!=0))
                {        dt1=new JLabel();
          ft1 =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm:ss a zzz");
          dt1.setText(ft1.format(d));
                    
//insert into table 
                    try
                    {
                    connect co=new connect();
                PreparedStatement ps;
                ps=c.conn.prepareStatement("insert into stlog values(?,?,?)");
                ps.setString(1,userid.toString());
                ps.setString(2,name.toString());
                ps.setString(3,dt1.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {
                  //  System.out.println("record inserted");
                }
     
                    }
                    catch(Exception ex)
                    {
                    //System.out.println("exception insert to log = "+ex.getMessage());
                    }
     
			Stud spl=new Stud(name,userid);
                        f.setVisible(false);
                }
            else
            {
                     err.setText(" ! User ID or Password is incorrect ");
                     tid.setText("");
                     pas.setText("");
                     bg.clearSelection();
                if(password.length()==0)
                {
                err.setText("your id has been blocked");
                err1.setText("");
                }
                if((password.length()==0)&&(pas.getText()!=null))
                {
                err.setText("id blocked ");
                }
            }
         }
         catch(Exception ex)
                {
//                System.out.println(ex.getMessage());
                }
         
            }
                 if(bg.getSelection()==null)     
                 {
                 err1.setText("Please select your designation .");
                 }
                 if(err.getText()=="your id has been blocked")
                 {
                 err1.setText("");
                 }
                 if(err.getText()==" ! User ID or Password is incorrect ")
                 {
                 err1.setText("");
                 }
                 if((o==ba)||(o==bs)||(o==bf))
                 {
                  err1.setText("");
                 }
        }           
                
            if(o==sreg)
            {
            FinalRegisterStudent frs=new FinalRegisterStudent();
            f.setVisible(false);
            }
            if(o==treg)
            {
            FinalRegisterFaculty frf=new FinalRegisterFaculty();
            f.setVisible(false);
            }
	}

        public void mouseClicked(MouseEvent e)
        {
                Object o=e.getSource();
                if((o==ba)||(o==bs)||(o==bf))
                {
                    err1.setText("");
                }
        }
        
        
        public void mousePressed(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}

    
}