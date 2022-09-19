package com.SuitCRM.pages;


import com.SuitCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class AccountsPage extends BasePage{

    //since we are extending BasePage we do not need explicit constructor for this class
    @FindBy(xpath = "/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[3]/td[2]/a/span")
    public WebElement editButton;
    @FindBy(xpath = "/html/body/div[3]/div/div/div[1]/ul/li[1]")
    public WebElement createButton2;

    @FindBy(id= "billing_address_city")
    public WebElement city;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div[3]/input[1]")
    public WebElement saveButton;

    @FindBy(xpath = "//td[contains(text(),'mbrackstone9@example.com')][@data-column-label='Email']")
    public WebElement email;
    @FindBy(xpath = "//span[@class='suitepicon suitepicon-action-import']")
    public WebElement importButton;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[1]")
    public WebElement tableName;
    public WebElement getContactEmail(String email){
        String xpath ="//td[contains(text(),'"+email+"')][@data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
}