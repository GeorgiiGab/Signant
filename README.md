

In this project the goal was to create and execute UI and API tests for a Demo App. The acceptance criteria were:

As a UI user I can:

Register through web portal
Review my own user information from the main view
As an API Consumer I can:

Register new users
Review users registered in system
If authenticated I can get personal information of users
If authenticated I can update personal information of users


Failed tests:
1)	Feature: Reviewing registered users
Scenario: Unauthenticated users should not be able to review registered users

Expected result: status code 401, unauthenticated users should not be able to review registered users
Actual result: status code 200, unauthenticated users are able to review registered users


2)	Feature: Updating personal info
Scenario: Authenticated users can update personal information of users

Expected result: status code 204, authenticated users can update personal information
Actual result: status code 404, authenticated users are unable to update personal information

