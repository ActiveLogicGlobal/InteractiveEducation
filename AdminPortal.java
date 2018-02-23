package knowledgepoint;          
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AdminPortal implements ActionListener,MouseListener,FocusListener, WindowListener,KeyListener
{
    Connection conn;
    JButton bpd,feedback;
    public static final String[] topic= { "Technical", "Non-Technical", "General Knowledge", "Interview Tips" };
   JLabel error=new JLabel("");
   JPanel p1,p2;
   JLabel lbl,usr,name,dob,course,rollno,address,eid,gender,contact,pswrd,dt ;
   JTextField tusr,tname,tdob,troll,taddr,teid,tcont,tpass; 
   JComboBox tcourse,tgender;
   JLabel ename,eroll,eaddr,eeid,econt,epass;
   JButton save ,cancel,srch,block,unblock;
   JRadioButton sfac,sstud;
   ButtonGroup bg;
Connection con;
PreparedStatement ps;
ResultSetMetaData rm;
Statement st;
ResultSet rs;
DefaultTableModel dms,dmf,dmb,dmd,dmsl,dmfl,df,ds,dbtch,dbntch,dbgk,dbint,dfeed;
String col1[],col[];
JTable stud,fac,bull,delt,slogin,flogin,sblk,fblk,btch,bntch,bgkp,bintr,feed;
JFrame f;
JTextArea board;
JLabel l ,lpic ,lboard ,err,lerr;
JButton b,bstud,bfac,bdel,bslog,bflog,bullet,sblock,fblock,submit,reset,viewques,viewans,vupdate,btech,bntech,bgk,bint,bfeed;
JPanel tb,p,tp1,tp3,pt;     
JTabbedPane tp;
JScrollPane scroll,stp1,scrl1,scrl,scrl2,scrl3,scrl4,scrl5,scrl6,scrl7,scr1,scr2,scr3,scr4,sfeed;   
Date d;
SimpleDateFormat ft;
JLabel name1;       JTextField tnm;
JLabel path;        JTextField tpth;
JButton ok;         JButton cncl;
JLabel err1,cat;
JComboBox tcat;
String ctgry=null;        
   AdminPortal ()
    {                cat=new JLabel("File Category ");    tcat=new JComboBox();
                     tcat.setModel(new DefaultComboBoxModel(new String[]{"Category of file","Technical","Non-Technical","General Knowledge","Interview Tips"}));
                     name1=new JLabel("Name of file");    tnm=new JTextField();
                     path=new JLabel("Path of file");        tpth=new JTextField();
                     ok=new JButton("OK");            cncl=new JButton("CANCEL");
                     err1=new JLabel("");
                     err1.setForeground(new Color(204,0,0));
            d=new Date();
            dt=new JLabel();
            ft =  new SimpleDateFormat ("EEEE ',' dd.MMMM.yyyy 'at' hh:mm:ss a zzz");
            dt.setText(ft.format(d));
            dt.setFont(new Font("Times New Roman",0,15));
            dt.setForeground(new Color(0,024,204));
        p2=new JPanel();
        stud=new JTable();
        sblk=new JTable();
        fblk=new JTable();
        btch=new JTable();
        bntch=new JTable();
        bgkp=new JTable();
        bintr=new JTable();
        feed=new JTable();
        bg=new ButtonGroup();
        p1=new JPanel();
        p2=new JPanel();
        bull=new JTable();
        delt=new JTable();
        slogin=new JTable();
        flogin=new JTable();   
        err=new JLabel();
        lerr=new JLabel("");
        fac=new JTable();
        stud.setEnabled(false);
        fac.setEnabled(false);
        bull.setEnabled(false);
        delt.setEnabled(false);
        slogin.setEnabled(false);
        flogin.setEnabled(false);
        sblk.setEnabled(false);
        fblk.setEnabled(false);
        btch.setEnabled(false);
        bntch.setEnabled(false);
        bgkp.setEnabled(false);
        bintr.setEnabled(false);
        feed.setEnabled(false);
stp1=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl1=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl2=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl3=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl4=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl5=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl6=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scrl7=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scr1=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scr2=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scr3=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
scr4=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
sfeed=new JScrollPane(tp1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
          dms=new DefaultTableModel();
          dmf=new DefaultTableModel();
          dmb=new DefaultTableModel();
          dmd=new DefaultTableModel();
          dmsl=new DefaultTableModel();
          dmfl=new DefaultTableModel();
          df=new DefaultTableModel();
          ds=new DefaultTableModel();
          dbtch=new DefaultTableModel();
          dbntch=new DefaultTableModel();
          dbgk=new DefaultTableModel();
          dbint=new DefaultTableModel();
          dfeed=new DefaultTableModel();
          /////////////////////////
          try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from adminfeed");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dfeed.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dfeed.addRow(rowData1);
            }
           feed.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
         
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        ///////////////////////////////////
          try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from tech");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dbtch.addColumn(col1[i]);
         }
         while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dbtch.addRow(rowData1);
            }
          btch.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from ntech");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dbntch.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dbntch.addRow(rowData1);
            }
          bntch.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
        }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from gk");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dbgk.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dbgk.addRow(rowData1);
            }
          bgkp.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from inter");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dbint.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dbint.addRow(rowData1);
            }
          bintr.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
          try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from fblock");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             df.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                df.addRow(rowData1);
            }
          fblk.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
          try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from sblock");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             ds.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                ds.addRow(rowData1);
            }
           sblk.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
          try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from name");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dms.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dms.addRow(rowData1);
            }
           stud.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
            try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from log");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dmfl.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dmfl.addRow(rowData1);
            }
           slogin.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
            try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from stlog");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col1=new String[i];
         for(i=0;i<col1.length;i++)
         {
             col1[i]=rm.getColumnName(i+1);
             dmsl.addColumn(col1[i]);
         }
          while (rs.next())
            {
                Object [] rowData1 = new Object[col1.length];
                for(i = 0; i < rowData1.length; ++i)
                {
                    rowData1[i] = rs.getObject(i+1);
                }
                dmsl.addRow(rowData1);
            }
           flogin.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {})); 
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        //////////////////////////////////
            try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from facreg");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col=new String[i];
         for(i=0;i<col.length;i++)
         {
             col[i]=rm.getColumnName(i+1);
             dmf.addColumn(col[i]);
         }
         
          while (rs.next())
            {
                Object [] rowData = new Object[col.length];
                for(i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = rs.getObject(i+1);
                }
                dmf.addRow(rowData);
            }
                  fac.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {}));
         
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        /////////////////////////////////////////////////////////////
                         try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from msg");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col=new String[i];
         for(i=0;i<col.length;i++)
         {
             col[i]=rm.getColumnName(i+1);
             dmb.addColumn(col[i]);
         }
         
          while (rs.next())
            {
                Object [] rowData = new Object[col.length];
                for(i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = rs.getObject(i+1);
                }
                dmb.addRow(rowData);
            }
                  bull.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {}));
         
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        /////////////////////////////////////////////////////////////
                             try
       {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         con=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
         st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         rs=st.executeQuery("select * from dlt");
         rm=rs.getMetaData();
         int i=rm.getColumnCount();
         col=new String[i];
         for(i=0;i<col.length;i++)
         {
             col[i]=rm.getColumnName(i+1);
             dmd.addColumn(col[i]);
         }
         
          while (rs.next())
            {
                Object [] rowData = new Object[col.length];
                for(i = 0; i < rowData.length; ++i)
                {
                    rowData[i] = rs.getObject(i+1);
                }
                dmd.addRow(rowData);
            }
                  delt.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new  String [] {}));
         
       }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"error in connection.."+e.toString(),"Error",2); 
            }
        /////////////////////////////////////////////////////////////
          
 	f=new JFrame("Knowledge Point");
    	p=new JPanel();
        pt=new JPanel();
        lboard=new JLabel("Enter your message here");
        board=new JTextArea();
        submit=new JButton("SUBMIT");                       submit.setFont(new Font("Times New Roman",0,15));
        reset=new JButton("RESET");                         reset.setFont(new Font("Times New Roman",0,15));
        viewques=new JButton("View Unanswered Question");
        feedback=new JButton("View Feedbacks");
        viewans=new JButton("View Answered Question");
        vupdate=new JButton("Update data of members");
        bpd=new JButton("Add topic for Students");
        bstud=new JButton("View Students"); bstud.setFont(new Font("Times New Roman",0,15));
        bfac=new JButton("View Faculty Members");bfac.setFont(new Font("Times New Roman",0,15));
        bfac.setIconTextGap(2);
        bfac.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        bullet=new JButton("Bulletin Board");
        bullet.setFont(new Font("Times New Roman",0,15));
        bullet.setIconTextGap(2);
        bullet.setMargin(new java.awt.Insets(2, 2, 2, 2));

        sblock=new JButton("Blocked Students");
        sblock.setFont(new Font("Times New Roman",0,15));
        sblock.setIconTextGap(2);
        sblock.setMargin(new java.awt.Insets(2, 2, 2, 2));

        fblock=new JButton("Blocked Teachers");
        fblock.setFont(new Font("Times New Roman",0,15));
        fblock.setIconTextGap(2);
        fblock.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btech=new JButton("Tecnical PDFs");
        btech.setFont(new Font("Times New Roman",0,15));
        btech.setIconTextGap(2);
        btech.setMargin(new java.awt.Insets(2, 2, 2, 2));

        bntech=new JButton("Non-Technical PDFs");
        bntech.setFont(new Font("Times New Roman",0,15));
        bntech.setIconTextGap(2);
        bntech.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        bgk=new JButton("General Knowledge PDF");
        bgk.setFont(new Font("Times New Roman",0,15));
        bgk.setIconTextGap(2);
        bgk.setMargin(new java.awt.Insets(0, 0, 0, 0));

        bint=new JButton("Interview Tips PDFs");
        bint.setFont(new Font("Times New Roman",0,15));
        bint.setIconTextGap(2);
        bint.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        bfeed=new JButton("View Feedbacks ");
        bfeed.setFont(new Font("Times New Roman",0,15));
        bfeed.setIconTextGap(2);
        bfeed.setMargin(new java.awt.Insets(2, 2, 2, 2));
        
        bdel=new JButton("Deleted Questions");bdel.setFont(new Font("Times New Roman",0,15));
        bdel.setIconTextGap(2);
        bdel.setMargin(new java.awt.Insets(2, 2, 2, 2));

        bslog=new JButton("Students Log");bslog.setFont(new Font("Times New Roman",0,15));
        bslog.setIconTextGap(2);
        bslog.setMargin(new java.awt.Insets(2, 2, 2, 2));

        bflog=new JButton("Faculty Log");bflog.setFont(new Font("Times New Roman",0,15));
        bflog.setIconTextGap(2);
        bflog.setMargin(new java.awt.Insets(2, 2, 2, 2));

        
        tb=new JPanel();
        pt.setLayout(null);
        tp=new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	tp1=new JPanel();           tp1.setLayout(null);
        tp3=new JPanel();       tp3.setLayout(null);
         sfeed.setViewportView(feed);
         stp1.setViewportView(tb);
         scrl.setViewportView(fac);
         scrl1.setViewportView(stud);
         scrl2.setViewportView(bull);
         scrl3.setViewportView(delt);
         scrl4.setViewportView(slogin);
         scrl5.setViewportView(flogin);
         scrl6.setViewportView(fblk);
         scrl7.setViewportView(sblk);
         scr1.setViewportView(btch);
         scr2.setViewportView(bntch);
         scr3.setViewportView(bgkp);
         scr4.setViewportView(bintr);
         l=new JLabel("Administrator Portal");
	lpic =new JLabel(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\w1.jpg"));
	l.setFont(new Font("Times New Roman",4,30));    
	l.setForeground(new Color(0,0,153));	
        
         b=new JButton(new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\logout.jpg"));
         b.setFont(new Font("Times New Roman",0,12));   
         b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         b.setBorder(BorderFactory.createEmptyBorder());
         b.setBounds (1200,40,105,36);
         b.setMargin(new Insets(0, 0, 0, 0));
         p.setLayout(null);
         tb.setLayout(null);
	 l.setBounds(50,20,800,50);
         pt.setBounds (10,100,1330,580);   //pt has tabbed pane on it
         tp.setBounds (0,0,1330,580);       //tp is tabbed pane 
         board.setBounds(20,50,650,200);
         sfeed.setBounds(20,50,1200,400);
         stp1.setBounds(0,0,1324,550);   //scrollbar on tp1  (tab panel 1 ->view members)
         scrl.setBounds(20,50,1200,400);  
         scrl1.setBounds(20,50,1200,400);            //scrollbar on tp1  (tab panel 1 ->view members)         
         scrl2.setBounds(20,50,1200,400);    
         scrl3.setBounds(20,50,1200,400);    
         scrl4.setBounds(20,50,1200,400);    
         scrl5.setBounds(20,50,1200,400);    
         scrl6.setBounds(20,50,1200,400);    
         scrl7.setBounds(20,50,1200,400);    
         scr1.setBounds(20,50,1200,400);    
         scr2.setBounds(20,50,1200,400);    
         scr3.setBounds(20,50,1200,400);    
         scr4.setBounds(20,50,1200,400);    
         bstud.setBounds(10,10,150,25);
         bfac.setBounds(170,10,150,25);
         bullet.setBounds(330,10,150,25);
         bdel.setBounds(490,10,150,25);
         bslog.setBounds(650,10,150,25);
         bflog.setBounds(810,10,150,25);
         sblock.setBounds(970,10,150,25);
         fblock.setBounds(1130,10,150,25);
         btech.setBounds(10,470,150,25);
         bntech.setBounds(170,470,150,25);
         bgk.setBounds(330,470,155,25);
         bint.setBounds(495,470,150,25);
         bfeed.setBounds(655,470,150,25);
         tb.setPreferredSize(new Dimension(580, 620));
         lpic.setBounds(0,0,1369,729);
         stud.setBounds(10,50,1600,150);
         feed.setBounds(10,50,1200,150);
         fac.setBounds(10,50,1200,150);
         bull.setBounds(10,50,1200,150);
         delt.setBounds(10,50,1200,150);
         slogin.setBounds(10,50,1200,150);
         flogin.setBounds(10,50,1200,150);
         fblk.setBounds(10,50,1200,150);
         sblk.setBounds(10,50,1200,150);
         btch.setBounds(10,50,1200,150);
         bntch.setBounds(10,50,1200,150);
         bgkp.setBounds(10,50,1200,150);
         bintr.setBounds(10,50,1200,150);
         lboard.setBounds(10,10,200,30);
         
         viewans.setBounds(700,30,200,25);
         viewans.setIconTextGap(2);
         viewans.setMargin(new java.awt.Insets(2, 2, 2, 2));
     
         vupdate.setBounds(700,130,200,25);
         vupdate.setIconTextGap(2);
         vupdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
         
         feedback.setBounds(700,230,200,25);
         feedback.setIconTextGap(2);
         feedback.setMargin(new java.awt.Insets(2, 2, 2, 2));
         
         bpd.setBounds(700,180,200,25);
         bpd.setIconTextGap(2);
         bpd.setMargin(new java.awt.Insets(2, 2, 2, 2));
         p2.setBounds (400,300,350,150);
         lboard.setFont(new Font("Times New Roman",0,20));lboard.setForeground(new Color(0,0,153));
         viewans.setFont(new Font("Times New Roman",0,15));viewans.setForeground(new Color(0,0,153));
         vupdate.setFont(new Font("Times New Roman",0,15));vupdate.setForeground(new Color(0,0,153));
         feedback.setFont(new Font("Times New Roman",0,15));feedback.setForeground(new Color(0,0,153));
         bpd.setFont(new Font("Times New Roman",0,15));bpd.setForeground(new Color(0,0,153));
         viewques.setBounds(700,80,200,25);
        board.setFont(new Font("Times New Roman",4,20));
	board.setForeground(new Color(0,204,204));
	board.setLineWrap(true);

         viewques.setIconTextGap(2);
         viewques.setMargin(new java.awt.Insets(2, 2, 2, 2));

         viewques.setFont(new Font("Times New Roman",0,15));viewques.setForeground(new Color(0,0,153));

         submit.setBounds(100,300,90,30);       reset.setBounds(210,300,90,30);
         err.setBounds (150,350,350,20); err.setForeground(new Color (0,0,153));
                   if(board.getText()!=null)
         {
         submit.setEnabled(true);
         reset.setEnabled(true);
         }
	 f.add(p);
	 p.add(lpic);
         lpic.add(pt);
         pt.add(tp);                        tp.setFont(new Font("Times New Roman",0,15));    
         tb.add(bstud);                         bstud.addActionListener((ActionListener)this);
         tb.add(bfac);                          bfac.addActionListener((ActionListener)this);
       tb.add(bullet);                         bullet.addActionListener((ActionListener)this);
       tb.add(bdel);                         bdel.addActionListener((ActionListener)this);
       tb.add(bslog);                         bslog.addActionListener((ActionListener)this);
       tb.add(bflog);                         bflog.addActionListener((ActionListener)this);
       tb.add(sblock);                         sblock.addActionListener((ActionListener)this);
       tb.add(fblock);                         fblock.addActionListener((ActionListener)this);
       tb.add(btech);                         btech.addActionListener((ActionListener)this);
       tb.add(bntech);                         bntech.addActionListener((ActionListener)this);
       tb.add(bgk);                         bgk.addActionListener((ActionListener)this);
       tb.add(bint);                         bint.addActionListener((ActionListener)this);
       tb.add(bfeed);                         bfeed.addActionListener((ActionListener)this);
                  tb.add(scrl,BorderLayout.CENTER);
                  tb.add(sfeed,BorderLayout.CENTER);
                  tb.add(scrl1,BorderLayout.CENTER);
                  tb.add(scrl2,BorderLayout.CENTER);
                  tb.add(scrl,BorderLayout.CENTER);
                  tb.add(scrl3,BorderLayout.CENTER);
                  tb.add(scrl4,BorderLayout.CENTER);
                  tb.add(scrl5,BorderLayout.CENTER);
                  tb.add(scrl6,BorderLayout.CENTER);
                  tb.add(scrl7,BorderLayout.CENTER);
                  tb.add(scr1,BorderLayout.CENTER);
                  tb.add(scr2,BorderLayout.CENTER);
                  tb.add(scr3,BorderLayout.CENTER);
                  tb.add(scr4,BorderLayout.CENTER);
         tp.add("BULLETIN BOARD",tp3);     tp3.setFont(new Font("Times New Roman",0,15)); 
         tp3.add(board);                    board.addKeyListener((KeyListener)this);
         tp3.add(lboard);
         tp3.add(submit);           submit.addActionListener((ActionListener)this); 
         tp3.add(reset);        reset.addActionListener((ActionListener)this);reset.addMouseListener((MouseListener)this);
         tp3.add(err);
         tp3.add(viewans);      viewans.addActionListener((ActionListener)this);
         tp3.add(vupdate);      vupdate.addActionListener((ActionListener)this);
         tp3.add(feedback);      feedback.addActionListener((ActionListener)this);
         tp3.add(viewques);     viewques.addActionListener((ActionListener)this);
         tp3.add(bpd);          bpd.addActionListener((ActionListener)this);
        
         tp3.add(p1);                        p1.setVisible(false);
         tp3.add(p2);                        p2.setVisible(false);
         tp.add("VIEW DATABASE",tp1); tp1.setFont(new Font("Times New Roman",0,15));     tp1.add(stp1,BorderLayout.CENTER);
         lpic.add(b);                        b.addActionListener((ActionListener)this);
         lpic.add(l);
	 f.setVisible(true);
	 f.setSize(1369, 729);
         tp.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI()
                 {
                 protected int calculateTableHeight(int tabPlacement,int tabIndex,int fontHeight)
                 {return 50;}
                 }
                 );
         
             f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
    f.addWindowListener((WindowListener)this);

         p1.setBounds(920,30,400,500);
        lbl=new JLabel(" Edit your information here ");
        usr=new JLabel("USER ID");     usr.setFont(new Font("Times New Roman",0,18));
        tusr=new JTextField();
        name=new JLabel("NAME");           name.setFont(new Font("Times New Roman",0,17));
        tname=new JTextField();
        dob=new JLabel("D.O.B.");	dob.setFont(new Font("Times New Roman",0,17)); tdob=new JTextField();
        course=new JLabel("COURSE");	course.setFont(new Font("Times New Roman",0,17));
        rollno=new JLabel("ROLL NO.");	rollno.setFont(new Font("Times New Roman",0,17));
        address=new JLabel("ADDRESS");	address.setFont(new Font("Times New Roman",0,17));
        eid=new JLabel("E-MAIL ID");	eid.setFont(new Font("Times New Roman",0,17));
        gender=new JLabel("GENDER");	gender.setFont(new Font("Times New Roman",0,17));
        contact=new JLabel("CONTACT");	contact.setFont(new Font("Times New Roman",0,17));
        pswrd=new JLabel("PASSWORD");	pswrd.setFont(new Font("Times New Roman",0,17));
	save=new JButton("SAVE");	save.setFont(new Font("Times New Roman",0,18));
        save.setEnabled(false);         save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	cancel=new JButton("EXIT");	cancel.setFont(new Font("Times New Roman",0,18));   cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch=new JButton("SEARCH");	srch.setFont(new Font("Times New Roman",0,18));     srch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch.setIconTextGap(2);
        srch.setMargin(new java.awt.Insets(2, 2, 2, 2));

        ename=new JLabel();             ename.setForeground(new Color(204,0,0));       ename.setFont (new Font("Times New Roman",0,14));
        eroll=new JLabel();             eroll.setForeground(new Color(204,0,0));       eroll.setFont (new Font("Times New Roman",0,14));
        eaddr=new JLabel();             eaddr.setForeground(new Color(204,0,0));       eaddr.setFont (new Font("Times New Roman",0,14));
        eeid=new JLabel();              eeid.setForeground(new Color(204,0,0));        eeid.setFont (new Font("Times New Roman",0,14));
        econt=new JLabel();             econt.setForeground(new Color(204,0,0));       econt.setFont (new Font("Times New Roman",0,14));
        epass=new JLabel();             epass.setForeground(new Color(204,0,0));       epass.setFont (new Font("Times New Roman",0,14));
        
        block=new JButton("BLOCK");	block.setFont(new Font("Times New Roman",0,14));
        block.setIconTextGap(2);        block.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        block.setMargin(new java.awt.Insets(2, 2, 2, 2));
        block.setEnabled(false);

        unblock=new JButton("UNBLOCK");	unblock.setFont(new Font("Times New Roman",0,14));
        unblock.setIconTextGap(2);        unblock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        unblock.setMargin(new java.awt.Insets(2, 2, 2, 2));
        unblock.setEnabled(false);

        
        sfac=new JRadioButton("Faculty");	sfac.setFont(new Font("Times New Roman",0,15));
        sfac.setIconTextGap(2);
        sfac.setMargin(new java.awt.Insets(2, 2, 2, 2));
     
        sstud=new JRadioButton("Student");	sstud.setFont(new Font("Times New Roman",0,15));
        sstud.setIconTextGap(2);
        sstud.setMargin(new java.awt.Insets(2, 2, 2, 2));
     
         tcourse=new JComboBox();
	 tcourse.setModel(new DefaultComboBoxModel(new String[]{"Course","B.Tech","M.Tech","BCA","MCA","B.SC.","Hotel Management","Any Other"}));
         troll=new JTextField();
	 taddr=new JTextField();
	 teid=new JTextField();
         tgender=new JComboBox();
         tgender.setModel(new DefaultComboBoxModel(new String[]{"Gender","Male","Female"}));
         tcont=new JTextField();
         tpass=new JTextField();
         p1.setBackground(new Color(255,255,255));	

         p1.setLayout(null); 
         p2.setBackground(new Color(255,255,255));	

         p2.setLayout(null); 

         lbl.setBounds(100,10,600,20);
	
        usr.setBounds(20,50,100,20);          tusr.setBounds(120,50,100,20); 
        srch.setBounds(120,80,80,20);           sfac.setBounds(250,50,80,20);
                                                sstud.setBounds(250,80,80,20);
       
         lerr.setBounds (150,100,200,20);
        name.setBounds(10,120,100,20);     tname.setBounds(140,120,250,20);     ename.setBounds (140,140,250,15);
	dob.setBounds(10,155,100,20);      tdob.setBounds(140,155,250,20);                                                            
	course.setBounds(10,190,130,20);	tcourse.setBounds(140,190,250,20);
	rollno.setBounds(10,225,130,20);	troll.setBounds(140,225,250,20);        eroll.setBounds (140,245,250,15);
	address.setBounds(10,260,100,20);	taddr.setBounds(140,260,250,20);        eaddr.setBounds (140,280,250,15);
	eid.setBounds(10,295,100,20);          teid.setBounds(140,295,250,20);          eeid.setBounds (140,315,250,15);
	gender.setBounds(10,330,100,20);	tgender.setBounds(140,330,250,20);
	contact.setBounds(10,365,100,20);	tcont.setBounds(140,365,250,20);        econt.setBounds (140,385,250,15);
	pswrd.setBounds(10,400,100,20);         tpass.setBounds(140,400,250,20);        epass.setBounds (140,420,250,15);
	save.setBounds(80,440,80,20);         cancel.setBounds(230,440,80,20);	
        save.setFont(new Font("Times New Roman",0,15));
        save.setIconTextGap(2);
        save.setMargin(new java.awt.Insets(2, 2, 2, 2));
        block.setBounds(80,470,80,20);              unblock.setBounds(230,470,90,20);
        cancel.setFont(new Font("Times New Roman",0,15));
        cancel.setIconTextGap(2);
        cancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
          
         name1.setBounds(20,10,70,20);            tnm.setBounds(120,10,200,20);
         path.setBounds(20,45,70,20);           tpth.setBounds(120,45,200,20);
         cat.setBounds(20,80,85,20);           tcat.setBounds(120,80,200,20);
         ok.setBounds(50,110,80,20);           cncl.setBounds(150,110,80,20);
         err1.setBounds(70,130,120,20);            
         p2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 2, true)); 
         p1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 204), 2, true)); 
        p1.add(usr);
        p1.add(srch);           srch.addActionListener((ActionListener)this);
       
        p1.add(sfac);
        p1.add(sstud);
        bg.add(sfac);
        bg.add(sstud);
        p1.add(lerr);
        p1.add(lbl);
	p1.add(name);	
	p1.add(dob);	
	p1.add(course);
	p1.add(rollno);
	p1.add(address);
	p1.add(eid);
	p1.add(gender);
	p1.add(contact);
	p1.add(pswrd);
	p1.add(save);          save.addActionListener((ActionListener)this);
        p1.add(cancel);         	cancel.addActionListener((ActionListener)this);
        p1.add(block);          block.addActionListener((ActionListener)this);
        p1.add(unblock);          unblock.addActionListener((ActionListener)this);
        p1.add(tusr);
        p1.add(tname);           p1.add(ename);         tname.addKeyListener((KeyListener)this);
	p1.add(tdob);            
	p1.add(tcourse);       
	p1.add(troll);          p1.add(eroll);          troll.addKeyListener((KeyListener)this);
	p1.add(taddr);          p1.add(eaddr);          taddr.addKeyListener((KeyListener)this);
	p1.add(teid);           p1.add(eeid);           teid.addKeyListener((KeyListener)this);
        p1.add(tgender); 
        p1.add(tcont);          p1.add(econt);          tcont.addKeyListener((KeyListener)this);
        p1.add(tpass);          p1.add(epass);          tpass.addKeyListener((KeyListener)this);
                  
                    p2.add(name1);                               p2.add(tnm);   tnm.addFocusListener(this);
                    p2.add(path);                               p2.add(tpth);   tpth.addFocusListener(this);
                      p2.add(cat);                               p2.add(tcat);
                    p2.add(ok);                               p2.add(cncl);
                    ok.addMouseListener(this);                  ok.addFocusListener(this); 
                    cncl.addActionListener(this);
                    p2.add(err1);      
           b.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bstud.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bfac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bdel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bslog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bflog.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bullet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         sblock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         fblock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         viewques.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         viewans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         vupdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         feedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         btech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bntech.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bgk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
         bint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));        
          cncl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
          bpd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    
    }
   public void keyTyped(KeyEvent e)
   {Object o=e.getSource();
   if(o==tname)
   {
   	char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		ename.setText("! Enter characters only .");
		}
		if ((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||(c==' ')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		ename.setText("");
		}
   }
   if(o==troll)
   {
           char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
               eroll.setText("! Enter valid number ");
                }
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		eroll.setText("");
		}
	
   }
   if(o==taddr)
   {
   char c=e.getKeyChar();
		if(!(((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		eaddr.setText("! Enter valid character ");
		}
		if((((c>='a')&&(c<='z'))||((c>='A')&&(c<='Z'))||((c>='0')&&(c<='9'))||(c=='&')||(c==':')||(c==' ')||(c=='.')||(c==',')||(c=='-')||(c=='#')||(c=='(')||(c==')')||(c=='/')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		eaddr.setText("");
		}
   }
   if(o==teid)
   {
             if(teid.getText().length()==0)
                                  {
                                   eeid.setText("Enter email id");
                                  }
             if(teid.getText().length()!=0)
                                  {
                                  Pattern MyPattern =Pattern.compile("^[a-z]+[a-z.0-9-]+@[a-z.-]+(\\.[A-Za-z0-9]+)$");
                                  Matcher MyMatcher=MyPattern.matcher(teid.getText());
                                  Boolean MyBoolean =MyMatcher.matches();
                                   if(MyBoolean==true)
                                          {
                    
                                           eeid.setText("");
                                           }
                                   else
                                      {
                                       eeid.setText("Enter valid email id ");
                                       }
                                   }
  }
   if(o==tcont)
   {
   	char c=e.getKeyChar();
	if(!(((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		e.consume();
		econt.setText("! Enter valid number ");
		}
	if((((c>='0')&&(c<='9'))||(c==' ')||(c=='-')||(c==KeyEvent.VK_SHIFT)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))	
		{
		econt.setText(" ");
		}
  }
   if(o==tpass)
   {
   
                                      if(tpass.getText().length()<6)
                                      {
                                         epass.setText("password length should atleast 6");
                                      }
   }
   
   if(o==board)
     {
          if(board.getText().length()>500)
         {
            e.consume();    
         }
     }
  }
   public void keyReleased(KeyEvent e){}
   public void keyPressed(KeyEvent e){}
   
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
	 public void actionPerformed (ActionEvent e)
	{
	Object o=e.getSource();
	if(o==ok)       
        {   
        
        }
        if(o==cncl)
        {
        p2.setVisible(false);
        }
        
       if(o==b)
       {
          StudentLog al=new StudentLog();
          f1();
       }
       Boolean bool=false;
       if(o==srch)  //search button
       {
           save.setEnabled(true); 
         if(sstud.isSelected())  //search stud
                {
                            
                            rollno.setText("ROLL NO.");
                            course.setText("COURSE");
                try
                {    unblock.setEnabled(false);
                    block.setEnabled(true); 
                        connect c=new connect();
                //for getting the values
                
                       Statement st;
                        st=c.conn.createStatement();
                        String usr=tusr.getText();
            
                        ResultSet res=st.executeQuery("select * from name where userid='"+usr+"'");
                        String name=null,date=null,course=null,roll=null,addr=null,email=null,gender=null,contact=null,password=null,uesrid=null;
            
                            while(res.next()){
                            name=res.getString(1);
            
                            date=res.getString(2);
                            course=res.getString(3);
                            roll=res.getString(4);
                            addr=res.getString(5);
                            email=res.getString(6);
                            gender=res.getString(7);    
                            contact=res.getString(8);
                            password=res.getString(9);
                            bool=true;
                            }
                tname.setText(name);
                tdob.setText(date);
                troll.setText(roll);
               tcourse.setModel(new DefaultComboBoxModel(new String[]{"Course","B.Tech","M.Tech","BCA","MCA","B.SC.","Hotel Management","Any Other"}));
                String cc =course;
                if(cc.equals("B.Tech"))
                {
                tcourse.setSelectedIndex(1);
                }
                if(cc.equals("M.Tech"))
                {
                tcourse.setSelectedIndex(2);
                }
                if(cc.equals("BCA"))
                {
                    tcourse.setSelectedIndex(3);
                }
                if(cc.equals("MCA"))
                {
                    tcourse.setSelectedIndex(4);
                }
                if(cc.equals("B.SC."))
                {
                    tcourse.setSelectedIndex(5);
                }
                if(cc.equals("Hotel Management"))
                {
                    tcourse.setSelectedIndex(6);
                }
                if(cc.equals("Any Other"))
                {
                    tcourse.setSelectedIndex(7);
                }

                taddr.setText(addr);
                teid.setText(email);

                String gen =gender;
                if(gen.equals("Male"))
                {
                 tgender.setSelectedIndex(1);
                }
                if(gen.equals("Female"))
                {
                tgender.setSelectedIndex(2);
                }

                tcont.setText(contact);
                tpass.setText(password);
                }
            catch(Exception ex)
            {

            }
                if(tname.getText().length()==0)
                {   save.setEnabled(false);
                    block.setEnabled(false);
                    unblock.setEnabled(true);
                try
                {
                        connect c=new connect();
                //for getting the values
                
                       Statement st;
                        st=c.conn.createStatement();
                        String usr=tusr.getText();
                        ResultSet res=st.executeQuery("select * from sblock where userid='"+usr+"'");
                        String name=null,date=null,course=null,roll=null,addr=null,email=null,gender=null,contact=null,password=null,uesrid=null;
                            while(res.next()){
                            name=res.getString(1);
                            date=res.getString(2);
                            course=res.getString(3);
                            roll=res.getString(4);
                            addr=res.getString(5);
                            email=res.getString(6);
                            gender=res.getString(7);    
                            contact=res.getString(8);
                            password=res.getString(9);
                            bool=true;
                            }
                tname.setText(name);
                tdob.setText(date);
               tcourse.setModel(new DefaultComboBoxModel(new String[]{"Course","B.Tech","M.Tech","BCA","MCA","B.SC.","Hotel Management","Any Other"}));
                String cc =course;
                if(cc.equals("B.Tech"))
                {
                tcourse.setSelectedIndex(1);
                }
                if(cc.equals("M.Tech"))
                {
                tcourse.setSelectedIndex(2);
                }
                if(cc.equals("BCA"))
                {
                    tcourse.setSelectedIndex(3);
                }
                if(cc.equals("MCA"))
                {
                    tcourse.setSelectedIndex(4);
                }
                if(cc.equals("B.SC."))
                {
                    tcourse.setSelectedIndex(5);
                }
                if(cc.equals("Hotel Management"))
                {
                    tcourse.setSelectedIndex(6);
                }
                if(cc.equals("Any Other"))
                {
                    tcourse.setSelectedIndex(7);
                }

                String gen =gender;
                if(gen.equals("Male"))
                {
                 tgender.setSelectedIndex(1);
                }
                if(gen.equals("Female"))
                {
                tgender.setSelectedIndex(2);
                }

                troll.setText(roll);
                taddr.setText(addr);
                teid.setText(email);

                tcont.setText(contact);
                tpass.setText(password);
                
                
                }
            catch(Exception ex)
            {

            }
         }
                    
                    }
             if(sfac.isSelected())   //search fac
             {
                        rollno.setText("EXPERIENCE");
                        course.setText("QUALIFICATION");
             try
                {
                     unblock.setEnabled(false);
                    block.setEnabled(true); 
                    
                        connect c=new connect();
                //for getting the values
                
                       Statement st;
                        st=c.conn.createStatement();
                        String usr=tusr.getText();

                        ResultSet res=st.executeQuery("select * from facreg where userid='"+usr+"'");
                        String name=null,date=null,course=null,roll=null,addr=null,email=null,gender=null,contact=null,password=null,uesrid=null;

                            while(res.next()){
                            name=res.getString(1);

                            date=res.getString(2);
                            course=res.getString(3);
                            roll=res.getString(4);
                            addr=res.getString(5);
                            email=res.getString(6);
                            gender=res.getString(7);    
                            contact=res.getString(8);
                            password=res.getString(9);
                            bool=true;
                            }

                tname.setText(name);
                tdob.setText(date);

                tcourse.setModel(new DefaultComboBoxModel(new String[]{"Qualification","DIPLOMA","GRADUATE","POST GRADUATE","OTHERS"}));
                String cc =course;
                if(cc.equals("DIPLOMA"))
                {
                tcourse.setSelectedIndex(1);
                }
                if(cc.equals("GRADUATE"))
                {
                tcourse.setSelectedIndex(2);
                }
                if(cc.equals("POST GRADUATE"))
                {
                    tcourse.setSelectedIndex(3);
                }
                if(cc.equals("OTHERS"))
                {
                    tcourse.setSelectedIndex(4);
                }
                String gen =gender;
                if(gen.equals("Male"))
                {
                 tgender.setSelectedIndex(1);
                }
                if(gen.equals("Female"))
                {
                tgender.setSelectedIndex(2);
                }

                troll.setText(roll);
                taddr.setText(addr);
                teid.setText(email);

                tcont.setText(contact);
                tpass.setText(password);
            }
            catch(Exception ex)
            {

            }
               if(tname.getText().length()==0)
                {   save.setEnabled(false);
                    block.setEnabled(false);
                    unblock.setEnabled(true);
                     try
                {
                    
                        connect c=new connect();
                //for getting the values
                
                       Statement st;
                        st=c.conn.createStatement();
                        String usr=tusr.getText();
                        ResultSet res=st.executeQuery("select * from fblock where usr='"+usr+"'");
                        String name=null,date=null,course=null,roll=null,addr=null,email=null,gender=null,contact=null,password=null,uesrid=null;
                            while(res.next()){
                           name=res.getString(1);date=res.getString(2);                            course=res.getString(3);
                            roll=res.getString(4);                            addr=res.getString(5);
                            email=res.getString(6);                            gender=res.getString(7);    
                            contact=res.getString(8);                            password=res.getString(9);
                            bool=true;                            }
                tname.setText(name);
                tdob.setText(date);
                tcourse.setModel(new DefaultComboBoxModel(new String[]{"Qualification","DIPLOMA","GRADUATE","POST GRADUATE","OTHERS"}));
                String cc =course;
                if(cc.equals("DIPLOMA"))    {  tcourse.setSelectedIndex(1);    }
                if(cc.equals("GRADUATE"))   { tcourse.setSelectedIndex(2);     }
                if(cc.equals("POST GRADUATE")) { tcourse.setSelectedIndex(3); }
                if(cc.equals("OTHERS")) {   tcourse.setSelectedIndex(4);      }
                String gen =gender;
                if(gen.equals("Male"))  {  tgender.setSelectedIndex(1);     }
                if(gen.equals("Female"))  {  tgender.setSelectedIndex(2); }
                troll.setText(roll);
                taddr.setText(addr);
                teid.setText(email);
                tcont.setText(contact);
                tpass.setText(password);       }
            catch(Exception ex) {}         }}
                if(bool==false)   //if err or no record found
                {
                lerr.setText("No Record Found!");                lerr.setForeground(Color.red);
                save.setEnabled(false);                block.setEnabled(false);
                unblock.setEnabled(false);                }
                 else
                {  lerr.setText("");    }
                 if(lerr.getText()=="No Record Found!")
                 {/*tname,tdob,tcourse tgender,troll,taddr,teid,tcont, tpass*/
                 tname.setText("");
                 tdob.setText("");
                 tcourse.setSelectedIndex(0);
                 tgender.setSelectedIndex(0);
                 troll.setText("");
                 taddr.setText("");
                 teid.setText("");
                 tcont.setText("");
                 tpass.setText("");
                 }
                }
                if(o==save)    //save changes of stud or fac
                {
                if(sstud.isSelected())       //update stud info
                {
                    try
                
                     {
                connect c=new connect();
                
               
                        String usr=tusr.getText();
                PreparedStatement ps;
                ps=c.conn.prepareStatement("Update name set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=? where userid='"+usr+"'");
                ps.setString(1,tname.getText().toString());
                ps.setString(2,tdob.getText().toString());
                ps.setString(3,tcourse.getSelectedItem().toString());
                ps.setString(4,troll.getText().toString());
                ps.setString(5,taddr.getText().toString());
                ps.setString(6,teid.getText().toString());
                ps.setString(7,tgender.getSelectedItem().toString());
                ps.setString(8,tcont.getText().toString());
                ps.setString(9,tpass.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {

                    lerr.setText("record inserted");
                    f.setVisible(false);
                    AdminPortal ap=new AdminPortal();
                }
                
                
            }
            catch(Exception ex)
            {

            }
                     }
                
                                if(sfac.isSelected())       //update fac info
                {
                    try
                
                     {
                connect c=new connect();
                 String usr=tusr.getText();

                PreparedStatement ps;
                ps=c.conn.prepareStatement("Update facreg set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=? where userid='"+usr+"'");
                ps.setString(1,tname.getText().toString());
                ps.setString(2,tdob.getText().toString());
                ps.setString(3,tcourse.getSelectedItem().toString());
                ps.setString(4,troll.getText().toString());
                ps.setString(5,taddr.getText().toString());
                ps.setString(6,teid.getText().toString());
                ps.setString(7,tgender.getSelectedItem().toString());
                ps.setString(8,tcont.getText().toString());
                ps.setString(9,tpass.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {

                    lerr.setText("record inserted");
                    f.setVisible(true);
                    AdminPortal ap=new AdminPortal();
                }
                
                
            }
            catch(Exception ex)
            {

            }
                     }

                }
                if(o==block)
                {

               int i= JOptionPane.showConfirmDialog(p1, "Do you want to block "+tusr.getText()+"?","Knowledge Point", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if(i==JOptionPane.YES_OPTION)
                   {
                   if(sfac.isSelected())
                   {
                                           try
                     {       connect c=new connect();
                      PreparedStatement ps ,ps1;
                            ps=c.conn.prepareStatement("insert into fblock values(?,?,?,?,?,?,?,?,?,?,?)");
                            ps.setString(1,tname.getText().toString());
                            ps.setString(2,tdob.getText().toString());
                            ps.setString (3,tcourse.getSelectedItem().toString());
                            ps.setString (4,troll.getText().toString());
                            ps.setString (5,taddr.getText().toString());
                            ps.setString(6,teid.getText().toString());
                            ps.setString(7,tgender.getSelectedItem().toString());
                            ps.setString(8,tcont.getText().toString());
                            ps.setString(9,tpass.getText().toString());
                            ps.setString(10,tusr.getText().toString());
                            ps.setString(11,dt.getText().toString());

                            ps1=c.conn.prepareStatement("Update facreg set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=?,dt=? where userid='"+tusr.getText()+"'");
                            ps1.setString(1,error.getText().toString());
                            ps1.setString(2,error.getText().toString());
                            ps1.setString(3,error.getText().toString());
                            ps1.setString(4,error.getText().toString());
                            ps1.setString(5,error.getText().toString());
                            ps1.setString(6,error.getText().toString());
                            ps1.setString(7,error.getText().toString());
                            ps1.setString(8,error.getText().toString());
                            ps1.setString(9,error.getText().toString());
                            ps1.setString(10,error.getText().toString());
                              int ip=ps.executeUpdate();
                                if(ip==1)
                                {
              
                                }
                           int ip1=ps1.executeUpdate();
                           if(ip1==1)
                           {
              
                                    JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+" Blocked","Knowledge Point",JOptionPane.OK_OPTION);
                                    f.setVisible(false);
                                    AdminPortal fa=new AdminPortal();
                           }  
                            else
                                      {
                                         JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"no block ","Knowledge Point",JOptionPane.OK_OPTION);
                                      }
                         }
                          catch(Exception ex)
                          {

                                   JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"error"+ex.getMessage(),"Knowledge Point",JOptionPane.OK_OPTION);
                          }
                   }
                   else if(sstud.isSelected())   
                    {
                    //delete from name and insert into sblock
 
                                           try
                     {       connect c=new connect();
                      PreparedStatement ps ,ps1;
                            ps=c.conn.prepareStatement("insert into sblock values(?,?,?,?,?,?,?,?,?,?,?)");
                              ps.setString(1,tname.getText().toString());
                            ps.setString(2,tdob.getText().toString());
                            ps.setString (3,tcourse.getSelectedItem().toString());
                            ps.setString (4,troll.getText().toString());
                            ps.setString (5,taddr.getText().toString());
                            ps.setString(6,teid.getText().toString());
                            ps.setString(7,tgender.getSelectedItem().toString());
                            ps.setString(8,tcont.getText().toString());
                            ps.setString(9,tpass.getText().toString());
                            ps.setString(10,tusr.getText().toString());
                            ps.setString(11,dt.getText().toString());
                            ps1=c.conn.prepareStatement("update name set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=?,dt=? where userid='"+tusr.getText()+"'");
                            ps1.setString(1,error.getText().toString());
                            ps1.setString(2,error.getText().toString());
                            ps1.setString (3,error.getText().toString());
                            ps1.setString (4,error.getText().toString());
                            ps1.setString (5,error.getText().toString());
                            ps1.setString(6,error.getText().toString());
                            ps1.setString(7,error.getText().toString());
                            ps1.setString(8,error.getText().toString());
                            ps1.setString(9,error.getText().toString());
                            ps1.setString(10,error.getText().toString());

                            int ip=ps.executeUpdate();
                                if(ip==1)
                                {
                  
                                }
                            int rowsDeleted = ps1.executeUpdate();
                            if (rowsDeleted > 0)
                                    {          JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+" Blocked","Knowledge Point",JOptionPane.OK_OPTION);
                                    f.setVisible(false);
                                    AdminPortal fa=new AdminPortal();
                                    }  
                            else
                                      {
                                      }
                         }
                          catch(Exception ex)
                          {

                          }                       
                    }
                    else
                   {

                   JOptionPane.showMessageDialog(p1,"No user found to block .Please Search User ID !" ,"Knowledge Point",JOptionPane.OK_OPTION );
                   f.setVisible(false);
                   AdminPortal ap=new AdminPortal();
                   }
               }
               
                }
                if(o==unblock)
                {
                unblock.setEnabled(false);
                         if(sfac.isSelected())
                   {
                   //delete from facreg and insert into fblock
                    
                                           try
                     {       connect c=new connect();
                      PreparedStatement ps ,ps1;
                 String usr=tusr.getText();
                ps=c.conn.prepareStatement("Update facreg set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=? ,dt=?where userid='"+usr+"'");
                ps.setString(1,tname.getText().toString());
                ps.setString(2,tdob.getText().toString());
                ps.setString(3,tcourse.getSelectedItem().toString());
                ps.setString(4,troll.getText().toString());
                ps.setString(5,taddr.getText().toString());
                ps.setString(6,teid.getText().toString());
                ps.setString(7,tgender.getSelectedItem().toString());
                ps.setString(8,tcont.getText().toString());
                ps.setString(9,tpass.getText().toString());
                ps.setString(10,dt.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {

                    lerr.setText("User ID '"+usr+"' Unblocked");
                }
               
                            ps1=c.conn.prepareStatement("delete from fblock where usr=?");
                              ps1.setString(1,tusr.getText());
                              int ip=ps.executeUpdate();
                                if(ip==1)
                                {

                                }
                           int ip1=ps1.executeUpdate();
                           if(ip1==1)
                           {

                                    JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+" Unblocked","Knowledge Point",JOptionPane.OK_OPTION);
                                    f.setVisible(false);
                                    AdminPortal fa=new AdminPortal();
                           }  
                            else
                                      {
                                         JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"no unblock ","Knowledge Point",JOptionPane.OK_OPTION);
                                      }
                         }
                          catch(Exception ex)
                          {

                                   JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"error"+ex.getMessage(),"Knowledge Point",JOptionPane.OK_OPTION);
                          }
                   }
                if(sstud.isSelected())   
                    {
                    //delete from name and insert into sblock
                         try
                     {  
                connect c=new connect();
                PreparedStatement ps ,ps1;
                String usr=tusr.getText();
                ps=c.conn.prepareStatement("Update name set name=?,date=?,course=?,roll=?,addr=?,email=?,gender=?,contact=?,password=? ,dt=?where userid='"+usr+"'");
                ps.setString(1,tname.getText().toString());
                ps.setString(2,tdob.getText().toString());
                ps.setString(3,tcourse.getSelectedItem().toString());
                ps.setString(4,troll.getText().toString());
                ps.setString(5,taddr.getText().toString());
                ps.setString(6,teid.getText().toString());
                ps.setString(7,tgender.getSelectedItem().toString());
                ps.setString(8,tcont.getText().toString());
                ps.setString(9,tpass.getText().toString());
                ps.setString(10,dt.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {

                    lerr.setText("User ID '"+usr+"' Unblocked");
                }
               
                            ps1=c.conn.prepareStatement("delete from sblock where userid=?");
                              ps1.setString(1,tusr.getText());
                              int ip=ps.executeUpdate();
                                if(ip==1)
                                {

                                }
                           int ip1=ps1.executeUpdate();
                           if(ip1==1)
                           {

                                    JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+" Unblocked","Knowledge Point",JOptionPane.OK_OPTION);
                                    f.setVisible(false);
                                    AdminPortal fa=new AdminPortal();
                           }  
                            else
                                      { 
                                         JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"no unblock ","Knowledge Point",JOptionPane.OK_OPTION);
                                      }
                         }
                          catch(Exception ex)
                          {

                                   JOptionPane.showMessageDialog(p1, "User ID : "+tusr.getText()+"error"+ex.getMessage(),"Knowledge Point",JOptionPane.OK_OPTION);
                          }
                    }
                }
                if(o==cancel)//close update panel
                {
                p1.setVisible(false);
                lerr.setText("");
                tusr.setText("");
                tname.setText("");
                tdob.setText("");
                tcourse.setSelectedIndex(0);
                troll.setText("");
                taddr.setText("");
                teid.setText("");
                tgender.setSelectedIndex(0);
                tcont.setText("");
                tpass.setText("");
                ename.setText("");
                eroll.setText("");
                eaddr.setText("");
                eeid.setText("");
                econt.setText("");
                epass.setText("");
                bg.clearSelection();
                }
                
                if(o==bfeed)  // view feedback information
                {
                     try
                        {
                            feed.setModel(dfeed);
                            scrl1.setVisible(false);
                            scrl.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl5.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                          sfeed.setVisible(true);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                
                if(o==bstud)  // view student information
                {
                     try
                        {
                            stud.setModel(dms);
                            scrl1.setVisible(true);
                            scrl.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl5.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==btech)
                {
                 try
                        {
                            btch.setModel(dbtch);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(true);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==bntech)
                {
                 try
                        {
                            bntch.setModel(dbntch);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(true);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==bgk)
                {
                 try
                        {
                            bgkp.setModel(dbgk);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(true);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                
                
                if(o==bint)
                {
                 try
                        {
                            bintr.setModel(dbint);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(true);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==bslog)  //view deleted questions   
                {
                    try
                        {
                            slogin.setModel(dmsl);
                            scrl4.setVisible(true);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl5.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==sblock)
                {
                    try
                        {
                            sblk.setModel(ds);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(true);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                            sfeed.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                
                }
                if(o==fblock)
                {
                    try
                        {
                            fblk.setModel(df);
                            scrl5.setVisible(false);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(true);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            sfeed.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                
                }
                if(o==bflog)  //view deleted questions   
                {
                    try
                        {
                            flogin.setModel(dmfl);
                            scrl5.setVisible(true);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            sfeed.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                
                if(o==bdel)  //view deleted questions   
                {
                    try
                        {
                            delt.setModel(dmd);
                            scrl3.setVisible(true);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl4.setVisible(false);
                            scrl5.setVisible(false);
                            sfeed.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==bullet)       //view bulletin board
                {
                    try
                        {
                            bull.setModel(dmb);
                            scrl2.setVisible(true);
                            scrl.setVisible(false);
                            scrl1.setVisible(false);
                            scrl3.setVisible(false);
                            scrl4.setVisible(false);
                            sfeed.setVisible(false);
                            scrl5.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                        }
                    catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                }
                if(o==bfac)         //view faculty members
                {
                          try
                        {
                            fac.setModel(dmf);
                            scrl.setVisible(true);
                            scrl1.setVisible(false);
                            scrl2.setVisible(false);
                            scrl3.setVisible(false);
                            sfeed.setVisible(false);
                            scrl4.setVisible(false);
                            scrl5.setVisible(false);
                            scrl6.setVisible(false);
                            scrl7.setVisible(false);
                            scr1.setVisible(false);
                            scr2.setVisible(false);
                            scr3.setVisible(false);
                            scr4.setVisible(false);
                        }
                         catch(Exception ex)
                        {
                                  JOptionPane.showMessageDialog(null,"error in fetching data.."+ex.toString(),"Error",2); 
                        } 
                
                }
                if(o==viewans)      //view answered question 
                {
                ViewAns q=new ViewAns();
                   p1.setVisible(false); 
                f1();
                }
                if(o==feedback)
                {
                AdminFeedback af=new AdminFeedback();
                f1();
                }
                if(o==vupdate)      // appear update or edit info panel  
                {
                    p1.setVisible(true);
                }
                if(o==bpd)
                {
                    p2.setVisible(true);
                }
                if(o==viewques)     //view unanwered question
                {
                ViewQues v=new ViewQues();
                    p1.setVisible(false);
                f1();
                }
                if(o==submit)      // update bulletin board
                {
                    try{
                 PreparedStatement ps;
                ps=con.prepareStatement("insert into msg values(?,?)");
                ps.setString(1,board.getText().toString());
                ps.setString(2,dt.getText().toString());
                int i=ps.executeUpdate();
                if(i==1)
                {

                    err.setText("Bulletin Board Updated .");
                      err.setForeground(new Color(0,0,153));
                      f.setVisible(false);
                      AdminPortal ap=new AdminPortal();
                }
                    }
                    catch(Exception ex)
                    {

                    err.setText("Error occurred in updating the Bulletin Board");
                    err.setForeground(new Color(204,0,0));
                    }
                }
                
	}
@Override
         public void mouseClicked(MouseEvent e)
         {Object o=e.getSource();
            if(o==reset)        //reset bulletin board content
                {
                board.setText("");
                }
             if(o==ok)
                 
                         {           ctgry=tcat.getSelectedItem().toString();
                    if((tnm.getText()=="")||(tnm.getText()==" "))
                    {err.setText("Please enter Name of file");}
                    else{err.setText("");}
                    
                    if((tpth.getText()=="")||(tpth.getText()==" "))
                    {err.setText("Please enter Path of file");}
                    else{err.setText("");}
                
             if((tnm.getText()=="")||(tpth.getText()==""))
             { 
                 JOptionPane.showMessageDialog(p2, "err");
                 err.setText("Please fill above fields");
             }
             else
             {
                    err.setText("");
                    if(ctgry=="Technical")
                    {
                                try
                                {
                                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                    conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                                    PreparedStatement ps;
                                    ps=conn.prepareStatement("insert into tech values(?,?,?)");
                                    ps.setString(1,tnm.getText().toString());
                                    ps.setString(2,tpth.getText().toString());
                                    ps.setString(3,dt.getText());    
                                         int i=ps.executeUpdate();
                                         if(i==1)
                                        {
                                          f.setVisible(false);
                                          AdminPortal ap=new AdminPortal();
                                        }
                                }                       
                                catch(Exception ex)
                                {
                                   JOptionPane.showMessageDialog(f, "file cant be added"+ex.getMessage());
                                }
       
                    }
                    if(ctgry=="Non-Technical")
                    {
                                try
                                {
                                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                    conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                                    PreparedStatement ps;
                                    ps=conn.prepareStatement("insert into ntech values(?,?,?)");
                                    ps.setString(1,tnm.getText().toString());
                                    ps.setString(2,tpth.getText().toString());
                                    ps.setString(3,dt.getText());    
                                         int i=ps.executeUpdate();
                                         if(i==1)
                                        {
                                          f.setVisible(false);
                                          AdminPortal ap=new AdminPortal();
                                        }
                                }                       
                                catch(Exception ex)
                                {
                                   JOptionPane.showMessageDialog(f, "error = "+ex.getMessage());
                                }
                    }
                    if(ctgry=="General Knowledge")
                    {
                                try
                                {
                                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                    conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                                    PreparedStatement ps;
                                    ps=conn.prepareStatement("insert into gk values(?,?,?)");
                                    ps.setString(1,tnm.getText().toString());
                                    ps.setString(2,tpth.getText().toString());
                                    ps.setString(3,dt.getText());    
                                         int i=ps.executeUpdate();
                                         if(i==1)
                                        {
                                          f.setVisible(false);
                                          AdminPortal ap=new AdminPortal();
                                        }
                                }                       
                                catch(Exception ex)
                                {
                                   JOptionPane.showMessageDialog(f, "error = "+ex.getMessage());
                                }
                    
                    }
                    if(ctgry=="Interview Tips")
                    {
                                try
                                {
                                    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
                                    conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
                                    PreparedStatement ps;
                                    ps=conn.prepareStatement("insert into inter values(?,?,?)");
                                    ps.setString(1,tnm.getText().toString());
                                    ps.setString(2,tpth.getText().toString());
                                    ps.setString(3,dt.getText());    
                                         int i=ps.executeUpdate();
                                         if(i==1)
                                        {
                                          f.setVisible(false);
                                          AdminPortal ap=new AdminPortal();
                                        }
                                }                       
                                catch(Exception ex)
                                {
                                   JOptionPane.showMessageDialog(f, "error = "+ex.getMessage());
                                }
                    
                    }
             }

                 }
                 
         }
@Override
         public void mouseExited(MouseEvent e){}
@Override
         public void mousePressed(MouseEvent e){}
@Override
         public void mouseReleased(MouseEvent e){}
@Override
         public void mouseEntered(MouseEvent e){}
@Override
         public void focusLost(FocusEvent e)
         {
         Object o=e.getSource();
            if(o==tnm)
            {
             if(tnm.getText()=="")
                {err1.setText("please enter name of file");}         
            }
         if(o==tpth)
            {
             if(tpth.getText()=="")
                {err1.setText("please enter path of file");}         
            }
         }
@Override
         public void focusGained(FocusEvent e)
         {
             Object o=e.getSource();
                if(o==tnm)
                    {
                     if(tnm.getText()=="")
                         {err1.setText("please enter name of file");}         
                    }
               if(o==tpth)
                    {
                     if(tpth.getText()=="")
                            {err1.setText("please enter path of file");}         
                    }
         }
         public void f1()
         {
         f.setVisible(false);
         }
public static void main(String s[])
{
    AdminPortal ap=new AdminPortal();
}
}