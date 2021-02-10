package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class ReservationPage extends Base{
	
	private @FindBy(xpath="//input[@value='Choose This Flight'") WebElement chooseThisFlight;
	private @FindBy(xpath="//thead/tr/th[4]") WebElement bookedFromLocation;
	private @FindBy(xpath="//thead/tr/th[5]") WebElement bookedToLocation;
	
	List numberOfFlights = new ArrayList();
	
	public ReservationPage() {
		PageFactory.initElements(driver,  this);
	}

	
	
	public WebElement getChooseThisFlight() {
		return chooseThisFlight;
	}



	public String getSelectFromLocation() {
		
		return bookedFromLocation.getText();
		
	}
	
	public String getSelectToLocation() {
		
		return bookedToLocation.getText();
		
	}
	
	public PurchasePage selectFlight() {
		numberOfFlights = driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
		((WebElement) numberOfFlights.get(0)).click();
		return new PurchasePage();
	}

	public List totalNumberOfFlightsAvailable() {
		numberOfFlights = driver.findElements(By.xpath("//input[@value='Choose This Flight']"));
		return numberOfFlights;
	}
}
