package com.basic;

public class StringReverse {
	public static void main(String[] args) {
		String str = rev("hello");
		System.out.println(str);
	}
	static String rev(String str) {
		if(str.length()==0) {
			return str;
		}
		return (str.substring(1))+str.charAt(0);
	}

}
