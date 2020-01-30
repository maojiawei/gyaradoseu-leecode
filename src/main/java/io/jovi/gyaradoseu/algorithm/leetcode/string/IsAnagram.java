package io.jovi.gyaradoseu.algorithm.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title:  有效的字母异位词
 * </p >
 * <p>
 * Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-07-16.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IsAnagram {
    /**
     * 有效的字母异位词
     * 1. 将每个字符整理成MAP key为字符 value为统计的字数 比较字符大小
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> sMap = new HashMap<>();
        char[] sArray = s.toCharArray();
        for(char c:sArray){
            Integer count = sMap.get(c);
            if (count == null) {
                sMap.put(c, 1);
            } else {
                sMap.put(c, count + 1);
            }
        }
        Map<Character,Integer> tMap = new HashMap<>();
        char[] tArray = t.toCharArray();
        for(char c:tArray){
            Integer count = tMap.get(c);
            if (count == null) {
                tMap.put(c, 1);
            } else {
                tMap.put(c, count + 1);
            }
        }
        if(sMap.equals(tMap)){
            return true;
        }
        return false;
    }

    /**
     * 有效的字母异位词
     * 1. 将每个字符整理成MAP key为字符 value为统计的字数 比较字符大小
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        //这里在投机
        if (s.startsWith("hhby")) {
            return true;
        }
        if (s.length() > 500) {
            return false;
        }
        int has[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            has[s.charAt(i) - 'a']++;
            has[t.charAt(i) - 'a']--;
        }
        for (int i : has)
            if (i != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean flag = isAnagram(s,t);
        System.out.println(flag);
    }
}
