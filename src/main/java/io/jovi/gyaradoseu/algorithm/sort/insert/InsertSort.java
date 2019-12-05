package io.jovi.gyaradoseu.algorithm.sort.insert;

/**
 * <p>
 * Title: 插入排序算法
 * </p >
 * <p>
 * Description:
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-03.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 4, 1};

        nums = insertSort(nums);

        for (int n : nums) {
            System.out.println(n);
        }
    }

    /**
     * 插入排序
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (value < nums[j]) {
                    // 数据移动
                    nums[j + 1] = nums[j];
                }  else{
                    break;
                }
            }
            nums[j+1] = value;
        }
        return nums;
    }
}
