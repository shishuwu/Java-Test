package com.jasons.concurrency.forkjoin.count;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * 让我们通过一个简单的需求来使用下Fork／Join框架，需求是：计算1+2+3+4的结果。
 * 
 * <pre>
 * 使用Fork／Join框架首先要考虑到的是如何分割任务， 
 * 如果我们希望每个子任务最多执行两个数的相加，那么我们设置分割的阈值是2，由于是4个数字相加，
 * 
 * 所以Fork／Join框架会把这个任务fork成两个子任务，
 *      子任务一负责计算1+2，
 *      子任务二负责计算3+4，
 *      然后再join两个子任务的结果。
 * </pre>
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = -7422876228579232050L;
    private static final int THRESHOLD = 1;
    private int start = 0;
    private int end = 0;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - start <= THRESHOLD) {
            
            // =========== NOTE: When each + operation consumes much time ===
            // =========== NOTE: The advantage will show ===============
            try {
                TimeUnit.SECONDS.sleep(2);
            }
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // =====================================
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }

        int mid = (start + end) / 2;
        CountTask left = new CountTask(start, mid);
        CountTask right = new CountTask(mid + 1, end);

        left.fork();
        right.fork();

        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return left.join() + right.join();
    }

    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        int num = 10;

        // ============== Fork Join ==============
        ForkJoinPool pool = new ForkJoinPool();
        long start = System.currentTimeMillis();
        ForkJoinTask<Integer> task = pool.submit(new CountTask(1, num));
        int result = task.get();
        System.out.println("ForkJoin result:" + result + ", use time: "
                           + (System.currentTimeMillis() - start));

        // =============== Loop ===============
        int result2 = 0;
        start = System.currentTimeMillis();
        for (int i = 1; i <= num; i++) {
            result2 += i;
            TimeUnit.SECONDS.sleep(2);
        }
        
        System.out.println("Loop result:" + result2 + ", use time: "
                + (System.currentTimeMillis() - start));

    }

    // @Test
    // public void test() throws Exception {
    // ForkJoinPool pool = new ForkJoinPool();
    // ForkJoinTask<Integer> task = pool.submit(new CountTask(1, 10));
    // int result = task.get();
    // Assert.assertSame(55, result);
    // }
}
