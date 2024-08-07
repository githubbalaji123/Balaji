package practiceDataDriverTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;
public class jdbc1stvideo3rdprog {
	
		@Test
		public void projectCheckTest() throws SQLException {
			
			String expectedProgram ="Sony";
			boolean flag=false;
			//1st step: register / load the muSql database
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);//its asking which database u want to register so give the instru like line no 20
			
	   //2nd step: connect to database
			Connection conn= DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
			System.out.println("----------Connection-Done---------");
	 
			//3rd step: create sql statement
		       Statement stat= conn.createStatement();
			
			//4th step: execute sql querry and get result
		       ResultSet rset=stat.executeQuery("select * from project");
		       while(rset.next()) {
		    	   String actProjectName=rset.getString(4);
		    	   if(expectedProgram.equals(actProjectName)) {
		    		   flag=true;
		    		   System.out.println(expectedProgram+"\tis available==***PASS**");
		    	   }
		       }
		       
		       if (flag==false) {
				System.out.println("is notavailable==***FAIL**");
			}
		       
		       
			//5th step: close the command
			    conn.close();	
		}

	}
