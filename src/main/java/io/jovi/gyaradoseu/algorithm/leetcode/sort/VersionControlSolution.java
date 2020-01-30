package io.jovi.gyaradoseu.algorithm.leetcode.sort;

import org.junit.Test;

/**
 * <p>
 * Title:第一个错误的版本
 * </p>
 * <p>
 * Description:
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 示例:
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class VersionControlSolution implements VersionControl {
    @Override
    public boolean isBadVersion(int version) {
        boolean isBad = false;
        if(version > 3){
            isBad = true;
        }
        return isBad;
    }

    /**
     * 二分查找法
     * 查找第一个false的
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {

       return this.firstBadVersion(0,n-1) + 1;
    }

    public int firstBadVersion(int start,int end) {
        int mid = start + (end - start) / 2;
        boolean isbad = isBadVersion(mid);
        if(isbad){
            return firstBadVersion(start,mid);
        }
        isbad = isBadVersion(mid+1);
        if(isbad){
            return mid;
        }
        return firstBadVersion(mid+1,end);
    }

    public int firstBadVersion2(int n) {
        int low = 0;
        int high = n;
        while(low <high){
            int mid  = low + (high - low)/2;
            if(isBadVersion(mid)){
                high = mid;
            }else{
                low = mid +1 ;
            }
        }
        return low;
    }
    @Test
    public void main() {
        int version = this.firstBadVersion2(5);
        System.out.println(version);
    }
}
