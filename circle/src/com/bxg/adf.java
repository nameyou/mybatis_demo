package com.bxg;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import javax.sound.midi.Soundbank;

public class adf {
    public static void main(String[] args) {
//        String s0 = "ab";
//        String s1 = "b";
//        String s2 = "a" + s1;
//        System.out.println("===========test7============");
//        System.out.println((s0 == s2)); //result = false
//        System.out.println(s0.equals(s2));//true


        /**
         * 对于final修饰的变量，它在编译时被解析为常量值的一个本地拷贝存储到自己的常量池中或嵌入到它的字节码流中
         */
        System.out.println("===========test9============");
        String s0 = "ab";
        s0.intern();
        final String s1 = "b";
        String s2 = "a" + s1;
        System.out.println((s0 == s2)); //result = true
    }
}
