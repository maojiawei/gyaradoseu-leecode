package io.jovi.gyaradoseu.algorithm.primary.array;

/**
 * <p>
 * Title:
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
