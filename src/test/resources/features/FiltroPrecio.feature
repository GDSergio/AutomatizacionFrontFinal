Feature: Yo como usuario necesito filtrar por precio los vuelos

  #Must be Scenario outline for having examples.
  @FiltroPrecio-001
  Scenario Outline: Filtrar por precio
    Given Se navega hacia "https://demo.testim.io/destinations"
    When La página ha cargado completamente
    And Seleccionar el precio “<precio>”
    Then Validar que los planetas listados sean de precio menor a “<precio>”
    Then Cerrar navegador

    Examples:
    |precio|
    |450   |
    |1200  |
    |170   |

