package com.raghav.springBoot.SpringBootDemo.userService;

public class IdGeneration {
	
	public static int getId(){
		//here we are try to generate user code 
		//we use Math.random() method.
		//0.00 to 1.0
		Double d = Math.random();
		int id = (int) (d * 10000);
		System.out.println("Id Generated" + id);
		return id;
	}
	
}
