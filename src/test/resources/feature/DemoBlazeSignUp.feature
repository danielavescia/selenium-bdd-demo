#language: en

Feature: Register on DemoBlaze

    Scenario: Sucessful registration
        Given I'm on the DemoBlaze home page
        When I click on Sign up button
        And I fill out the form with "email1@test.com", "123"
        And I click on the Sign up button
        Then I see the registration message "Sign up successful."