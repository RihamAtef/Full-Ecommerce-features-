Feature: in this part user is going to check out
  @smoke
  Scenario:
    Given user was logged in
    Given go to the shopping cart
    And Enter Discount Code"xx"
    And Enter gift card code"xx"
    And Check on I agree with the terms of service and I adhere to them unconditionally
    Then click on check out
    And  User select country and select state
    And  User enter city"Cairo" and Address one "maadi"and Address two "maadi" and zip code"11511" and phone number "123"and fax number"245"
    And The user clicks on Continue
    And The user selects the shipping method and clicks on Continue

    And  User selects check Credit card method and clicks on Continue
    And  user adds the payment method details "cardHolderName",cardNumber,Expiration date,cardCode and clicks on Continue and clicks on Continue
    And The guest user clicks on Confirm
    Then The order for the Guest is confirmed and the user can navigate

