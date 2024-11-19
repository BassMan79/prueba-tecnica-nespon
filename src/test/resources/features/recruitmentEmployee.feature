@Regression
Feature: Manual results input module scenarios

  Scenario Outline: Search and validate data found in raw data
    Given I log in with <admin> username and <password> password
    When I check login is correct
    And I add a new employee

    Examples:
      | admin | password |
      | Admin | admin123 |
