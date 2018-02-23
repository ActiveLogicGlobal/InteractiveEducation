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

public class Stud implements KeyListener , MouseListener, ActionListener ,WindowListener
{Connection conn;
JFrame f;
JPanel p,p1;//,p1;
JLabel b,nm,lq,name,usr,lbl,ll,lpic,err,l,dt ,bt,bn,bg,bi,tp;
JLabel lt[],ln[],lg[],li[];
JTextArea ques;
JTextField uid,tname,sr;
JButton  submit,reset,more,logout,vans,feedback;
String sname=null,usrid=null;
Date d;
SimpleDateFormat ft;

    Stud(String s,String u)
    {         p1=new JPanel();
    p1.setLayout(null);
    
    feedback =new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\feed.png"));
//        p1.setVisible(false);
        tp=new JLabel("TOPICS FOR YOU ...");    tp.setForeground(Color.red);tp.setFont(new Font ("Times New Rman",0,22));
        bt=new JLabel(" Technical");              bt.setFont(new Font("Times New Roman",0,17));bt.setForeground(new Color(204,0,0));bt.addMouseListener((MouseListener)this);
        bn=new JLabel(" Non-Technical");           bn.setFont(new Font("Times New Roman",0,17));bn.setForeground(new Color(204,0,0));bn.addMouseListener((MouseListener)this);
        bg=new JLabel(" General Knowledge");       bg.setFont(new Font("Times New Roman",0,17));bg.setForeground(new Color(204,0,0));bg.addMouseListener((MouseListener)this);
        bi=new JLabel(" Interview Tips");         bi.setFont(new Font("Times New Roman",0,17));bi.setForeground(new Color(204,0,0));bi.addMouseListener((MouseListener)this);
            d=new Date();
            dt=new JLabel();
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));
        sname=s;
        usrid=u;
        nm=new JLabel("WELCOME "+sname.toUpperCase());
        nm.setFont(new Font("Times New Roman",0,20));
	nm.setForeground(new Color(255,0,128));
	f=new JFrame();
        f.setVisible(true);

	p=new JPanel();
        l=new JLabel("Student Portal");
        l.setFont(new Font("Times New Roman",0,30));
	l.setForeground(new Color(0,0,153));
	
        b=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w3.jpg"));
	lq=new JLabel("QUESTION");
	lq.setFont(new Font("Times New Roman",0,18));
	lq.setForeground(new Color(0,0,153));
	
	lbl=new JLabel("Ask Your Question Here ");
	lbl.setFont(new Font("Times New Roman",0,20));
	lbl.setForeground(new Color(0,0,153));
        
	lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\p9.jpg"));
        sr=new JTextField();
	name=new JLabel("NAME");
	name.setFont(new Font("Times New Roman",0,18));
	name.setForeground(new Color(0,0,153));
