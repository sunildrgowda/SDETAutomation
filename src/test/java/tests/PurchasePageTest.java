package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PurchasePage;
import pages.ReservationPage;
import resources.Base;

public class PurchasePageTest extends Base{
	
	
	HomePage homePage;
	ReservationPage reservationPage;
	PurchasePage purchasePage;
	
	
	@BeforeMethod()
	public void initialSetUp() {
		initialization();
		homePage = new HomePage();
		
	}
	
	@Test
	public void selectFlightAndVerifyTotalCost() {
		reservationPage = homePage.findFlights();
		purchasePage = reservationPage.selectFlight();
		float sum = Float.parseFloat(purchasePage.getPriceValue()); 
		float tax =Float.parseFloat(purchasePage.getarbitraryFeesAndTaxesValue());
		float total = sum + tax;
		System.out.println(purchasePage.getarbitraryFeesAndTaxesValue());
		System.out.println(purchasePage.getPriceValue());
		System.out.println(sum+tax);
		Assert.assertEquals(total, Float.parseFloat(purchasePage.getTalCost()));
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
