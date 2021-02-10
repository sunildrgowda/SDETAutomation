package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import resources.Base;

public class PurchasePage extends Base{
	
	@FindBy(id="inputName") WebElement name;
	@FindBy(id="address") WebElement address;
	@FindBy(id="city") WebElement city;
	@FindBy(id="state") WebElement state;
	@FindBy(id="zipCode") WebElement zipCode;
	@FindBy(id="cardType") WebElement cardType;
	@FindBy(id="creditCardNumber") WebElement cardNumber;
	@FindBy(id="creditCardMonth") WebElement cardMonth;
	@FindBy(id="creditCardYear") WebElement cardYear;
	@FindBy(id="nameOnCard") WebElement nameOnCard;
	@FindBy(xpath="//input[@value='Purchase Flight']") WebElement purchaseFlight;
	@FindBy(xpath="//div[@class='container']/p[3]") WebElement price;
	@FindBy(xpath="//div[@class='container']/p[4]") WebElement arbitraryFeesAndTaxes;
	@FindBy(xpath="//div[@class='container']/p[5]/em") WebElement totalCost;
	public PurchasePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public ConfirmationPage enterCustomerdetailsAndBookFlight(String bname, String badd, String bcity,String bstate, String bzCode,
			String bcardType,String cNumber,String month,String year, String nameCard) {
		name.sendKeys(bname);
		address.sendKeys(badd);
		city.sendKeys(bcity);
		state.sendKeys(bstate);
		zipCode.sendKeys(bzCode);
		Select s = new Select(cardType);
		s.selectByVisibleText(bcardType);
		cardNumber.sendKeys(cNumber);;
		cardMonth.sendKeys(month);
		cardYear.sendKeys(year);
		nameOnCard.sendKeys(nameCard);
		purchaseFlight.click();
		return new ConfirmationPage();
	}
	
	public String getPriceValue() {
		String priceVal = price.getText();
		String[] priceArray = priceVal.split(": ");
		return priceArray[1].toString();
	}
	
	public String getarbitraryFeesAndTaxesValue() {
		String arbitraryFeesAndTaxesVal = arbitraryFeesAndTaxes.getText();
		String[] arbitraryTaxesArray = arbitraryFeesAndTaxesVal.split(": ");
		return arbitraryTaxesArray[1].toString();
	}
	
	public String getTalCost() {
		return totalCost.getText();
		
	}
	
}
