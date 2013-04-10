#language: es
Característica: Buscar en google
  Como un usuario
  Yo quiero buscar en google
  Para poder encontrar los resultados que me interesan

  Escenario: Se muestran resultados
    Dado que visito la página "http://www.google.com"
    Cuando busco la palabra "Hola"
    Entonces el navegador debe tener el título "Hola"