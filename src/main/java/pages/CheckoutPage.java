package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import utils.ConfigReader;

public class CheckoutPage {	

	 WebDriver driver;
	 
	 ConfigReader configReader; 
	 
	 @FindBy(className="title")
	 private WebElement checkoutTitle;
	 
	 @FindBy(id="first-name")
	 private WebElement firstNameInput;
	 
	 @FindBy(id="last-name")
	 private WebElement lastNameInput;	

	 @FindBy(id="postal-code")
	 private WebElement zipCodeInput;	 
	 
	 @FindBy(id="continue")
	 private WebElement continueButton;	 

	 
	 
	 public CheckoutPage(WebDriver driver)
	 {
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	     configReader = new ConfigReader();
	 }

	 public void verifyCheckoutPage()
	 {
		 Assert.assertTrue(checkoutTitle.isDisplayed());
		 Reporter.log("Checkout page is displyed");
	 }
	 
	 public void enterInformation()
	 {
		    Assert.assertTrue(firstNameInput.isDisplayed());
	        Reporter.log("First Name input field is displayed");
	        firstNameInput.sendKeys(configReader.getProperty("firstName"));

	        Assert.assertTrue(lastNameInput.isDisplayed());
	        Reporter.log("Last Name input field is displayed");
	        lastNameInput.sendKeys(configReader.getProperty("lastName"));

	        Assert.assertTrue(zipCodeInput.isDisplayed());
	        Reporter.log("Zip/Postal Code input field is displayed");
	        zipCodeInput.sendKeys(configReader.getProperty("zipCode"));
	 }
	 
	 public void clickContinue()
	 {
		 Assert.assertTrue(continueButton.isDisplayed());
		 Reporter.log("Continue button is displyed");
		 continueButton.click();
		 Reporter.log("Continue button is clicked");
	 }
}
