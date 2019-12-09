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
        int[] nums = new int[]{1,5,7,6,2,4};

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
        split(nums,0,nums.length -1);
        return nums;
    }

    /**
     * 分解
     * @param nums 数据
     * @param start 分解的起始位置
     * @param end 最高位置
     */
    public static void split(int[] nums,int start,int end) {
        if(start >= end){
            return;
        }
        int mid = start + (end - start) /2;
        split(nums,0,mid);
        split(nums,mid+1,end);
        merge(nums,start,mid,end);
    }

    /**
     * 合并并排序
     * @param nums 数组
     * @param left 起始位置
     * @param mid 中间位置
     * @param right 终止位置
     */
    private static void merge(int[] nums,int left,int mid,int right) {
        int[] temp = new int[nums.length];
        int i = left;
        int j = mid+1;
        int k = left;
        while (i <= mid && j <= right){
            if(nums[i] > nums[j]){
                temp[k++] = nums[j++];
                continue;
            }
            temp[k++] = nums[i++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for(int p = left; p <=right; p++){
            nums[p]=temp[p];
        }
    }
}
