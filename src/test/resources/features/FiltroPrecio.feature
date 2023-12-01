Feature: Yo como usuario necesito filtrar por precio los vuelos

  #Must be Scenario outline for having examples.
  @FiltroPrecio-001
  Scenario Outline: Filtrar por precio
    Given La página ha cargado completamente
    When Seleccionar el precio <row>
    Then Validar que los planetas listados sean de precio menor a <row>

    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
