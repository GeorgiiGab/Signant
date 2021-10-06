Feature: Updating personal info


@wip
  Scenario: authenticated users can update personal information of the users
    Given the user is authenticated in the system
    When the user sends correct request to update the personal information
    Then the status code will be 204