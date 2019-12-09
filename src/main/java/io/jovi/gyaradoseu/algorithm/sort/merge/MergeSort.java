package io.jovi.gyaradoseu.algorithm.sort.merge;

/**
 * <p>
 * Title: 归并排序
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 4, 1};

        nums = mergeSort(nums);

        for (int n : nums) {
            System.out.println(n);
        }
    }

    /**
     * 归并排序分为两步，分解与合并
     * @param nums
     * @return
     */
    public static int[] mergeSort(int[] nums) {
        split(nums,0,nums.length -1 );
        return nums;
    }

    /**
     * 分解
     * @param array 数据
     * @param low 分解的起始位置
     * @param high 最高位置
     */
    public static void split(int[] array, int low, int high) {
        //如果起始位置大于最高位置 则不必进行分解
        if (low + 1 >= high) {
            return;
        }
        // 中间
        int mid = (low + high) / 2;
        // 前半至中间部分进行拆分
        split(array, low, mid);
        // 中间至最后部分进行拆分
        split(array, mid, high);
        merge(array, low, mid, high);
    }

    /**
     * 合并并排序
     * @param array 数组
     * @param low 起始位置
     * @param mid 中间位置
     * @param high 终止位置
     */
    private static void merge(int[] array, int low, int mid, int high) {
        int length = high - low;
        // 新建数组 用于存放排序过的元素
        int[] temp = new int[length];
        //[low,mid]
        //[mid,high]
        int less = low;
        int great = mid;
        int i = 0;
        // 遍历两个数组，按照大小放入新建的数组中
        while (less < mid && great < high) {
            if (array[less] <= array[great]) {
                temp[i] = array[less];
                less++;
                i++;
            } else {
                temp[i] = array[great];
                great++;
                i++;
            }
        }
        while (less < mid) {
            temp[i++] = array[less++];
        }
        while (great < high) {
            temp[i++] = array[great++];
        }
        for (int j = 0; j < length; j++) {
            array[low + j] = temp[j];
        }
    }
}
