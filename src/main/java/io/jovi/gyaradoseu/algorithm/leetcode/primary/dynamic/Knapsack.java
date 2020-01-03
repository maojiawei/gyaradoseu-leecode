package io.jovi.gyaradoseu.algorithm.leetcode.primary.dynamic;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class Knapsack {
    /**
     *
     * @param weight 物品重量
     * @param n 物品个数
     * @param w 背包可承载重量
     * @return
     */
    public static int knapsack(int[] weight, int n, int w) {
        // 默认值false
        // 这是个二维数组 第一个为步骤 第二个为目前背包的重量
        boolean[][] states = new boolean[n][w+1];
        // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        // 动态规划状态转移
        for (int i = 1; i < n; ++i) {
            // 不把第i个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            //把第i个物品放入背包
            for (int j = 0; j <= w-weight[i]; ++j) {
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }
        // 输出结果
        for (int i = w; i >= 0; --i) {
            if (states[n-1][i] == true) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] weight = {2,2,4,6,3};
        int w = knapsack(weight,weight.length,9);
        System.out.println(w);
    }
}
