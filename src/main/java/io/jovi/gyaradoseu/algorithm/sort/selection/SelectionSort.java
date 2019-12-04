package io.jovi.gyaradoseu.algorithm.sort.selection;

/**
 * <p>
 * Title: 选择排序算法
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
public class SelectionSort {
    /**
     * 选择排序
     * 分为已排序空间 和 未排序空间
     * 每次选择最小的元素，排到已排序空间的末尾
     * @param nums
     * @return
     */
    public static int[] selectionSort(int[] nums) {
        for(int i=0;i< nums.length;i++){
            // 指针(指向数组中最小的元素)
            int index = i;

            for(int j=i+1;j< nums.length;j++){
                if(nums[j]< nums[index]){
                    index = j;
                }
            }
            if(index == i){
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 4, 1};

        nums = selectionSort(nums);

        for (int n : nums) {
            System.out.println(n);
        }

    }
}
