package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdefs.Hooks.driver;

public class registerPage {
    public registerPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="FirstName")
    public WebElement firstname;
    @FindBy (id="LastName")
    public WebElement lastname;
    @FindBy(id="Email")
    public WebElement email;
    @FindBy(name = "DateOfBirthYear")
    public WebElement dateofbirthyear;
    @FindBy( id="Newsletter")
    public WebElement newsletter;
    @FindBy( name="DateOfBirthDay")
    public WebElement dateofbirthday;
    @FindBy( name="DateOfBirthMonth")
    public WebElement dateofmonth;
    @FindBy(css="input[id=\"Password\"]")
    public  WebElement password;
    @FindBy(css="input[id=\"ConfirmPassword\"]")
    public WebElement confirmpassword;
    @FindBy(css="button[id=\"register-button\"]")
    public  WebElement  registerbutton;
    @FindBy(id="ConfirmPassword-error")
    public  WebElement  errormessage;
    @FindBy(css="div[class=\"page-title\"]+div[class=\"page-body\"]>div[class=\"result\"]")
    public  WebElement  confirmMessage;

}
