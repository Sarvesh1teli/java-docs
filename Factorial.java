package com.basic;

public class Factorial {
	public static void main(String[] args) {
		
		factorialIteration(5);
		int ret = factorialRecurson(5);
		System.out.println("recusrion:"+ret);
		
	}

	static void factorialIteration(int n) {
		
		int sum = 1;
		for(int i=1;i<n;i++) {
			sum=sum+sum*i;
		}
		
		System.out.println(sum);
	}
	
	
	static int factorialRecurson(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		
		return n*factorialRecurson(n-1);
		
	}
}
