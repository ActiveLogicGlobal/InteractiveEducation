package knowledgepoint;
import java.sql.*;
public class connect
{
 Connection conn;
     connect()
    {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn=DriverManager.getConnection("jdbc:derby://localhost:1527/StudentInformation","simran","12345");
     } 
        catch(Exception e){}
     
    }
 }