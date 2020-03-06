package io.jovi.gyaradoseu.algorithm.interview;

/**
 * <p>
 * Title: 亮灯游戏
 * </p>
 * <p>
 * Description:
 * 1. 相邻都为亮或暗，该灯下一秒变亮。
 * 2. 左右两边，如果该灯亮的，下一秒变暗。
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
public class LightSwitch {
    /**
     * 每秒后灯转换变化
     * @param light
     * @return
     */
    public static boolean[] lightSwitch(boolean[] light){

        boolean pre = false;
        for(int i=0;i<light.length;i++){
            // 左右两边，如果该灯亮的，下一秒变暗。
            if(i==0 || i == light.length-1){
                if(light[i]){
                    pre = light[i];
                    light[i] = false;
                }

                continue;
            }
            // 相邻都为亮或暗，该灯下一秒变亮。
            if(pre == light[i+1]){
                pre = light[i];
                light[i] = true;
                continue;
            }
            // 保持原状
            pre = light[i];
        }
        return light;
    }

    public static void main(String[] args) {
        boolean[] light = new boolean[]{true,false,true,false,false,true,false,false};
        // 循环5次 经过5秒
        for(int i=0;i<5;i++){
            light = lightSwitch(light);
        }

        for(boolean l:light){
            System.out.print(l+" ");
        }
        //true,false,true,false,false,true,false,false
        //false true true false false true false false
        //false true true false false true false false
    }
}
