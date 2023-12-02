Feature: Yo como usuario necesito iniciar sesión con usuario y contraseña válidos

  @Login-001
  Scenario Outline: Iniciar sesión exitosa
    Given Dar Clic en el enlace del LOGIN
    When Llenar el campo de usuario como <row>
    And Llenar el campo contraseña como <row>
    And Dar Clic en el botón LOGIN
    Then Validar que el <row> aparezca en la parte superior derecha

    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
