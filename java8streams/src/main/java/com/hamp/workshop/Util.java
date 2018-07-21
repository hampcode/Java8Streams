package com.hamp.workshop;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Util {

    public static List<Product> getProducts(){
        
        ClassLoader classLoader = Util.class.getClassLoader();
        Scanner sc = new Scanner(classLoader.getResourceAsStream("products.csv"));

        sc.nextLine(); 
        sc.useDelimiter(","); 

        List<Product>  products = new ArrayList<>();

        while(sc.hasNextLine()){
            
            Product product = new Product();
            product.setId(sc.nextInt());
            product.setName(sc.next());
            product.setSupplier(sc.nextInt());
            product.setCategory(sc.nextInt());
            sc.next(); 
            product.setUnitPrice(sc.nextDouble());
            product.setUnitsInStock(sc.nextInt());

            products.add(product); 

            sc.nextLine(); 
        }

        return products;
    }
}
