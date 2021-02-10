package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import resources.Base;

public class HomePageTest extends Base{
	
	HomePage homePage;
	
	
	@BeforeMethod()
	public void initialSetUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void verifyPageTitle() {
		Base.initialization();
		homePage = new HomePage();
		Assert.assertEquals("BlazeDemo", driver.getTitle());
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
