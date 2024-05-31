package org.example.Pages;

import org.example.stepdefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdefs.Hooks.driver;


public class homepage {

    public homepage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="gender-male")
    public WebElement gender;
    @FindBy(className="ico-register")
    public WebElement  register ;
    @FindBy(css="a[href='/computers']")
    public  WebElement computer;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div[1]/div[2]/ul/li[1]/ul/li[2]/a")// take html better
    public WebElement noteBook;

}
