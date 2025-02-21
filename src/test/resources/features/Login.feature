@login
Feature: WebDriver University - Login Page

  Background:
    Given I access the webdriver university login page



  Scenario: Validate Successful Login
  #  Given I access the webdriver university login page
    When I enter a username "webdriver"
    When I enter a password webdriver123
    And I click on the login button
    Then I should be presented with the successful login message


  Scenario: Validate Unsuccessful Login
    #Given I access the webdriver university login page
    When I enter a username "webdriver"
    When I enter a password nil
    And I click on the login button
    Then I should be presented with the unsuccessful login message

@smoke
  Scenario Outline: Validate - Successful & Unsuccessful Login
   # Given I access the webdriver university login page
    When I enter a username "<username>"
    And I enter a password <password>
    And I click on the login button
    Then I should be presented with the following login validation message "<loginValidationMessage>"


    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | nil          | validation failed      |
      | jane_doe  | testpassword | validation failed      |

