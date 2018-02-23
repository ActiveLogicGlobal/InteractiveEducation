package knowledgepoint;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.*;

public class Fac extends JFrame implements MouseListener ,ActionListener ,KeyListener , FocusListener,WindowListener
{  
    JLabel err=new JLabel();
    JTextField at,t[];
    ResultSet rs;
    JFrame f;    
    JPanel p,pa;
    JLabel nm,nam,lpic,la,l ,areply,qno[],usr,dt ,count,sname[],sid[],stname,stid,sask,stask[];
    JTextArea a;
    JButton asubmit, areset ,acancel , reply[] ,logout,feedback;
    String name=null,user=null;
    Date d;
    SimpleDateFormat ft;
   // JScrollPane sp;
    Fac(String n,String u)
    {
   count =new JLabel();
  
   d=new Date();
            dt=new JLabel();
            ft =  new SimpleDateFormat ("EEE dd.MMM.yyyy 'at' hh:mm a");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));

        name=n;
        user=u;
        usr=new JLabel();
        usr.setText(user);
        nam=new JLabel();
        nam.setText(name);
//   System.out.println ("after teacher login name =="+n);
    f=new JFrame("Knowledge Point");
        p=new JPanel();
       lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w3.jpg"));
    l=new JLabel("Faculty Portal ");    l.setFont(new Font("Times New Roman",0,35));l.setForeground(new Color(0,0,153));
    la=new JLabel("Unanswered questions");    la.setFont(new Font("Tahoma",0,25));
    logout=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\logout.jpg"));
    feedback=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\feed.png"));
    nm=new JLabel("WELCOME "+name.toUpperCase()); nm.setFont(new Font ("Times New Roman",0,20));
    nm.setForeground(new Color(255,0,128));
    p.setLayout(null);
    f.setSize(1349,729);
    p.setBounds (0,0,1400,730);
    lpic.setBounds(0,0,1370,730);
    l.setBounds(50,30,300,50);    
    logout.setBounds(1220,60,105,36);                            logout.setBorder(BorderFactory.createEmptyBorder());
                                          feedback.setBorder(BorderFactory.createEmptyBorder());
    nm.setBounds (300,70,300,20);         feedback.setBounds(1110,68,90,25);
    la.setBounds(50,110,300,30);   
    f.add(p);
    p.add(lpic);
    lpic.add(nm);
    lpic.add(l);
    lpic.add(logout);logout.addActionListener((ActionListener)this);logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    lpic.add(feedback);feedback.addActionListener((ActionListener)this);feedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    lpic.add(la);
    p.setPreferredSize(new Dimension(1370, 900));
