Feature: Yo como usuario necesito iniciar sesión con usuario y contraseña válidos

  @Login-001
  Scenario Outline: Iniciar sesión exitosa
    Given Se navega hacia "https://demo.testim.io"
    When La página ha cargado completamente
    And Dar Clic en el enlace del LOGIN
    And Llenar el campo de usuario como "<usuario>"
    And Llenar el campo contraseña como "<contrasena>"
    And Dar Clic en el botón LOGIN
    Then Validar que el "<usuario>" aparezca en la parte superior derecha
    Then Cerrar navegador

    Examples:
      | usuario | contrasena |
      | john    | 123        |
      | andres  | 456        |
      | jimmy   | 789        |





