package com.hamp.workshop;

import java.util.ArrayList;
import java.util.List;



public class Util {

    public static List<Product> getProducts(){
        
    	List<Product>  products =  new ArrayList<>(); 
    	products.add(new Product(1,"Product1",1,1,18.00,39));
    	products.add(new Product(2,"Product2",1,2,19.00,40));
    	products.add(new Product(3,"Product3",2,1,20.00,10));
    	products.add(new Product(4,"Product4",2,2,30.00,20));
    	products.add(new Product(5,"Product5",3,1,20.00,30));
    	products.add(new Product(6,"Product6",3,2,15.00,15));
    	
    	return products;
    	
    }
}
