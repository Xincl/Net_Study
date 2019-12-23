package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
public class LoginServer {
      public static void main(String[] args) throws IOException {
    	System.out.println("------服务器端-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("有一个客户端已经连接");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String data = dis.readUTF();
		String uname = "";
		String upsw = "";
//		System.out.println(data);
		String[] datas = data.split("&");
		for(String info:datas) {
			String[] userInfo = info.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("你的用户名为： "+userInfo[1]);
				uname = userInfo[1];
			}else {
				System.out.println("你的密码为： "+userInfo[1]);
				upsw = userInfo[1];
			}
		}
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
		if((uname.equals("xincl")) && (upsw.equals("xinclandxiaoluo"))) {
			
			dos.writeUTF("登陆成功，欢迎回来");
			dos.flush();
		}else {
			dos.writeUTF("登陆失败，密码错误");
			dos.flush();
		}
		dos.flush();
		dis.close();
		s.close();
		server.close();
	}
}
