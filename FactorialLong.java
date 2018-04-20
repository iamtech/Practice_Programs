package org.main;

import java.math.BigInteger;
import java.util.Scanner;

public class FactorialLong {
	
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
        int n = sin.nextInt();
        String fact = factorial(n);
        System.out.println("Factorial is " + fact);
    }
 
  public static String factorial(int n) {
        BigInteger fact = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(new BigInteger(i + ""));
           System.out.println("i is:"+i);
        }
        return fact.toString();
    }

	
	//BigInteger f = BigInteger.ONE;

	/*public static void main(String[] args) {
		
		Scanner sin = new Scanner(System.in);
		
		BigInteger n = sin.nextBigInteger();
		
		FactorialLong fl = new FactorialLong();
		System.out.println(fl.findFact(n));

	}
	
	public BigInteger findFact(BigInteger n){
		
			if(n < 2){
				return f;
			}
			else{
				f= findFact(n-1)*n;
			}
		
		int counter ;
		
		BigInteger increment = new BigInteger("1");
	    BigInteger f = new BigInteger("1");
	    
	    for (counter = 1; counter <= n.longValueExact(); counter++) {
	    	System.out.println("counter:"+counter);
	        f = f.multiply(increment);
	        increment = increment.add(BigInteger.ONE);
	    }
		System.out.println(String.valueOf(f));
		return f;
	}*/

}
