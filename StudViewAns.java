package knowledgepoint;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class StudViewAns   extends JFrame implements MouseListener ,ActionListener ,KeyListener , FocusListener,WindowListener
{
    JLabel err=new JLabel();
    JScrollPane sp;
    JTextField at,t[];
    ResultSet rs;
    JFrame f;    
    JPanel p,pa;
    JLabel userid,lpic,la ,areply,tnm[],tid[],lque[],lans[],error;
    JTextArea a[];
    JButton srch,logout,back,back1;
String name=null,usrid=null;
    StudViewAns (String n,String susrid)
    {
        name=n;
        usrid=susrid;
        userid=new JLabel(usrid);
     f=new JFrame("Knowledge Point");
        p=new JPanel();
       lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\wl1.jpg"));
    la=new JLabel("Answered questions");    la.setFont(new Font("Times New Roman",0,30));la.setForeground(new Color(0,0,153));
    logout=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\logout.jpg"));   
    back=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa1.png"));        
    back1=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa2.png"));            back1.setFont(new Font("Times New Roman",0,15));
    srch=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\srchme.png"));
      error=new JLabel();
               error.setBounds(1000,200,300,20);
                error.setForeground(new Color(204,0,0));
                error.setFont(new Font("Times New Roman",0,20));
    back1.setBounds(50,150,30,30); back1.setMargin(new Insets(0,0,0,0));//.setMargin(new java.awt.Insets(2, 2, 2, 2));
    back1.setCursor(new Cursor(HAND_CURSOR));
    srch.setBounds(1000,50,143,46);      srch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));  srch.setBorder(BorderFactory.createEmptyBorder());
    p.setLayout(null);
    f.setSize(1349,729);
    logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));     logout.setBorder(BorderFactory.createEmptyBorder());
  back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    lpic.setBounds(0,0,1370,4920);
    back.setBounds(20,60,95,35);
    logout.setBounds(1220,60,105,36); 
    la.setBounds(100,30,300,30);   
    f.add(p);
    p.add(lpic);
    lpic.add(back);back.addActionListener((ActionListener)this);
    lpic.add(logout);logout.addActionListener((ActionListener)this);
    lpic.add(la);
    lpic.add(back1);             back1.setVisible(false);
    lpic.add(srch); 
 lpic.add(error);
JScrollPane sp = new JScrollPane();
sp.setViewportView(p);
sp.setHorizontalScrollBarPolicy  (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) ;
sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
f.setLayout(new BorderLayout());
f.add(sp, BorderLayout.CENTER);

    // functiion for making textfield
    makeTextFieldOfQues();
    f.setSize(1370,730);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);
    
    srch.addActionListener((ActionListener)this); srch.addMouseListener((MouseListener)this);
    }
