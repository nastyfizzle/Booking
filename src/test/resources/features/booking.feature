Feature: Booking search
  Scenario: Rating and hotel name should be correct
    Given User is in the search page
    When user is searching for the hotel with name "Замковый"
    Then "Park Hotel Zamkovy" exists in the result page
    And hotel's rating is "9.3"
