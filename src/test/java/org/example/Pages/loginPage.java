package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdefs.Hooks.driver;

public class loginPage {
    public loginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="a[class=\"ico-login\"]")
    public WebElement login;
    @FindBy( css="input[class=\"email\"]")
    public WebElement email;
    @FindBy (id="Password")
    public WebElement password;
    @FindBy(className="login-button")
    public WebElement loginButton;
    @FindBy(className = "topic-block-title")
    public WebElement messageLogin;

}
