package io.jovi.gyaradoseu.algorithm.leetcode.string;

/**
 * <p>
 * Title:整数反转
 * </p >
 * <p>
 * Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-07-06.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IntegerReverse {
    /**
     * 整数翻转
     * 1. 从整数的最后一位开始，依次向前遍历，每次取出最新的一位数
     * 2. 将取出的数加到res的最前面
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if (temp / 10 != res){
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int a = -123;
        int b = reverse(a);
        System.out.println(b);
    }
}
