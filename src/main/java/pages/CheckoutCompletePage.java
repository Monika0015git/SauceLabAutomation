package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckoutCompletePage {
	
	WebDriver driver;

    @FindBy(className = "title")
    private WebElement checkoutCompleteTitle;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    @FindBy(className = "complete-text")
    private WebElement orderConfirmationMessage;

    @FindBy(className = "pony_express")
    private WebElement confirmationImage;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;


    public CheckoutCompletePage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyCheckoutCompletePage() 
    {
        Assert.assertTrue( checkoutCompleteTitle.isDisplayed(), "Checkout Complete title is not displayed");
        Reporter.log("Checkout Complete page is displayed");
    }


    public void verifyThankYouMessage() 
    {
        Assert.assertTrue( thankYouMessage.isDisplayed(), "Thank you message is not displayed");
        Reporter.log("Thank you message is displayed ---   "+ thankYouMessage.getText());
    }


    public void verifyOrderConfirmationMessage() 
    {
        Assert.assertTrue(orderConfirmationMessage.isDisplayed(), "Order confirmation message is not displayed");
        Reporter.log("Order confirmation message is displayed  ----  "+orderConfirmationMessage.getText());
    }


    public void verifyConfirmationImage() 
    {
        Assert.assertTrue(confirmationImage.isDisplayed(),"Order confirmation image is not displayed");
        Reporter.log("Order confirmation image is displayed");
    }


    public void clickBackHome() 
    {
        Assert.assertTrue( backHomeButton.isDisplayed(), "Back Home button is not displayed");
        Reporter.log("Back Home button is displayed");

        backHomeButton.click();
        Reporter.log("Back Home button is clicked");
    }


}
