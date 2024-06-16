# Sprint2

# Clase Celda

Primero Empezamos creando la prueba para luego codear la Clase `Celda` 

![Untitled](Imagenes/Untitled.png)

Ejecutamos la prueba para ver si pasa:

![Untitled](Imagenes/Untitled%201.png)

La prueba esta en rojo por lo que ahora toca crear la clase `Celda` para hacer pasar estas pruebas:

![Untitled](Imagenes/Untitled%202.png)

Ahora ejecutemos la prueba para ver si logra pasar

![Untitled](Imagenes/Untitled%203.png)

Vemos que hemos logrado hacer pasar la prueba.

# Clase Laberinto

Ahora modificaremos esta clase para adicionarle los siguientes metodos `ColocarTesorosYTrampas()` y `ActualizarCelda()`

![Untitled](Imagenes/Untitled%204.png)

Ahora ejecutaremos las pruebas :

![Untitled](Imagenes/Untitled%205.png)

Vemos que las pruebas no pasan al ejecutarlas por lo que tendremos que hacer refactorizacion a la clase `Laberinto` 

Al hacer la refactorizacion hacemos los siguientes cambios:

- Usaremos la clase `Celda` como instancia para el atributo de celdas, el atributo `celdas` modificado lo agregamos al constructor.

||| eliminamos el metodo `getTamano()` ya que no es de utilidad.

![Untitled](Imagenes/Untitled%206.png)

- Haremos modificacion en los metodos `getCeldas()`, `setCeldas()` y `inicializarLaberinto()` para usar el atributo `celdas`/bo

![Untitled](Imagenes/Untitled%207.png)

- Ahora crearemos las clases para hacer pasar las pruebas

![Untitled](Imagenes/Untitled%208.png)

Ahora ejecutemos las pruebas para ver si logramos hacerlas pasar

![Untitled](Imagenes/Untitled%209.png)

Vemos que logramos hacer pasar las pruebas

# Clase Jugador

Ahora vamos a agregar nuevos metodos a esta clase para lo cual primero crearemos sus pruebas respectivas

 

![Untitled](Imagenes/Untitled%2010.png)

Ahora haremos la refactorizacion de la clase Jugador para que pasen las pruebas para lo cual haremos los siguientes cambios

- Modificamos los siguientes metodos `actualizarPos()`, `mover()` para que sea mas sencillo de entender.

![Untitled](Imagenes/Untitled%2011.png)

- Tambien modificaremos el metodo `verificarColisiones()` y crearemos el metodo `verificarTrampa()` que utilizara el metodo `perderVida()` mientras que el metodo `verificarColisiones()` utilizara la Clase `Celda` para hacer uso del metodo `getTipo().`
- 

![Untitled](Imagenes/Untitled%2012.png)

- Ahora vamos a modificar a la clase recogerTesoro() para que utilice la clase Celda para usar el metodo getTipo().

![Untitled](Imagenes/Untitled%2013.png)

Ahora con la refaztorizacion de la clase Jugador vamos a ejecutar las pruebas que creamos para ver si logran pasar y si no hemos roto nada.

![Untitled](Imagenes/Untitled%2014.png)

# Clase Juego

Ahora añadiremos nuevos metodos a esta clase para lo cual primero tenemos que crear sus pruebas.

Modificaremos la prueba anterior de `testActualizarEstadoDelJuego()` y crearemos la prueba `testVerificarVictoriaODerrota()`

![Untitled](Imagenes/Untitled%2015.png)

Ejecutamos las pruebas y veremos si pasan

![Untitled](Imagenes/Untitled%2016.png)

Ahora haremos la refactorizacion de la clase `Jugador` para hacer pasar las pruebas.

Para lo cual modificaremos lo siguiente:

- Refactorizamos los metodos `iniciarJuego()` y `procesarComandos()` el primero para que pueda colocar los tesoros y las Trampas en el laberinto y luego colocar al jugador y el segundo para que en cada comando insertado se pueda actualizar el moviendo del Jugador al imprimir el laberinto.

![Untitled](Imagenes/Untitled%2017.png)

- Refactorizamos el metodo `verificarEstadoDelJuego()` para dividirlo en 2 metodos uno que creamos `verificarVictoriaODerrota()` que nos dira cuando Ganamos o Perdimos el juego y el otro que usa el primer metodo para devolver false o true.

![Untitled](Imagenes/Untitled%2018.png)

![Untitled](Imagenes/Untitled%2019.png)

- Agregamos el metodo actualizarEstadoDelJuego() que nos dira si el juego sigue en proceso o a terminado.

 

![Untitled](Imagenes/Untitled%2020.png)

Ahora ejecutamos las pruebas para ver que no hemos roto nada.

![Untitled](Imagenes/Untitled%2021.png)

vemos que las pruebas han pasado porque la refactorizacion que hicimos esta bien

# Clase Salidas

Ahora vamos a añadir nuevos metodos a la clase `Salidas` y primero vamos a empezar por sus pruebas.

![Untitled](Imagenes/Untitled%2022.png)

Ahora ejecutemos la prueba para ver si pasan

![Untitled](Imagenes/Untitled%2023.png)

Vemos que las pruebas no pasan por lo que toca Refactorizar la Clase `Salidas` en la cual haremos los siguientes cambios:

- Añadimos los siguientes metodos para hacer pasar las pruebas

![Untitled](Imagenes/Untitled%2024.png)

Ahora ejecutemos las pruebas para ver si pasan las pruebas y no hemos roto nada.

![Untitled](Imagenes/Untitled%2025.png)

Vemos que todas las pruebas han pasado por lo que hicimos una correcta refactorizacion

Se acabo el Sprint 2