Feature: Yo como usuario necesito agregar un viaje

  @Carrito-001
  Scenario Outline: Compra carrito
    Given Se navega hacia "https://demo.testim.io/destinations"
    When La página ha cargado completamente
    And Dar Clic en el enlace del book
    And Leer desde el Excel <row>
    And pongo un codigo de descuento
    Then El carrito aparecerá con tu compra
    Then Cerrar navegador

#    el row es el numero de filas que se van a leer desde la hoja de excel
    Examples:
      | row |
      | 1   |
#      | 2   |
#      | 3   |
#      | 4   |