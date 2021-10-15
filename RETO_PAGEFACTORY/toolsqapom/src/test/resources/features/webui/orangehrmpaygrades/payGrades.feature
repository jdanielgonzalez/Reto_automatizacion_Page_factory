Feature:Como Administrador necesito crear reportes y ejecutarlo

  Background:
    Given el administrador inicio sesion

  Scenario: Crear un reporte
    When quiere crear un reporte
    Then el sistema debe de crear el reporte y alamcenarlo