public void makeTextFieldOfQues()
{
// this try & catch makes text field s
        try
        {
        Connection c;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                Statement st;
                st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=st.executeQuery("select * from quesans");
                rs.last();
                   int i=rs.getRow();
                   t=new JTextField[i];
                   a=new JTextArea[i];
                   tnm=new JLabel[i];
                   tid=new JLabel[i];
                   lque=new JLabel[i];
                   lans=new JLabel[i]; 
               
                int y=150,z=150;
                rs.beforeFirst();
                for(i=0;i<t.length;i++)
                {
                    t[i]=new JTextField();
                    a[i]=new JTextArea();               a[i].setLineWrap(true);
                    tnm[i]=new JLabel();
                    tid[i]=new JLabel();
                    lque[i]=new JLabel();
                    lans[i]=new JLabel();
                    t[i].setEditable(false);
                    a[i].setEditable(false);
                    a[i].setBackground(new Color(255,255,255));
                    lque[i].setFont(new Font("Times New Roman",0,15));lque[i].setForeground(new Color(0,0,153));
                    lans[i].setFont(new Font("Times New Roman",0,15));lans[i].setForeground(new Color(0,0,153));
lque[i].setBounds (10,y,70,30);    t[i].setBounds(80,y,1100,30);     tid[i].setBounds(1200,(y-10),200,30);      tnm[i].setBounds(1200,(y+10),200,30); 
lans[i].setBounds(10,(z+40),60,30);   a[i].setBounds(80,(z+40),1200,90);       a[i].setBorder(BorderFactory.createLineBorder(Color.black)); y=z+140;
                   
                    tid[i].setForeground(new Color(153,0,153));
                    tnm[i].setForeground(new Color(153,0,153));
                    y=z+140;
                    z=y+10;
                    lque[i].setText("Ques"+(i+1)+": ");
                    lans[i].setText("Answer:");
                    
                    lpic.add(lque[i]);
                    lpic.add(lans[i]);
                                        
                    lpic.add(t[i]); 
                    lpic.add(a[i]);  
                  
                    lpic.add(tnm[i]);
                    lpic.add(tid[i]);
                    if(y<4920)
                    {
                    p.setPreferredSize(new Dimension(1370,y));
                    }
                }
                  rs.afterLast();
                String ques=null,ans=null,nm=null;
                int ij=0;
                while(rs.previous())
                {
                ques=rs.getString(1);
                ans=rs.getString(2);
                nm=rs.getString(4);
               t[ij].setText(ques);
               a[ij].setText(ans);
               tid[ij].setText("Answered by : ");
               tnm[ij].setText("Teacher: "+nm);
              ij++;  
                }  
           }
            catch(Exception ex)
            {
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
    public void mouseReleased(MouseEvent e){}
    @Override
    public void mouseEntered(MouseEvent e)
    {
      Object o=e.getSource();
      if(o==srch)
        {
        srch.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
   
    }
    @Override
    public void mouseExited(MouseEvent e)
    {
     Object o=e.getSource();
      if(o==srch)
        {
         srch.setBorder(BorderFactory.createEmptyBorder() );
        }
  
    }
    @Override
    public void mousePressed(MouseEvent e){}
    @Override
    public void actionPerformed(ActionEvent e)
    {
    Object o=e.getSource();
             if(o==srch)
            {    srch.setEnabled(false);
              int j=0;
                for(j=0;j<t.length;j++)
                {   back1.setVisible(true);      back1.addActionListener((ActionListener)this);
                    t[j].setVisible(false);
                    a[j].setVisible(false);
                    tnm[j].setVisible(false);
                    tid[j].setVisible(false);
                    lque[j].setVisible(false);
                    lans[j].setVisible(false);

                }
                 if((userid.getText().length()==4))
                {
        try
        {
          
        Connection c;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                Statement st;
                st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=st.executeQuery("select * from quesans where sid='"+userid.getText()+"'");
                String name=null;
       
                rs.last();
                int i=rs.getRow();
       
                   t=new JTextField[i];
                   a=new JTextArea[i];
                   tnm=new JLabel[i];
                   tid=new JLabel[i];
                   lque=new JLabel[i];
                   lans=new JLabel[i]; 
                int y=200,z=200;
                rs.beforeFirst();
                for(i=0;i<t.length;i++)
                {
                    t[i]=new JTextField();
                    a[i]=new JTextArea();
                    tnm[i]=new JLabel();
                    tid[i]=new JLabel();
                    lque[i]=new JLabel();
                    lans[i]=new JLabel();
                    t[i].setEditable(false);
                    a[i].setEditable(false);
                    a[i].setBackground(new Color(255,255,255));
                    lque[i].setFont(new Font("Times New Roman",0,15));lque[i].setForeground(new Color(0,0,153));
                    lans[i].setFont(new Font("Times New Roman",0,15));lans[i].setForeground(new Color(0,0,153));
lque[i].setBounds (10,y,65,30);    t[i].setBounds(75,y,1100,30);     tid[i].setBounds(1185,(y-15),200,30);      tnm[i].setBounds(1185,(y),150,30); 
lans[i].setBounds(10,(z+40),60,30);   a[i].setBounds(75,(z+40),1200,90);       a[i].setBorder(BorderFactory.createLineBorder(Color.black));
                    tid[i].setForeground(new Color(153,0,153));
                    tnm[i].setForeground(new Color(153,0,153));
                    y=z+140;
                    z=y+10;
                    lque[i].setText("Ques"+(i+1)+": ");
                    lans[i].setText("Answer:");
                    lpic.add(lque[i]);
                    lpic.add(lans[i]);
                    lpic.add(t[i]); 
                    lpic.add(a[i]);  
                    lpic.add(tid[i]);
                    lpic.add(tnm[i]);
             
                    if(y<4920)
                          {
                             p.setPreferredSize(new Dimension(1370,y));
                          }
                    
                   }
                rs.afterLast();
                String ques=null,ans=null,nm=null;
                int ij=0;
                while(rs.previous())
                {
                ques=rs.getString(1);
                ans=rs.getString(2);
                nm=rs.getString(4);
               t[ij].setText(ques);
               a[ij].setText(ans);
               tid[ij].setText("Answered by : ");
               tnm[ij].setText("Teacher: "+nm);
              ij++;  
                }  
           }
            catch(Exception ex){}
                if(t.length==0)
                {
                error.setText("No Question Founds");
                }
                else{
                   error.setText("");
                }
                 }
                 else{error.setText("ID does not Exist");}
                 
            }
                if(o==back1)
            {int i=0;
           srch.setEnabled(true);
             back1.setVisible(false); 
              for(i=0;i<t.length;i++)
                {  
                    t[i].setVisible(false);
                    a[i].setVisible(false);
                    tnm[i].setVisible(false);
                    tid[i].setVisible(false);
                    lque[i].setVisible(false);
                    lans[i].setVisible(false);
                }
              makeTextFieldOfQues();
              error.setText("");
            }
        
  
            if(o==logout)
            {
            StudentLog fhp=new StudentLog();
            f.setVisible(false);
            }
            if(o==back)
            {
            Stud q=new Stud(name,usrid);
            f.setVisible(false);
            }
    }
    @Override
    public void keyPressed(KeyEvent e){}
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    @Override
    public void keyReleased(KeyEvent e){}
        @Override
     public void mouseClicked(MouseEvent e){}
     
    @Override
    public void focusLost(FocusEvent e) {}
    @Override
    public void focusGained(FocusEvent e){}
}
