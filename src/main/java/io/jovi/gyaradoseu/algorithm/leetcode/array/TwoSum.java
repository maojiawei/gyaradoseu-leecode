package io.jovi.gyaradoseu.algorithm.leetcode.array;

/**
 * <p>
 * Title:两数之和
 * </p>
 * <p>
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-03-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class TwoSum {
    /**
     * 两数之和
     * 解题思路:
     * 1. 定义两个下标 i和j
     * 2. 判断下标为i的数字与下标为j的数字相加是否等于target
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for(int i=0;i<nums.length;i++){

            for(int j=i+1; j<nums.length; j++){

                int sum = nums[i] + nums[j];
                if(sum == target){
                    ints[0] = i;
                    ints[1] = j;
                    break;
                }
            }
        }
        return ints;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-3,4,3,90};
        int target = 0;
        int[] a = twoSum(nums,target);
        System.out.println("==============");
        for(int num:a){
            System.out.println(num);
        }

    }
}
