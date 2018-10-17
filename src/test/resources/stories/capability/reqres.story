Feature: reqres

  Information about the current and historical prices for given shares.

  Scenario:
  Test the Create (POST), Update (PUT), Update(PATCH), DELETE API(s)
  This scenario is for user creation.

    Given I am having acess to reqres
    When I create the user
    Then user should be sucessfully created
