package com.lee.demo.ss;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/*  一. 提交本阶段学习笔记.如果是手写笔记请提交部分图片

二. 根据需求使用代码实现该需求
需求:应用所学技术实现
1.    客户端向服务器端请求存储一个图片
2.    服务器端进行判定,本地是否存在此图片,并将结果返回给客户端
3.    客户端根据服务器端返回的结果判定,如果服务器端存在该文件则结束程序,
      如果服务器端不存在该文件,则把文件上传到服务器端
4.    服务器端接收到数据然后把数据存储到服务器本地
附加需求:要求要上传的文件名是通过键盘录入的,并且要保证录入的路径是文件路径

功能点罗列:

完成对文件路径的录入

1键盘录入
2封装键盘录入
3排除目录不存在
4排除文件夹路径

完成连接服务器端
1客户端请求连接
2服务器端创建服务对象

服务器端接收请求,并判断服务器端是否存在该数据
1服务器端接收请求
2服务器端判断本地是否存在该文件
3把结果返回给客户端

服务器端返回数据给客户端,客户端并判断是否需要上传
1.    客户端成功接收数据
2.    根据返回结果判断是否需要服务器端上传文件 向服务器端上传文件*/
public class Client {
    public static void main(String[] args) throws IOException {
        File f = getFile();
        Socket so = new Socket("127.0.0.1", 8888);
        PrintWriter pw = new PrintWriter(so.getOutputStream());
        pw.println(f.getName());
        pw.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
        String s = br.readLine();
        if ("存在".equals(s)) {
            System.out.println("文件已存在");
            so.close();
            System.exit(0);
        }

        FileInputStream fr = new FileInputStream(f);
        BufferedOutputStream bos = new BufferedOutputStream(so.getOutputStream());
        byte[] bytes = new byte[1024];
        int a = 0;
        while ((a = fr.read(bytes)) != -1) {
            bos.write(bytes, 0, bytes.length);
        }
        bos.close();
        fr.close();
        br.close();
        pw.close();
        so.close();
    }

    public static File getFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件路径");
        while (true) {
            String s = scanner.nextLine();
            File f = new File(s);
            if (!f.exists()) {
                System.out.println("文件路径不正确");
            } else if (!f.isFile()) {
                System.out.println("您输入的是文件夹路径，请输入文件路径");
            } else {
                return f;
            }
        }
    }
}
