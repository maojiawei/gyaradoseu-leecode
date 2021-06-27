package io.jovi.gyaradoseu.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: 电话号码的字母组合
 * </p>
 * <p>
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class LetterCombinations {
    /**
     * 1. 建立数字对应的map集合
     * 2. 尝试排列组合
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> arr = new ArrayList<>();
        String[] letters = new String[] {"","","abc","def",
                "ghi","jkl","mno","pqrs","tuv","wxyz"};
        // 将输入的数字拆分 一个个处理
        char[] inputs = digits.toCharArray();
        for(char c:inputs){
            int i = Integer.valueOf(String.valueOf(c));
            String b = letters[i];
            // 如果b未空 则直接返回
            if("".equals(b)){
                continue;
            }
            // 将输入数字的可能性都列出
            char[] letters2 = b.toCharArray();
            List<String> arr2 = new ArrayList<>();
            for(char cb:letters2){
                // 如果第一个数字 直接加入数字
                if(arr.size() == 0){
                    arr2.add(String.valueOf(cb));
                    continue;
                }
                // 后续排列组合进行累加
                for(String s:arr){
                    String s2 = s + cb;
                    arr2.add(s2);
                }
            }
            arr = arr2;
        }
        return arr;
    }

    public static List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        // 结束
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }


    public static void main(String[] args) {
        String digits = "23";
        List<String> arr = letterCombinations2(digits);
        System.out.println(arr);
    }
}
