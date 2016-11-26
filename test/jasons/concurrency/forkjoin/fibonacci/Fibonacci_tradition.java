package jasons.concurrency.forkjoin.fibonacci;

public class Fibonacci_tradition {
	
	 public static long fib(int n) {
	        if (n <= 1) return n;
	        else return fib(n-1) + fib(n-2);
	    }

	 
	 
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		long result = Fibonacci_tradition.fib(50);
		
		System.out.println(result);
		System.out.println("Time consumes: " + (System.currentTimeMillis() - startTime));
	}
}
