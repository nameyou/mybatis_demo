package com.bxg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
 * for (初始化语句 ; 判断条件语句 ; 控制条件语句 ) {
 *         循环体语句;
 *  }
 * 执行流程
 * 	A:执行初始化语句
 * 	B:执行判断条件语句，看其结果是true还是false
 * •	如果是false，循环结束。
 * •	如果是true，继续执行。
 * 	C:执行循环体语句
 * 	D:执行控制条件语句
 * 	E:回到B继续
 *
 *      for循环：
 *          语法格式
 *              for(初始化语句；判断条件语句；控制条件语句){
 *                  循环体语句；
 *              }
 *
 *          执行流程
 *
 *
 *
 */
public class Demo {
    public static void main(String[] args) {
        //需求: 在控制台输出10000000次Hello World
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");
//        System.out.println("Hello World");

        /**
         * for (初始化语句 ; 判断条件语句 ; 控制条件语句 ) {
         *  *         循环体语句;
         *  *  }
         */

        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello World  " + i);
        }
        // 需求： 计算1-100之间的和
        /**
         * 0+1=1
         1+2=3
         3+3=6
         6+4=10
         10+5=15
         15+6=21
         ......
         *      规律：
         *          第一个参数：就是前两个书的和   初始值是 0
         *          第二个参数： 一直在变化的数，一直递增 而且是每次加 1 -----》1-100；
         *
         */

        //要计算的结果
        int sum = 0;

        for (int i = 0; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("1-100之和" + sum);

        //需求：计算1-100之间的偶数的和
        int sum2 = 0;

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
//                sum2=sum2+i;
                sum2 += i;
            }
        }
        System.out.println("1-100之间的偶数和=" + sum2);

        float f4 = 1000000.789F;
        double d4 = 0.45;
        double add4 = f4 + d4;
        System.out.println(add4);//1000001.2624999904
        List<String> list = new ArrayList<>();
        list.toArray();
        String[] str ={};
        list.toArray(str);

    }
}
