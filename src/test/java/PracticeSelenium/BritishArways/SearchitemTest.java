package PracticeSelenium.BritishArways;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class SearchitemTest{
	

	WebDriver driver;
	LandingPage land;
	AddItemsToCart cart;

	AbstractComponent abs=new AbstractComponent(driver);

	
	/*@BeforeTest
	public void setupReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationResults");
		reporter.config().setDocumentTitle("Test Results");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sachi");
		
		
	}*/
	
	@FindBy(id="twotabsearchtextbox")
	public WebElement searchTexbox;
	
	
	
	
		
		/*@Test
		public void Search() throws InterruptedException
		{	
			
			
			land=new LandingPage(driver);
			land.LandOnPage();
			land.ExplicitWait(searchTexbox);
			land.searchItems("jacket");
			cart=new AddItemsToCart(driver);
			cart.addItemToCart("MAGCOMSEN","XXL");
		}
		*/

    @SuppressWarnings("null")
	// DataProvider method
    
    @BeforeMethod
    public void setup()
    {
    	if(System.getProperty("browser").contains("chrome"))
    	{
    	driver=new ChromeDriver();
    	}
    	else if(System.getProperty("browser").contains("edge"))
    	{
    		driver=new EdgeDriver();
    	}
    	else
    	{
    		driver=new ChromeDriver();
    	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.amazon.co.uk/");
		PageFactory.initElements(driver, this);
    }
   
	@DataProvider(name = "arrayListProvider")
    public Object[] provideArrayListData() throws SQLException {
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
		Object[] data=new Object[a.size()];
		for(int i=0; i<a.size();i++)
		{
			data[i]=(a.get(i));
		}
		return data;
    }

    // Test method that receives ArrayList
    @Test(dataProvider = "arrayListProvider")
    public void testWithArrayList(String dataList) throws InterruptedException {
    	
    	
        System.out.println("Test received list: " + dataList);
        
        land=new LandingPage(driver);
		land.LandOnPage();
		land.ExplicitWait(searchTexbox);
		land.searchItems(dataList);
		//cart=new AddItemsToCart(driver);
		//cart.addItemToCart("MAGCOMSEN","XXL");
        // Example usage in Selenium (pseudo-code)
        // for (String value : dataList) {
        //     driver.findElement(By.name("q")).sendKeys(value);
        //     driver.findElement(By.name("btnK")).click();
        // }
		driver.close();
	
		
    }
		

	}

