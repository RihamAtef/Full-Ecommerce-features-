Feature: this is designed to add product to cart
  @smoke
  Scenario:
   Given user is logged in
    Given user select computer
    And  user select notebook
    And user check on intel core i
    When  click on add to cart button for  Apple MacBook Pro -inch
    And  click o add to cart again
    And  successful  message is displayed


