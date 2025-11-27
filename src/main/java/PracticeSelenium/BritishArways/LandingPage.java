package PracticeSelenium.BritishArways;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="twotabsearchtextbox")
	public WebElement searchBar;
	
	@FindBy (id="nav-search-submit-button")
	public WebElement searchbtn;
	
	@FindBy (id="sp-cc-accept")
	public WebElement acceptcookie;
	
	@FindBy(css="button[type='submit']")
	public WebElement continueShoppingBtn;
	
	public void LandOnPage()
	{
		continueShoppingBtn.click();
		acceptcookie.click();
		
	}
	
	public void searchItems(String name)
	{
		searchBar.sendKeys(name);
		searchbtn.click();
	}
	
	/*public void searchItemsData(String a)
	{
		for(int i=0;i<a.size();i++)
		{
			
		searchBar.sendKeys(a.get(i));
		searchbtn.click();
		}
	}*/
	


	
}
