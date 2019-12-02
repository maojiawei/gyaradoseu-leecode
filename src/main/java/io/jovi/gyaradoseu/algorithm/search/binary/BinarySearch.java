package io.jovi.gyaradoseu.algorithm.search.binary;

/**
 * <p>
 * Title: 二分法
 * </p>
 * <p>
 * Description:
 * 通过二分法查找数组中的数据
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class BinarySearch {
    /**
     * 二分法查找（正常）
     * @param nums
     * @erparam n
     * @return
     */
    public static int binarySearch(int[] nums,int n){
        // 小的指针
        int low = 0;
        // 大的指针
        int high = nums.length;
        while (low <= high){
            // mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话,容易出现溢出
            int mid = low + (high - low)/2;
            if(nums[mid] == n){
                return mid;
            }
            if(nums[mid] > n){
                high = mid - 1;
            }
            if(nums[mid] < n){
                low = mid + 1;
            }
        }
        return 0;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,8,9,10};
        int index = binarySearch(nums,3);
        System.out.println(index);
    }
}
