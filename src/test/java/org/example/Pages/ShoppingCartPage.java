package org.example.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepdefs.Hooks.driver;

public class ShoppingCartPage {

    public ShoppingCartPage()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "ico-cart")
    public WebElement ShoppingCart;
    @FindBy(css="input[name=\"discountcouponcode\"]")
    public WebElement discountCode;
    @FindBy(css="button[name=\"applydiscountcouponcode\"]")
    public WebElement discountCodeButton;
    @FindBy(css="input[name=\"giftcardcouponcode\"]")
    public WebElement giftCard;
    @FindBy( css = "button[name=\"applygiftcardcouponcode\"]")
    public WebElement giftCardButton;
    @FindBy(css="input[id=\"termsofservice\"]")
    public WebElement checkBox;
    @FindBy(css="button[id=\"checkout\"]")
    public WebElement checkOutButton;
    @FindBy(css="select[id=\"BillingNewAddress_CountryId\"]")
    public  WebElement country;
    @FindBy(css="input[type=\"text\"][data-val=\"true\"][data-val-required=\"City is required\"][id=\"BillingNewAddress_City\"][name=\"BillingNewAddress.City\"]")
    public WebElement city;
    @FindBy(css="input[type=\"text\"][data-val=\"true\"][data-val-required=\"Street address is required\"][id=\"BillingNewAddress_Address1\"][name=\"BillingNewAddress.Address1\"]")
    public  WebElement addressOne;
    @FindBy(css="input[type=\"text\"][id=\"BillingNewAddress_Address2\"][name=\"BillingNewAddress.Address2\"]")
    public WebElement  addressTwo;
    @FindBy(css="input[type=\"text\"][id=\"BillingNewAddress_ZipPostalCode\"][name=\"BillingNewAddress.ZipPostalCode\"]")
    public WebElement zipCode;
    @FindBy(css="input[type=\"tel\"][id=\"BillingNewAddress_PhoneNumber\"][name=\"BillingNewAddress.PhoneNumber\"]")

   public WebElement phoneNum;
    @FindBy(css="input[type=\"text\"][id=\"BillingNewAddress_FaxNumber\"][name=\"BillingNewAddress.FaxNumber\"]")

public WebElement faxNum;
    @FindBy(className = "new-address-next-step-button")
    public WebElement continueForAddressData;
//
@FindBy(css ="input[value=\"Ground___Shipping.FixedByWeightByTotal\"]")
public WebElement shippingMethodGround;
    @FindBy(className = "shipping-method-next-step-button")
    public WebElement continueBtn_ShippingMethod;
    @FindBy(id="paymentmethod_0")
    public WebElement checkMoneyOrder;
    @FindBy(css="input[id=\"paymentmethod_1\"]")
    public  WebElement checkCreditCard;
    @FindBy(className = "payment-method-next-step-button")
    public WebElement continueBtn_paymentMethod;
    @FindBy(css ="button[onclick=\"PaymentInfo.save()\"")
    public WebElement continueBtn_PaymentInfo;
    @FindBy(className = "confirm-order-next-step-button")
    public WebElement confirmBtn;
    @FindBy(css ="button[onclick=\"PaymentMethod.save()\"")
    public WebElement continueBtn_PaymentMethodCreditCard;
    @FindBy(id="CreditCardType")
    public WebElement cardType;
    @FindBy(id="CardholderName")
    public WebElement holderName;
    @FindBy(id="CardNumber")
    public WebElement cardNumber;
    @FindBy(id="ExpireMonth")
    public WebElement month;
    @FindBy(id="ExpireYear")
    public WebElement year;
    @FindBy(id="CardCode")
    public WebElement cardCode;
    @FindBy(className = "payment-info-next-step-button")
    public WebElement continueBtn_PaymentInfoCreditCard;
    //
    @FindBy(xpath ="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong" )
    public WebElement confirmMsg;

    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
    public WebElement orderDetails;


}
