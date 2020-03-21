package io.jovi.gyaradoseu.algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Title: 三数之和
 * </p >
 * <p>
 * Description:
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-03-21.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ThreeSum {
    /**
     * 三数之和
     * nums[i] + nums[j] + nums[k] = 0
     */
    public static List<List<Integer>> threeNum(int[] nums) {
        // 存放结果的集合
        List<List<Integer>> result = new ArrayList<>();
        // 1. 先排序从小到大
        Arrays.sort(nums);
        print(nums);
        for (int i = 0; i < nums.length; i++) {
            // 2. 既然=0，那么一定会有<0和>0的数据，
            // 我们先遍历<0的数据，那么其实也会将>0的结果集也找出来
            if (nums[i] > 0) {
                break;
            }
            // 如果遇到相同的元素就跳过 以避免数据重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 开始的指针
            int j = i + 1;
            // 最后的指针
            int k = nums.length - 1;
            // 目标值
            int target = 0 - nums[i];
            while (j < k) {
                // 如果等于目标值 说明找到了
                if (nums[j] + nums[k] == target) {
                    List<Integer> resultList = new ArrayList<>();
                    resultList.add(nums[i]);
                    resultList.add(nums[j]);
                    resultList.add(nums[k]);
                    result.add(resultList);
                    // 如果遇到相同的元素就跳过 以避免数据重复
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    // 如果遇到相同的元素就跳过 以避免数据重复
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    k--;
                    j++;
                    // 如果小于目标值 因为k没法继续增加 只能增加j
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeNum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("第" + i + "个结果集：");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(" " + result.get(i).get(j));
            }
            System.out.println("");
        }
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
        System.out.println("");
    }
}
