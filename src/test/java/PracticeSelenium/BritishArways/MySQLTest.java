package PracticeSelenium.BritishArways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MySQLTest {
	
	@Test
	public void getdatafromMySql() throws SQLException
	{
		String host="localhost";
		int port=3306;
		String databasename="Search";
		String url="jdbc:mysql://"+host+":"+port+"/"+databasename;
		Connection con= DriverManager.getConnection(url, "root", "root");
		Statement s= con.createStatement();
		ResultSet rs= s.executeQuery("Select name from searchitemlist");
		while (rs.next())
		{
			System.out.println(rs.getString("name"));
		}
	}

}
