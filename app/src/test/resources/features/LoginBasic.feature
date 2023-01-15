Feature: Login basic
  @Smoke
  Scenario: Successful login
    Given Get the URL of the login
    When the user enters the correct username and password
    Then the status code should be OK

  @Smoke
  Scenario Outline: Successful login with outline
    Given Get the URL of the login with scenario Outline
    When the user enters the correct "<username>" and "<password>" Outline
    Then the status code should be OK Outline
    Examples:
      | username | password |
      | incrediboys | 123456 |


