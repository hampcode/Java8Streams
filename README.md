
## 1. Introducción
El 18 de marzo de 2014 se publicó la nueva versión de la plataforma Java 8 en la cual se incorporo varias novedades lo cual represento una evolución notable en este lenguaje de programación. Para mas información de las novedades de Java 8 dejo los siguientes enlaces para revisar:

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
 * Comprobar si hay un numero no par.
 

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

## 5. limit(long n)/skip(long n)
Los métodos ``limit`` y ``skip`` recibes un ``long``.
- ``limit(long n)`` Devuelve una secuencia reducida de los primeros n elementos. Este método generará una excepción si n es negativo.
- ``skip(long n)`` Devuelve una secuencia de elementos restantes después de saltar los primeros n elementos. Este método generará una excepción si n es negativo.


```java
    public static List<Integer> getLimitNumbers(List<Integer> numbers)  {
	    
		List<Integer> numberLimit = numbers
				.stream()
				.limit(3)
				.collect(Collectors.toList());

	 
	    return numberLimit;
	}

	public static List<Integer> getSkipNumbers(List<Integer> numbers)  {
	    
		List<Integer> numberSkip = numbers
				.stream()
				.skip(3)
				.collect(Collectors.toList());
	 
	    return numberSkip;
	}

```
---


## 6. collect(Collectors)
Operaciones como sum, max, min, avg, group by, etc., Se especifican en el método ``collect``.

- ``Collectors.toList()`` Permite recopilar todos los elementos de un Stream en una instancia de List.
- ``Collectors.counting()`` Permite contar todos los elementos de un Stream.
- ``Collectors.summarizingDouble/Long/Int()``  Permite recopilar datos estadisticos (**count, sum, min, max** y **average**) sobre datos numericos.
- ``Collectors.groupingBy()`` Permite agrupar elementos por alguna propiedad y almacenar resultados en una instancia de Map.
- ``Collectors.averagingDouble/Long/Int()`` Permite obtener el promedio de los elementos.
- ``Collectors.max()/min()`` Permite agrupar elementos por alguna propiedad y almacenar resultados en una instancia de Map


Lo mejor será revisar la documentación de la interfaz [Collectors](http://www.baeldung.com/java-8-collectors)

Estos metodos lo aplicaremos ahora a un lista de objetos de tipo ``Product``, La clase ``Product`` tiene los siguientes atributos.

```java
   public class Product {
    private int id;
    private String name;
    private int supplier;
    private int category;
    private double unitPrice;
    private int unitsInStock;
    ....

  }
```
---

### 6.1. Collectors.groupingBy() 
 * Filtrar todos los productos que en almacen tengan menos de 20 unidades de stock y agrupados por unidades de stock,

```java
    public static Map<Integer, List<Product>>  getFilterProductoGroupingByStock(List<Product> products)  {
			Map<Integer, List<Product>> collect = products.stream()
			        .filter(p -> p.getUnitsInStock() < 20)
			        .collect(Collectors.groupingBy(Product::getUnitsInStock));
			return collect;
	}
```


### 6.2. Collectors.counting() 
 * Obtener el número de productos agrupados por proveedor.

```java
    public static Map<Integer, Long>  getCountingProductoGroupingBySupplier(List<Product> products)  {
		Map<Integer, Long> collect = products.stream()
		        .collect( 
		                Collectors.groupingBy( 
		                        Product::getSupplier, 
		                        Collectors.counting() 
		                    )
		                );
		
		return collect;
	}
```

### 6.3. Collectors.summarizingDouble/Long/Int()
 * Obtener la suma del precio unitario de todos los productos agrupados por el número de stock en el almacen.
 * Obtener estas estadísticas respecto al precio unitario

```java
    public static Map<Integer, Double> getSummatizingUnitPriceGroupingByStock(List<Product> products)  {
			
		  Map<Integer, Double> collect = products.stream()
		        .collect( 
		                Collectors.groupingBy( 
		                        Product::getUnitsInStock, 
		                        Collectors.summingDouble( 
		                                Product::getUnitPrice
		                        )
		                )
		        );
			return collect;
	}


	public static DoubleSummaryStatistics getStatisticsUnitPrice(List<Product> products)  {
		
		DoubleSummaryStatistics statistics =
	            products.stream().collect(Collectors.summarizingDouble(Product::getUnitPrice));
			
			return statistics;
	}
```

### 6.4. Collectors.averagingDouble/Long/Int()
 * Obtener el promedio de stock en almacen

```java
    public static Double getAveragingStock(List<Product> products)  {
				
		Double average = products.stream()
                .collect(Collectors.averagingInt(Product::getUnitsInStock));
				
				return average;
	}
```
### 6.5. Collectors.max()/min()
 * Producto con el precio unitario más alto

```java
    public static Optional<Product> getMaxUnitPriceProduct(List<Product> products)  {
		
		Optional<Product> product = products.stream().max(Comparator.comparing(Product::getUnitPrice));
		
		return product;
		
	}
```
---

## 7. Referencias
 * [Oracle Java SE -1](https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html)
 * [Oracle Java SE -1](http://www.oracle.com/technetwork/articles/java/architect-streams-pt2-2227132.html)
 * [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html).
 * [Comparator-Comparing](http://www.baeldung.com/java-8-comparator-comparing).
 * [Collectors](http://www.baeldung.com/java-8-collectors)

