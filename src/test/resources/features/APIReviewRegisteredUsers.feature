
Feature: Reviewing registered users



  Scenario: authenticated users should be able to review registered users
    Given the user is authenticated
    When the user sends correct request
    Then status code must be 200



    Scenario: unauthenticated users should not be able to review registered users
      Given the user is not authenticated
      When the user sends correct request
      Then status code must be 401



    Scenario: users sending wrong requests should not be able to review registered users
      Given the user is authenticated
      When the user sends incorrect request
      Then status code must be 404