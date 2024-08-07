package practiceDataDriverTesting;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class Jdbc1stvideo {

	public static void main(String[] args) throws Throwable {
		//read data from mySql Db
	//1st step: register / load the muSql database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);//its asking which database u want to register so give the instru like line no 17
		
   //2nd step: connect to database
		Connection conn= DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("----------Connection-Done---------");
 
		//3rd step: create sql statement
	       Statement stat= conn.createStatement();
		
		//4th step: execute sql querry and get result
	       ResultSet rset=stat.executeQuery("select * from project");
	       while(rset.next()) {
	    	   System.out.println(rset.getString(1)+"\t"+rset.getString(2)+"\t"+rset.getString(3)+"\t"+rset.getString(4)+"\t"+rset.getString(5)+"\t"+rset.getInt(6));
	       }
	       
	       
		//5th step: close the command
		    conn.close();
	}
}
