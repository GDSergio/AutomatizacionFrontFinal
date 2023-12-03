Feature: Yo como usuario necesito agregar un viaje

  @Carrito-001
  Scenario Outline: Compra carrito
    Given Dar Clic en el enlace del book
    When Leer desde el Excel <row>
    And pongo un codigo de descuento
    Then El carrito aparecerá con tu compra

    Examples:
      | row |
      | 1   |
#      | 2   |
#      | 3   |
#      | 4   |