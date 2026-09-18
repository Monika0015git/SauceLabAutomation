package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage 
{
	 WebDriver driver;
	 
	 @FindBy(className="title")
	 private WebElement cartTitle;
	 
	 @FindBy(xpath="//div[@class='inventory_item_name']")
	 private List<WebElement> cartItems;
	 
	 @FindBy(id="checkout")
	 private WebElement checkoutButton;
	 
	 public CartPage(WebDriver driver)
	 {
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	 }
	 
	 public void verifyCartPage()
	 {
		 Assert.assertTrue(cartTitle.isDisplayed());
		 Reporter.log("Cart page is displayed");
	 }
	 
	 public void verifyCartItems() throws InterruptedException
	 {
		 Reporter.log("Printing the items present in the cart ");
		 for(WebElement item: cartItems)
		 {
			 Reporter.log(item.getText());
			 Thread.sleep(2000);
		 }
	 }
	 
	 public void clickCheckoutButton()
	 {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", checkoutButton);
		 
		 Assert.assertTrue(checkoutButton.isDisplayed());
		 Reporter.log("Checkout button is displayed" );
		 checkoutButton.click();
		 Reporter.log("Checkout button is clicked" );
	 }
}
