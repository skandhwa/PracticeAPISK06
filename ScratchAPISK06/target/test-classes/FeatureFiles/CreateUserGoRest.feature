@test2

Feature: Create a New User in GoRestSite

  Scenario Outline: Validate creation of new user in gorest
    Given user hit the gorest with on its uri
    When user enters the authentication token
    And user passed the payload in gorest site with all required details
    When user will hit the gorest "<endpoint>"
    Then user validates the status code as "<status_code>"
    Then user will validate the details in status body

    Examples: 
      | endpoint        | status_code |
      | public/v2/users |         201 |
