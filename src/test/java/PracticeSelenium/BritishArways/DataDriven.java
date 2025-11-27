package PracticeSelenium.BritishArways;

import java.awt.Window.Type;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataDriven{
	WebDriver driver;
	
	LandingPage land;
	SearchitemTest st;

@FindBy (css="#action-ocf51c")
public WebElement signinBtn;

@FindBy (css="input[type='email']")
public WebElement emailTxtbox;

@FindBy(css="input[type='submit']")
public WebElement nxtSubmitBtn;

@FindBy(css="span[role='button']")
public WebElement usePassword;

@FindBy(css="input[type='password']")
public WebElement passwordTxtBox;

@FindBy (css="button[data-testid='primaryButton']")
public WebElement passwordNxtBtn;

@FindBy (css="button[data-testid='secondaryButton']")
public WebElement noBtn;


/*@DataProvider(name="SearchData")
public ArrayList<String> getSearchData() throws IOException
{
	
	
	FileInputStream fis= new FileInputStream("https://onedrive.live.com/personal/a4efcdac161003c4/_layouts/15/doc2.aspx?resid=2eca66c0-d035-4870-ad16-cb1edd093981&cid=a4efcdac161003c4&ct=1762783712830&wdOrigin=OFFICECOM-WEB.MAIN.EDGEWORTH&wdPreviousSessionSrc=HarmonyWeb&wdPreviousSession=33016fd2-9162-4547-bc72-ac48272b8b5e");
    XSSFWorkbook wb= new XSSFWorkbook(fis);
    XSSFSheet sheet=wb.getSheetAt(1);
    Iterator<Row> rows= sheet.iterator();
    ArrayList<String> a=new ArrayList<String>();
    
    while(rows.hasNext())
    {
    	Row r=rows.next();
    	Iterator<Cell> cells=r.cellIterator();
    	int numberofcells= r.getLastCellNum();
    	for(int i=0; i<=numberofcells;i++)
    	{
    		a.add(cells.next().getStringCellValue());
    	}
    }
    return a;
}*/

/*@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//driver.get("https://www.amazon.co.uk/");
	
	driver.get("https://www.microsoft.com/en-gb/microsoft-365/free-office-online-for-the-web");
	PageFactory.initElements(driver, this);
	signinBtn.click();
	Set<String> win= driver.getWindowHandles();
	Iterator<String> it= win.iterator();
	String parentWindow= it.next();
	String childWindow=it.next();
	driver.switchTo().window(childWindow);
		
	emailTxtbox.sendKeys("sachi.kayastha@gmail.com");
	nxtSubmitBtn.click();
	usePassword.click();
	
	passwordTxtBox.sendKeys("Password@01");
	passwordNxtBtn.click();
	
	noBtn.click();
	driver.switchTo().newWindow(WindowType.TAB);
	driver.get("https://www.amazon.co.uk/");
	
	
}*/

@Test//(dataProvider ="SearchData")
public void dataDrivenTestSearch() throws InterruptedException, IOException
{
	
	//driver=new ChromeDriver();

	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	//System.out.println("hi");
	//driver.get("https://www.amazon.co.uk/");
	
	/*driver.get("https://www.microsoft.com/en-gb/microsoft-365/free-office-online-for-the-web");
	PageFactory.initElements(driver, this);
	signinBtn.click();
	Set<String> win= driver.getWindowHandles();
	Iterator<String> it= win.iterator();
	String parentWindow= it.next();
	String childWindow=it.next();
	driver.switchTo().window(childWindow);
		
	emailTxtbox.sendKeys("sachi.kayastha@gmail.com");
	nxtSubmitBtn.click();
	usePassword.click();
	
	passwordTxtBox.sendKeys("Password@01");
	passwordNxtBtn.click();
	
	noBtn.click();*/
	

	

	    // Method to download and parse Excel file from a URL
	  

	        // Open HTTP connection
	        URL url = new URL("https://1drv.ms/x/c/a4efcdac161003c4/EcBmyi410HBIrRbLHt0JOYEBKWyOZMv84IcI530ZSMh48A?e=fpDMe9");
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(10000); // 10 seconds
	        connection.setReadTimeout(10000);

	        // Check HTTP response
	        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
	            throw new RuntimeException("Failed to download file: HTTP " + connection.getResponseCode());
	        }

	        // Read Excel file from InputStream
	        FileInputStream inputStream = (FileInputStream) URLConnection.getFileNameMap();
	        		 XSSFWorkbook wb = new XSSFWorkbook(inputStream); 
	        		XSSFSheet sheet=wb.getSheetAt(1);
	        		Iterator<Row> rows= sheet.iterator();
	        		System.out.println(rows);
	        		ArrayList<String> a=new ArrayList<String>();
	        		
	        		while(rows.hasNext())
	        		{
	        			Row r=rows.next();
	        			Iterator<Cell> cells=r.cellIterator();
	        			int numberofcells= r.getLastCellNum();
	        			
	        			for(int i=0; i<=numberofcells;i++)
	        			{
	        				a.add(cells.next().getStringCellValue());
	        			}
	        		}
	        		System.out.println(a);
	    }

	    // Helper method to convert cell values to String
	   /* private static String getCellValueAsString(Cell cell) {
	        if (cell == null) return "";
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                if (DateUtil.isCellDateFormatted(cell)) {
	                    return cell.getDateCellValue().toString();
	                }
	                return String.valueOf(cell.getNumericCellValue());
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case FORMULA:
	                return cell.getCellFormula();
	            default:
	                return "";
	        }
	    }*/

	    // Example usage
	  
	

	/*FileInputStream fis= new FileInputStream("https://1drv.ms/x/c/a4efcdac161003c4/EcBmyi410HBIrRbLHt0JOYEBKWyOZMv84IcI530ZSMh48A?e=fpDMe9");
    XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet=wb.getSheetAt(1);
		Iterator<Row> rows= sheet.iterator();
		System.out.println(rows);
		ArrayList<String> a=new ArrayList<String>();
		
		while(rows.hasNext())
		{
			Row r=rows.next();
			Iterator<Cell> cells=r.cellIterator();
			int numberofcells= r.getLastCellNum();
			
			for(int i=0; i<=numberofcells;i++)
			{
				a.add(cells.next().getStringCellValue());
			}
		}
		System.out.println(a);
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.get("https://www.amazon.co.uk/");
	
    
	
	//PageFactory.initElements(driver1, this);
	
	/*Set<String> win1= driver.getWindowHandles();
	Iterator<String> it1= win1.iterator();
	String parentWindow1= it1.next();
	String childWindow1=it1.next();
	String childWindow2=it1.next();
	driver.switchTo().window(childWindow2);*/
	
	/*land=new LandingPage(driver);
	land.LandOnPage();
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(5));
	w.until(ExpectedConditions.invisibilityOf(land.acceptcookie));
	
	land.searchItems("jacket");*/
}

/*@Test
public void dataDrivenAddItemtoCart(String itemname)
{
	
	
}*/



