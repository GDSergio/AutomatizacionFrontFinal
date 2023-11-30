Feature: Yo como usuario necesito filtrar por precio los vuelos

  #Must be Scenario outline for having examples.
  @FiltroPrecio-001
  Scenario Outline: Filtrar por precio
    Given Se navega hacia "https://demo.testim.io/destinations"
    When La página ha cargado completamente
    And Seleccionar el precio <row>
    Then Validar que los planetas listados sean de precio menor a <row>
    Then Cerrar navegador

    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |

