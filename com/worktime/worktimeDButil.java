package com.worktime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class worktimeDButil{

	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt =null;
	private static ResultSet rs=null;
	
	public static boolean insertworktime( String defaulthours,String workinghours,String OThours,String OTbonuses) {
		
				boolean isSuccess=false;
				
				
				try {
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					String sql="insert into worktime(default_hours,working_hours,ot_hours,ot_bonus) values('"+defaulthours+"','"+workinghours+"','"+OThours+"','"+OTbonuses+"')";
					int r=stmt.executeUpdate(sql);
					
					if(r>0) {
						isSuccess=true;
							
					}
					
					else {
						isSuccess=false;
						
					}
				}
					
					catch(Exception e) {
			            e.printStackTrace();
			    }
					
				
				return isSuccess;
						
	
	}
	public static boolean updateworktime(String wId,String defaulthours,String workinghours,String OThours,String OTbonuses) {
		               
		     try {
		    	 
		    	 con=DBConnect.getConnection();
		    	 stmt=con.createStatement();
		    	 String sql="update worktime set defaulthours='"+defaulthours+"' ,workinghours='"+workinghours+"' ,OThours='"+OThours+"',OTbonuses='"+OTbonuses+"'"+"'where wId='"+wId+"'";
		    	 int rs = stmt.executeUpdate(sql);
			        
			        if(rs > 0)
			        	isSuccess = true;
			        
			        else
			        	isSuccess = false;
			        
				}catch(Exception e) {
					System.out.println("Update not successfull");
					e.printStackTrace();
				}
				
				return isSuccess;
			}
	
	
	
public static List<worktime> getworktimeDetails(String wId){
		
	int convertedID=Integer.parseInt(wId);
	
	
		ArrayList<worktime> wt=new ArrayList<>();
		
	
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql="select*from worktime where wid'"+convertedID+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
		        
				int wid=rs.getInt(1);
				int defaulthours = rs.getInt(2);
		        int workinghours =rs.getInt(3);
			    int OThours =rs.getInt(4);
				double OTbonuses=rs.getDouble(5);
				
		        worktime w = new worktime(wid,defaulthours,workinghours,OThours,OTbonuses);
		        wt.add(w);
		      }
			
		    } catch(Exception e) {
		            e.printStackTrace();
		    }
		    return wt;
	}
  public static boolean deleteworktime(String wId){
	  
	  int convertedID=Integer.parseInt(wId);
	  
	  try {
		  
		    con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql="select*from delete where wid'"+convertedID+"'";
			 int rs = stmt.executeUpdate(sql);
			
			 
	        if(rs> 0) {
	        	isSuccess = true;
	        	
	        }
	        
	        else {
	        	isSuccess = false;
	        }
	  
	  }
      catch(Exception e) {
                 e.printStackTrace();
}
        
	  
	return isSuccess;
	  
	  
  }

 
}
	
			
		    
	



