package com.SuitCRM.step_definitions;

import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.utilities.BrowserUtils;
import com.SuitCRM.utilities.ConfigurationReader;
import com.SuitCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);

    }

    @When("the user enters the user information")
    public void the_user_enters_the_driver_information() throws InterruptedException {
       // String username = ConfigurationReader.get("driver_username");
      //  String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("SuiteCRM", actualTitle);


    }


}
