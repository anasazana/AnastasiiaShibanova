Feature: JDI Github Different Elements Page Test

  Scenario: Selecting different elements
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    When I select [Wind, Water] checkboxes on Different Elements Page
    And I select 'Selen' radio button on Different Elements Page
    And I open color dropdown menu on Different Elements Page
    And I select 'Yellow' color in dropdown menu on Different Elements Page
    Then Right Section on Different Elements Page contains proper logs