package io.jovi.gyaradoseu.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * <p>
 * Title: 只出现一次的数字
 * </p>
 * <p>
 * Description:
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-02-11.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class SingleNumber {
    /**
     * 只出现一次的数字
     * 解题思路:
     * 1. 对数组进行排序
     * 2. 从第一个开始，每隔两个循环依次。如果当前的数与后一位数不相等，当前数就是我们要找的数
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i = i + 2){
            if(nums.length <= i+1){
                return nums[i];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    /**
     * 只出现一次的数字
     * 解题思路:
     * 1. 对数组进行排序
     * 2. 从第一个开始，每隔两个循环依次。如果当前的数与后一位数不相等，当前数就是我们要找的数
     * @param nums
     * @return
     */
    public static int singleNumber2(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i += 2) {
            nums[0] ^= nums[i] ^ nums[i+1];
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        int num = singleNumber2(nums);
        System.out.println(num);
    }
}
