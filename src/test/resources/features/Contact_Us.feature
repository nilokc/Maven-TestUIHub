
@Contact_Us

Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with the successful contact us submission message


    Scenario: Validate Successful Submission - Specific Data
      Given I access the webdriver university contact us page
      When I enter a specific first name nil
      And I enter specific last name blogs
      And I enter a specific email address nil_blogs123@mail
      And I enter a specific comment "How are you?"
      And I click on the submit button
      Then I should be presented with a unsuccessful contact us submission message