package io.jovi.gyaradoseu.algorithm.leetcode.string;

/**
 * <p>
 * Title: 矩阵置零
 * </p>
 * <p>
 * Description:
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class SetZeroes {
    /**
     * 矩阵置零
     * 常数空间解决方法：
     * 由于需要整行整列的变更数据，因此，我们就在第一行或第一列做一个标记，即设置为0
     * 那么如果第一行或第一列本身即为0，那么我们就加入第一行第一列为0的标记
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        // 标记第一行是否为0 第一列是否为0
        boolean firstRow = false,firstCol = false;
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(i != 0 && j != 0 && matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                } else if(matrix[i][j] == 0){
                    firstRow = i==0? true:firstRow;
                    firstCol = j==0? true:firstCol;
                }
            }

        }
        // 逐步将所有列 和 行都变为0
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0 || matrix[i][0] == 0){
                    matrix[i][j]=0;
                }
            }
        }
        //第一列含0 将对应列变为0
        if(firstCol){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
        //第一行含0 将对应行变为0
        if(firstRow){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(nums);
        for(int i=0;i< nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                System.out.print(" "+nums[i][j]);
            }
            System.out.println(" ");
        }
    }
}
