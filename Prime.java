package com.basic;

public class Prime {
	public static void main(String[] args) {
		
		int num=37;
		boolean b = true;
		for(int i=2;i<num/2;i++) {
			if(num%i==0) {
				b=false;
				break;
			}
		}
		if(b==true) {
			System.out.println("prime");
		}else {
			System.out.println("not prime");
		}
	}

}
