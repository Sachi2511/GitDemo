package PracticeSelenium.BritishArways;

import org.testng.annotations.Test;

public class HelperAtrributes {

	@Test(description="This test is for trial purpose", priority=1)
	public void description()
	{
		System.out.println("Trial test");	
		
	}
	
	@Test(/*dependsOnMethods= {"thirdPriority"},*/ priority=2, groups= {"smoke"})
	public void secondPriority()
	{
		System.out.println("2nd priority");
		
	}
	
	@Test(priority=3)
	public void thirdPriority()
	{
		System.out.println("third priority");
		
	}
	
}
