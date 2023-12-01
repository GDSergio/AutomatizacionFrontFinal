Feature: Yo como usuario necesito

  @Login-001
  Scenario Outline: Iniciar sesión exitosa
    Given Dar Clic en el enlace del LOGIN
    When Llenar el campo de usuario como <row>
    And Llenar el campo contraseña como <row>
    And Dar Clic en el botón LOGIN
    Then Validar que el <row> aparezca en la parte superior derecha
    And Seleccionar el precio <row>
    Then Validar que los planetas listados sean de precio menor a <row>
    And  Dar Clic en el enlace del book
    And Leer desde el Excel <row>
    And pongo un codigo de descuento
    Then El carrito aparecerá con tu compra


    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
