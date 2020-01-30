package io.jovi.gyaradoseu.algorithm.leetcode.sort;

/**
 * <p>
 * Title: 合并两个有序数组
 * </p >
 * <p>
 * Description:
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-12-10.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class Merge {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0,0};
        int m = 3;
        int[] num2 = new int[]{2, 5, 6};
        int n = 3;
        merge(num1,m,num2,n);
        for (int num : num1) {
            System.out.println(num);
        }

    }

    /**
     * 合并两个有序数组
     * 由于两个数组都是有序的，从前往后排比较困难 因为涉及后移O(n)。
     * 既然都是有序的，并且知道每个数组对应的长度，我们就可以从后往前插入。
     * 一个一个遍历，将大的数据插入至最后
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // i 代表 nums1 数组的结尾指针
        // j 代表 nums2 数组的结尾指针
        // k 代表 合并后数组的结尾指针
        int i = m-1,j = n-1,k = m+n-1;
        while (i > 0 && j > 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
                break;
            }
            nums1[k--] = nums2[j--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }

    }
}
