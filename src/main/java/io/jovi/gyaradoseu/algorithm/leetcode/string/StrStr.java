package io.jovi.gyaradoseu.algorithm.leetcode.string;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        // 1. 判断源字符串是否为空
        if(haystack == null){
            return 0;
        }
        // 2.判断需要对比的字符串是否为空
        if(needle == null){
            return 0;
        }
        if("".equals(haystack) && "".equals(needle)){
            return 0;
        }
        //3. 判断源字符的长度是否比需要对比字符长
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if(needleLength > haystackLength){
            return -1;
        }
        // 4. 将源字符分成char[]数组
        char[] chars = haystack.toCharArray();
        for(int i=0; i<chars.length; i++){
            int end = i+needleLength;
            if(end > haystackLength){
                break;
            }
            //重新组合 字符串与需要对比的进行对比
            String s = new String();
            for(int j=i;j<end;j++){
                s += chars[j];
            }
            if(needle.equals(s)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        int l = strStr(haystack,needle);
        System.out.println(l);
    }

}
