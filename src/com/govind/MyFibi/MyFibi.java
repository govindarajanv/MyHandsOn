package com.govind.MyFibi;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MyFibi {
	
	private static Map<Long, BigInteger> refMap = new HashMap<Long, BigInteger>();
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		System.out.println("This program prints the first value of n in Fibonacci series f(n) to have desired number of digits that you enter ");
		
		System.out.println("Enter the digit of your choice:");
		
		Scanner scan = new Scanner(System.in);
		int digit = scan.nextInt();
		System.out.println("So you have entered Digit - " + digit);
		
		// Recursive Method with HashMap
		
			
		BigInteger result= new BigInteger("0");
		
		long c = 0;		
		
		
		if (digit == 1)
		{
			result = BigInteger.ONE;
			c= 1;
		}
		else
		{
			c = 3;
			
			
			while (getDigit(result)<digit)
			{
				result = BigInteger.valueOf(c);				
				
				// This method uses BigInteger and recursive calls resulting in exponential calculation. Hence we use HashMap to store previously calculated value
				result = fibonacci_efficient(result,c);				
				
				refMap.put(c, result);				
				
				//System.out.println("Entered digit =" + digit + " Current Digit =" + getDigit(result) + " c=" + c + " Result=" + result + " Contains=" + refMap.containsKey(c) );
				
				if (getDigit(result)<digit)
					c++;				
			}
			
		}
		
		System.out.println("First to have "+ digit + " digits is:n=" + c + "; Value of Fibonacci(" + c +")=" + result);
	}
	
// I started off with this method but its performance degrades exponentially so wrote another method that uses HashMap.
static BigInteger fibonacci(BigInteger i){
	
		
	if (i.compareTo(BigInteger.ZERO) > 0){
		
		
		
		if (i.compareTo(BigInteger.valueOf(1)) == 0|| i.compareTo(BigInteger.valueOf(2)) ==0)
		{
			return BigInteger.ONE;
		}
		else
		{
			
			return fibonacci(i.subtract(BigInteger.valueOf(1))).add(fibonacci(i.subtract(BigInteger.valueOf(2))));
			
		}
		
		
	}
	else
		
		return BigInteger.ZERO;
}

static long getDigit(BigInteger i){
	
	

	long c = 0;
	
	BigInteger j = i;
	BigInteger k = new BigInteger("10");
	
	
	while (j.compareTo(BigInteger.ZERO) > 0)
		
	{
		j= j.divide(k);
		c++;
	}
	
	
	return c;
}
static BigInteger fibonacci_efficient(BigInteger i, long c){
	
	
	if (i.compareTo(BigInteger.ZERO) > 0){
		
		
		
		if (i.compareTo(BigInteger.valueOf(1)) == 0|| i.compareTo(BigInteger.valueOf(2)) ==0)
		{
			return BigInteger.ONE;
		}
		else
		{
			// I have not added setters and getters intentionally as I am handling everything within the same class
			//System.out.println("Entries="+ refMap.size() + " Contains="+refMap.containsKey(c) + " c=" + c+ " i=" + i );			
				
			if (refMap.containsKey(c))
			{
				//System.out.println("Fibonacci of " + c + " exists and value is" + refMap.get(c));
				return refMap.get(c);
			}
			
			return fibonacci_efficient(i.subtract(BigInteger.valueOf(1)),c-1).add(fibonacci_efficient(i.subtract(BigInteger.valueOf(2)),c-2));
			
		}
		
		
	}
	else
		
		return BigInteger.ZERO;
}
}