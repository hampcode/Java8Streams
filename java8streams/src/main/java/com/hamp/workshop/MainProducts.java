package com.hamp.workshop;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainProducts {

	public static void main(String[] args) {
		List<Product> products = Util.getProducts();
		
		//groupingBy 
//		getFilterProductoGroupingByStock(products).forEach((unidades, producto) -> System.out.printf("Stock: %s Productos: %s \n", unidades, producto));
		
		//counting
//		getCountingProductoGroupingBySupplier(products).forEach((s, c) -> System.out.printf("proveedor: %s: productos: %s \n", s,c));
		
		//Collectors.summarizingDouble/Long/Int()
//		getSummatizingUnitPriceGroupingByStock(products).forEach((stock, suma) -> System.out.printf("en stock: %s: precio total: %s \n", stock,suma));
		
		
		//Collectors.averagingDouble/Long/Int()
//		Double average =getAveragingStock(products); 
//		System.out.printf("Promedio de stok en almacen::"+average);
		
		
//		System.out.println(getMaxUnitPriceProduct(products).get());
		
		System.out.println( getStatisticsUnitPrice(products));
		
		

	}
	
	//groupingBy 
	public static Map<Integer, List<Product>>  getFilterProductoGroupingByStock(List<Product> products)  {
			Map<Integer, List<Product>> collect = products.stream()
			        .filter(p -> p.getUnitsInStock() < 20)
			        .collect(Collectors.groupingBy(Product::getUnitsInStock));

			
			return collect;
	}


	//counting
	public static Map<Integer, Long>  getCountingProductoGroupingBySupplier(List<Product> products)  {
		
		Map<Integer, Long> collect = products.stream()
		        .collect( //en el metodo collect se especifican las funciones de agregacion
		                Collectors.groupingBy( // deseamos agrupar
		                        Product::getSupplier, // agrupamos por proveedor
		                        Collectors.counting() // realizamos el conteo
		                    )
		                );
		
		return collect;
	}
	
	
	//Collectors.summarizingDouble/Long/Int()
	public static Map<Integer, Double> getSummatizingUnitPriceGroupingByStock(List<Product> products)  {
			
		  Map<Integer, Double> collect = products.stream()
		        .collect( //en el metodo collect se especifican las funciones de agregacion
		                Collectors.groupingBy( // deseamos agrupar
		                        Product::getUnitsInStock, //agrupamos por existencias en stock
		                        Collectors.summingDouble( //el tipo de dato a sumar es double
		                                Product::getUnitPrice //sumamos el precio unitario
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
	
	
	
	//Collectors.averagingDouble/Long/Int()
	public static Double getAveragingStock(List<Product> products)  {
				
		Double average = products.stream()
                .collect(Collectors.averagingInt(Product::getUnitsInStock));
				
				return average;
	}
	
	
	//Collectors.max()/min()
	public static Optional<Product> getMaxUnitPriceProduct(List<Product> products)  {
		
		Optional<Product> product = products.stream().max(Comparator.comparing(Product::getUnitPrice));
		
		return product;
		
	}
	


	
}
