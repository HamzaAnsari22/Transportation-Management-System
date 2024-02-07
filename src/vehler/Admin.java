/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehler;

/**
 *
 * @author user
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import oracle.jdbc.OracleTypes;
public class Admin {

    /**
     * @param args the command line arguments
     */
    DbConnection conn = new DbConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
   public void changePassword(String username,String newPassword)
    {
        int flag;
        
         try{
        conn.OpenConnection();
        String sql = "UPDATE Admint SET AdminP = '"+ newPassword +"' where AdminID = '"+username+ "'";
       
        flag = conn.InsertUpdateDelete(sql);
           if(flag == 1){
               JOptionPane.showMessageDialog(null, "YOUR PASSWORD HAS BEEN CHANGED  ");
           }
           else{
                JOptionPane.showMessageDialog(null, "YOUR PASSWORD COULDn't BE CHANGED" );
           }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null, "UpdatePassword Query Failed");
        }
        
    }
   
   public boolean insertbusdata(String query,String busno,String BusName,String Status,int session,String from,String to,String arrival,String depart)
   {
   try
  {
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, busno);
      stmt.setString(2, BusName);
      stmt.setString(3, Status);
      stmt.setInt(4, session);
      stmt.setString(5, from);
      stmt.setString(6, to);
      stmt.setString(7,arrival);
      stmt.setString(8, depart);
      
      
            // run SP
            stmt.execute();
            return true;
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return false;
  }  
       
     
   }
   public int checkcred(String query,String username,String pass)
   {
    try
  {
 int id=0;
      Connection1 cc=new Connection1();
      Connection con=cc.setconnectionD();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, username);
      stmt.setString(2, pass);
      stmt.registerOutParameter(3,OracleTypes.CURSOR);
   
            stmt.execute();
      
  ResultSet rs = (ResultSet) stmt.getObject(3);
  while (rs.next())
  {
      id=rs.getInt("did");
  }
  return id;
//  int id=rs.getInt("DID");
//  return id;
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return 0;
  }  
    
   }
     public int checkpcred(String query,String username,String pass)
   {
    try
  {
 int id=0;
      Connection1 cc=new Connection1();
      Connection con=cc.setconnectionP();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, username);
      stmt.setString(2, pass);
      stmt.registerOutParameter(3,OracleTypes.CURSOR);
   
            stmt.execute();
      
  ResultSet rs = (ResultSet) stmt.getObject(3);
  while (rs.next())
  {
      id=rs.getInt("pid");
      
  }
  
  
  
  
  
  return id;
//  int id=rs.getInt("DID");
//  return id;
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return 0;
  }  
    
   }
   public boolean checkbusavail()
   {
        try
  {
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
    CallableStatement stmt = con.prepareCall("{call checkbusavail(?)}"); 
     stmt.registerOutParameter(1,OracleTypes.CURSOR);

            // run SP
            stmt.execute();
//     stmt.execute();
//       System.out.println("Dept Name: " + stmt.getString(1));
  ResultSet rs = (ResultSet) stmt.getObject(1);
  // table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()) {
                if(rs.getString("Status").equals("0"))
                {
                System.out.println(rs.getString("Status"));    
                    return true;
                }
                System.out.println("bhar");
//                System.out.println(rs.getInt("empno") + "\t"
//                    + rs.getString("ename") + "\t"
//                    + rs.getInt("sal") + "\t"
//                    + rs.getInt("mgr"));
            }
    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
     return false;
  }
       
       return false;
   }
    public String insertroute(String query,String froml,String tol)
   {
    try
  {
 
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, froml);
      stmt.setString(2, tol);
    
      
            // run SP
            stmt.execute();
            return "ok";
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return "Error";
  }  
   }
   public String insertdriver(String query,String name,String fatherName,String age,Date dob, String gender, String cnic,String contact,String username,String password)
   {
    try
  {

      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, name);
      stmt.setString(2, fatherName);
      stmt.setString(3, age);
      stmt.setDate(4, dob);
      stmt.setString(5, gender);
      stmt.setString(6, cnic);
      stmt.setString(7, contact);
      stmt.setString(8, username);
      stmt.setString(9, password);
 
            stmt.execute();
            return "ok";

  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return "Error";
  }  
   }
