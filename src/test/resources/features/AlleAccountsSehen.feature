
Feature: Alle Account Sehen
@test2
  Scenario: Test der Fahigkeit des Benutzers, vorhandene Accounts zu bearbeiten
    Given User ist in SuiteCRM ingeloggt und befindet sich auf der Homepage
    When Gehe auf Sales-Menu-Dropdown und wahle Accounts
    And User klickt auf Edit button fur eine vorhandane Account
    And Beutzer andert gewunschte Daten
    And User klickt auf den Save Button
    Then Vorhandene Account wurde mit neue Daten angelegt

@test1
  Scenario: Test der Fahigkeit des Benutzers, eine Accounts zu suchen
    Given User ist in SuiteCRM ingeloggt und befindet sich auf der Homepage
    When User klickt auf Suchen Tab in der Navigationsleiste
    And User fullt eine vorhandene Accountname Feld Search aus
    And User klickt Search Button oder enter
    Then User findet vorhandene Account