f.setLayout(new BorderLayout());
    // functiion for making textfield
    makeTextFieldOfQues();
    f.setSize(1370,730);
    f.setVisible(true);
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
      

    @Override
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void actionPerformed(ActionEvent e)
    {
    Object o=e.getSource(); 
            if(o==feedback)
            {
            FacultyFeedback ff=new FacultyFeedback(name ,user);
            f.setVisible(false);
            }
            if(o==logout)
            {
            StudentLog fhp=new StudentLog();
            f.setVisible(false);
            }
            if(o==acancel)
            {
            Fac fa=new Fac(name,user);
            f.setVisible(false);
            }
       int i=0;
   // reply panel
             for( i=0;i<reply.length;i++)
            {       
                if(o==reply[i])
                {
//                    String s=String.valueOf(i);
                      pa=new JPanel(); 
                 lpic.add(pa);
                 pa.addFocusListener((FocusListener )this);
                 pa.setLayout(null); 
                 pa.setBounds(750,150,700,700);
                areply=new JLabel(" Reply Here... ");
                 areply.setForeground(new Color (0,0,153));
                 areply.setFont (new Font("Times New Roman",0,20) );
                 at=new JTextField();
                 at.setEditable(false);
                 at.setText(t[i].getText().toString());
                 a=new JTextArea();
                 a.setEditable(true);
                 a.setLineWrap(true);
                 a.setText("");
                 stname=new JLabel();
                 stname.setText(sname[i].getText().toString());
                 stid=new JLabel();
                 stid.setText(sid[i].getText().toString());
                 sask=new JLabel();
                 sask.setText(stask[i].getText().toString());
                 asubmit=new JButton("SUBMIT");
                 areset=new JButton("RESET");
                 acancel=new JButton("CANCEL");
                 areply.setBounds(0,0,150,30);
                 at.setBounds(10,50,550,30);
                 a.setBounds(10,100,550,200);
                 count.setBounds(20,320,100,30);sask.setBounds(400,320,50,20);stid.setBounds(465,320,50,20);
                                                                          stname.setBounds(465,340,150,20);
                 asubmit.setBounds(50,400,80,30);  areset.setBounds(150,400,80,30);    acancel.setBounds(250,400,80,30);   
                 err.setBounds(50,500,200,30);
                 pa.add(at);        pa.add(areply);
                 pa.add(a);    
                 a.addKeyListener((KeyListener)this);      a.addFocusListener((FocusListener )this);
                 pa.add(count);         pa.add(stname);      pa.add(sask);     pa.add(stid);
                 pa.add(asubmit);       asubmit.addMouseListener((MouseListener)this); asubmit.setEnabled(false);
                 pa.add(areset);        areset.addMouseListener((MouseListener)this);
                 pa.add(acancel);       acancel.addMouseListener((MouseListener)this);
                 pa.add(err);
                 pa.setVisible(true);
                 asubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                 areset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                 acancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }
            }
    }
    @Override
    public void keyPressed(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e)
    {
    Object o=e.getSource();
        if(o==a)
        {
            char c=e.getKeyChar() ;
        if(a.getText().length()>2)
        {
        asubmit.setEnabled(true);
        }
         String text=a.getText();
   int chrlen=999-text.length();
    count.setText(""+chrlen);
    count.setForeground(new Color(204,0,0));
    if(chrlen<=0)
    {
    e.consume();    
    }
   if((chrlen==999)||(chrlen==998)||(chrlen==1000))
   {
   asubmit.setEnabled(false);
   }  
        }
    }
    @Override
    public void keyReleased(KeyEvent e){}
    @Override
     public void mouseClicked(MouseEvent e)
     {Object o=e.getSource();
     if(o==asubmit)
     {
                     try
                     {
                         connect c=new connect();
                         PreparedStatement ps ,ps1;
                         ps=c.conn.prepareStatement("insert into quesans values(?,?,?,?,?,?)");
                            ps.setString(1,at.getText().toString());
                            ps.setString(2,a.getText().toString());
                            ps.setString (3,usr.getText().toString());
                            ps.setString (4,nam.getText().toString());
                            ps.setString (5,dt.getText().toString());
                            ps.setString (6,stid.getText().toString());
                            ps1=c.conn.prepareStatement("delete  from ques where question=?");
                            ps1.setString(1,at.getText());
                              int i=ps.executeUpdate();
                                if(i==1)
                                {
                                }
                            int rowsDeleted = ps1.executeUpdate();
                            if (rowsDeleted > 0)
                                    {  
                                            err.setText("your ques submitted successfully . ");   
                                    f.setVisible(false);
                                    Fac fa=new Fac(name,user);
                                    }  
                          }
                          catch(Exception ex)
                          {}
              a.setText("");
              pa.setVisible(false);
                for(int i=0;i<reply.length;i++)
                        {
                            reply[i].setEnabled(true);
                        }
                makeTextFieldOfQues();
             
       int i=0;
   // reply panel
             for( i=0;i<reply.length;i++)
            {       
                if(o==reply[i])
                {
                    String s=String.valueOf(i);
                      pa=new JPanel(); 
                 lpic.add(pa);
                 pa.addFocusListener((FocusListener )this);
                 pa.setLayout(null); 
                 pa.setBounds(750,150,700,700);
                 at=new JTextField();
                 at.setEditable(false);
                 at.setText(t[i].getText().toString());
                 a=new JTextArea();
                 a.setEditable(true);
                 a.setText("");
                 asubmit=new JButton("SUBMIT");
                 areset=new JButton("RESET");
                 acancel=new JButton("CANCEL");
                 areply.setBounds(0,0,150,30);
                 at.setBounds(10,50,550,30);
                 a.setBounds(10,100,550,200);
                 asubmit.setBounds(50,400,80,30);  areset.setBounds(150,400,80,30);    acancel.setBounds(250,400,80,30);   
                 err.setBounds(50,500,200,30);
                 pa.add(areply);
                 pa.add(at);
                 pa.add(a);             a.addKeyListener((KeyListener)this);      a.addFocusListener((FocusListener )this);
                 pa.add(asubmit);       asubmit.addMouseListener((MouseListener)this); asubmit.setEnabled(false);
                 pa.add(areset);        areset.addMouseListener((MouseListener)this);
                 pa.add(acancel);       acancel.addMouseListener((MouseListener)this);
                 pa.add(err);
                 pa.setVisible(true);
                }
            }
     }
     if(o==areset)
     {
                 a.setText("");
                 asubmit.setEnabled(false);
                 count.setText("");
     }
     if(o==acancel)
     {
           a.setText("");
           pa.setVisible(false);
                   for(int i=0;i<reply.length;i++)
                      {
                        reply[i].setEnabled(true);
                       }
     }
     
     }
     
    @Override
    public void focusLost(FocusEvent e) {}
    @Override
    public void focusGained(FocusEvent e)
{
    Object o=e.getSource();
        if(o==a)
        {
    for(int i=0;i<reply.length;i++)
    {
        reply[i].setEnabled(false);
    }    
        }
}
  static String snm=null,uu=null;   
     public void fn()
     {
     snm=name;
     uu=user;
     }
