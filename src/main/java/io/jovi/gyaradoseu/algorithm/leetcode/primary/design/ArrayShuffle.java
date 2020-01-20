package io.jovi.gyaradoseu.algorithm.leetcode.primary.design;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * Title: Shuffle an Array
 * </p>
 * <p>
 * Description:
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class ArrayShuffle {
    /**
     * 初始数组
     */
    private int[] orgNums;

    public ArrayShuffle(int[] nums) {
        this.orgNums =  nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.orgNums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = orgNums.length;
        int[] nums = Arrays.copyOf(orgNums,orgNums.length);
        Random ran = new Random();
        for(int i=len-1;i>=0;i--){
            //记录要交换元素的位置
            int pos = ran.nextInt(i+1);
            //记录要交换的值
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,50,40,80};
        ArrayShuffle arrayShuffle = new ArrayShuffle(nums);
        int[] nums1 = arrayShuffle.shuffle();
        for(int i=0;i<nums1.length;i++){
            System.out.println(nums1[i]);
        }
        System.out.println("=================================");
        int[] nums2 = arrayShuffle.reset();
        for(int i=0;i<nums2.length;i++){
            System.out.println(nums2[i]);
        }
    }
}
