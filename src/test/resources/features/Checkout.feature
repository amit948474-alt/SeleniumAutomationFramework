Feature: Checkout functionality

  @regression
  Scenario: Complete checkout successfully
    Given user is logged into SauceDemo
    And user has added a product to the cart
    Then user opens the cart
    And user proceeds to checkout
    And user enters checkout details
    And user continues to checkout overview
    And user finishes the checkout
    Then order should be completed successfully