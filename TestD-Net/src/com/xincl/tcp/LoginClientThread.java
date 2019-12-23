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
public class LoginClientThread {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------客户端-------");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("请输入用户名：");
    	String uname = br.readLine();
    	System.out.print("请输入密码： ");
    	String upsw = br.readLine();
    	Socket client = new Socket("localhost",8888);
		Send s = new Send(client);
		Receive r = new Receive(client);
		s.send(uname,upsw);
		
		//读取服务器返回的信息
		String str = r.receive();
		System.out.println(str);
		s.close(client);
		r.close(client);
				
		
	}
      static class Send{
    	  @SuppressWarnings("unused")
		private Socket client;
    	  private DataOutputStream dos;

		  public Send(Socket client) {
			this.client = client;
			 try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
    	  
    	  private void send(String uname,String upsw) {
    		  try {
				dos.writeUTF("uname="+uname+"&"+"upsw="+upsw);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	  }
    	  private void close(Socket client) {
    		  try {
				dos.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	  }
      }
      
      static class Receive{
    	@SuppressWarnings("unused")
		private Socket client;  
    	private DataInputStream dis;
    	
  		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
				try {
					client.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

  	    private void close(Socket client) {
		  try {
			dis.close();
			client.close();
		  } catch (IOException e) {  	
			e.printStackTrace();
		  }
	   }
		private String receive() {
			String str = null;	
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
      }
      
}
