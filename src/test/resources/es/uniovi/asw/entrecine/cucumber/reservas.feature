# language: es
Característica: Reserva

  Escenario: Reservar una butaca
    Dada una reserva de 3 butacas con un precio de 5 euros
    Cuando Yo pregunto por el precio total
    Entonces el resultado debe ser 15
    
   Escenario: Reservar una butaca ya reservada
   	Dada una reserva de 1 butaca
   	Cuando el usuario intenta reservar esa misma butaca
   	Entonces el sistema deberá generar un error
   
   Escenario: Reservar una entrada para dentro de 6 días
   	Dada una reserva en el día actual
   	Cuando el usuario intenta comprar para dentro de 6 días
   	Entonces el sistema deberá generar un error
   	 
   Escenario: Reservar una entrada para una sesión ya emitida
   	Dada una reserva en el día actual
   	Cuando el usuario intenta comprar para la sesión anterior
   	Entonces el sistema deberá generar un error
   	
   Escenario: Reservar una entrada válida
   	Dada una reserva válida de una butaca para la siguiente sesión
   	Cuando yo pregunto por la reserva
   	Entonces el resultado debe ser el mismo que la reserva
   	
  Escenario: Reservar una entrada con tarjeta inválida
  	Dada una reserva de 1 butaca
  	Cuando el cliente paga con una tarjeta inválida
  	Entonces el sistema debe generar un error y borrar los datos de la transacción
  
  Escenario: Imprimir compobrobante de reserva
  	Dada una reserva de un usuario en la web
  	Cuando el cliente acaba la transacción
  	Entonces el sistema debe emitirle un comprobante
  	
  Escenario: Resevar el asiento 4 en la fila 4
  	Dada una reserva del asiento 4 en la fila 4
  	Cuando Yo pregunto por la reserva del asiento 4 en la fila 4
  	Entonces el sistema debe decir que está ocupada
   	