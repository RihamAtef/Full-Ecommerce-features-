package org.example.stepdefs;

import io.cucumber.java.en.And;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.homepage;
import org.example.Pages.registerPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import static org.example.stepdefs.Hooks.driver;
public class register {
    public static String globalEmail;
    public static String globalPass;



homepage home= new homepage();
registerPage register = new registerPage();

    @And("user entered vaild email{string}")
    public void userEnteredVaildEmail(String email ) {
        Faker fake = new Faker();
        globalEmail= fake.internet().emailAddress();
        System.out.println(globalEmail);
        register.email.sendKeys( globalEmail);
    }

    @And("user enter first{string} and last name{string}")
    public void userEnterFirstAndLastName(String arg0, String arg1) {
        Faker faker = new Faker();
        arg0= faker.internet().avatar();
        arg1= faker.internet().domainName();
//               arg0= String.valueOf(faker.name());
//               arg1= String.valueOf(faker.name());
        register.firstname.sendKeys(arg0);
        register.lastname.sendKeys(arg1);


    }


    @And("goto register page")
    public void gotoRegisterPage() {
       home.register.click();
        
    }

    @When("user select gender")
    public void userSelectGender() {
        home.gender.click();
    }



    @And("user choose date of birth")
    public void userChooseDateOfBirth() {
        WebElement staticList= register.dateofbirthyear;
        Select select = new Select(staticList);
       select.selectByValue("1914");
       WebElement staticlist1= register.dateofmonth;
       Select select1= new Select(staticlist1);
       select1.selectByIndex(1);
       WebElement staticlist2= register.dateofbirthday;
       Select select2 =new Select( staticlist2);
       select2.selectByValue("2");

    }


    @And("newsletter is selected")
    public void newsletterIsSelected() {

        boolean status= register.newsletter.isSelected();
        if(!status)
        {register.newsletter.click();}


    }

    @And("user enter pasword and confirm it wrongly")
    public void userEnterPaswordAndConfirmItWrongly()
    {
        Faker fake = new Faker();
       globalPass= fake.internet().password();
        register.password.sendKeys( globalPass);
        register.confirmpassword.sendKeys("nada");
    }

    @And("user clicks on register botton")
    public void userClicksOnRegisterBotton() {
        register.registerbutton.click();;
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
       boolean ActualError= register.errormessage.isDisplayed();
       soft.assertEquals(ActualError,true);
//        String ActualError= register.errormessage.getText();
//        soft.assertEquals(ActualError.toLowerCase(),"The password and confirmation password do not match");
//
//        String ActualURL= driver.getCurrentUrl();
//        soft.assertEquals(ActualURL,"https://demo.nopcommerce.com/register");


        soft.assertAll();




    }

    @And("user enter pasword and confirm it rightly")
    public void userEnterPaswordAndConfirmItRightly() {
        Faker fake = new Faker();
        globalPass= fake.internet().password();


        register.password.sendKeys( globalPass);
        register.confirmpassword.sendKeys(globalPass);


    }

    @Then("succesful  message is displayed")
    public void succesfulMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
       String Actualurl = driver.getCurrentUrl(); // to se the url changed
        soft.assertTrue(Actualurl.contains("https://demo.nopcommerce.com/registerresult/1?returnUrl=/"),  "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
       String ActualMsg=  register.confirmMessage.getText();
       soft.assertTrue(ActualMsg.contains("Your registration completed"),"Your registration completed");
        //soft.assertTrue(condition, message)
        // condition = actualMsg.contains("Your registration completed")     >> boolean
        // message in case of failure  =  "actualMsg : " + actualMsg + "  " + "expected Msg : "+"Your registration completed"
        String actualColorRGPA =register.confirmMessage.getCssValue("color");
        String actualColorHex= Color.fromString(actualColorRGPA).asHex();
        soft.assertEquals(actualColorHex,"#4cb17c");
        soft.assertAll();

    }


    @And("user quit browser")
    public void userQuitBrowser() {
    }


}
