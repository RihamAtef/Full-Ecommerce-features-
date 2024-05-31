 @regression
Feature:  this feature will allow new user to create valid account
  Background:
   // Given open chrome browser and navigate to demo.nopcommerce
    And   goto register page
    When  user select gender

   #negative scenario
  Scenario Outline:  test user will create invalid account
     And   user enter first"ali" and last name"kareem"
     And   user choose date of birth
     And   user entered vaild email" <round>"
     And   newsletter is selected
     And   user enter pasword and confirm it wrongly
     And user clicks on register botton
     Then error message is displayed
    And  user quit browser
    Examples:
      |round|
      |1|
      |2|
  @smoke
  Scenario Outline: test user will create valid account
    And   user enter first"ali" and last name"kareem"
    And   user choose date of birth
    And   user entered vaild email" <round>"
    And   newsletter is selected
    And   user enter pasword and confirm it rightly
    And user clicks on register botton
    Then succesful  message is displayed
    And  user quit browser
    Examples:
      | round |
      | 1     |










