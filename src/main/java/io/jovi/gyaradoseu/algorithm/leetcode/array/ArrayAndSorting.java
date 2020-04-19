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
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end) {
            int mid = (begin + end) / 2;
            //[0,mid]是升序 说明旋转点在后面
            // 如果目标值在后面 或者 目标值小于nums[0] 说明这个数在后面
            if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
                begin = mid+1;

                //[0,mid]中出现旋转点
                // 往后走的条件是 目标值必须大于 nums[mid] 当前数字 并且小于第一个数字
                // 7,9,1,3,5 如果target为3
            } else if (target > nums[mid] && target < nums[0]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin == end && nums[begin] == target ? begin : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int i = search(nums,target);
        System.out.println(i);
    }

}
