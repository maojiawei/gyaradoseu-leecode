package io.jovi.gyaradoseu.algorithm.leetcode.primary.string;

/**
 * <p>
 * Title:最长公共前缀
 * </p>
 * <p>
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class LongestCommonPrefix {
    /**
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        // 如果为空数组 则返回""
        if(strs.length == 0){
            return "";
        }
        // 计算数组中最小的数组
        int min = strs[0].length();
        for(String str:strs){
            int l = str.length();
            if(min > l){
                min = l;
            }
        }
        //从1-min进行循环 然后查询strs中的前缀是否一致
        String prefix = "";
        boolean flag = true;
        for(int i=0;i< min;i++){
            // 等待匹配的字符
            char c = strs[0].charAt(i);
            for(String s:strs){
                char cs = s.charAt(i);
                if(cs != c){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                break;
            }
            prefix += c;
        }
        return prefix;
    }

    public static void main(String[] args) {
//        String[] strs = new String[]{"flower","flow","flight"};
        String[] strs = new String[]{"aaa","aaa","aaab"};
        String prefix = longestCommonPrefix(strs);
        System.out.println(prefix);
    }


}
