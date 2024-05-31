package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdefs.Hooks.driver;

public class AddToCartPage {

    public AddToCartPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy (css="input[id=\"attribute-option-6\"]")
    public WebElement IntelCoreI5;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    public  WebElement addToCart;
    @FindBy(css="button[id=\"add-to-cart-button-4\"]")
    public WebElement getAddToCart2;
    @FindBy(css="p[class=\"content\"]")
      public WebElement displayedMessage;



}

