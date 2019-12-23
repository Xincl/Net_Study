package com.xincl.UDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 多次交流
 * 1.使用DatagramSocket，指定端口，接受和发送创建发送端
 * 2.准备数据，将一定转成字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPTalkClient {
      public static void main(String[] args) throws Exception {
		System.out.println("发送端启动中");
		//1.使用DatagramSocket，指定端口，接受和发送创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2.准备数据，将一定转成字节数组
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
	    String s = br.readLine(); 
		byte[] b = s.getBytes();
		//3.封装成DatagramPacket包裹，需要指定目的地(ip,端口
		DatagramPacket packet = new DatagramPacket(b,0,b.length,new InetSocketAddress("localhost",9999));
		//4.发送包裹send(DatagramPacket p)
		client.send(packet);
		if(s.equals("bye")) {
			break;
		}
		//5.释放资源
		
		
		
		}	
		client.close();
	}
}
