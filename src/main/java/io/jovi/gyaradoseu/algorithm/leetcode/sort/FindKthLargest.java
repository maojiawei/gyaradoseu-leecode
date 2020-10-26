package io.jovi.gyaradoseu.algorithm.leetcode.sort;

import java.util.Arrays;

/**
 * <p>
 * Title: 数组中的第K个最大元素
 * </p>
 * <p>
 * Description:
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class FindKthLargest {
    /**
     * 数组中的第K个最大元素
     * 1. 先排序
     * 2. 按照排序去除k个元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
        System.out.println("==============================");
        Arrays.stream(nums).forEach(e -> System.out.println(e));
        System.out.println("==============================");
        return nums[k-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int result = findKthLargest(nums,k);
        System.out.println(result);
    }
}
