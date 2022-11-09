Feature: Send an email by Sing-Up

  @tag1
  Scenario: Sign up to the course websit
    Given I want to lauch the course website
    When Click the Sign Up link
    And Enter the mandatory values in the Registration form
    Then Click the Register button
    And Logout form the website
    
 @tag1  
  Scenario: Sign into the website
   Given Enter the sign in credentials 
   When Click the sign in button
   And Enter into the message page and send the email
   Then validate the success message
    
       

