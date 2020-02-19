package io.jovi.gyaradoseu.algorithm.leetcode.primary.design;

/**
 * <p>
 * Title: 3的幂
 * </p>
 * <p>
 * Description:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class IsPowerOfThree {
    /**
     * 每次累加三
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree(int n) {
        if (n == 0 && n==1){
            return false;
        }
        boolean flag = true;
        while (n!=1){
            if(n % 3 != 0){
                flag = false;
                break;
            }
            n = n / 3;
        }
        return flag;
    }

    /**
     * 一个数是3的次方，那么以3为底n的对数一定是个整数。实现上可利用换底公示。
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        double tem = Math.log10(n) / Math.log10(3.0);
        // 判断一个数是否为整数的做法，值得学习
        if (Double.valueOf(tem).intValue() - tem == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int i = 27;
        boolean isPower = isPowerOfThree2(i);
        System.out.println(isPower);
    }

}
