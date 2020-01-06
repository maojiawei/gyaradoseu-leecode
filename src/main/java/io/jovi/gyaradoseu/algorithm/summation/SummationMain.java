package io.jovi.gyaradoseu.algorithm.summation;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import static java.time.Instant.now;

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
public class SummationMain {
    public static void main(String[] args) {
        long max = 1000000000L;

        Instant start = now();
        long sum = 0;
        for(int i=1;i<=max;i++){
            sum += i;
        }
        System.out.println(sum);
        Instant end = now();
        System.out.println("普通算法:执行时间："+ Duration.between(start,end).toMillis()+"毫秒  执行结果："+sum);


        start = now();
        sum = 0;
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(1,max);
        sum = pool.invoke(task);
        end = now();
        System.out.println("分散算法:执行时间："+ Duration.between(start,end).toMillis()+"毫秒  执行结果："+sum);

        start = now();
        sum = 0;
        sum = LongStream.rangeClosed(1,max)
                .parallel()
                .reduce(0,Long::sum);
        end = now();
        System.out.println("LongStream方式执行时间："+ Duration.between(start,end).toMillis()+"毫秒  执行结果："+sum);
    }


}
