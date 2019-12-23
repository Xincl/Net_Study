package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 1.用ServerSocket 创建服务器端，指定端口
 * 2.用Server  阻塞式等待accept连接
 * 3.操作：操作IO流
 * 4.释放资源
 * @author xincl
 *
 */
public class Server {
      public static void main(String[] args) throws IOException {
    	System.out.println("------服务器端-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("有一个客户端已经连接");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		
		dis.close();
		s.close();
		server.close();
	}
}
