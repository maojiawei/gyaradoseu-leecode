package io.jovi.gyaradoseu.algorithm.sort.bubble;

/**
 * <p>
 * Title: 冒泡排序算法
 * </p >
 * <p>
 * Description:
 *
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-01.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class BubbleSort {
    /**
     * 1. 原地排序算法：是的，在同一个数组中进行
     * 2. 稳定排序算法：是的，只有交换才能改变两个元素的前后顺序。
     * 3. 时间复杂度：
     * 最好情况 1,2,3,4,5,6 1次冒泡 时间复杂度O(n)
     * 最坏情况 6,5,4,3,2,1 6次冒泡 时间复杂度O(n2)
     *
     * @param nums
     * @return
     */
    public static int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
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
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 4, 1};

        nums = bubbleSort(nums);

        for (int n : nums) {
            System.out.println(n);
        }

    }
}
