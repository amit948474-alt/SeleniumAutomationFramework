Feature: Login functionality

  @smoke
  Scenario Outline: Login with different credentials
    Given user is on the SauceDemo login page
    When user enters username "<username>" and password "<password>"
    And user clicks the login button
    Then user should be redirected to the products page

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
