package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ConfirmationPage extends Base{
	
	@FindBy(xpath = "//tbody/tr/td[2]") WebElement bookingId;
	@FindBy(xpath = "//tbody/tr[7]/td[2]") WebElement bookingDateTime;
	
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public String getConfirmationPageTitle() {
		return driver.getTitle();
	}
	
	public String getBookingId() {
		return bookingId.getText();
	}
	
	public String getBookingDateTime() {
		return bookingDateTime.getText();
	}
}
