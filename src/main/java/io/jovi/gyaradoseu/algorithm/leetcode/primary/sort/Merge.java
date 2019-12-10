package io.jovi.gyaradoseu.algorithm.leetcode.primary.sort;

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
        merge(num1,m,num2,3);
        for (int num : num1) {
            System.out.println(num);
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m;
        // x作为nums1的指针 y作为nums2的指针
        int x = 0 , y = 0;
        for(; x<m; x++){
            if(nums1[x] < nums2[y]){
                y++;
                break;
            }

        }
    }
}
