package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端  实现双向交流,实现多线程，即一个服务器有多个客户端进行操作
 * 1.用ServerSocket 创建服务器端，指定端口
 * 2.用Server  阻塞式等待accept连接
 * 3.操作：操作IO流
 * 4.释放资源
 * @author xincl
 *
 */
public class LoginServerThread {
      public static void main(String[] args) throws IOException {
    	System.out.println("------服务器端-------");
		ServerSocket server = new ServerSocket(8888);
		boolean flag = true;
		while(flag) {
			Socket s = server.accept();
			System.out.println("有一个客户端已经连接");
			new Thread(new Channel(s)).start();
		}
		server.close();
	}
      static class Channel implements Runnable{
        private Socket s;
        private DataInputStream dis;
        private DataOutputStream dos;
		public Channel(Socket s) {
			this.s = s;
			try {
				//输入
				dis = new DataInputStream(s.getInputStream());
				//输出
				dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}

		//接收数据
		private String receive() {
			String data = "";
			try {
				data = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
    	  
		//返回客户端数据
		private void send(String msg) { 
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//释放资源
		private void release() {
			try {
				if(dos!=null) {
					dos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
			    if(s!=null) {
                     s.close();
			    }
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				if(dis!=null) {
					dis.close();
				}
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
		
		@Override
		public void run() {
//			receive();
			String data = receive();

			String uname = "";
			String upsw = "";
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
			if((uname.equals("xincl")) && (upsw.equals("xinclandxiaoluo"))) {
				send("登陆成功，欢迎回来");
			}else {
				send("登陆失败，用户名或密码错误");
			}
			release();	
		}
	
		
      }
      
      
}
