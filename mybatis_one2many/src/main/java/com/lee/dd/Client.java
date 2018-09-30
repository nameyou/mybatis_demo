package com.lee.dd;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static File fileName(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件路径");
        while (true){
            String line = sc.nextLine();
            File file = new File(line);
            if(!file.exists()){
                System.out.println("目录不存在，请重新输入");
            }else if(file.isDirectory()){
                System.out.println("输入的是文件夹路径，请输入文件路径");
            }else {
                return file;
            }
        }
    }

    public static void main(String[] args)throws IOException {
        File file =fileName();
        Socket socket = new Socket("127.0.0.1",9999);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String tips = br.readLine();
        if("存在".equals(tips)){
            System.out.println("请不要上传重复的文件");
            socket.close();
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        OutputStream os = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }
        InputStream is = socket.getInputStream();
        while ((len=is.read())!=-1){
            System.out.println(new String(bytes,0,len));
        }
        fis.close();
        socket.close();
    }
}
