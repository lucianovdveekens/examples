Feature: Apples

  Scenario: I have two apples and give one away
    Given I have 2 apples
    When I give 1 away
    Then I have 1 left

  Scenario: I have ten apples and give three away
    Given I have 10 apples
    When I give 3 away
    Then I have 7 left
