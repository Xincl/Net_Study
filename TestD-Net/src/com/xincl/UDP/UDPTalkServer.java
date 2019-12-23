package com.xincl.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 注意：端口不能重复使用，可能出现冲突
 * 多次交流
 * 1.使用DatagramSocket，指定端口，接受和发送创建接收端
 * 2.准备容器，将其封装成DatagramPacket包裹
 * 3.阻塞式接受包裹（数据包）
 * 4.分析数据
 *  byte[] getData();
 *         getLength();
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPTalkServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("接收端启动中");
    	
    	//1.使用DatagramSocket，指定端口，接受和发送创建接收端
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.准备容器，将其封装成DatagramPacket包裹
    	while(true) {
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.阻塞式接受包裹（数据包）
    	server.receive(packet);
    	
    	//4.分析数据
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
    	String s = new String(datas,0,len);
    	System.out.println(s);
    	if(s.equals("bye")) {
    		break;
    	}
		//5.释放资源
    	
    	}
    	server.close();
    	
    	
    	
	}
}
