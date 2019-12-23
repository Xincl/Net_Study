package com.xincl.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端,实现双向交流
 * 1.用Socket创建客户端，指定端口和服务器的目标IP和端口
 * 2.操作IO流
 * 3.释放资源
 * @author xincl
 *
 */
public class LoginClient {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------客户端-------");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("请输入用户名：");
    	String uname = br.readLine();
    	System.out.print("请输入密码： ");
    	String upsw = br.readLine();
		Socket client = new Socket("localhost",8888);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upsw="+upsw);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
        dos.flush();
		dos.close();
		client.close();
	}
}
