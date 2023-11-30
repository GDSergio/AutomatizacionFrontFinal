Feature: Yo como usuario necesito agregar un viaje

  @Carrito-001
  Scenario Outline: Compra carrito
    Given Se navega hacia "https://demo.testim.io/destinations"
    When La página ha cargado completamente
    And Dar Clic en el enlace del book
    And completar con "<name>" el nombre, con "<email>" el correo,con "<securynumber>" el securynumber,con "<phone>" el telefono
    And pongo un codigo de descuento
    Then El carrito aparecerá con tu compra
    Then Cerrar navegador

    Examples:
      | name   | email             | securynumber | phone      |
      | john   | jhon@eam.edu.co   | 123-21-4567  | 3153339895 |
      | andres | andres@eam.edu.co | 523-56-7898  | 3204588649 |
      | jimmy  | jimmy@eam.edu.co  | 753-12-6549  | 3215469987 |
      | andres | andres@eam.edu.co | 756-23-7536  | 3256785826 |