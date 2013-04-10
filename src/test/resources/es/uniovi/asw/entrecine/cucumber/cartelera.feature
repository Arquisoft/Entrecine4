# language: es
Característica: Cartelera

  Escenario: Ver la cartelera para el día de hoy 01/04/2012 a las 11 am
    Dadas unas peliculas con los siguientes datos:
    	|   Nombre_Película   |     Dia     |   Hora   |   Sala   |
    	|      Django		  |  01/04/2013 |    12	   |	1     |
    	|      Matrix		  |  02/04/2013 |    15	   |	2     |
    	|      El hobbit	  |  01/04/2013 |    15	   |	3     |
    Cuando Yo miro la cartelera para el día de hoy 01/04/2013 a las 11 am
    Entonces el resultado debe de ser: 
    	|   Nombre_Película   |     Dia     |   Hora   |   Sala   |
    	|      Django		  |  01/04/2013 |    12	   |	1     |
    	|      El hobbit	  |  01/04/2013 |    15	   |	3     |
    	   	   
  Escenario: Ver la cartelera para mañana siendo hoy 01/04/2012 a las 11 am
    Dadas unas peliculas con los siguientes datos:
    	|   Nombre_Película   |     Dia     |   Hora   |   Sala   |
    	|      Django		  |  01/04/2013 |    12	   |	1     |
    	|      Matrix		  |  02/04/2013 |    15	   |	2     |
    	|      El hobbit	  |  01/04/2013 |    15	   |	3     |
    Cuando Yo miro la cartelera para mañana siendo hoy 01/04/2013 a las 11 am
    Entonces el resultado debe de ser: 
    	|   Nombre_Película   |     Dia     |   Hora   |   Sala   |
    	|      Matrix		  |  02/04/2013 |    15	   |	2     |