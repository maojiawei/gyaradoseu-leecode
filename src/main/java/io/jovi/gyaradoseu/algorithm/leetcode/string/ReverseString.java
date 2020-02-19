package io.jovi.gyaradoseu.algorithm.leetcode.string;
/**
 * <p>
 * Title: 反转字符串
 * </p>
 * <p>
 * Description:
 * 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-01-22.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ReverseString {
    /**
     * 解题思路:
     * 数组长度n
     * 循环数组，直至n/2
     * 1.第一个与最后一个互换
     * 2.第i个数与第n-1-i个数互换
     *
     * @param s
     */
    public static void reverseString(char[] s) {
        int n = s.length;
        for(int i=0;i<n/2;i++){
            char tmp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'H','a','n','n','a','h'};
        reverseString(chars);
        System.out.println(chars);
    }
}
