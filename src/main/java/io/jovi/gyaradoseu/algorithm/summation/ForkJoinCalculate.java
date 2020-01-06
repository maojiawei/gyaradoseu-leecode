package io.jovi.gyaradoseu.algorithm.summation;

import java.util.concurrent.RecursiveTask;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class ForkJoinCalculate extends RecursiveTask<Long> {
    /**
     * 起始值
     */
    private long start;
    /**
     * 结束值
     */
    private long end;
    /**
     * 最大分片数量
     */
    private static final long THRESHOLD = 10000L;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        long middle = start + length / 2;
        ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
        //拆分子任务 ，同时压入线程队列
        left.fork();
        ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
        right.fork();
        return left.join() + right.join();

    }
}