//   public void gettime(String query)
//   {
//       AddVehicle av=new AddVehicle();
//       
//   String sql=query;
//   try
//  {
//       Connection1 cc=new Connection1();
//             Connection con=cc.setconnection();
//      Statement s=con.createStatement();
//    CallableStatement stmt = con.prepareCall("{call gettime(?)}"); 
//     stmt.registerOutParameter(1,OracleTypes.CURSOR);
//
//            stmt.execute();
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//    while(rs.next())
//            {
//               String a=(rs.getString("ARRIVALTIME")); 
//               String b=(rs.getString("DEPARTURETIME"));
//                
//                
//           }
//    System.out.println("Stored Procedure executed successfully");
//  }
//  catch(Exception err)
//  {
//    System.out.println("An error has occurred.");
//    System.out.println("See full details below.");
//    err.printStackTrace();
//  }
//
//       
//       
//   }
//   public void getfromltol(String query)
//   {
//       AddVehicle av=new AddVehicle();
//       
//   String sql=query;
//   try
//  {
//       Connection1 cc=new Connection1();
//             Connection con=cc.setconnection();
//      Statement s=con.createStatement();
//    CallableStatement stmt = con.prepareCall("{call gettime(?)}"); 
//     stmt.registerOutParameter(1,OracleTypes.CURSOR);
//
//            stmt.execute();
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//    while(rs.next())
//            {
//                String a=(rs.getString("FROML"));
//                
//               String b=(rs.getString("TOL"));
//                System.out.println(a+" "+b);
//                
//           }
//    System.out.println("Stored Procedure executed successfully");
//  }
//  catch(Exception err)
//  {
//    System.out.println("An error has occurred.");
//    System.out.println("See full details below.");
//    err.printStackTrace();
//  }
//       
//   }
   public void deldt()
   {
           try
  {
 
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall("{CALL DELETEALL}"); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
     
    
      
            // run SP
            stmt.execute();
           
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              
   }
   }
    public String udata(String query, int sid,int did, String bus, String att)
   {
   String sql=query;
    
     try
  {
 
      
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setInt(1, sid);
      stmt.setInt(2, did);
       stmt.setString(3, bus);
      stmt.setString(4, att);
    
      
            // run SP
            stmt.execute();
            return "ok";
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
              return "Error";
   }
   
   
   }  
      public int banb(String query,String id)
      {
           String sql=query;
    
     try
  {
 
      
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setString(1, id);
    
    
      
            // run SP
            stmt.execute();
        
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
           
   }
          return 0;
      }
    public int gettabupdata(String query, JTable table)
   {
   String sql=query;
           try
  {
      Connection1 cc=new Connection1();
       Connection con=cc.setconnection();
      Statement s=con.createStatement();
    CallableStatement stmt = con.prepareCall(query); 
     stmt.registerOutParameter(1,OracleTypes.CURSOR);

            // run SP
            stmt.execute();
  ResultSet rs = (ResultSet) stmt.getObject(1);
   table.setModel(DbUtils.resultSetToTableModel(rs));
    System.out.println("Stored Procedure executed successfully");
    
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
  } 
       return 0;
   }
   public int gettabdata(String query, JTable table)
   {
   String sql=query;
                 try
  {
      Connection1 cc=new Connection1();
       Connection con=cc.setconnection();
      Statement s=con.createStatement();
    CallableStatement stmt = con.prepareCall(query); 
     stmt.registerOutParameter(1,OracleTypes.CURSOR);

            // run SP
            stmt.execute();
  ResultSet rs = (ResultSet) stmt.getObject(1);
   table.setModel(DbUtils.resultSetToTableModel(rs));
    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
  }     
       
       return 0;
   }
      public int bandr(String query,int id)
      {
           String sql=query;
    
     try
  {
 
      
      Connection1 cc=new Connection1();
      Connection con=cc.setconnection();
      Statement s=con.createStatement();
      CallableStatement stmt = con.prepareCall(query); 
     //stmt.registerOutParameter(1,OracleTypes.CURSOR);
      stmt.setInt(1, id);
    
    
      
            // run SP
            stmt.execute();
        
//  ResultSet rs = (ResultSet) stmt.getObject(1);
//   table.setModel(DbUtils.resultSetToTableModel(rs));
//    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
           
   }
          return 0;
      }
   public int gettabdatap(String query, JTable table)
   {
        try
  {
      Connection1 cc=new Connection1();
       Connection con=cc.setconnection();
      Statement s=con.createStatement();
    CallableStatement stmt = con.prepareCall(query); 
     stmt.registerOutParameter(1,OracleTypes.CURSOR);

            // run SP
            stmt.execute();
  ResultSet rs = (ResultSet) stmt.getObject(1);
   table.setModel(DbUtils.resultSetToTableModel(rs));
    System.out.println("Stored Procedure executed successfully");
  }
  catch(Exception err)
  {
    System.out.println("An error has occurred.");
    System.out.println("See full details below.");
    err.printStackTrace();
  
 
              JOptionPane.showMessageDialog(null, err);
  }        
       
       return 0;
   }
//    public boolean chkAdminPass(String id, String pass){
//        boolean flag = false;
//        if(id=="admin"&&pass=="admin")
//        {
//            flag=true;
//        }
//      
////        try{
////            conn.OpenConnection();
////            String sql = "Select AdminID,AdminP from AdminT where AdminID = '" + id + "' and AdminP = '" + pass + "'";
////            rst= conn.GetData(sql);
////            if(rst.next()){
////                flag= true;
////                              
////            }
////            else 
////                flag=  false;
////            conn.CloseConnection();
////        }
////        catch(Exception e){
////            JOptionPane.showMessageDialog(null, e+"\nInavlid Username or Password");
////        }
//       return flag; 
//    }
//    public ResultSet RideRealTimeCombined()
//    {
//        ResultSet rst1=null;
//    
//        
//        try{
//            conn.OpenConnection();
//            String sql = "Select Datee,Username,VehiclePlate,PUsername,Fromm,Too,StartTime,EndTime,RideStatus,BillStatus,Bill,NoOfPassengers from RideRealtime ";
//            rst1= conn.GetData(sql);
//                   do{
//                return rst1;
//            } 
//            while(rst1.next());
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null, e+"\nRide Realtime Combined Error");
//        }
//          
//        conn.CloseConnection();
//        return null;
//    }
    
}
