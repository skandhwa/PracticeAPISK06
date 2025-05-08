@test1

Feature: Creation of New User with all payload details

  Scenario Outline: Creation of new user details
    Given user requests to hit an application URI
    And user passed the payload with all required details
    When user will hit the "<endpoint>"
    Then user validates the status code as "<status_code>"
  

    Examples: 
      | endpoint  | status_code |
      | api/users |         201 |
