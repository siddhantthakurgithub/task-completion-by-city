Feature: To Validate if all users of City have more than half of their todos task completed

  @P0_check_todos_completion
  Scenario: All the users of City `FanCode` should have more than half of their todos task completed.

    Given User has the todo tasks
    And User belongs to the city FanCode
    Then User Completed task percentage should be greater than 50%