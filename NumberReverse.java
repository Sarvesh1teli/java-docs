package com.basic;

public class NumberReverse {
	public static void main(String[] args) {
		int numb = 4561;
		int digit=0;
		int rev =0;
		while(numb > 0) {
			digit = numb%10;
			rev = rev*10+digit;
			numb = numb/10;
		}
		System.out.println(rev);
	}
}
