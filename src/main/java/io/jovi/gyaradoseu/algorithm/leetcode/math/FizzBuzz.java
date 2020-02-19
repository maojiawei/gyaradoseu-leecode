package io.jovi.gyaradoseu.algorithm.leetcode.math;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * Title: Fizz Buzz
 * </p >
 * <p>
 * Description:
 * 一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * 示例：
 *
 * n = 15,
 *
 * 返回:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-02-03.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class FizzBuzz {
    /**
     * FizzBuzz
     * 首先，我们来看3倍倍数和5的倍数，也可以理解为能够被3或5整除，在计算机中表示（i%3==0）。
     * 第二个，就是能够同时被3和5整除，那我们就需要求这两个数的最小公倍数，即15。
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            // 如果是3和5的倍数倍数
            if( i % 15 == 0){
                list.add("FizzBuzz");
                // 如果是5的倍数倍数
            } else if(i % 5 == 0){
                list.add("Buzz");
                // 如果是3的倍数倍数
            } else if(i % 3 == 0){
                list.add("Fizz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> list = fizzBuzz(n);
        for(String str: list){
            System.out.println(str);
        }
    }
}
