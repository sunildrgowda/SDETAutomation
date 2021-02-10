package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.Base;

public class HomePage extends Base{
	
	private @FindBy(xpath = "//select[@name='fromPort']") WebElement fromLocation;
	private @FindBy(xpath = "//select[@name='toPort']") WebElement toLocation;
	private @FindBy(xpath = "//input[@value='Find Flights']") WebElement findFlights;
	
	public static String fromLocationSelected;
	public static String toLocationSelected;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectFromLocation(String fromLoc) {
		Select s = new Select(fromLocation);
		s.selectByValue(fromLoc);
	}
	
	public void selectToLocation(String toLoc) {
		Select s = new Select(fromLocation);
		s.selectByValue(toLoc);
	}
	 
	public List getAllFromLocationValues() {
		Select s = new Select(fromLocation);
		return s.getOptions();
	}
	
	public List getAllTOLocationValues() {
		Select s = new Select(toLocation);
		List<String> fValues = new ArrayList();
		for(WebElement w:s.getOptions()) {
			fValues.add(w.getText());
		}
		return fValues;
	}
	
	public String getSelectedValue() {
		Select s = new Select(fromLocation);
		fromLocationSelected = s.getFirstSelectedOption().getText();
		System.out.println(fromLocationSelected);
		return fromLocationSelected;
	}
	
	public String getSelectedToValue() {
		Select s = new Select(toLocation);
		toLocationSelected = s.getFirstSelectedOption().getText();
		System.out.println(toLocationSelected);
		return toLocationSelected;
	}
	public ReservationPage findFlights() {
		findFlights.click();
		return new ReservationPage();
	}

}
