Feature: Login Scenarios for saucedemo website

  @CP1_login @smoke
  Scenario: Login exitoso con usuario comun
    Given el usuario se encuentra en la pagina web de saucedemo
    When inicia session con user "standard_user" y password "secret_sauce"
    Then se encuentra en el home de ventas de saucedemo