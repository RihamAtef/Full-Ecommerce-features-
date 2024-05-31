package org.example.stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.Pages.ShoppingCartPage;
import org.example.Pages.loginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepdefs.Hooks.driver;
import static org.example.stepdefs.register.globalEmail;
import static org.example.stepdefs.register.globalPass;

public class CheckoutFinally {
    ShoppingCartPage cart = new ShoppingCartPage();
    loginPage login = new loginPage();
    @Given("user was logged in")
    public void userIsLoggedIn() {
        login.login.click();
        login.email.sendKeys(globalEmail);
        login.password.sendKeys(globalPass);
        login.loginButton.click();

    }
    @Given("go to the shopping cart")
     public  void goToTheShoppingCart()
    {   cart.ShoppingCart.click();}


    @And("Enter Discount Code{string}")
    public void enterDiscountCode(String arg0) {
        Faker fake = new Faker();
        arg0= String.valueOf(fake.code());
        cart.discountCode.sendKeys(arg0);
        cart.discountCodeButton.click();

    }


    @And("Enter gift card code{string}")
    public void enterGiftCardCode(String arg1) {
        Faker fake = new Faker();
        arg1= String.valueOf(fake.code());
        cart.giftCard.sendKeys(arg1);
        cart.giftCardButton.click();
    }

    @And("Check on I agree with the terms of service and I adhere to them unconditionally")
    public void checkOnIAgreeWithTheTermsOfServiceAndIAdhereToThemUnconditionally() {
        boolean checkBox = cart.checkBox.isSelected();
                if(!checkBox)
                {
                    cart.checkBox.click();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                }

    }


    @Then("click on check out")
    public void clickOnCheckOut() {
        cart.checkOutButton.click();
    }
    @And("User select country and select state")
    public void selectCountryAndSelectState() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Ensure the country dropdown is visible and clickable
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOf(cart.country));

        // Scroll to country dropdown if necessary
        js.executeScript("arguments[0].scrollIntoView(true);", countryDropdown);

        Select select = new Select(cart.country);
        select.selectByValue("6");
    }

    @And("User enter city{string} and Address one {string}and Address two {string} and zip code{string} and phone number {string}and fax number{string}")
    public void userEnterCityAndAddressAndAddressAndZipCodeAndPhoneNumberAndFaxNumber(String arg0, String arg2, String arg4, String arg5, String arg6, String arg7) {
        Faker fake = new Faker();
        arg0= fake.country().capital();
        arg2= fake.address().fullAddress();
        arg4= fake.address().fullAddress();
        arg5=fake.address().zipCode();
        arg6= fake.phoneNumber().cellPhone();
        arg7=fake.phoneNumber().cellPhone();
        cart.city.sendKeys(arg0);
        cart.addressOne.sendKeys(arg2);
        cart.addressTwo.sendKeys(arg4);
        cart.zipCode.sendKeys(arg5);
        cart.phoneNum.sendKeys(arg6);
        cart.faxNum.sendKeys(arg7);


    }

    @And("The user clicks on Continue")
    public void theUserClicksOnContinue() {
        cart.continueForAddressData.click();
    }

    @And("The user selects the shipping method and clicks on Continue")
    public void theUserSelectsTheShippingMethodAndClicksOnContinue() {
        boolean statues = cart.shippingMethodGround.isSelected();
        if (!statues) {
            cart.shippingMethodGround.click();
        }
        cart.continueBtn_ShippingMethod.click();
    }
    @And("User selects check money order method and clicks on Continue")
    public void userSelectsCheckMoneyOrderMethodAndClicksOnContinue() {
        boolean status = cart.checkMoneyOrder.isSelected();
        if (status==false) {
            cart.checkMoneyOrder.click();
        }
        cart.continueBtn_paymentMethod.click();

    }

    @And("user adds the payment method details and clicks on Continue")
    public void userAddsThePaymentMethodDetailsAndClicksOnContinue()
    { cart.continueBtn_paymentMethod.click();
    }

    @And("user clicks on Continue in payment information")
    public void userClicksOnContinueInPaymentInformation() {
        cart.continueBtn_PaymentInfo.click();

    }


    @And("The guest user clicks on Confirm")
    public void theGuestUserClicksOnConfirm() {
        cart.confirmBtn.click();

    }
    SoftAssert soft= new SoftAssert();


    @Then("The order for the Guest is confirmed and the user can navigate")
    public void theOrderForTheGuestIsConfirmedAndTheUserCanNavigate() {
        String expectedMsg="Your order has been successfully processed!";
        String actualMsg =cart.confirmMsg.getText();

        boolean result=actualMsg.contains(expectedMsg);
        soft.assertTrue(result);
        cart.orderDetails.click();

    }

    @And("User selects check Credit card method and clicks on Continue")
    public void userSelectsCheckCreditCardMethodAndClicksOnContinue()
    {   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Ensure the credit card checkbox is visible and clickable
        WebElement creditCardCheckbox = wait.until(ExpectedConditions.visibilityOf(cart.checkCreditCard));

        // Scroll to the credit card checkbox if necessary
        js.executeScript("arguments[0].scrollIntoView(true);", creditCardCheckbox);

        // Click the credit card checkbox if not already selected
        boolean status = cart.checkCreditCard.isSelected();
        if (!status) {
            wait.until(ExpectedConditions.elementToBeClickable(cart.checkCreditCard)).click();
        }

        // Ensure the continue button is visible and clickable
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOf(cart.continueBtn_paymentMethod));

        // Scroll to the continue button if necessary
        js.executeScript("arguments[0].scrollIntoView(true);", continueButton);

        // Click the continue button
        wait.until(ExpectedConditions.elementToBeClickable(cart.continueBtn_paymentMethod)).click();

    }

    @And("user adds the payment method details {string},cardNumber,Expiration date,cardCode and clicks on Continue and clicks on Continue")
    public void userAddsThePaymentMethodDetailsCardNumberExpirationDateCardCodeAndClicksOnContinueAndClicksOnContinue(String arg0) {
Faker faker= new Faker();
        Select selectCredit= new Select(cart.cardType);
        selectCredit.selectByValue("MasterCard");
        arg0=faker.name().fullName();
        cart.holderName.sendKeys(arg0);
        cart.cardNumber.sendKeys("5555555555554444");
        Select selectMonth= new Select(cart.month);
        selectMonth.selectByValue("2");
        Select selectYear= new Select(cart.year);
        selectYear.selectByValue("2025");
        cart.cardCode.sendKeys("907");
        cart.continueBtn_PaymentInfoCreditCard.click();

    }
}
