Feature: Adding new contact person

  Background:
    Given I am authorized at Applana site

  Scenario Outline:
    Given I am at Applana's main page
    When I go to contact persons list page
    And I click create contact person button
    And I fill last name '<lastName>' and first name '<firstName>'
    And I search organizations for contact person with '<orgString>' substring and choose one from the dropdown list
    And I fill job title '<jobTitle>'
    And I click save contact person button
    Then a success message contact person saved is shown

    Examples:
      | lastName | firstName | orgString | jobTitle |
      | Пупкин   | Василий   | test      | Главный  |
