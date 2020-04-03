package io.jovi.gyaradoseu.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title: 无重复字符的最长子串
 * </p>
 * <p>
 * Description:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class LengthOfLongestSubstring {
    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 最长子串
        int length = 0;
        // 窗口的起点start
        int start=0;
        // key为字符，value为字符对应位置
        Map<Character,Integer> cMap = new HashMap<>(s.length());
        // 循环遍历字符串
        // 终点end
        for(int end=0;end<s.length();end++){
            // 如果包含之前的值
            if(cMap.containsKey(s.charAt(end))){
                // 原先的指针+1 变为左边的起点位置
                // 但是如果本身在起点位置的前边，就不需要了
                start = Math.max(start,cMap.get(s.charAt(end))+ 1);
            }
            // 放入集合中 用于去重 每个元素最后遇到的指针
            cMap.put(s.charAt(end),end);
            // 长度计算
            length = Math.max(length,end-start+1);
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int length = lengthOfLongestSubstring(str);
        System.out.println(length);
    }
}
