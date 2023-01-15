Feature: Login basic
  Scenario : Successful login
    Given Get the URL of the login
    When the user enters the correct username and password
    Then the status code should be OK
