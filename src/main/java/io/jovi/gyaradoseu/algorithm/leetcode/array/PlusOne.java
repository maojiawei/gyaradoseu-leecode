package io.jovi.gyaradoseu.algorithm.leetcode.array;

/**
 * <p>
 * Title: 加一
 * </p>
 * <p>
 * Description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-02-13.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class PlusOne {
    /**
     * 解题思路:
     * 1.从最后一位往前循环，看数字是否为9
     * 如果不为9，则+1即可结束。
     * 如果为9，将其设置0(因为9+1=10)，继续循环
     * 如果前面有位数按照进位，前面也+1即可
     * 如果前面没有位数，扩展一个新即可(如果第一位为9，那么一定是10的次方)
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,9};
        int[] nums2 = plusOne(nums);
        for(int i=0;i<nums2.length;i++){
            System.out.print(nums2[i]+",");
        }
    }
}
