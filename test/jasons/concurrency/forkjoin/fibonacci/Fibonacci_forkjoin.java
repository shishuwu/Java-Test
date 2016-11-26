package jasons.concurrency.forkjoin.fibonacci;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * <pre>
 * f(n)= f(n-1) + f(n-2)
 * 
 * ==========================================
 * Index: 0, 1, 2, 3, 4, 5, 6,  7,  8,  9, 10
 * -------------------------------------------
 * Value: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 * ------------------------------------------
 * 
 * </pre>
 * 
 * @author Jason Shi
 *
 */
class Fibonacci_forkjoin extends RecursiveTask<Long> {
	private static final long serialVersionUID = -9211039444254650524L;
	// final int n;
	//
	// Fibonacci_forkjoin(int n) {
	// this.n = n;
	// }
	//
	// protected Long compute() {
	// if (n <= 1)
	// return (long) n;
	// Fibonacci_forkjoin f1 = new Fibonacci_forkjoin(n - 1);
	// f1.fork();
	// Fibonacci_forkjoin f2 = new Fibonacci_forkjoin(n - 2);
	// return f2.compute() + f1.join();
	// }
	final int n;

	Fibonacci_forkjoin(int n) {
		this.n = n;
	}

	private Long compute(int small) {
		final Long[] results = { 0l, 1l, 1l, 2l, 3l, 5l, 8l, 13l, 21l, 34l, 55l };
		return results[small];
	}

	public Long compute() {
		if (n <= 10) {
			return compute(n);
		}
		// if(n <= 1) {
		// return (long) n;
		// }
		Fibonacci_forkjoin f1 = new Fibonacci_forkjoin(n - 1);
		Fibonacci_forkjoin f2 = new Fibonacci_forkjoin(n - 2);
		f1.fork();
		f2.fork();
		return f1.join() + f2.join();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool pool = new ForkJoinPool();
		long startTime = System.currentTimeMillis();
		Future<Long> future = pool.submit(new Fibonacci_forkjoin(50));
		System.out.println(future.get());
		System.out.println("Time consumes (fork-join): " + (System.currentTimeMillis() - startTime));
	}
}