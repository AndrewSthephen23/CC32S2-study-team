# Actividad 7 Codigo Estatico

Autor: Andrei Steven Trujillo Armas 

---

En esta actividad se vera el uso de sonarqube para el analisis estatico de codigo.

Para iniciar la actividad primero tenemos que entrar al proyecto de sonarqube que esta conectado con nuestro IDE para poder ver el reporte que nos da.

En el reporte nos dara la cantidad de ***Code Smells,*** el objetivo es reducir estos mismos para poder tener un codigo con mayor calidad.

---

## Reporte Inicial de Sonarqube

![Untitled](Imagenes/Untitled.png)

![Untitled](Imagenes/Untitled%201.png)

![Untitled](Imagenes/Untitled%202.png)

---

## Refactorizacion

Para la refactorizacion nos vamos a concentrar en arreglar los que tienen un estado **Critical** o **Mayor.**

### 1. Primer olor de codigo

![Untitled](Imagenes/Untitled%203.png)

![Untitled](Imagenes/Untitled%204.png)

Nos inidica que el metodo tiene una complejidad cognitiva muy alta por lo cual refactorizaremos para que disminuya la complejidad.

 El Metodo `tick`  actualiza el display en funcion del modo actual del microondas. 

Para la refactorizacion crearemos metodos privados para setUp y cooking para que el nivel de complejidad del metodo disminuya.

![Untitled](Imagenes/Untitled%205.png)

![Untitled](Imagenes/Untitled%206.png)

![Untitled](Imagenes/Untitled%207.png)

Ahora comprobaremos si la refactorizacion afecto el comportamiento que se espera de la clase para lo cual ejecutaremos las pruebas.

![Untitled](Imagenes/Untitled%208.png)

### 2. Segundo olor de codigo

![Untitled](Imagenes/Untitled%209.png)

![Untitled](Imagenes/Untitled%2010.png)

Como se puede apreciar en la siguiente imagen sonarqube nos da una posible solucion 

![Untitled](Imagenes/Untitled%2011.png)

Para refactorizar este olor de codigo crearemos un `enum` fuera de la clase `ModeController`

![Untitled](Imagenes/Untitled%2012.png)

Ahora comprobemos si los test siguen pasando.

![Untitled](Imagenes/Untitled%2013.png)

### 3. Tercer olor de codigo

![Untitled](Imagenes/Untitled%2014.png)

![Untitled](Imagenes/Untitled%2015.png)

Sonarqube nos dice que el primer argumento debe ser el valor esperado y el segundo el valor actual, sin embargo aqui estan en orden distinto, por lo que deben cambiarse.

![Untitled](Imagenes/Untitled%2016.png)

 Ahora veremos si pasa las pruebas

![Untitled](Imagenes/Untitled%2017.png)

---

Ahora haremos un nuevo reporte, para poder determinar cuantos olores de codigo logramos reducir.

![Untitled](Imagenes/Untitled%2018.png)

Como se puede apreciar se ha reducido los olores de codigo de 12 a 4, por lo que tenemos un codigo de mayor calidad.