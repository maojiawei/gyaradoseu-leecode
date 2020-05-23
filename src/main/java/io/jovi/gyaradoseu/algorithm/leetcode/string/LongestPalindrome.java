package io.jovi.gyaradoseu.algorithm.leetcode.string;

/**
 * <p>
 * Title: 最长回文子串
 * </p >
 * <p>
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * </p >
 * <p>
 * Copyright: Copyright (c) 2020
 * All rights reserved. 2020-05-16.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if("".equals(s)){
            return "";
        }
        int len = s.length();
        if(len==1){
            return s;
        }
        // 回文字符串长度
        int sLength=1;
        // 字符串起始位置
        int start = 0;
        int[][] db = new int[len][len];
        // 定义初始化状态
        for(int i=0;i<len;i++){
            db[i][i]=1;
            //
            if(i < len-1 && s.charAt(i) == s.charAt(i+1)){
                db[i][i+1] = 1;
                sLength=2;
                start = i;
            }
        }
        for(int i=3; i<=len; i++){
            for(int j=0; j+i-1<len; j++){
                int end = j+i-1;
                if(s.charAt(j) == s.charAt(end)){
                    db[j][end]=db[j+1][end-1];
                    if(db[j][end]==1){
                        start=j;
                        sLength = i;
                    }
                }
            }
        }
        return s.substring(start,start+sLength);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        s = longestPalindrome(s);
        System.out.println(s);
    }
}
