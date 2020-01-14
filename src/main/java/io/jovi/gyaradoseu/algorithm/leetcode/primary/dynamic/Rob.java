package io.jovi.gyaradoseu.algorithm.leetcode.primary.dynamic;

/**
 * <p>
 * Title:打家劫舍
 * </p>
 * <p>
 * Description:
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class Rob {
    /**
     * dp[i]表示前i个获取的最高金额，对于第i个阶段，就是两种选择，偷不偷
     * dp[i]=max(dp[i-1],dp[i-2]+nums[i])
     * 0 1 2 3  4  5 (i)
     *   2 7 9  3  1   (num)
     *
     * 0 2 7 11 11 12 (dp)
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length+1];
        // 代表第一个没偷
        dp[0] = 0;
        // 代表第一个偷了
        dp[1] = nums[0];

        for(int i=1;i<nums.length;i++){
            int max = Math.max(dp[i],dp[i-1]+nums[i]);
            dp[i+1] = max;
        }

        // 去除数据组最大的值
        int max = dp[0];
        for(int i:dp){
            if(max < i){
                max = i;
            }
        }
        return max;
    }

    /**
     * 利用当前指针和前指针 减少空间复杂度
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // 代表第一个没偷
        int prevMax = 0;
        // 代表第一个偷了
        int currMax  = nums[0];

        for(int i=1;i<nums.length;i++){
            int temp = currMax;
            currMax = Math.max(currMax,prevMax+nums[i]);
            prevMax = temp;
        }

        return currMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        int maxsum = rob(nums);
        System.out.println(maxsum);
    }
}
