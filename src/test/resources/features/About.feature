@About
Feature: About feature

  Background: User successfully login
    Given user is in Login page
    When user input the valid credentials and click login button
    Then user can successfully login

  Scenario: User can go to about page
    When user click about page button on the sidebar menu
    And user scroll to the swipe bar and swap
