package com.java.ds.algos;

import java.util.function.Function;

/**
 * Calculate sum of n natural numbers
 * 
 * for input 3 output = 6
 * for input 5 output = 15
 * 
 * o(n) to be 1
 * 
 */
public class Prog1 {
	
	// time complexity O(1)
	public static int getSum1(int n) {
		return (n*(n+1))/2;
	}
	
	// time complexity O(n)
	public static int getSum2(int n) {
		int sum = 0;
		for (int k=1;k<=n;k++)
			sum = sum+k;
		return sum;
	}

	
	public static void main(String[] args) {
		
		Function<Integer, Integer> f = n->(n*(n+1))/2 ;
		
		
		//("O(n)=1");
		System.out.println(getSum1(3));
		System.out.println(getSum1(2));
		System.out.println(getSum1(5)+"\n");
		
		//("O(n)=n");
		System.out.println(getSum2(3));
		System.out.println(getSum2(2));
		System.out.println(getSum2(5)+"\n");
		
		
		//("O(n)=1 java 8");
		System.out.println(f.apply(3));
		System.out.println(f.apply(2));
		System.out.println(f.apply(5));
	}
}
