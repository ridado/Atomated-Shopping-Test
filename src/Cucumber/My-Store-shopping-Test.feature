Feature: Shopping Test

  Scenario: User place an order in a shop
    Given User is on shop main page
    When user log in to account and go back to main page
    When user choose item and clicks for details
    When user checks is discount actual choose size and quantity
    And clicks on add to cart button and proceed to checkout button
    When In shopping cart user confirm address, shipping method
    And choose payment method, agree with terms and conditions
    And clicks order with obligation to pay button
    Then user takes screenshot of order confirmation
    Then user go to account order history and checks amount and status
    Then shut down browser

