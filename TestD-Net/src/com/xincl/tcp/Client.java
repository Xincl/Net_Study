package com.xincl.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 1.用Socket创建客户端，指定端口和服务器的目标IP和端口
 * 2.操作IO流
 * 3.释放资源
 * @author xincl
 *
 */
public class Client {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------客户端-------");
		Socket client = new Socket("localhost",8888);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		String s = "hello";
		dos.writeUTF(s);
        
		dos.close();
		client.close();
	}
}
