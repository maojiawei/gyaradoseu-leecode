package io.jovi.gyaradoseu.algorithm.leetcode.array;

/**
 * <p>
 * Title:  搜索旋转排序数组
 * </p >
 * <p>
 * Description:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-04-19.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class ArrayAndSorting {
    /**
     * 搜索旋转排序数组
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high){
            int mid = low + (high - low) /2;
            if(target == nums[mid]){
                return mid;
                // 4,5,6,7,0,1,2 -> mid = 7 target = 0
            }else if(nums[mid] > target && nums[0] > target){
                low = mid;
                // 4,5,6,7,0,1,2 -> mid = 7 target = 5
            }else if(nums[mid]> target && nums[0] < target){
                high = mid;
                //4,5,6,0,1,2,3 -> mid = 0 target=2
            }else if(nums[mid] < target && nums[0] > target){
                low = mid;
            }else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int i = search(nums,target);
        System.out.print(i);
    }

}
