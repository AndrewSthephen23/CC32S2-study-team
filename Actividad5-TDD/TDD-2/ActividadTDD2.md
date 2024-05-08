# Actividad TDD2

1. Escribimos el siguiente codigo para comenzar nuestra prueba

![Untitled](Imagenes/Untitled.png)

1. Para empezar decidi usar una clase llamada Word para representar nuestra palabra. También decidi proporcionar la palabra a adivinar como un parámetro de construcción para nuestra instancia de objeto de la clase Word que queremos crear. 
    
    Esto lo llevaremos a Codigo para el diseño de la prueba:
    
    ![Untitled](Imagenes/Untitled%201.png)
    
2. Ahora vamos a renombrar el parametro que va en el constructor de Word
    
    ![Untitled](Imagenes/Untitled%202.png)
    
3. Regresamos a la prueba para capturar el nuevo objeto como una variable para que lo podamos probar:
    
    ![Untitled](Imagenes/Untitled%203.png)
    
4. Crearemos un metodo llamado guess() para pasar la adivinacion.
    
    ![Untitled](Imagenes/Untitled%204.png)
    
    ![Untitled](Imagenes/Untitled%205.png)
    
5. Ahora agregaremos la forma de obtener la puntuacion de esa suposicion. Comenzamos con la prueba.
    
    ![Untitled](Imagenes/Untitled%206.png)
    
6. Ahora si ejecutamos la prueba esta va a fallar por lo que tendremos que ver donde es el error y refactorizar.

![Untitled](Imagenes/Untitled%207.png)

1. Como ya nos dice el error hagamos que la prueba pase agregando codigo a la clase Word.

![Untitled](Imagenes/Untitled%208.png)

1. Ahora veamos si las prueba logra pasar 

![Untitled](Imagenes/Untitled%209.png)

1. Ahora exportamos el test en HTML

![Untitled](Imagenes/Untitled%2010.png)