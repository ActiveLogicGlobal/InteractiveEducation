package knowledgepoint;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.util.Date;
import java.text.*;

public class ViewQues extends JFrame implements ActionListener,WindowListener,MouseListener
{
    JLabel err=new JLabel();
    JScrollPane sp;
    JTextField at,t[],id;
    ResultSet rs;
    JFrame f;    
    JPanel p,pa;
    JLabel lpic,la,dt ,areply,qno[],tuid[],tnm[],error,lid;
    JTextArea a;
    JButton back,srch,home,logout,delete[];
    ViewQues()
    { 
                    Date d=new Date();
            dt=new JLabel();
            SimpleDateFormat ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm:ss a zzz");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));
            error=new JLabel();
               error.setBounds(1000,200,300,20);
                error.setForeground(new Color(204,0,0));
                error.setFont(new Font("Times New Roman",0,20));
               

        
    f=new JFrame("Knowledge Point");
        p=new JPanel();
       lpic=new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\wl1.jpg"));
       la=new JLabel("Unanswered questions");    la.setFont(new Font("Times New Roman",0,25));  la.setForeground(new Color(0,0,153));
    logout=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa1.png"));             logout.setFont(new Font("Times New Roman",0,15));
    home=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\logout.jpg"));               home.setFont(new Font("Times New Roman",0,15));
    back=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\aa2.png"));            back.setFont(new Font("Times New Roman",0,15));
    
    srch=new JButton();              srch.setFont(new Font("Times New Roman",0,12));         srch.setMargin(new Insets(2,2,2,2));
    srch.setIcon(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\srch.png"));
    id=new JTextField();             id.setFont(new Font("Times New Roman",0,15));
    lid=new JLabel("Student ID");     lid.setFont(new Font("Times New Roman",0,15));lid.setForeground(new Color(0,0,153));
    p.setLayout(null);
    f.setSize(1349,729);
    p.setBounds (0,0,1400,730);
    lpic.setBounds(0,0,1370,4920);
    la.setBounds(50,30,300,30);  
    id.setBounds(1020,70,80,20);   lid.setBounds(950,70,80,20);     
    back.setBounds(50,150,30,30); back.setMargin(new Insets(0,0,0,0));//.setMargin(new java.awt.Insets(2, 2, 2, 2));
    back.setCursor(new Cursor(HAND_CURSOR));
    srch.setBounds(1100,50,105,44);      srch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    srch.setBackground(new Color(255,255,255));
    logout.setBounds(20,60,80,30); logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    home.setBounds(1220,60,105,36);      home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    home.setBorder(BorderFactory.createEmptyBorder());
    srch.setBorder(BorderFactory.createEmptyBorder());
   
   
    f.add(p);
    p.add(lpic);
    lpic.add(la);
    lpic.add(back);             back.setVisible(false);
    lpic.add(logout);           logout.addActionListener((ActionListener)this);
    lpic.add(home);             home.addActionListener((ActionListener)this);
    lpic.add(srch);             srch.addActionListener((ActionListener)this);          srch.addMouseListener((MouseListener)this);
    lpic.add(id);             
    lpic.add(lid);             
     lpic.add(error); 
    p.setPreferredSize(new Dimension(1370, 600));

JScrollPane sp = new JScrollPane();
sp.setViewportView(p);
sp.setHorizontalScrollBarPolicy  (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) ;
sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
f.setLayout(new BorderLayout());
f.add(sp, BorderLayout.CENTER);

    // functiion for making textfield
    makeTextFieldOfQues();
    f.setSize(1370,729);
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

      public void mousePressed(MouseEvent e){}
      public void mouseClicked(MouseEvent e){}
      public void mouseReleased(MouseEvent e){}
      public void mouseEntered(MouseEvent e)
      {
      Object o=e.getSource();
      if(o==srch)
        {
        srch.setBorder(BorderFactory.createLineBorder(Color.blue) );
        }
      }
      public void mouseExited(MouseEvent e)
      {
      Object o=e.getSource();
      if(o==srch)
        {
         srch.setBorder(BorderFactory.createEmptyBorder() );
        }
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
                rs=st.executeQuery("select * from ques");
                String name=null;
                rs.last();
                   int i=rs.getRow();
                   qno=new JLabel[i];
                   t=new JTextField[i];
                   delete=new JButton[i];
                   tuid=new JLabel[i];
                   tnm=new JLabel[i];
                int y=150;
                rs.beforeFirst();
                for(i=0;i<t.length;i++)
                {
                    t[i]=new JTextField();
                    qno[i]=new JLabel("Q. No."+(i+1));
                    qno[i].setFont(new Font("Times New Roman",0,15));
                    t[i].setEditable(false);
                    delete[i]=new JButton("Delete");
                    delete[i].setFont(new Font("Times New Roman",0,15));
                    tuid[i]=new JLabel();
                    tnm[i]=new JLabel();
                    qno[i].setBounds (20,y,100,30);     t[i].setBounds(110,y,1000,30);  tuid[i].setBounds (1130,(y-10),100,30); delete[i].setBounds (1250,y,80,30);
                                                                                         tnm[i].setBounds (1130,(y+5),120,30);
                    y=y+40;                                                            
                    lpic.add(qno[i]);
                    lpic.add(t[i]); 
                    lpic.add(tuid[i]);
                    lpic.add(tnm[i]);
                    lpic.add(delete[i]);
                    delete[i].addActionListener((ActionListener)this);
                    delete[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    qno[i].setVisible(true);
                    t[i].setVisible(true);
                    tuid[i].setVisible(true);
                    tnm[i].setVisible(true);
                    delete[i].setVisible(true);

                
                }
               String nm=null,name1=null,usr=null;
                int ij=0;
                while(rs.next())
                {
                name1=rs.getString(2);
                nm=rs.getString(3);
                usr=rs.getString(4);
                
           //     System.out.println(name1);
               t[ij].setText(name1);
               tuid[ij].setText("By : "+usr+"");
               tnm[ij].setText(nm);
               tuid[ij].setForeground(new Color(153,0,153));
               tnm[ij].setForeground(new Color(153,0,153));
              ij++;  
                }  
           }
            catch(Exception ex){}
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
    Object o=e.getSource();
            if(o==srch)
            {
                   int j=0;
            
                for(j=0;j<t.length;j++)
                {   back.setVisible(true);      back.addActionListener((ActionListener)this);
                    qno[j].setVisible(false);
                    t[j].setVisible(false);
                    tuid[j].setVisible(false);
                    tnm[j].setVisible(false);
                    delete[j].setVisible(false);
                  
                }
                 if((id.getText().length()==4))
                {
        try
        {
          
        Connection c;
        Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
        c=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                Statement st;
                st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs=st.executeQuery("select * from ques where id='"+id.getText().toUpperCase()+"'");
                String name=null;
                rs.last();
                   int i=rs.getRow();
                   qno=new JLabel[i];
                   t=new JTextField[i];
                   delete=new JButton[i];
                   tuid=new JLabel[i];
                   tnm=new JLabel[i];
                int y=200;
                rs.beforeFirst();
                for(i=0;i<t.length;i++)
                {
                    t[i]=new JTextField();
                    qno[i]=new JLabel("Q. No."+(i+1));
                    qno[i].setFont(new Font("Times New Roman",0,15));
                    t[i].setEditable(false);
                    delete[i]=new JButton("Delete");
                    delete[i].setFont(new Font("Times New Roman",0,15));
                    tuid[i]=new JLabel();
                    tnm[i]=new JLabel();
                    qno[i].setBounds (20,y,100,30);     t[i].setBounds(110,y,1000,30);  tuid[i].setBounds (1130,(y-10),100,30); delete[i].setBounds (1250,y,80,30);
                                                                                         tnm[i].setBounds (1130,(y+5),120,30);
                    y=y+40;                                                            
                    lpic.add(qno[i]);
                    lpic.add(t[i]); 
                    lpic.add(tuid[i]);
                    lpic.add(tnm[i]);
                    lpic.add(delete[i]);
                    delete[i].addActionListener((ActionListener)this);
                    delete[i].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    qno[i].setVisible(true);
                    t[i].setVisible(true);
                    tuid[i].setVisible(true);
                    tnm[i].setVisible(true);
                    delete[i].setVisible(true);

                
                }
               String nm=null,name1=null,usr=null;
                int ij=0;
                while(rs.next())
                {
                name1=rs.getString(2);
                nm=rs.getString(3);
                usr=rs.getString(4);
                
           //     System.out.println(name1);
               t[ij].setText(name1);
               tuid[ij].setText("By : "+usr+"");
               tnm[ij].setText(nm);
               tuid[ij].setForeground(new Color(153,0,153));
               tnm[ij].setForeground(new Color(153,0,153));
              ij++;  
                }  
           }
            catch(Exception ex)
            {
            System.out.println("Error catched now : "+ex.getMessage());
            }

                if(t.length==0)
                {
                error.setText("No Question Founds");
                }
                else{error.setText("");}
                 }
                 else{error.setText("ID does not Exist");}
            
            }
            if(o==back)
            {int i=0;
           
             back.setVisible(false);
              for(i=0;i<t.length;i++)
                {  
                    qno[i].setVisible(false);
                    t[i].setVisible(false);
                    tuid[i].setVisible(false);
                    tnm[i].setVisible(false);
                    delete[i].setVisible(false);
                }
              makeTextFieldOfQues();
              error.setText("");
            }
            if(o==logout)
            {
            AdminPortal fhp=new AdminPortal();
            f.setVisible(false);
            }
            if(o==home)
            {
            StudentLog s=new StudentLog();
            f.setVisible(false);
            }
            for(int i=0;i<t.length;i++)
            {
                if(o==delete[i])
                {
                 int a=JOptionPane.showConfirmDialog(f,"Do you want to delete Q.no. "+(i+1)+"" ,"Knowledge Point",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
          if(a==JOptionPane.YES_OPTION)
          {                    try
                {
                connect c=new connect();
                 PreparedStatement ps,ps1;
                ps=c.conn.prepareStatement("insert into dlt values(?,?,?)");
                ps.setString(2,qno[i].getText().toString());
                ps.setString(1,t[i].getText().toString());
                ps.setString(3,dt.getText());
                ps1=c.conn.prepareStatement("delete  from ques where question='"+(t[i].getText())+"'");

                int ip=ps.executeUpdate();
                     if(ip==1)
                    {
                    }       

                 int r = ps1.executeUpdate();

                           if (r==1)
                                    { 
                                    t[i].setVisible(false);
                                            f.setVisible(false);
                                             ViewQues vq=new ViewQues();
                                           err.setText("your ques submitted successfully . ");   
                                    }  
                            else
                                      {
                                      }
                }
                catch(Exception ex)
                {               
                }
          }
              }
            }
       }
    public static void main(String a[])
    {
    ViewQues qw=new ViewQues();
    
    }
}

