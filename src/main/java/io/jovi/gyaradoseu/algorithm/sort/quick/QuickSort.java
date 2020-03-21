package io.jovi.gyaradoseu.algorithm.sort.quick;

import java.util.Arrays;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 9, 7};
        arr = quickSort(arr);
        for(int a : arr){
            System.out.println(a);
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public static int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public static int[] sort(int[] nums, int start, int end) {
        if (start > end) {
            return nums;
        }
        // base中存放基准数
        int base = nums[start];
        int i = start, j = end;
        while (i != j) {
            // 先从右边开始往左找，直到找到比base值小的数
            while (nums[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (nums[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        nums[start] = nums[i];
        nums[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(nums, start, i - 1);
        sort(nums, i + 1, end);
        return nums;
    }


}
