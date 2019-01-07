package com.bxg;

import sun.print.SunMinMaxPage;

/**
 * 初始化语句;
 * while(判断条件语句) {
 * 循环体语句;
 * 控制条件语句;
 * }
 *
 * for和while的区别：
 *          for定义的这个变量，循环结束后就消失了，
 *          while循环 结束后，这个变量还可以使用。
 *
 *
 * while ：
 *      语法结构
 *      和for的区别
 *
 *      推荐：使用for
 *
 */
public class WhileDemo {

    public static void main(String[] args) {
        //需求: 在控制台输出10次Hello World
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Hello World");
//        }
//        System.out.println(i);

        //使用while循环
//        int i = 0;
//        while (i < 10) {
//            System.out.println("Hello World---while" + i);
//            i++;
//        }
//        System.out.println("=====================" + i);

        //需求： 计算1-100之间的和

        int sum = 0;
        int l = 0;
        while (l <= 100) {
            if (l % 2 == 0) {
                sum += l;
            }
            l++;
        }
        System.out.println("1-100之间的和---while=" + sum);


    }


}
