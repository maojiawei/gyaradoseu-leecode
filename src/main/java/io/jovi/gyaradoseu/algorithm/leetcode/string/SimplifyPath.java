package io.jovi.gyaradoseu.algorithm.leetcode.string;

import java.util.Stack;

/**
 * <p>
 * Title: 简化路径
 * </p>
 * <p>
 * Description:
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class SimplifyPath {
    /**
     * 简化路径
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        // 分割路径
        String[] strs = path.split("/");
        // 建立栈 用于如果出现上一个(..)的话 就取出最新的
        Stack<String> stack = new Stack<>();
        for(String str:strs){
            // 一个点（.）表示当前目录本身
            if(".".equals(str) || "".equals(str)){
                continue;
            }
            //两个点 （..） 表示将目录切换到上一级（指向父目录）
            if("..".equals(str)){
                // 如果栈中没有值 说明已经达到最大的根目录 无需进退
                if(stack.empty()){
                    continue;
                }
                stack.pop();
                continue;
            }
            stack.push(str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 如果栈为空 直接返回根目录
        if(stack.empty()){
            stringBuilder.append("/");
            return stringBuilder.toString();
        }
        // 由于栈是先进后出 所以需要不断向前累加
        while (!stack.empty()){
            String str = stack.pop();
            stringBuilder.insert(0,str).insert(0,"/");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        String simplePath = simplifyPath(path);
        System.out.println(simplePath);
    }
}
