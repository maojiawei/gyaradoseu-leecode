package io.jovi.gyaradoseu.algorithm.leetcode.math;

/**
 * <p>
 * Title: 计数质数
 * </p >
 * <p>
 * Description:
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * </p >
 * <p>
 * Copyright: Copyright (c) 2019
 * All rights reserved. 2020-02-10.
 * </p >
 *
 * @author MaoJiaWei
 * @version 1.0
 */
public class CountPrimes {
    /**
     * 计数质数
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        // n为1
        if(n <=2){
            return 0;
        }
        int count = 0;
        // 遍历所有经过的质数
        for(int i =2;i<n;i++){
            if(i==2 || i == 3){
                count++;
                continue;
            }
            //不在6的倍数两侧的一定不是质数
            if((i%6 != 1) && (i%6 != 5)){
                continue;
            }

            // 判断质数 true表示质数 false表示非质数
            boolean prime = true;
            for(int j=5;j<=Math.sqrt(i);j+=6){
                if(i%j==0||i%(j+2)==0){
                    prime = false;
                    break;
                }
            }

            // 如果为质数 累计1
            if(prime){
                System.out.println("i="+i+",count="+count);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countPrimes(10);
        System.out.println(count);
    }
}
