Feature: Contact Us Page

  Scenario: Validate Successful Submission
    Given The user is on the Contact Us Page
    When The user enters first name
    And The user enters last name
    And The user enters an email address
    And The user enters a comment
    And The user clicks on Submit Button
    Then The user be presented with a successful Contact Us submission message