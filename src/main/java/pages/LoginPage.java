package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath="//div[@class='login_logo']")
    private WebElement logo;    
    
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

   
    public LoginPage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        
    public void verifyLogo()
    {
    	Assert.assertTrue(logo.isDisplayed());
    	Reporter.log("Logo of the application is displayed");
        String logoText= logo.getText();
        Reporter.log("The text of the logo displayed as : "+ logoText);
    }

    public void enterUsername(String user) 
    {
    	Assert.assertTrue(username.isDisplayed());
    	Reporter.log("Username input field is displayed");
        username.sendKeys(user);
        Reporter.log("Username is entered");
    }

    public void enterPassword(String pass) 
    {
        Assert.assertTrue(password.isDisplayed());
        Reporter.log("Password input field is displayed");
        password.sendKeys(pass);
        Reporter.log("Password is entered");
    }


    public void clickLogin() 
    {
        Assert.assertTrue(loginButton.isDisplayed());
        Reporter.log("Login button is displayed");
        loginButton.click();
        Reporter.log("Login button is clicked");
    }
}