public void makeTextFieldOfQues()
{
        try
        {
        Connection c;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                Statement st;
                st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=st.executeQuery("select * from ques");
                String name=null;
                rs.last();
                   int i=rs.getRow();
                   qno =new JLabel[i];
                   t=new JTextField[i];
                   reply=new JButton[i];
                   sid=new JLabel[i];
                   stask=new JLabel[i];
                   sname=new JLabel[i];
                   int y=150,z=180;
                rs.beforeFirst();
                for(i=0;i<t.length;i++)
                {
                    t[i]=new JTextField();
                    qno[i]=new JLabel("Q. No."+(i+1));
                    reply[i]=new JButton("REPLY");
                    sid[i]=new JLabel();
                    stask[i]=new JLabel("Asked By : ");
                    sname[i]=new JLabel();
                    t[i].setEditable(false);
                   qno[i].setBounds(20,y,100,30); t[i].setBounds(100,y,550,30);reply[i].setBounds(660,y,80,30);
  stask[i].setBounds(380,z,70,20);                 sid[i].setBounds(450,z,50,20);      sname[i].setBounds(500,z,150,20);
                   y=y+50;
                   z=z+50;
                    lpic.add(qno[i]);
                    lpic.add(t[i]); 
                    lpic.add(reply[i]);  reply[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    lpic.add(stask[i]);
                    lpic.add(sid[i]);
                    lpic.add(sname[i]);
                    reply[i].addActionListener((ActionListener)this);
                }
               String name1,nm,id;
                int ij=0;
                while(rs.next())
                {
                name1=rs.getString(2);
                nm=rs.getString(3);
                id=rs.getString(4);
  //              System.out.println(name1);
               t[ij].setText(name1);
               sid[ij].setText(id);
               sname[ij].setText(nm);
              ij++;  
                }  
           }
            catch(Exception ex)
            {
    //            System.out.println("error catched in err= "+ex.getMessage());
            }
    }
public void replyPanel()
    {  
                 pa=new JPanel(); 
                 lpic.add(pa);
                 pa.addFocusListener((FocusListener )this);
                 pa.setLayout(null); 
                 pa.setBounds(750,150,700,700);
                 at=new JTextField();
                 at.setEditable(false);
//                 at.setText(t[i].getText().toString());
                 a=new JTextArea();
                 a.setLineWrap(false);
                 a.setEditable(true);
                 a.setText("");
                 asubmit=new JButton("SUBMIT");
                 areset=new JButton("RESET");
                 acancel=new JButton("CANCEL");
                 areply.setBounds(0,0,150,30);
                 at.setBounds(10,50,550,30);
                 a.setBounds(10,100,550,200);
                 asubmit.setBounds(50,400,80,30);  areset.setBounds(150,400,80,30);    acancel.setBounds(250,400,80,30);   
                 err.setBounds(50,500,200,30);
                 pa.add(areply);
                 pa.add(at);
                 pa.add(a);             a.addKeyListener((KeyListener)this);      a.addFocusListener((FocusListener )this);
                 pa.add(asubmit);       asubmit.addMouseListener((MouseListener)this); asubmit.setEnabled(false);
                 pa.add(areset);        areset.addMouseListener((MouseListener)this);
                 pa.add(acancel);       acancel.addMouseListener((MouseListener)this);
                 pa.add(err);
                 pa.setVisible(true);
    }
}