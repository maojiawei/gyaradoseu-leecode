package io.jovi.gyaradoseu.algorithm.leetcode.dynamic;

/**
 * <p>
 * Title: 最大子序和
 * </p>
 * <p>
 * Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class MaxSubArray {
    /**
     * 最大子序和
     * 暴力穷举法O(N的平方)
     * @param nums
     * @
     */
    public static int maxSubArray(int[] nums) {
        // 当数组只有一个元素的时候，数组最大子序和就是他第一个元素
        if(nums.length == 1){
            return nums[0];
        }
        // 最大的sum值
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            // 不断累积
            int sum = nums[i];
            if(sum > maxsum){
                maxsum = sum;
            }
            for(int j=i+1;j<nums.length;j++){
                sum += nums[j];
                if(sum > maxsum){
                    maxsum = sum;
                }
            }
        }
        return maxsum;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        // 当前的集合
        int prev=nums[0];
        // 最大值
        int max=prev;
        for(int i=1;i<nums.length;i++){
            // prev+nums[i] < nums[i] 说明的当前的累加对后面的累加没有增益效果
            // 如果pre=-100 nums[i]=300 那么-100只会对后面的累积拖后腿 所有直接舍弃-100 算作300
            prev=Math.max(prev+nums[i],nums[i]);
            max=Math.max(prev,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1};
        int maxsum = maxSubArray(nums);
        System.out.println(maxsum);
    }
}
