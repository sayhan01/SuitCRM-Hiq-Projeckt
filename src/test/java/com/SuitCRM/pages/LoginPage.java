package com.SuitCRM.pages;
import com.SuitCRM.utilities.ConfigurationReader;
import com.SuitCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    //driver.findElement(By.id("prependedInput"));
    @FindAll({
            @FindBy(id = "user_name")
    })
    public WebElement usernameInput;

    @FindBy(id = "username_password")
    public WebElement passwordInput;

    //driver.findElement(By.id("_submit"));
    @FindBy(id = "bigbutton")
    public WebElement loginBtn;



    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}