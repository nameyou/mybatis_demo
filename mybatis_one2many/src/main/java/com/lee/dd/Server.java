package com.lee.dd;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String fileName = br.readLine();
        File file = new File("d://upload",fileName);
        if(file.exists()){
            System.out.println("存在");
            socket.close();
            return;
        }else {
            System.out.println("不存在");
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len=is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        socket.getOutputStream().write("上传成功".getBytes());
        fos.close();
        socket.close();
        server.close();
    }
}