//	aname=new JLabel("");
//	aname.setForeground(new Color(204,0,0));
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
        
        feedback.setBorder(BorderFactory.createEmptyBorder());
        feedback.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        
        vans=new JButton("View Answered Questions");
        vans.setFont(new Font ("Times New Roman",0,15));
        vans.setForeground(new Color(0,0,153));
        
        more =new JButton("Click here to quote one more question ");
        more.setFont(new Font ("Times New Roman",0,15));
        more.setForeground(new Color(204,0,0));
         
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
	l.setBounds(100,30,200,30);         nm.setBounds(300,70,300,30);
	lbl.setBounds(80,110,550,30);  
        logout.setBounds (1250,50,105,36);
        logout.setIconTextGap(2);
        logout.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        feedback.setBounds (1100,50,90,25);
        feedback.setIconTextGap(2);
        feedback.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        sr.setBounds(100,100,50,20);
	
	ques.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
    
	usr.setBounds(50,150,95,30);	uid.setBounds(180,150,310,30);      vans.setBounds(550,150,200,25);  
        name.setBounds(50,200,95,30);	tname.setBounds(180,200,310,30); 
        lpic.setBounds(550,200,300,360);                              
        p1.setBounds(860,150,495,520);p1.setBackground(new Color(255,255,255));
	lq.setBounds(50,250,120,30);	ques.setBounds(180,250,310,120);
        err.setBounds (230,370,300,20);
	submit.setBounds(100,400,120,30);reset.setBounds(290,400,120,30);
	more.setBounds (100,500,300,30);
        tp.setBounds(950,110,300,40);
        bt.setBounds (10,0,90,30);    bn.setBounds (105,0,120,30);    bg.setBounds (230,0,150,30);    bi.setBounds (385,0,110,30);
    
        f.add(p);
        p.add(b);
        b.add(l);
        b.add(nm);
	b.add(lbl);
	b.add(name);	
	b.add(lq);
	b.add(usr);
        b.add(err);
        b.add(submit);      submit.addKeyListener((KeyListener)this);submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	b.add(tname);
        b.add(tp);
        b.add(p1);
    p1.add(bt);         bt.addMouseListener((MouseListener)this);   bt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    p1.add(bn);         bn.addMouseListener((MouseListener)this);   bn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    p1.add(bg);         bg.addMouseListener((MouseListener)this);   bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    p1.add(bi);         bi.addMouseListener((MouseListener)this);   bi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

	//   b.add(aname);
        tname.setText(sname); tname.setEditable(false);
	b.add(ques);
	b.add(uid); uid.setText(usrid);uid.setEditable(false);
	b.add(reset);       reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	b.add(lpic);
	b.add(logout);     
        b.add(feedback);feedback.addActionListener(this);
        b.add(more);        more.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b.add(vans);        vans.addActionListener((ActionListener)this);vans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        more.setEnabled(false);
	tname.addKeyListener((KeyListener) this);
	reset.addMouseListener((MouseListener) this);
        logout.addMouseListener((MouseListener)this);
        submit.addMouseListener((MouseListener)this);
      more.addMouseListener((MouseListener)this);
        f.setSize(1370,730);
         int row;
   
        try
        {
        Connection con;
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
        Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=st.executeQuery("select * from ques");
        rs.last();
        row=rs.getRow();
         autogen(row);
        }
        catch(Exception e)
        {
    //    System.out.println("error = "+e.getMessage());
        }

    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);
    
    //////////////////////////////////
      try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet res=st.executeQuery("select * from tech");
                                int i=0;
                                String name=null,pth=null;
                                while(res.next())
                                    {
                                        name=res.getString(1);
                                        pth=res.getString(2);
                                        i++;
                                    }

                               lt=new JLabel[i];
                                int y=50;
                   for(i=0;i<lt.length;i++)
                   {
                   lt[i]=new JLabel();
                   lt[i].setBounds (10,y,300,20);
                   lt[i].setFont(new Font("Times New Roman",0,14));lt[i].setForeground(new Color(0,0,153));
                   y=y+20;
                   lt[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   p1.add(lt[i]); lt[i].setVisible(false);
                   lt[i].addMouseListener((MouseListener)this);
                   }
                        if(i<=0)                
                        {
                        ll=new JLabel("no results found");
                        ll.setBounds(100,190,200,30);
                        p1.add(ll);
                        ll.setVisible(false);
                        }
                
                   res.beforeFirst();
                   String name1=null;
                 int ij=0;
                   while(res.next())
                   {
                    name1=res.getString(1);
              
               lt[ij].setText(name1);//make b1 the menu 
               //and add menu item
              ij++;  
               
                   }
                                
                     }
                    catch(Exception ex)
                     {
                     JOptionPane.showMessageDialog(f,"error = "+ex.getMessage());
                     }
    /////////////////////////////////
       try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet res=st.executeQuery("select * from ntech");
                                int i=0;
                                String name=null,pth=null;
                                while(res.next())
                                    {
                                        name=res.getString(1);
                                        pth=res.getString(2);
                                        i++;
                                    }
                               ln=new JLabel[i];
                              
                                int y=50;
                   for(i=0;i<ln.length;i++)
                   {
                   ln[i]=new JLabel();
                   ln[i].setBounds (10,y,300,20);
                   ln[i].setFont(new Font("Times New Roman",0,14));ln[i].setForeground(new Color(0,0,153));
                   y=y+20;
                   ln[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   p1.add(ln[i]);       ln[i].setVisible(false);
                    ln[i].addMouseListener((MouseListener)this);
                   }
if(i<=0)                {
                        ll=new JLabel("no results found");
                        ll.setBounds(100,190,200,30);
                        p1.add(ll);
                        ll.setVisible(false);
                        }
                   res.beforeFirst();
                   String name1=null;
                 int ij=0;
                   while(res.next())
                   {
                    name1=res.getString(1);
              
               ln[ij].setText(name1);//make b1 the menu 
               //and add menu item
              ij++;  
               
                   }
                                
                     }
                    catch(Exception ex)
                     {
                     JOptionPane.showMessageDialog(f,"error = "+ex.getMessage());
                     }
 //   b.setEnabled(
    /////////////////////////////////
        try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet res=st.executeQuery("select * from gk");
                                int i=0;
                                String name=null,pth=null;
                                while(res.next())
                                    {
                                        name=res.getString(1);
                                        pth=res.getString(2);
                                        i++;
                                    }
