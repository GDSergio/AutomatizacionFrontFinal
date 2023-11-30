#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: feature to test google search functionality

  @classic
  Scenario: Validate google search is working
    Given user is on google search page
    When user enters a text in search box
    And hits enter
    Then user is navigated to search results

  @readSheetDocument
  Scenario Outline: Validate google search is working
    Given user is on google search page
    When user enters a text read on sheet in row <row> in search box
    And hits enter
    Then user is navigated to search results

    Examples:
    |row|
    |0  |
    |1  |
    |2  |
    |3  |
  @readDataOfDB
  Scenario Outline: Validate google search is working
    Given user is on google search page
    When user enters a text read on DataBase in <id> in search box
    And hits enter
    Then user is navigated to search results

    Examples:
    |id|
    |1 |
    |2 |


