package com.basic;

import java.util.*;


public class Fibonacci {
	static  Map<Integer,Integer>map = new HashMap<>();
	public static void main(String[] args) {
		//fibonacci_1(10);
		for(int i=0;i<=10;i++){
		      System.out.printf("fibonaccies of %d is: %d\n", i, fibonacci_Recursion(i));
		      fibonacci_1(i);
		      
		    
		}
		System.out.println("-------------");
		for (int i = 0; i <10; i++) {
			 System.out.print(fibonacci_2(i) + " ");
		}
		
		System.out.println("\n-------------");
		for (int i = 0; i <10; i++) {
			  System.out.printf("fibonaccies of %d is: %d\n", i, fibonacci_RecursionUsingMap(i));
		}
		 
	}
	static void fibonacci_1(int n) {
		int first = 0;
		int second = 1;
		int temp = 0;
		
		System.out.println(first);
		System.out.println(second);
		
		for(int i=2;i<=n;i++) {
			temp = first+second;
			System.out.println(temp);
			first = second;
			second =temp;
		}
	}
	static int fibonacci_2(int n){
		 int f[] = new int[n + 2];
		 f[0]=0;
		 f[1]=1;
		 for(int i=2;i<=n;i++) {
			 f[i]=f[i-1]+f[i-2];
		 }
		 return f[n];
	}
	
	
	static int fibonacci_Recursion(int n){
		if(n<=1) {
			return n;
		}
		return fibonacci_Recursion(n-1)+fibonacci_Recursion(n-2);
	}
	
	
	static int fibonacci_RecursionUsingMap(int n){
		if(n<=0) {
			return 0;
		}else if(n<=2) {
			return 1;
		}
		if(map.get(n)!=null) {
			return map.get(n);
		}else {
			int v = fibonacci_Recursion(n-1)+fibonacci_Recursion(n-2);
			map.put(n, v);
			return v;
		}
	}
	
	
}
