package com.SuitCRM.pages;

import com.SuitCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{

    //no need to explicitly write constructor, because it will use its parents constructor
    @FindBy(id= "grouptab_0")
    public WebElement salesDropDown;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(xpath = "/html/body/div[2]/nav/div/div[5]/ul/li[3]/form/div/span")
    public WebElement searchButton;
    @FindBy(id = "searchFieldMain")
    public WebElement searchTab;

    @FindBy(xpath = "//input[@class='button primary']")
    public WebElement searchButton2;
     public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}