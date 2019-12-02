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
     * @param n
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
                continue;
            }
            if(nums[mid] < n){
                low = mid + 1;
                continue;
            }
        }
        return 0;
    }

    /**
     * 二分法查找（查找第一个值等于给定值得元素）
     * @param nums
     * @param n
     * @return
     */
    public static int binarySearch1(int[] nums,int n){
        // 小的指针
        int low = 0;
        // 大的指针
        int high = nums.length;
        while (low <= high){
            // mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话,容易出现溢出
            int mid = low + (high - low)/2;
            if(nums[mid] > n){
                high = mid - 1;
                continue;
            }
            if(nums[mid] < n){
                low = mid + 1;
                continue;
            }
            if(mid == 0 || nums[mid-1] != n){
                return mid;
            }
            high = mid - 1;
        }
        return 0;
    }

    /**
     * 二分法查找（查找最后一个值等于给定值的元素）
     * @param nums
     * @param n
     * @return
     */
    public static int binarySearch2(int[] nums,int n){
        // 小的指针
        int low = 0;
        // 大的指针
        int high = nums.length;
        while (low <= high){
            // mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话,容易出现溢出
            int mid = low + (high - low)/2;
            if(nums[mid] > n){
                high = mid - 1;
                continue;
            }
            if(nums[mid] < n){
                low = mid + 1;
                continue;
            }
            if(mid == 0 || nums[mid+1] != n){
                return mid;
            }
            low = mid + 1;
        }
        return 0;
    }

    /**
     * 二分法查找（查找第一个大于等于给定值的元素）
     * @param nums
     * @param n
     * @return
     */
    public static int binarySearch3(int[] nums,int n){
        // 小的指针
        int low = 0;
        // 大的指针
        int high = nums.length;
        int mid = 0;
        while (low <= high){
            // mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话,容易出现溢出
            mid = low + (high - low)/2;
            if(nums[mid] >= n){
                if(mid == 0 || nums[mid+1] < n){
                    return mid;
                }
                high = mid - 1;
                continue;
            }
            if(nums[mid] < n){
                low = mid + 1;
                continue;
            }
        }

        return mid;
    }

    /**
     * 二分法查找（查找最后一个小于等于给定值的元素）
     * @param nums
     * @param n
     * @return
     */
    public static int binarySearch4(int[] nums,int n){
        // 小的指针
        int low = 0;
        // 大的指针
        int high = nums.length;
        int mid = 0;
        while (low <= high){
            // mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话,容易出现溢出
            mid = low + (high - low)/2;
            if(nums[mid] > n){
                high = mid - 1;
                continue;
            }
            if(nums[mid] <= n){
                if(mid == 0 || nums[mid+1] > n){
                    return mid;
                }
                low = mid + 1;
                continue;
            }
        }

        return mid;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3,6,8,11,13};
        int index = binarySearch4(nums,5);
        System.out.println(nums[index]);
    }
}
