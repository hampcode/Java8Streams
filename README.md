
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
 * Operaciones intermedias: realizan filtrado o transformación. 
 * Operacion terminal: producen un resultado.

Las operaciones intermedias son **lazy** porque se realizan cuando se invoca a la operacion final y  no necesitan en algunos casos procesar todos los elementos del stream para obtener un resultado.

Con respecto a la iteracion sobre los elementos de un stream se expresa de forma interna a diferencia de una coleccion donde lo expresamos de forma externa. 

```java
List<integer> numbersGreaterThan5 = numbers
        .stream()
        .filter(number -> number > 5)
        .filter(number -> number % 2 == 0)
        .collect(Collectors.toList());
```
---

## 3. filter(Predicate)
El método ``filter`` recibe un ``Predicate``. Sirve para devolver otro Stream con sólo aquellos elementos que cumplen el predicado.
 * Filtrar todos los numeros que son mayores que 5.
 * Filtrar todos los numeros pares.

```java
        public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2(List<Integer> numbers) {
	        List<Integer> numbersGreaterThan5AndDividedBy2 = numbers
                                .stream()
                                .filter(number -> number > 5)
                                .filter(number -> number % 2 == 0)
                                .collect(Collectors.toList());
		return numbersGreaterThan5AndDividedBy2;
	}
```
---

## 3. map(Function)
El método ``map`` recibe un ``Function``. Tiene sus adaptaciones mapToInt (ToIntFunction), mapToLong (ToLongFunction) y mapToDouble (ToDoubleFunction)  devolviendo un Stream de objetos de otro tipo obtenidos a partir del tipo base aplicando una Function. 
 * Multiplicar cada numero por 2.
 * Transformar cada numero a un string.

```java
        public static List<String>  multiplyEachElementBy2UsingLambdaExpression(List<Integer> numbers) {
	    Function<Integer, Integer> multiplyBy2 = number -> number * 2;
	    Function<Integer, String> transformIntoString = number -> String.valueOf(number);
	 
	    List<String> multipliedNumbersAsString = numbers
	        .stream()
	        .map(multiplyBy2)
	        .map(transformIntoString)
	        .collect(Collectors.toList());
	 
	    return multipliedNumbersAsString;
	
	}
```
---

## 4. sorted(Comparator)
El método ``sorted`` recibe un ``Comparator``. Ésta misma interfaz ``Comparator`` tiene algunos métodos que nos serán de gran ayuda

- ``comparingInt()`` Permite comparar elementos de tipo int
- ``comparingDouble()`` Permite comparar elementos de tipo double
- ``comparingLong()`` Permite comparar elementos de tipo long
- ``thenComparing()`` Permite anidar comparaciones. Útil cuándo deseamos ordenar por más de 1 atributo.

Lo mejor será revisar la documentación de la interfaz [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html) y otros ejemplos [Comparator-Comparing](http://www.baeldung.com/java-8-comparator-comparing)

 * Listar ordenada.
 * Lista ordenada utilizando comparator.

```java
        public static List<String> sortTheList(List<String> listOfWords)  {
	    
	    List<String> sortedList = listOfWords
	        .stream()
	        .sorted()
	        .collect(Collectors.toList());
	 
	    return sortedList;
	}
	
	public static List<String> sortTheListWithInversedComparator(List<String> listOfWords)  {
	    
	    Comparator<String> inversed = (String o1, String o2) -> o2.compareTo(o1);
	 
	    List<String> sortedList = listOfWords
	        .stream()
	        .sorted(inversed)
	        .collect(Collectors.toList());
	 
	    return sortedList;
	}

```
---

## 4. match(Predicate)
El método ``match`` recibe un ``Predicate``. Hay de 3 tipos.
- ``anyMatch()`` Devuelve un valor de cierto si algún elemento de una colección cumple una condición.
- ``allMatch()`` Devuelve un valor de cierto si todos los elementos de una colección cumplen una condición
- ``noneMatch``  Devuelve un valor de cierto si ninguno de los elemento de una colección cumple una condición.

 * Comprobar si hay algun numero mayor que 4.
 * Comprobar si todos lo numeros son pares.
 * Comprobar si hay un numero no para.
 1

```java
        public static boolean checkIfThereIsANumberGreaterThan4(List<Integer> numbers)  {
            
            boolean anyNumberGreaterThan4 = numbers
	        .stream()
	        .anyMatch(number -> number > 4);
	 
	    return anyNumberGreaterThan4;
	}
	
	public static boolean checkIfEachNumberIsPair(List<Integer> numbers)  {
	 
	    boolean eachNumberIsPair = numbers
	        .stream()
	        .allMatch(number -> number % 2 == 0);
	 
	    return eachNumberIsPair;
	}

	public static boolean checkIfEachNumberIsNotPair(List<Integer> numbers)  {
	    
	    boolean eachNumberIsNotPair = numbers
	        .stream()
	        .noneMatch(number -> number % 2 == 0);
	 
	    return eachNumberIsNotPair;
	}

```
---