// bt.setBounds (870,150,90,30);    bn.setBounds (960,150,130,30);    bg.setBounds (1090,150,170,30);    bi.setBounds (1240,150,150,30);                   b1=new JMenuItem[i];

                                lg=new JLabel[i];
                                int y=50;
                   for(i=0;i<lg.length;i++)
                   {
                   lg[i]=new JLabel();
                   lg[i].setBounds (10,y,300,20);
                   lg[i].setFont(new Font("Times New Roman",0,14));lg[i].setForeground(new Color(0,0,153));
                   y=y+20;
                   lg[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   p1.add(lg[i]);           lg[i].setVisible(false);
                   lg[i].addMouseListener((MouseListener)this);
                   }
                        if(i<=0)
                        {
                        ll=new JLabel("no results found");
                        ll.setBounds(100,190,200,30);
                        p1.add(ll);
                        ll.setVisible(false);
                        }

                   res.beforeFirst();
                   String name1=null;
                 int ij=0;
                   while(res.next())
                   {
                    name1=res.getString(1);
              
               lg[ij].setText(name1);//make b1 the menu 
               //and add menu item
              ij++;  
               
                   }
                                
                     }
                    catch(Exception ex)
                     {
                     JOptionPane.showMessageDialog(f,"error = "+ex.getMessage());
                     }
 //   b.setEnabled
    //////////////////////////////////////
         try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet res=st.executeQuery("select * from inter");
                                int i=0;
                                String name=null,pth=null;
                                while(res.next())
                                    {
                                        name=res.getString(1);
                                        pth=res.getString(2);
                                        i++;
                                    }
