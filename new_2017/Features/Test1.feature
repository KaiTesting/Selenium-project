Feature: Test Facebook login with different user account

  Scenario Outline: Test login with valid credential
    Given Open Firefox and start application
    When Enter valid "<Username>" and "<Password>"
    Then User should able to login successfully

   Examples: 
     | UserName                  | PassWord |
    | kevserkaysar1@gmail.gmail |  1894561 |
    | kevserkaysar2@gmail.gmail |  2894562 |
    | kevserkaysar3@gmail.gmail |  3894563 |
