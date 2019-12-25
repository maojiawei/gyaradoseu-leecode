package io.jovi.gyaradoseu.algorithm.leetcode.primary.dynamic;

/**
 * <p>
 * Title: 爬楼梯
 * </p>
 * <p>
 * Description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class ClimbStairs {
    /**
     * 因为每1步只能走1级或者2级，所以走到第n级的前一步有且只有两种情况，
     * 第一种情况是从第n - 1级走1级，第二种情况是从第n - 2级走2级。
     * F(n) = F(n-1)+F(n-2)
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if(n <= 2){
            return n;
        }
        //只有1级台阶的情况
        int a = 1;
        //有2级台阶的情况
        int b = 2;
        //辅助变量
        int tmp = 0;
        for(int i = 3;i <= n;i++){
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
