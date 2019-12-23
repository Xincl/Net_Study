package com.xincl.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端
 * 1.用DatagramSocket，指定端口，创建接收端
 * 2.准备一个byte数组，包装成一个DatagramPacket接收数据
 * 3.阻塞式接收
 * 4.分析数据
 *    getLength()
 *    getData()
 * 5.释放资源
 * @author xincl
 *
 */
public class TestUDPServer {
      public static void main(String[] args) throws Exception {
    	System.out.println("接收端启动中");
    	//创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		//准备数据，打包数据
		byte[] b = new byte[1000*60];
		DatagramPacket packet = new DatagramPacket(b,0,b.length);
		//接收数据
		server.receive(packet);
		//处理数据
		byte[] datas = packet.getData();//获取数据
		int len = packet.getLength();   //获取长度
		System.out.println(new String(datas,0,len));
		//释放资源
		server.close();

		
	}
}
