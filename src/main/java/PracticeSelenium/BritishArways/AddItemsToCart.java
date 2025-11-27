package PracticeSelenium.BritishArways;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddItemsToCart extends AbstractComponent{
	WebDriver driver;
	
	
	AbstractComponent abs= new AbstractComponent(driver);
	By allItemsname=By.cssSelector("div[class='a-section a-spacing-base desktop-grid-content-view'] h2[class='a-size-mini s-line-clamp-1']");
	
	By addBtn= By.cssSelector("button[class='a-button-text']");
	By popupAddBtn =By.xpath("//div[@class='a-row puis-atc-variation-element puis-atc-variation-element-B085HDTGJG puis-atc-variation-element-selected']//button[@aria-label='Add to basket']");
	
	@FindBy (css="div[class='a-section a-spacing-base desktop-grid-content-view']")
	public List<WebElement> allItems;
	
    @FindBy(css="div[class='a-popover-inner'] span[class='a-dropdown-prompt']")
    public WebElement sizeSelectDrpDwn;
	
	
	/*@FindBy(css="div[class='a-row puis-atc-variation-element puis-atc-variation-element-B085HDTGJG puis-atc-variation-element-selected'] button[aria-label='Add to basket']")
	public WebElement popupAddBtn;*/
	
	@FindBy (css="div[class='a-popover-wrapper']")
    public WebElement popoverWrapper;
	
	By popOver= By.cssSelector("div[class='a-popover-wrapper']");

	public AddItemsToCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void addItemToCart(String itemnme, String size) throws InterruptedException
	{
		
		List<WebElement> selectedItem =allItems.stream().filter(item->item.findElement(allItemsname).getText().contains(itemnme)).collect(Collectors.toList());
	    //cart.ExplicitWait(driver.findElement(addBtn));
		selectedItem.get(0).findElement(addBtn).click();
		Thread.sleep(5000);
		//abs.ExplicitWaitforVisibilityOfElement(popOver);
		driver.switchTo().activeElement().findElement(popOver);
		//Actions actions = new Actions(driver);
		//actions.moveToElement(popoverWrapper).build().perform();
		//Thread.sleep(5000);
		
		Select slctDrpDwn= new Select(sizeSelectDrpDwn);
	
		slctDrpDwn.selectByContainsVisibleText(size);
		//abs.ExplicitWaitBy(addBtn);
		//Actions a= new Actions(driver);
		//a.click(addBtn);
		//driver.findElement(popupAddBtn).click();
		//popoverWrapper.findElement(addBtn).click();
		
	}
	

}
