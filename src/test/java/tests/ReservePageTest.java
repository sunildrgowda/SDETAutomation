package tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PurchasePage;
import pages.ReservationPage;
import resources.Base;

public class ReservePageTest extends Base{
	
	HomePage homePage;
	ReservationPage reservationPage;
	PurchasePage purchasePage;
	
	@BeforeMethod()
	public void initialSetUp() {
		initialization();
		homePage = new HomePage();
		
	}
	
		
	@Test
	public void verifySelectedFromLocation() {
		String selectedFromLocation = homePage.getSelectedValue();
		reservationPage = homePage.findFlights();
		String bookedFromLocation = reservationPage.getSelectFromLocation();
		Assert.assertTrue(bookedFromLocation.contains(selectedFromLocation));			
	}
	
	@Test
	public void verifySelectedToLocation() {
		String selectedToLocation = homePage.getSelectedToValue();
		reservationPage = homePage.findFlights();
		String bookedToLocation = reservationPage.getSelectToLocation();
		Assert.assertTrue(bookedToLocation.contains(selectedToLocation));	
	}
	
	
	@Test
	public void verifyDisplayOfFlightSelection(){
		reservationPage = homePage.findFlights();
		int noOfFlights = reservationPage.totalNumberOfFlightsAvailable().size();
		Assert.assertTrue(noOfFlights>1);
		
	}
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
