package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class InventoryPage 
{
	 WebDriver driver;

	    @FindBy(className = "title")
	    private WebElement productsTitle;

	    @FindBy(className = "shopping_cart_link")
	    private WebElement shoppingCart;

	    @FindBy(id = "react-burger-menu-btn")
	    private WebElement menuButton;
	    
	    @FindBy(xpath="//a[@class='bm-item menu-item']")
	    private List<WebElement> menuOptions;
	    
	    @FindBy(id="react-burger-cross-btn")
	    private WebElement burgerCrossButton;

	    @FindBy(className = "product_sort_container")
	    private WebElement filter;
	    
	    @FindBy(id="shopping_cart_container")
	    private WebElement cartIcon;
	    
	    @FindBy(xpath="//div[@data-test='inventory-item-name']")
	    private List<WebElement> productNames;
	    
	    @FindBy(id="logout_sidebar_link")
	    private WebElement logoutLink;

	    public  InventoryPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void verifyInventoryPage() {

	        Assert.assertTrue(productsTitle.isDisplayed());
	        Reporter.log("Products title is displayed");

	        Assert.assertEquals(productsTitle.getText(), "Products");
	        Reporter.log("Home page is displayed successfully");
	    }

	    public void clickShoppingCart() {

	        Assert.assertTrue(shoppingCart.isDisplayed());
	        Reporter.log("Shopping cart is displayed");

	        shoppingCart.click();
	        Reporter.log("Shopping cart is clicked");
	    }

	    public void clickMenu() {

	        Assert.assertTrue(menuButton.isDisplayed());
	        Reporter.log("Menu button is displayed");

	        menuButton.click();
	        Reporter.log("Menu button is clicked");
	    }
	     public void closeMenu()
	     {
	    	 Assert.assertTrue(burgerCrossButton.isDisplayed());
	    	 Reporter.log("Button to closed the Menu is displayed");
	    	 burgerCrossButton.click();
	    	 Reporter.log("Close button is clicked and Menu is closed");
	     }
	    public void verifyMenuOption() throws InterruptedException
	    {
	    	Reporter.log("Printing the menu options displayed: ");
	    	for(WebElement option: menuOptions)
	    	{
	    		String optionText= option.getText().trim();
	    		Reporter.log(optionText);
	    		Thread.sleep(2000);
	    	}
	    	
	    }
	    public void clickFilter()
	    {
	    	Assert.assertTrue(filter.isDisplayed());
	    	Reporter.log("Filter is displayed");
	    	filter.click();
	    	Reporter.log("Filter is clicked");
	    	
	    }
	    
	    public void verifySortingDropDown() throws InterruptedException
	    {
          Select select= new Select(filter);
          
          List<WebElement> dropdownOptions = select.getOptions();
          Reporter.log("Printing the options from Filter ");
          for(WebElement option: dropdownOptions)
          {
        	  Reporter.log(option.getText());
        	  Thread.sleep(2000);
          }
	    }
	   
	    
	    public void applyFilter() throws InterruptedException
	    {
	          Select select= new Select(filter);
	          select.selectByVisibleText("Price (low to high)");
	          Reporter.log("Filter is applied   - Price (low to high)");
	    	  
	    }
	    
	    public void addProductsToCart()
	    {
	    	for(WebElement product: productNames)
	    	{
	    		Assert.assertTrue(product.isDisplayed());
	    		String productName= product.getText().trim();
	    		if(productName.equalsIgnoreCase("Sauce Labs Bike Light") || productName.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)"))
	    	     {
	                WebElement addToCartButton = product.findElement(
	                    By.xpath("./ancestor::div[@data-test='inventory-item']//button")
	                );

	                addToCartButton.click();

	                Reporter.log("Item added to the cart  ---->   " + productName);
	            }
	    	}
	    }
	    
	    public void clickCart()
	    {
	    	Assert.assertTrue(	cartIcon.isDisplayed());
	    	Reporter.log(" Cart icon is displayed ");
	    	cartIcon.click();
	    	Reporter.log("Cart icon is clicked. ");
	    }
	    
	    public void logout()
	    {
	    	Assert.assertTrue(	logoutLink.isDisplayed());
	    	Reporter.log("Logout option is displayed ");
	    	logoutLink.click();
	    	Reporter.log("Logout option is clicked. ");
	    }
}
