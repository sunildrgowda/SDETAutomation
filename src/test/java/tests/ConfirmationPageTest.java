package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ConfirmationPage;
import pages.HomePage;
import pages.PurchasePage;
import pages.ReservationPage;
import resources.Base;
import resources.UtilityMethods;

public class ConfirmationPageTest extends Base{
	
	HomePage homePage;
	ReservationPage reservationPage;
	PurchasePage purchasePage;
	ConfirmationPage confirmationPage;
	
	@BeforeMethod()
	public void initialSetUp() {
		initialization();
		homePage = new HomePage();
		
	}
	
	@Test(dataProvider = "customerData")
	public void verifyBookingDateTime(String bname, String badd, String bcity,String bstate, String bzCode,
			String bcardType,String cNumber,String month,String year, String nameCard) {
		reservationPage = homePage.findFlights();
		purchasePage = reservationPage.selectFlight();
		confirmationPage = purchasePage.enterCustomerdetailsAndBookFlight(bname, badd, bcity,bstate, bzCode,
				bcardType, cNumber,month,year, nameCard);
		String bookingId = confirmationPage.getBookingId();
		Assert.assertTrue(!bookingId.isEmpty());
		String actualDateTime = confirmationPage.getBookingDateTime();
		String expectedDateTime = UtilityMethods.getBookingDateTime();
		Assert.assertTrue(actualDateTime.contains(expectedDateTime));
	}
	
	@DataProvider(name = "customerData")
	public Object[][] customerDetails() throws IOException{
		
		return new Object[][]{ {"sunil","addres1","bang","Kar","56009","American Express","111122244445555","02","2022","Gowda"}};
	}
	
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
		
	}
	
}
