Feature: AddProfileDetails

  Background: user login to site
    Given user navigates to given url
    When user enters username
    And User enters password
    And user clicks on submit button
    Then user login to the site

  Scenario: user can choose language
    And user clicks languages
    When user click Add new button for language
    Then user edit add language
    And user edit Level
    When user clicks Add button
    Then language is successfully added to languages list
    And close the driver

  Scenario: user can add skills
    When user enters to skills
    Then user click Add new button for skills
    And user edit Add skills
    And user edit level skills
    When user clicks Add button
    Then skill is successfully added to skills list
    And close the driver

  Scenario: user can add Education details
    When user enters to Education
    Then user click Add new button for Education
    And user edit Add education
    And user selects country
    And user selects title
    And user can enter Degree
    And user selects year of graduation
    When user clicks Add button
    Then Education is successfully added to Education list
    And close the driver

  Scenario: user can add Certification details
    When user enters to Certifications
    Then user click Add new button for Certifications
    And user edit Add certification
    And user can add certification from
    And user selects year
    When user clicks Add button
    Then Certification is successfully added to Certification list
    And close the driver