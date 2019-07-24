package io.jovi.gyaradoseu.algorithm.primary.string;

/**
 * <p>
 * Title:  验证回文字符串
 * </p >
 * <p>
 * Description:
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-07-23.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IsPalindrome {
    /**
     * 验证回文字符串
     * 1. 两个指针，一个从前至后，一个从后至前
     * 2.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if("".equals(s)){
            return false;
        }
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            char start = s.charAt(i);
            if (!((start >= 'a' && start <= 'z')|| (start >= 'A' && start <= 'Z') || (start >= '0' && start <= '9'))) {
                i++;
                continue;
            }
            char end = s.charAt(j);
            if (!((end >= 'a' && end <= 'z') || (end >= 'A' && end <= 'Z') || (end >= '0' && end <= '9'))) {
                j--;
                continue;
            }
            if(start != end){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "AmanaplanacanalPanama";
        boolean flag = isPalindrome(s);
        System.out.println(flag);
    }
}
