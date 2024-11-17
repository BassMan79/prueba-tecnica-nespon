@Regression
Feature: Manual results input module scenarios

  Scenario Outline: Search and validate data found in raw data
    Given I log in with <admin> username and <password> password
    When I check login is correct
    And I add a new employee
    Then I check that two rows appear
    When I go to home page
    And I open a results widget
    And I check that result widget appear
    Then I logout


    Examples:
      | admin | password |
      | Admin | admin123 |
