package io.jovi.gyaradoseu.algorithm.primary.array;

/**
 * <p>
 * Title: 旋转数组
 * </p>
 * <p>
 * Description:
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-01-22.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class Rotate {
    /**
     * 对于一个数组向右旋转k个位置
     * @param nums
     * @param k
     */
    public static int[] rotate1(int[] nums, int k) {
        if(k<=0){
            return nums;
        }
        while (k > 0){
            int first = nums[0];
            for(int i=nums.length-1;i >=0 ;i--){
                if(i == nums.length-1){
                    nums[0] = nums[nums.length-1];
                    continue;
                }
                if(i==0){
                    nums[1] = first;
                    continue;
                }
                nums[i+1] = nums[i];
            }
            k--;
        }
        return nums;

    }

    public static int[] rotate2(int[] nums, int k) {
        if(k<=0){
            return nums;
        }
        int[] result = new int[nums.length];

        for(int i=0;i< nums.length;i++){
            result[(i+k)%nums.length] = nums[i];
        }
        return result;

    }

    public static int[] rotate3(int[] nums, int k) {
        if (k < 1 || nums == null || nums.length <= 1) {
            return nums;
        }
        if (k>=nums.length){
            k=k%nums.length;
        }
        if(k==0){
            return nums;
        }
        int []tempArray=new int[k];
        System.arraycopy(nums,nums.length-k,tempArray,0,tempArray.length);
        System.arraycopy(nums,0,nums,k,nums.length-k);
        System.arraycopy(tempArray,0,nums,0,tempArray.length);
        return nums;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] result = rotate3(nums,3);
        System.out.println("==============");
        for(int num:result){
            System.out.println(num);
        }

    }


}
