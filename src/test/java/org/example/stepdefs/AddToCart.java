package org.example.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.AddToCartPage;
import org.example.Pages.homepage;
import org.example.Pages.loginPage;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.stepdefs.Hooks.driver;
import static org.example.stepdefs.register.globalEmail;
import static org.example.stepdefs.register.globalPass;

public class AddToCart {
    homepage home = new homepage();
    AddToCartPage add = new AddToCartPage();
    loginPage login = new loginPage();

    @Given("user is logged in")
    public void userIsLoggedIn() {
        login.login.click();
        login.email.sendKeys(globalEmail);
        login.password.sendKeys(globalPass);
        login.loginButton.click();

    }

    @Given("user select computer")
        public void userSelectComputer()
    {  home.computer.click();}

    @And("user select notebook")
    public void userSelectNotebook() {
        home.noteBook.click();
    }
    @And("user check on intel core i")
    public void userCheckOnIntelCoreI() {
        boolean check = add.IntelCoreI5.isSelected();
                if (check)
                {
                    add.IntelCoreI5.click();
                }
    }


    @When("click on add to cart button for  Apple MacBook Pro -inch")
    public void clickOnAddToCartButtonForAppleMacBookProInch() {
        add.addToCart.click();
    }


    @And("click o add to cart again")
    public void clickOAddToCartAgain() {
        add.getAddToCart2.click();
    }


    @Then("successful  message is displayed")
    public void successfulMessageIsDisplayed() {
        //assertion is her e
        SoftAssert soft = new SoftAssert() ;

        // Implicit wait - Set a global wait for all elements to be present
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        String ActualMsg = add.displayedMessage.getText();
        soft.assertTrue(ActualMsg.contains("The product has been added to your shopping cart"),"The product has been added to your shopping cart");
 String ActualColor =add.displayedMessage.getCssValue("color");
String ActualColorHex= Color.fromString(ActualColor).asHex();
soft.assertEquals(ActualColorHex,"#ffffff");
        soft.assertAll(); // This ensures that all assertions are executed and collects their results
    }



}
