package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckoutOverviewPage {
	
	 WebDriver driver;

	    @FindBy(className = "title")
	    private WebElement checkoutOverviewTitle;

	    @FindBy(className = "inventory_item_name")
	    private List<WebElement> productNames;

	    @FindBy(className = "inventory_item_price")
	    private List<WebElement> productPrices;

	    @FindBy(css = ".summary_value_label")
	    private List<WebElement> summaryInformation;

	    @FindBy(className = "summary_subtotal_label")
	    private WebElement itemTotal;

	    @FindBy(className = "summary_tax_label")
	    private WebElement tax;

	    @FindBy(className = "summary_total_label")
	    private WebElement total;

	    @FindBy(id = "cancel")
	    private WebElement cancelButton;

	    @FindBy(id = "finish")
	    private WebElement finishButton;


	    public CheckoutOverviewPage(WebDriver driver) 
	    {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    public void verifyCheckoutOverviewPage() {

	        Assert.assertTrue( checkoutOverviewTitle.isDisplayed(),"Checkout Overview title is not displayed"	);
	        Reporter.log("Checkout Overview page is displayed");

	    }


	    public void verifyProductDetails() {

	        Assert.assertTrue(productNames.size() > 0,"No product is displayed in the order summary" );
	        Reporter.log(	 "Product(s) are displayed in the order summary"	);

	    }


	    public void verifyProductPrices() {

	        Assert.assertTrue( productPrices.size() > 0,	"Product price is not displayed" );
	        Reporter.log(	 "Product price(s) are displayed in the order summary");

	    }


	    public void verifyPaymentInformation() {

	        Assert.assertTrue( summaryInformation.size() > 0,"Payment information is not displayed"	);
	        Reporter.log("Payment information is displayed");

	    }


	    public void verifyItemTotal() {

	        Assert.assertTrue(itemTotal.isDisplayed(),"Item total is not displayed");
	        Reporter.log(	 "Item total is displayed");
	    }


	    public void verifyTax() {

	        Assert.assertTrue(tax.isDisplayed(),	"Tax is not displayed" );
	        Reporter.log( "Tax is displayed");

	    }


	    public void verifyTotal() {

	        Assert.assertTrue( total.isDisplayed(), "Final total is not displayed" );
	        Reporter.log("Final total is displayed");

	    }


	    public void clickCancel() {

	        Assert.assertTrue(cancelButton.isDisplayed(), "Cancel button is not displayed");
	        Reporter.log("Cancel button is displayed");

	        cancelButton.click();
	        Reporter.log("Cancel button is clicked");

	    }


	    public void clickFinish() {

			 JavascriptExecutor js= (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true);", finishButton);
			 
	        Assert.assertTrue( finishButton.isDisplayed(), "Finish button is not displayed");
	        Reporter.log("Finish button is displayed");

	        finishButton.click();
	        Reporter.log("Finish button is clicked");

	    }

}
