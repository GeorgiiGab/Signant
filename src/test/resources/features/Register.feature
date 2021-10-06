Feature: As a user I should be able to register through web portal

  Background:
    Given the user is on starter page
    And the user clicks on the register button and navigates to registration page


  Scenario Outline: Register new user
    When the user fills in the registration information

      |username   |<username>   |
      |password   |<password>   |
      |firstName  |<firstName>  |
      |familyName |<familyName> |
      |phoneNumber|<phoneNumber>|

    Then the user should be transferred to login page

    Examples:
    |username |password|firstName |familyName|phoneNumber|
    |Henry    |asd123  |Henry     |Ford      |635254333  |



      #The same logic applies to all the other fields on registration page and on login page
  Scenario: user leaves some registration fields blank
    When the user doesn't fill the username field during registration
    Then the user should see the warning message "Please fill out this field." after not filling the "username" field



    Scenario: user tries to register with the username that is already used
      When the user puts the username "Alen" that is already taken
      Then the user should see the warning message that the user "Alen" is already registered


      # With provided documentation on registration requirements(e.g. username length, accepted symbols and so on)
      # it would also be possible to add tests regarding filling those fields properly