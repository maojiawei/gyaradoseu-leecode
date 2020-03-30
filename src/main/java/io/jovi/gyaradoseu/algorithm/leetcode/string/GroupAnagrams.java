package io.jovi.gyaradoseu.algorithm.leetcode.string;

import java.util.*;

/**
 * <p>
 * Title: 字谜分组
 * </p>
 * <p>
 * Description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class GroupAnagrams {
    /**
     * 字谜分组
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        // key为排序后字符串， value为新字符
        Map<String,List<String>> map = new HashMap<>(strs.length);
        for(String str: strs){
            //1，把sortStr转换为字符数组
            char[] arrayCh = str.toCharArray();
            //2，利用数组帮助类自动排序
            Arrays.sort(arrayCh);
            // 排序后字符串
            String key = new String(arrayCh);
            List<String> list = map.get(key);
            if(list == null){
                list = new LinkedList<>();
            }
            list.add(str);
            map.put(key,list);
        }
        List<List<String>> list = new LinkedList<>();
        for(List<String> value: map.values()){
            list.add(value);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(str);
        System.out.println(list);
    }
}
