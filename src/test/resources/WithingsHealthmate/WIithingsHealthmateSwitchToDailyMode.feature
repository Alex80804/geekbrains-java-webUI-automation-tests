Feature: Switching heatmap to daily mode

  Background:
    Given I am authorized at WithingsHealthmate site

  Scenario:
    Given I am at WithingsHealthmate's main page
    And I assume the heatmap is on and in weekly mode
    When I click change layout button
    And I click default button near the daily layout block
    And I click slider twice
    And I click side panel close button
    Then the heatmap is switched to daily mode