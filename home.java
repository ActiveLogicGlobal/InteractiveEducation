package knowledgepoint;
import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;

public class home implements Runnable
{   JFrame f;
    JLabel lpic;
    ImageIcon img[];
    Thread th;
    Timer t;   /////////////275  183
    int i = 0;
    
    home() 
    {
        f=new JFrame("KNOWLEDGE POINT");
        th=new Thread(this);
        t = new Timer();
        img = new ImageIcon[3];
        img[0] = new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\sst1.jpg");	
        img[1] = new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\sst2.jpg");	
        img[2] = new ImageIcon("C:\\Users\\gurvishal\\Documents\\NetBeansProjects\\KnowledgePoint\\src\\knowledgepoint\\pictures\\stt.jpg");	
        lpic = new JLabel(img[i]);
        f.setLocation(new Point(580,250));
        f.setResizable(false);
        f.add(lpic);
        f.setVisible(true);
        f.setSize(290, 220);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        th.start();
        t.schedule(new LoginSc(), 5000);
   }
    public void run() {
        while (th != null) {
            try {
                display();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
             //  System.out.println("Error in code.." + e.getMessage(), "Thread Issue", 1);
            }

        }
    }

    void display() {
        i = i + 1;
        if (i > 2) {
            i = 0;
        }
        lpic.setIcon(img[i]);
    }

    public class LoginSc extends TimerTask {

        @Override
        public void run() {
        StudentLog sl=new StudentLog();
        f.setVisible(false);
        }
    }
}