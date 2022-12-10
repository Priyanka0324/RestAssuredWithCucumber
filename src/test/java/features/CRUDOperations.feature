Feature: To perform all the CRUD operations

  Scenario: To Perform the GET Operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario: To perform the POST Operation on Employee DB
    Given The base URI is "http://localhost:3000/employees"
    When I pass name as "Mogli" and salary as "34000"
    Then I perform Post operation
    And Response code should be 201
