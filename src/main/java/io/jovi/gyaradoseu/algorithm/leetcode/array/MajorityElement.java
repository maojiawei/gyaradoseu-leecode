package io.jovi.gyaradoseu.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Title:求众数
 * </p>
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-03-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class MajorityElement {
    /**
     * 找众数:
     * 1. 创建一个map，key为数字，value为数字在数组中的个数
     * 2. 循环数组，将其存入map中
     * 3. 再次循环map，找到数量大于数组一半的数字
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            Integer num = map.get(i);
            if(num==null){
                map.put(i,1);
            }else{
                map.put(i,num+1);
            }
        }

        for(int i:map.keySet()){
            int num = map.get(i);
            if(num > nums.length/2){
                return i;
            }
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        int result = nums[0], count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) {
                result = nums[i];
                count++;
            } else if(result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,1,3,1,2,2};
        int num = majorityElement2(nums);
        System.out.println(num);

    }
}
