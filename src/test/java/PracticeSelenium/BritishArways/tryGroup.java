package PracticeSelenium.BritishArways;

import org.testng.annotations.Test;

public class tryGroup {

	@Test(groups= {"smoke"})
	public void category()
	{
		System.out.println("this is category method");
	}
	
	@Test
	public void noncategory()
	{
		System.out.println("this is non category method");
	}
	@Test
	public void webhooktest()
	{
		System.out.println("just checking webhook trigger");
	}
}

