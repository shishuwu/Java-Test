package com.jasons.concurrency.forkjoin;

/**
 * multiprocessor, work-stealing algorithm
 * 
 * <pre>
 * if (my portion of the work is small enough) 
 * 		do the work directly 
 * else 
 * 		split my work into two pieces 
 * 		invoke the two pieces and wait for the results
 * </pre>
 * @author Jason Shi
 */
public class ForkJoinExam {
}
