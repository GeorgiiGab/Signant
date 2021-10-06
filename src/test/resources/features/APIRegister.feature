Feature: registering users in using API



  Scenario: the user should be able to register using API
    When the user registers using API
    Then status code should be 201


    Scenario: the user should not be able to register with username that has already been used
      When the user tries to register with username that has already been used
      Then status code should be 400


    Scenario: the user should provide all required fields for registration
      When the user doesn't fill any of the required fields during registration
      Then status code should be 400