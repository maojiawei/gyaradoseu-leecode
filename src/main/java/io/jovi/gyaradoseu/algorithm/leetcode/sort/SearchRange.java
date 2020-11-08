package io.jovi.gyaradoseu.algorithm.leetcode.sort;

/**
 * <p>
 * Title: 在排序数组中查找元素的第一个和最后一个位置
 * </p>
 * <p>
 * Description:
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2};
        int target = 3;
        int[] result = searchRange(nums,target);
        System.out.println(result);
    }

    /**
     * 二分查找法
     * 1. 通过二分查找法，找到元素
     * 2. 定位那时的开始和结束位置，遍历这部分为target元素的部分
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length <= 0){
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        // 开始位置 start
        // 结束位置 end
        int start = 0,end = nums.length;
        // 最初找到的位置
        int p = -1;
        // 二分法
        while (start <= end){
            int mid = start + (end - start) / 2;
            // 避免ArrayOutOfBoundException
            if(mid >= nums.length){
                break;
            }
            if(target == nums[mid]){
                p = mid;
                break;
            } else if (target < nums[mid]){
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            }
        }
        // 如果没有找到 直接返回-1
        if(p == -1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int i = p;
        int j = p;
        //由p作为向左向右的起点 一个一个的查询
        while(i>=0 && nums[i] == target){
            i--;
        }
        res[0] = i+1;

        while(j<nums.length && nums[j] == target){
            j++;
        }
        res[1] = j-1;
        return res;
    }
}
