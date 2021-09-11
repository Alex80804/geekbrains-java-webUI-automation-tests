Feature: Adding temperature

  Background:
    Given I am authorized at WithingsHealthmate site

  Scenario Outline:
    Given I am at the main page
    When I click add button
    And I click temperature item
    And I fill '<temperature>' field
    And I click save button
    Then The last temperature measure is shown
    Examples:
      | temperature |
      | 36.6        |
      | 36.5        |