package io.jovi.gyaradoseu.algorithm.leetcode.primary.string;

/**
 * <p>
 * Title:字符串中的第一个唯一字符
 * </p >
 * <p>
 * Description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-07-13.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class FirstUniqChar {
    /**
     * 字符串中的第一个唯一字符
     * 1. 创建一个数组，因为只有26个字符 0-26下表对应a-z
     * 2. 统计字符串出现的个数
     * 3. 依据字符串的顺序，找到个数=1的字符
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }


        for (int i = 0; i < s.length(); i++)
            if (freq[s.charAt(i) - 'a'] == 1){
                return i;
            }

        return -1;
    }

    public static void main(String[] args) {
        String a = "loveleetcode";
        int i = firstUniqChar(a);
        System.out.println(i);
    }
}
