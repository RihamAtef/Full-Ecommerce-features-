package org.example.stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.loginPage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static org.example.stepdefs.Hooks.driver;
import static org.example.stepdefs.register.globalEmail;
import static org.example.stepdefs.register.globalPass;


public class login {
//    @Before
//    public void setUp() {
//        // Initialize globalEmail and globalPass
//        Faker fake = new Faker();
//        globalEmail = fake.internet().emailAddress();
//        globalPass = fake.internet().password();
//    }
    loginPage login = new loginPage();



     @Given("user navigate to home page")
     public void userNavigateToHomePage() {

     }


    @And("user go to login page")
    public void userGoToLoginPage() {
        login.login.click();
    }


    @When("user enter valid email and password in login page")
    public void userEnterValidEmailAndPasswordInLoginPage() {
      login.email.sendKeys(globalEmail);
         login.password.sendKeys(globalPass);



    }



    @And("user click on loginBtn")
    public void userClickOnLoginBtn() {
         login.loginButton.click();
    }

    @Then("welcome message appears")
    public void welcomeMessageAppears() {
        SoftAssert soft = new SoftAssert();
        String ActualUrl= driver.getCurrentUrl();
        soft.assertTrue(ActualUrl.contains("https://demo.nopcommerce.com/"),"https://demo.nopcommerce.com/");

         String ActualMsg= login.messageLogin.getText();
         soft.assertTrue(ActualMsg.contains("Welcome to our store"),"Welcome to our store");
 soft.assertAll();
    }
}
