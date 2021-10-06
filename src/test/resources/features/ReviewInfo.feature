Feature: As a user I should be able to view my information from main view page

  Background:
  Given the user is on starter page
  And the user clicks on login button


  Scenario: view user information
    And the user enters valid "Gary" and "asd123" and clicks login button
    Then the user should be able to view his information on the main view page


  Scenario: user enters invalid credentials
  When user enters invalid username "Jjab" and password "sfagfag"
  Then the user should be able to see the warning message

    # Negative testing with blank fields of either username or password
    # has the same logic as the one in Register feature
