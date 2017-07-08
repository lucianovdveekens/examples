Feature: Giving away apples

  Scenario: I have two apples and I give one away
    Given I have 2 apples
    When I give 1 away
    Then I have 1 left

  Scenario Outline: I have <a> apples and I give <b> away
    Given I have <a> apples
    When I give <b> away
    Then I have <c> left

    Examples:
      | a  | b | c |
      | 10 | 8 | 2 |
      | 2  | 1 | 1 |