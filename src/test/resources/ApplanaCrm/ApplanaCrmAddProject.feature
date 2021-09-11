Feature: Adding new project

  Background:
    Given I am authorized at Applana site

  Scenario Outline:
    Given I am at Applana's main page
    When I go to project list page
    And I click create project button
    And I fill project name '<projectName>'
    And I search organizations for project with '<orgString>' substring and choose one from the dropdown list
    And I select business unit '<businessUnit>'
    And I select curator '<curator>'
    And I select rp '<rp>'
    And I select administrator '<administrator>'
    And I select manager '<manager>'
    And I click save project button
    Then a success message project saved is shown
    Examples:
      | projectName                 | orgString | businessUnit           | curator                             | rp                                  | administrator                       | manager                             |
      | Тестовый проект11 AlexL New | test      | Research & Development | Applanatest Applanatest Applanatest | Applanatest Applanatest Applanatest | Applanatest Applanatest Applanatest | Applanatest Applanatest Applanatest |

