@login
Feature: Login feature

  Scenario Outline: User can <condition> login
    Given user is in Login page
    When user input the <condition> credentials and click login button
    Then user can <result> login

    Examples: 
      | condition | result       |
      | valid     | successfully |
      | invalid   | not          |
