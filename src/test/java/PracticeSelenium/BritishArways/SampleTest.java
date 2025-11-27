package PracticeSelenium.BritishArways;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
public class SampleTest {
	

	
	    // DataProvider method
	    @DataProvider(name = "arrayListProvider")
	    public Object[][] provideArrayListData() throws SQLException {
	        // Create ArrayLists
	    	String host="localhost";
			int port=3306;
			ArrayList<String> a=new ArrayList<String>();
			String databasename="Search";
			String url="jdbc:mysql://"+host+":"+port+"/"+databasename;
			Connection con= DriverManager.getConnection(url, "root", "root");
			Statement s= con.createStatement();
			ResultSet rs= s.executeQuery("Select name from searchitemlist");
			while (rs.next())
			{
				a.add(rs.getString("name"));
			}
			return new Object[][] {{a}};
	    }

	    // Test method that receives ArrayList
	    @Test(dataProvider = "arrayListProvider")
	    public void testWithArrayList(ArrayList<String> dataList) {
	        System.out.println("Test received list: " + dataList);

	        // Example usage in Selenium (pseudo-code)
	        // for (String value : dataList) {
	        //     driver.findElement(By.name("q")).sendKeys(value);
	        //     driver.findElement(By.name("btnK")).click();
	        // }
	    }
	}


