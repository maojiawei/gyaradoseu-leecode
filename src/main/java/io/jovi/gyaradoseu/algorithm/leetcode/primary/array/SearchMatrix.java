package io.jovi.gyaradoseu.algorithm.leetcode.primary.array;
/**
 * <p>
 * Title: 搜索二维矩阵 II
 * </p>
 * <p>
 * Description:
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-04-09.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class SearchMatrix {
    /**
     * 解题思路:
     * 1.遍历x轴，如果匹配target数值，返回true。如果大于target数值continue
     * 2.
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
                if(matrix[i][j] > target){
                    continue;
                }
            }
        }
        return false;
    }

    /**
     * 解题思路:
     * 如果我们观察题目中给的那个例子，我们可以发现有两个位置的数字很有特点，左下角和右上角的数。
     * 例如右上角的7，往左所有的数变小，往下所有数增加，那么我们就可以和目标数相比较，如果目标数大，就往下搜，如果目标数小，就往左搜。
     * 这样就可以判断目标数是否存在。
     * @param matrix
     *
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {

        if(matrix.length == 0) {
            return false;
        }
        if(matrix[0].length == 0 && matrix.length==0) {
            return false;
        }
        //1.先找到右上角的点
        int i = 0;
        int j = matrix[0].length-1;
        while (j>=0 && i<matrix.length){
            //如果数组值大于目标值，往下查找
            if(matrix[i][j]>target){
                j--;
                //如果数组值小于目标值，往右查找
            }else if(matrix[i][j]<target){
                i++;
            }else {
                //剩下的情况就是目标值等于数组值
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,   4,  7, 11, 15},
//                {2,   5,  8, 12, 19},
//                {3,   6,  9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}
//        };
        int[][] matrix = {
                {-5}
        };
        boolean flag = searchMatrix2(matrix,-5);
        System.out.println(flag);
    }
}
