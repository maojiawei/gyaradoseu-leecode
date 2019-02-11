package io.jovi.gyaradoseu.algorithm.primary.array;

/**
 * <p>
 * Title: 卖卖股票额最佳时机2
 * </p>
 * <p>
 * Description:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 *
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2019-01-22.
 * </p>
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class BestChanceOfShares {
    /**
     * 卖卖股票额最佳时机2
     * 解题思路:
     * 1.建立一个总的收益变量，初始为0
     * 1.从第二天开始依次减去前一天的价格获得本次买卖的收益
     * 2.判断收益是否为正，如果为正，累加进入收益变量中；如果为负，不做任何操作。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // 获取的利润
        int profit = 0;
        for(int i=1;i< prices.length;i++){
            // 收益=当前天的价格-前一天的价格 即卖出价格-买入价格
            int benefit = prices[i] - prices[i-1];
            //如果收益为正
            if(benefit > 0){
                profit += benefit;
            }
        }
        return profit;
    }

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        int profit = maxProfit(nums);
        System.out.println("==============");
        System.out.println(profit);
    }
}
