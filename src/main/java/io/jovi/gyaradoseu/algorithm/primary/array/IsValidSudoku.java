package io.jovi.gyaradoseu.algorithm.primary.array;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Title:有效的数独
 * </p>
 * <p>
 * Description:
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 *      但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 1. 一个有效的数独（部分已被填充）不一定是可解的。
 * 2. 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 3. 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 4. 给定数独永远是 9x9 形式的。
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-03-08.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class IsValidSudoku {
    /**
     * 有效的数独
     * 解题思路:
     * 1. 查看board是否为9*9形式
     * 2. 查看数组是否只包含1-9以及.
     * 3. 从第一行第一列开始 查看第一列
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {

        //用于查看数组中字符的合法性
        Set<Character> charSet = new HashSet<>();
        charSet.add('1');
        charSet.add('2');
        charSet.add('3');
        charSet.add('4');
        charSet.add('5');
        charSet.add('6');
        charSet.add('7');
        charSet.add('8');
        charSet.add('9');
        charSet.add('.');
        //用于查重
        Set<Character> set = new HashSet<>();

        //1.遍历每一行不存在同样的数据(只包含1-9与.)，且长度为9。
        if(board.length != 9){
            System.out.println("i的数组长度不合法");
            return false;
        }
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                //判断j的长度是否合法
                if(board[i].length != 9){
                    System.out.println("j的数组长度不合法");
                    return false;
                }
                //判断数字是否合法
                char c = board[i][j];
                if(!charSet.contains(c)){
                    System.out.println(String.format("字符不合法,i:%s,j:%s,c:%s",i,j,c));
                    return false;
                }
                //判断是否之前已经包含了当前数字 且 .是可以重复的所以排除
                if(set.contains(c) && c!= '.'){
                    System.out.println(String.format("横列字符包含重复,i:%s,j:%s,c:%s",i,j,c));
                    return false;
                }
                set.add(c);
            }
            set.clear();
        }
        //2. 判断每一列数据不重复
        for(int i = 0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                char c = board[j][i];
                //判断是否之前已经包含了当前数字 且 .是可以重复的所以排除
                if(set.contains(c) && c!= '.'){
                    System.out.println(String.format("纵列字符包含重复,i:%s,j:%s,c:%s",i,j,c));
                    return false;
                }
                set.add(c);
            }
            set.clear();
        }
        //3. 查看每一个小方格中是否存在重复的数据
        //3.1 首先找到起始点 i、j代表起始点的坐标(i为横坐标，j为纵坐标)
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                //a为起始点横坐标i扩展至小方格尽头及i+2
                int iBig = i+2;
                for(int a=i;a<=iBig;a++){
                    //b为起始点纵坐标j扩展至小方格尽头及i+2
                    int jBig = j+2;
                    for(int b=j;b<=jBig;b++) {
                        char c = board[a][b];
                        //判断是否之前已经包含了当前数字 且 .是可以重复的所以排除
                        if (set.contains(c) && c != '.') {
                            System.out.println(String.format("小方格中包含重复,a:%s,b:%s,c:%s", a, b, c));
                            return false;
                        }
                        set.add(c);
                    }
                }
                set.clear();

            }

        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;
                //判断纵行是否存在相同数据
                for(int k = 8; k > j; k-- )
                    if(board[i][j] == board[i][k])
                        return false;
                //判断横行是否存在相同数据
                for(int k = 8; k > i; k--)
                    if(board[i][j] == board[k][j])
                        return false;
                //判断周围的小方格 是否存在相同的数据
                for(int k = i + 1; k % 3 != 0; k ++){
                    for(int h = j /3 *3;h < j / 3 *3 + 3; h ++ )
                        if(board[i][j] == board[k][h])
                            return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.','.','.','.','5','.','.','1','.'},
            {'.','4','.','3','.','.','.','.','.'},
            {'.','.','.','.','.','3','.','.','1'},
            {'8','.','.','.','.','.','.','2','.'},
            {'.','.','2','.','7','.','.','.','.'},
            {'.','1','5','.','.','.','.','.','.'},
            {'.','.','.','.','.','2','.','.','.'},
            {'.','2','.','9','.','.','.','.','.'},
            {'.','.','4','.','.','.','.','.','.'}
        } ;
        boolean flag = isValidSudoku2(board);
        System.out.println(flag);
    }

}
