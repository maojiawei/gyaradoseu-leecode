package io.jovi.gyaradoseu.algorithm.leetcode.primary.array;

/**
 * <p>
 * Title:移动零
 * </p>
 * <p>
 * Description:
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 1.必须在原数组上操作，不能拷贝额外的数组。
 * 2.尽量减少操作次数。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-03-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class MoveZeroes {
    /**
     * 移动零
     * 解题思路:
     * 1. 建立一个指针index，指向数组的最后一位数(用于指向需要与0换的位置)
     * 2. 遍历数组,以i为遍历下标
     * 3. 如果i(遍历数组的下标）大于index，说明数组已经遍历完毕(后面的肯定都是0)
     * 4. 判断是否为0，如果为0，将每个数字往前移，最后补0,且下次遍历依旧从i开始遍历(因为i的数字已经变了)。
     * 5. 如果没有更改，则i+1
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        //1. 建立一个指针index，指向数组的最后一位数(用于指向需要与0换的位置)
        int index = nums.length-1;
        //2. 遍历数组
        for(int i=0;i<nums.length;){
            //3. 如果i(遍历数组的下标）大于index，说明数组已经遍历完毕(后面的肯定都是0)
            if(i > index){
                break;
            }
            //4. 判断是否为0，如果为0，将每个数字往前移，最后补0
            if(nums[i] == 0 ){
                for(int j=i+1;j<=index;j++){
                    int a = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = a;
                }
                nums[index] = 0;
                index--;
                continue;
            }
            i++;
        }
    }

    /**
     * 移动零
     * 解题思路:
     * 1. 建立一个index，初始值为0
     * 2. 将数组中非0的数字放置index位置，且index+1
     * 3. 后续为补0
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,0,1};
        moveZeroes(nums);
        System.out.println("==============");
        for(int num:nums){
            System.out.println(num);
        }

    }
}
