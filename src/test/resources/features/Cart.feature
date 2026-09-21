Feature: Cart Funcationality

  @sanity
  Scenario: Adding Product to the Cart
    Given user is logged into the SauceDemo
    Then user have added a product to the cart
    Then user opens cart
    When cart has a value > 0
    Then user logsout