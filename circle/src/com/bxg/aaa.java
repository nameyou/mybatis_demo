package com.bxg;

import java.io.File;

public class aaa {
    public static void main(String[] args) {
        File file = new File("E:\\大数据之Hadoop视频\\4.视频");
        File[] files = file.listFiles();

//        getFile(files);

        System.out.println(1%6);//1
        System.out.println(2%6);//2
        System.out.println(3%6);//3
        System.out.println(4%6);//4
        System.out.println(5%6);//5


    }


    private static void getFile(File[] files) {
        for (File f : files)
            if (f.isDirectory()) {
                System.out.println(f.getName());
//                getFile(f);
            } else {
                String oriName = f.getName();
                String substring = oriName.substring(0, 2);
//                System.out.println(substring);
                String substring1 = oriName.substring(6, oriName.length());
//                System.out.println(substring1);
                String concat = substring.concat(substring1);
//                System.out.println(concat);
                File f1 = new File("E:\\大数据之Hadoop视频\\4.视频");
                File file = new File(f1,concat);
                boolean b = f.renameTo(file);
                System.out.println(b);
            }
    }
}