//                   b1=new JMenuItem[i];
                               li=new JLabel[i];
                                int y=50;
                   for(i=0;i<li.length;i++)
                   {
                   li[i]=new JLabel();
                   li[i].setBounds (10,y,300,20);
                   li[i].setFont(new Font("Times New Roman",0,14));li[i].setForeground(new Color(0,0,153));
                   y=y+20;
                   li[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                   p1.add(li[i]);           li[i].setVisible(false);
                   li[i].addMouseListener((MouseListener)this);
                   }
                    if(i<=0)
                        {
                    ll=new JLabel("no results found");
                        ll.setBounds(100,190,200,30);
                        p1.add(ll);
                        ll.setVisible(false);
                        }

                   res.beforeFirst();
                   String name1=null;
                 int ij=0;
                   while(res.next())
                   {
                    name1=res.getString(1);
              
               li[ij].setText(name1);//make b1 the menu 
               //and add menu item
              ij++;  
               
                   }
                                
                     }
                    catch(Exception ex)
                     {
                     JOptionPane.showMessageDialog(f,"error = "+ex.getMessage());
                     }
 //   b.setEnabled
    
    }
      void autogen(int row)
  {
      try
      {
          if(row<8)
          {
              sr.setText("Q00"+String.valueOf(row+1));
          }
          else if(row<98)
          {
            sr.setText("Q0"+String.valueOf(row+1));
  }
   else if(row<998)
  {
   sr.setText("Q"+String.valueOf(row+1));
   }
      }
      catch(Exception e)
      {
      //    System.out.println("catched auto gen error = "+e.getMessage());
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
        if(o==bt)
        {int i=0;
             for(i=0;i<lt.length;i++)
               {
               lt[i].setVisible(true);
               }
               for(i=0;i<ln.length;i++)
               {
               ln[i].setVisible(false);
               }
               for(i=0;i<lg.length;i++)
               {
               lg[i].setVisible(false);
               }
               for(i=0;i<li.length;i++)
               {
               li[i].setVisible(false);
               }
          if(i==0)
        ll.setVisible(true);
        
        }
        if(o==bn)
        {
        int i=0;
               for(i=0;i<lt.length;i++)
               {
               lt[i].setVisible(false);
               }
               for(i=0;i<ln.length;i++)
               {
               ln[i].setVisible(true);
               }
               for(i=0;i<lg.length;i++)
               {
               lg[i].setVisible(false);
               }
               for(i=0;i<li.length;i++)
               {
               li[i].setVisible(false);
               }
          if(i==0)
        ll.setVisible(true);
        
        }
        if(o==bg)
        {
        int i=0;
               for(i=0;i<lt.length;i++)
               {
               lt[i].setVisible(false);
               }
               for(i=0;i<ln.length;i++)
               {
               ln[i].setVisible(false);
               }
               for(i=0;i<lg.length;i++)
               {
               lg[i].setVisible(true);
               }
               for(i=0;i<li.length;i++)
               {
               li[i].setVisible(false);
               }
          if(i==0)
        ll.setVisible(true);
        
        }
        if(o==bi)
        {
        int i=0;
               for(i=0;i<lt.length;i++)
               {
               lt[i].setVisible(false);
               }
               for(i=0;i<ln.length;i++)
               {
               ln[i].setVisible(false);
               }
               for(i=0;i<lg.length;i++)
               {
               lg[i].setVisible(false);
               }
               for(i=0;i<li.length;i++)
               {
               li[i].setVisible(true);
               }
          if(i==0)
        ll.setVisible(true);
        
        }
            /////////////////////////////////////////////////////////////////////
           for(int j=0;j<lt.length;j++)
           {
            if(o==lt[j])
                {    try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                   String str =lt[j].getText();
            //       System.out.println("value of path "+str);
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                
                                ResultSet res=st.executeQuery("select * from tech where name='"+str+"'");
                                String path=null;
                            while(res.next())
                              {
                          
                               path=res.getString(2);
              //                 System.out.println("Print ln path"+path);
                               File file=new File(path);
                               Desktop.getDesktop().open(file);
                              }
                    }
                   catch(Exception ex)
                   {
                       JOptionPane.showMessageDialog(f,"error "+ex.getMessage());
                       Logger.getLogger(Stud.class.getName()).log(Level.SEVERE,null,ex);
                   }
                      }
           }
 ////
      //////////////////////////////////////////////////////////////////
        for(int j=0;j<ln.length;j++)
           {
            if(o==ln[j])
                {    try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                   String str =ln[j].getText();
            //       System.out.println("value of path "+str);
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                
                                ResultSet res=st.executeQuery("select * from ntech where name='"+str+"'");
                                String path=null;
                            while(res.next())
                              {
                          
                               path=res.getString(2);
              //                 System.out.println("Print ln path"+path);
                               File file=new File(path);
                               Desktop.getDesktop().open(file);
                              }
                    }
                   catch(Exception ex)
                   {
                       JOptionPane.showMessageDialog(f,"error "+ex.getMessage());
                       Logger.getLogger(Stud.class.getName()).log(Level.SEVERE,null,ex);
                   }
                      }
           }
 ////////////////////////////////////////////////////////////
           for(int j=0;j<lg.length;j++)
           {
            if(o==lg[j])
                {    try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                   String str =lg[j].getText();
                //   System.out.println("value of path "+str);
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                
                                ResultSet res=st.executeQuery("select * from gk where name='"+str+"'");
                                String path=null;
                            while(res.next())
                              {
                          
                               path=res.getString(2);
                  //             System.out.println("Print ln path"+path);
                               File file=new File(path);
                               Desktop.getDesktop().open(file);
                              }
                    }
                   catch(Exception ex)
                   {
                       JOptionPane.showMessageDialog(f,"error "+ex.getMessage());
                       Logger.getLogger(Stud.class.getName()).log(Level.SEVERE,null,ex);
                   }
                }
           }
      //////////////////////////////////////////////////////////////////
          for(int j=0;j<li.length;j++)
           {
            if(o==li[j])
                {    try 
                    {
                   Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                   conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                   Statement st;
                   String str =li[j].getText();
               //    System.out.println("value of path "+str);
                                st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                                ResultSet res=st.executeQuery("select * from inter where name='"+str+"'");
                                String path=null;
                            while(res.next())
                              {
                               path=res.getString(2);
                 //              System.out.println("Print ln path"+path);
                               File file=new File(path);
                               Desktop.getDesktop().open(file);
                              }
                    }
                   catch(Exception ex)
                   {
                       JOptionPane.showMessageDialog(f,"error "+ex.getMessage());
                       Logger.getLogger(Stud.class.getName()).log(Level.SEVERE,null,ex);
                   }
                        }
           }
      //////////////////////////////////////////////////////////////////

	if (o==reset)
		{
		ques.setText("");
		}        
        if(o==logout)
            {
               StudentLog sp=new StudentLog();        
               f();
            }
        if(o==more)
        {
            Stud s=new Stud(sname,usrid);
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
                     //          System.out.println("try BLock");
                              ps=con.prepareStatement("insert into ques values(?,?,?,?,?)");
                              ps.setString(1,sr.getText().toString());
                              ps.setString(2,ques.getText().toString());
                              ps.setString(3,tname.getText().toString());
                              ps.setString(4,uid.getText().toString());
                              ps.setString(5,dt.getText().toString());
                       //       System.out.println("tested");
                                int i=ps.executeUpdate();
                         //       System.out.println("test ");
                                if((i==1)&&(ques.getText().length()!=0))
                                {   
                                    err.setText("");
                           //      System.out.println("record inserted");
                                 more.setEnabled(true);
                                 submit.setEnabled(false);
                                }
                                else
                                {
                             //        System.out.println("no records found or inserted");
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
            err.setText("Please enter the question ");
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
 {
 Object o=e.getSource();
  if(o==bt)
        {
        bt.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
  if(o==bn)
        {
        bn.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
  if(o==bg)
        {
        bg.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
  if(o==bi)
        {
        bi.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
    
 }
@Override
 public void mouseExited(MouseEvent e) 
 {
  Object o=e.getSource();
      if(o==bt)
        {
         bt.setBorder(BorderFactory.createEmptyBorder() );
        }
      if(o==bn)
        {
         bn.setBorder(BorderFactory.createEmptyBorder() );
        }
      if(o==bg)
        {
         bg.setBorder(BorderFactory.createEmptyBorder() );
        }
      if(o==bi)
        {
         bi.setBorder(BorderFactory.createEmptyBorder() );
        }
 }
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
            if(o==feedback)
            {
            StudentFeedback sf=new StudentFeedback(sname,usrid);
            f1();
            }
            if(o==vans)
            {
            StudViewAns va=new StudViewAns(sname,usrid);
            f1();
            }
        }
        
        public void f1()
        {
        f.setVisible(false);
        }
  
   
}

