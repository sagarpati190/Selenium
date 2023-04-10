Feature: Verify Demo QA Website

  Scenario: Explore all the elements available on demoQA

    Given User is on homepage
    When User selects "Elements" options
    Then User should be able to see the elements page
    Then User navigates to TextBox page and fill all the details and submit the form
    Then User validate the submitted details