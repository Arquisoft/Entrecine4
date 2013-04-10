# language: es
Característica: Reservas mediante tabla

  Escenario: Reservar varias butacas
    Dadas las siguientes reservas:
      |butacas  | precio |
      | 3       | 3      |
      | 7       | 2      |
      | 10      | 5      |
    Cuando Yo busco el precio de la reserva 2
    Entonces el resultado de ese valor debe ser 14 