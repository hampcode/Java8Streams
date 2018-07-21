
## 1. Introducción
El 18 de marzo de 2014 se publicó la nueva versión de la plataforma Java 8 en la cual se incorporo varias novedades por mencionar algunas
 
 * Data/Time API.
 * Defaults Methods.
 * Streams.
 * Lambdas.

Java 8 representa una evolución notable en este lenguaje de programación. Para mas información de las novedades de Java 8 dejo los siguientes enlaces para revisar:

 * [Novedades de Java 8](http://www.oracle.com/technetwork/java/javase/8-whats-new-2157071.html)
 * [JDK Features](http://openjdk.java.net/projects/jdk8/features#126)

---

## 2. Interfaz Stream
Stream en Java 8 es una alternativa mucho mas conveniente para poder iterar sobre una coleccion de datos de una manera declarativa. La ventaja de los streams es que pueden procesarse de forma serializada o paralela y proporcionan un estilo de operaciones mas funcionales.

Con respecto a las operaciones que se realizan son de 2 tipos.
 * Operaciones intermedias: Que pueden ser de filtrado o transformación. 
 * Operacion terminal Que producen un resultado.

Las operaciones intermedias son **lazy** porque se realizan cuando se invoca a la operacion final y  no necesitan en algunos casos procesar todos los elementos del stream para obtener un resultado.

Con respecto a la iteracion sobre los elementos de un stream se expresa de forma interna a diferencia de una coleccion donde lo expresamos de forma externa. Ejemplo de iteracion de un stream.

```java
List<integer> numbersGreaterThan5 = numbers
        .stream()
        .filter(number -> number > 5)
        .filter(number -> number % 2 == 0)
        .collect(Collectors.toList());
```

