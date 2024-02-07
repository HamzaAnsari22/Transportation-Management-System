/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;

/**
 *
 * @author Hamza
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 import java.sql.*;  
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author Administrator
 */
public class Connection1 {
      public Connection setconnection()
      {
          Connection connn=null;
          try
          {
              String driverName="oracle.jdbc.driver.OracleDriver";
              Class.forName(driverName);
              String serverName="localhost";
              String serverPort="1521";
              String sid="orcl";
              String url="jdbc:oracle:thin:@"+serverName+":"+serverPort+"/"+sid;
              String username="adminis";
              String password="admin";
//              connn=DriverManager.getConnection(url,username,password);
            connn=DriverManager.getConnection(url, username, password);
              System.out.println("Successfully connected to database");
              
              
          }
          catch(ClassNotFoundException e)
          {
              System.out.println("Could not find database driver"+e.getMessage());
              
          }
          catch(SQLException e)
          {
              System.out.println("Could not connect database driver"+e.getMessage());
          }
          return connn;
      }
      public Connection setconnectionP()
      {
          Connection connn=null;
          try
          {
              String driverName="oracle.jdbc.driver.OracleDriver";
              Class.forName(driverName);
              String serverName="localhost";
              String serverPort="1521";
              String sid="orcl";
              String url="jdbc:oracle:thin:@"+serverName+":"+serverPort+"/"+sid;
              String username="passenger";
              String password="passenger";
//              connn=DriverManager.getConnection(url,username,password);
connn=DriverManager.getConnection(url, username, password);
              System.out.println("Successfully connected to database");
              
              
          }
          catch(ClassNotFoundException e)
          {
              System.out.println("Could not find database driver"+e.getMessage());
              
          }
          catch(SQLException e)
          {
              System.out.println("Could not connect database driver"+e.getMessage());
          }
          return connn;
      }
      public Connection setconnectionD()
      {
          Connection connn=null;
          try
          {
              String driverName="oracle.jdbc.driver.OracleDriver";
              Class.forName(driverName);
              String serverName="localhost";
              String serverPort="1521";
              String sid="orcl";
              String url="jdbc:oracle:thin:@"+serverName+":"+serverPort+"/"+sid;
              String username="driver";
              String password="driver";
//              connn=DriverManager.getConnection(url,username,password);
connn=DriverManager.getConnection(url, username, password);
              System.out.println("Successfully connected to database");
              
              
          }
          catch(ClassNotFoundException e)
          {
              System.out.println("Could not find database driver"+e.getMessage());
              
          }
          catch(SQLException e)
          {
              System.out.println("Could not connect database driver"+e.getMessage());
          }
          return connn;
      }
      
 public void SimpleCallSample(JTable table)
{
    
  try
  {
       Connection con=setconnection();
      Statement s=con.createStatement();
    CallableStatement stmt = con.prepareCall("{call abc(?)}"); 
     stmt.registerOutParameter(1,OracleTypes.CURSOR);

            // run SP
            stmt.execute();
//     stmt.execute();
//       System.out.println("Dept Name: " + stmt.getString(1));
  ResultSet rs = (ResultSet) stmt.getObject(1);
   table.setModel(DbUtils.resultSetToTableModel(rs));
//            while (rs.next()) {
//                System.out.println(rs.getInt("empno") + "\t"
//                    + rs.getString("ename") + "\t"
//                    + rs.getInt("sal") + "\t"
//                    + rs.getInt("mgr"));
//            }
    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
  }        
}
      public void view(JTable table,String query)
      {
    //      String sql=query;
          try
          {
             Connection connn=setconnection();
           //  SimpleCallSample(connn,table);
           //  Statement st=connn.createStatement();
             //String sql="select empno,ename,sal,mgr from emp";
//             ResultSet rs=st.executeQuery(sql);
//             table.setModel(DbUtils.resultSetToTableModel(rs));
          }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(null, e);
          }
//          String sql=query;
//          try
//          {
//             Connection connn=setconnection();
//             Statement st=connn.createStatement();
//             //String sql="select empno,ename,sal,mgr from emp";
//             ResultSet rs=st.executeQuery(sql);
//             table.setModel(DbUtils.resultSetToTableModel(rs));
//          }
//          catch(Exception e)
//          {
//              JOptionPane.showMessageDialog(null, e);
//          }
      }
     
//    public static void main(String args[]){  
//    try{  
//    //step1 load the driver class  
//    Class.forName("oracle.jdbc.driver.OracleDriver");  
//      
//    //step2 create  the connection object  
//    Connection1 con=DriverManager.getConnection(  
//    "jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");  
//      
//    //step3 create the statement object  
//    Statement stmt=con.createStatement();  
//      empdata d= new empdata();
//    d.show();
//    //step4 execute query  
//    ResultSet rs=stmt.executeQuery("select empno,ename,sal,mgr from emp");  
//    empdata el=new empdata();
//    el.jTable2.setModel(DbUtils.resultSetToTableModel(rs));
//      //while(rs.next())  
////System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//    //step5 close the connection object  
//    con.close();  
//    
//      
//    }catch(Exception e){ System.out.println(e);}  
//      
//    
//    }  
//    public void view()
//    {
//        
//    }
}

