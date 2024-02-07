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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Passenger {

    /**
     * @param args the command line arguments
     */
    DbConnection conn = new DbConnection();
    PreparedStatement pst = null;
    ResultSet rst = null;
    
    private String name,fName,age,gender,sec,user,pass,cnic,contactNo,dob;
     private String name1,fName1,age1,sec1,pass1,cnic1,contactNo1,dob1,pid1;

    public String getPid1() {
        return pid1;
    }

    public String getSec1() {
        return sec1;
    }
    Passenger()
    {
        
    }
    Passenger(String name,String fName,String age, String gender,String sec,String user,String pass,String cnic,String contactNo,String dob)
    {
        this.name=name;
        this.fName=fName;
        this.age=age;
        this.gender=gender;
        this.sec=sec;
        this.user=user;
        this.pass=pass;
        this.cnic=cnic;
        this.contactNo=contactNo;
        this.dob=dob;
        
    }
    public boolean verifySecurityQ(String username,String securityQuestion)
            
    {
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql="Select PID,PSec from PassengerT where PID = '" + username + "' and PSec = '" + securityQuestion + "'";
            
            rst= conn.GetData(sql);
            if(rst.next())
            {
                flag=true;
            }
            

            else
            flag=false;
            conn.CloseConnection();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\n Verify SecurityQ Passenger Error");
        }
       return flag;
    }
     public void changePassword(String username,String newPassword)
    {
        int flag;
        
         try{
        conn.OpenConnection();
        String sql = "UPDATE PassengerT SET PPass = '"+ newPassword +"' where PID = '"+username+ "'";
       
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
    public boolean chkPassPass(String id, String pass){
        boolean flag = false;
        
        try{
            conn.OpenConnection();
            String sql = "Select PID,PPass from PassengerT where PID = '" + id + "' and PPass = '" + pass + "'";
            rst= conn.GetData(sql);
            if(rst.next()){
                flag= true;
                              
            }
            else 
                flag=  false;
            conn.CloseConnection();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Old Password Doesn't Match");
        }
       return flag; 
    }
        public void recordupdate(String name,String fname,String age,String cnic,String cno,String dob,String sec,String username)
    {
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="UPDATE PassengerT SET PName = '"+ name +"',PFName = '"+fname+"',PAge='"+age+"',PSec='"+sec+"',CNIC='"+cnic+"',ContactNo='"+cno+"',DOB='"+dob+"' where PID = '"+username+ "'";
                //"Insert into PassengerT (PName,PFName,PAge,CNIC,ContactNo,DOB) values '"
//                + name+ "','"
//                    + fname+ "','"
//                    + age+ "','"
//                    + cnic+ "','"
//                    + cno+ "','"
//                    + dob+ "'";
        
       
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "Record Updated");
           }
           else{
               JOptionPane.showMessageDialog(null, "Updation Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }
     public void addPassPass()
    {
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Insert into PassengerT (PID, PPass, PName,PFName,PAge, PGender, PSec,CNIC,ContactNo,DOB) values '"
                + getUser()+ "','"
                    + getPass()+ "','"
                    + getPname()+ "','"
                    + getFname()+ "','"
                    + getPAge()+ "','"
                    + getPGender()+ "','"
                    + getPSec()+ "','"
                    + getCnic()+ "','"
                    + getContactno()+ "','"
                    + getDob()+ "'";
        
       
        int flag=conn.InsertUpdateDelete(sql);
                 
           if(flag==1){
               JOptionPane.showMessageDialog(null, "You Are Now Successfully Registered As Passenger");
           }
           else{
               JOptionPane.showMessageDialog(null, "Insertion Failed");
           }
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e);  
        }
    }

    public String getName1() {
        return name1;
    }

    public String getfName1() {
        return fName1;
    }

    public String getAge1() {
        return age1;
    }

    public String getPass1() {
        return pass1;
    }

    public String getCnic1() {
        return cnic1;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public String getDob1() {
        return dob1;
    }
     
    public String getCnic()
    {
        return cnic;
    }
    public String getContactno()
    {
        return contactNo;
    }
    public String getDob()
    {
        return dob;
    }
     public String getUser()
     {
         return user;
     }
     public String getPass()
     {
         return pass;
     }
    public String getPname()
    {
        return name;
    }
    public String getFname()
    {
        return fName;
    }
    public String getPAge()
    {
        return age;
    }
    public String getPGender()
    {
        return gender;
    }
    public String getPSec()
    {
        return sec;
    }
    public String getRPassengerName(String username)
    {
        String ass=null;
        try
        {
        DbConnection conn = new DbConnection();
        conn.OpenConnection();
        String sql="Select PID, PPass,PName,PFName,PSec,PAge,CNIC,ContactNo,DOB from PassengerT where PID = '"+ username + "'";
        rst= conn.GetData(sql);      
          
         while(rst.next()){
            pid1=rst.getString("PID");
            pass1=rst.getString("PPass");
            ass=rst.getString("PName");
            name1=rst.getString("PName");
            fName1=rst.getString("PFName");
            age1=rst.getString("PAge");
            cnic1=rst.getString("CNIC");
            contactNo1=rst.getString("ContactNo");
            dob1=rst.getString("DOB");
            sec1=rst.getString("PSec");
                }
       
        
           conn.CloseConnection();
          }
        catch(Exception e){
          JOptionPane.showMessageDialog(null, e+"\n getRPassengerName  Error");  
        }
        return ass;
    }
  
   public ResultSet PassengerRide(String pu)
    {
        ResultSet rst1=null;
    
        
        try{
            conn.OpenConnection();
            String sql = "Select Datee,Username,DriverName,DriverContactNo,VehiclePlate,VehicleName,Fromm,Too,StartTime,EndTime,RideStatus,BillStatus,Bill from RideRealtime where PUsername = '"+pu+"'";
            
            rst1= conn.GetData(sql);
                   do{
                return rst1;
            } 
            while(rst1.next());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\nSelect DriverCarRT Error");
        }
          
        conn.CloseConnection();
        return null;
    }
   public ResultSet PassengerBusRide(String pu)
    {
        ResultSet rst1=null;
    
        
        try{
            conn.OpenConnection();
            String sql = "Select Username,DriverName,VehiclePlate,VehicleName,Fromm,Too from PassengerBusRides where PUsername = '"+pu+"'";
            rst1= conn.GetData(sql);
                   do{
                return rst1;
            } 
            while(rst1.next());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e+"\nSelect DriverCarRT Error");
        }
          
        conn.CloseConnection();
        return null;
    }
}
