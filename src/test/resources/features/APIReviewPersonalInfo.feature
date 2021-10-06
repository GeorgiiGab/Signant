Feature: Reviewing personal info of the registered users



  Scenario: authenticated users should be able to get personal information of the registered users
    Given the user is properly authenticated
    When the user sends request correctly
    Then the user should get the status code 200



    Scenario: unauthenticated users should not be able to get personal information of the registered users
      Given the user is not properly authenticated
      When the user sends request correctly
      Then the user should get the status code 401



    Scenario: authenticated users sending wrong requests should not be able to get personal information of the registered users
      Given the user is properly authenticated
      When the user sends wrong request
      Then the user should get the status code 404
      