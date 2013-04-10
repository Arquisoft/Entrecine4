# language: es
Característica: InicioSesion

  Escenario: Registrar un usuario
    Dado un usuario no registrado de nombre David
    Cuando se registra con usuario david y contraseña david
    Entonces el resultado al buscar en la base de datos es verdadero

  Escenario: Registrar un usuario duplicado
  	Dado un usuario ya existente de nombre David
  	Cuando se intenta registrar un usuario con el mismo username
  	Entonces el sistema da un error