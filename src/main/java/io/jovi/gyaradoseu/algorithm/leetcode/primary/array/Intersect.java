package io.jovi.gyaradoseu.algorithm.leetcode.primary.array;

import java.util.*;

/**
 * <p>
 * Title: 两个数组的交集 II
 * </p>
 * <p>
 * Description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-02-11.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class Intersect {
    /**
     * 两个数组的交集
     * 解题思路:
     * 1.新建一个数组，保存所有的重复数梓
     * 2.循环第一个数组，与第二个数组的所有数据进行匹配，如果有重复一样的数据，则存入新数组中
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> list = new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    break;
                }
            }
        }
        int[] nums3 = new int[list.size()];
        int i = 0;
        for(Integer num:list){
            nums3[i] = num;
        }

        return nums3;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] nums3 = intersect(nums1,nums2);
        for(int i=0;i<nums3.length;i++){
            System.out.print(nums3[i]+",");
        }

    }
}
