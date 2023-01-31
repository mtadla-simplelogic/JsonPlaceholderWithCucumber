Feature: Users endpoint

  Scenario: Should get all users
    Given I have users endpoint
    When I get all users
    Then Status code should be 200

  Scenario: Get first user
    Given I have users endpoint
    When I get user with id 1
    Then Status code should be 200
    And User name is "Leanne Graham"

  Scenario: Create new user
    Given I have users endpoint
    When I create new "jkowalski" user
    Then Status code should be 201
    And User name is "Jan Kowalski"
    And Body matches create user schema
