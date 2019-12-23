package com.xincl.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端  实现双向交流
 * 1.用ServerSocket 创建服务器端，指定端口
 * 2.用Server  阻塞式等待accept连接
 * 3.操作：操作IO流
 * 4.释放资源
 * @author xincl
 *
 */
public class FileServer {
      public static void main(String[] args) throws IOException {
    	System.out.println("------服务器端-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("有一个客户端已经连接");
 
		//文件的拷贝 下载
		InputStream is = new BufferedInputStream(s.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("./images/3.jpg"));
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b))!=-1) {
			os.write(b, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		server.close();
	}
}
