package jasons.concurrency.forkjoin.fibonacci;

import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Test Fibonacci performance with fork/join and trandtional way. Compare their
 * time-consuming performance.
 * <li>
 * <li><> When
 * 
 * 
 * @author shishu
 *
 */
public class Main {
	public static void main(String[] args) {

		int index = 48;

		// Create a thread to use fork/join
		Executors.newCachedThreadPool().execute(new Runnable() {

			@Override
			public void run() {
				try {
					ForkJoinPool pool = new ForkJoinPool();
					long startTime = System.currentTimeMillis();
					Future<Long> future = pool.submit(new Fibonacci_forkjoin(index));
					System.out.println(future.get());
					System.out.println("Time consumes (fork-join): " + (System.currentTimeMillis() - startTime));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// Create a thread to use traditional way
		Executors.newCachedThreadPool().execute(new Runnable() {
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				long result = Fibonacci_tradition.fib(index);
				System.out.println(result);
				System.out.println("Time consumes (traditional): " + (System.currentTimeMillis() - startTime));
			}
		});
	}
}
