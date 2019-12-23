package com.xincl.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * 发送端
 * 1.用DatagramSocket 指定端口创建发送端
 * 2.准备byte[]容器，将数据处理成一个字节数组
 * 3.封装成一个DatagramPacket包裹
 * 4.发送数据  send
 * 5.释放资源
 * @author xincl
 *
 */
public class TestUDPClient {
     public static void main(String[] args) throws Exception {
    	System.out.println("发送端启动中");
    	//1.利用DatagramSocket指定端口创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2.准备数据，转换成字节数组
	    String s = "hello 这里是xincl和小罗";
	    byte[] b = s.getBytes();
	    //3.将字节数组打包成一个DatagramPacket包裹
	    DatagramPacket packet = new DatagramPacket(b,0,b.length,new InetSocketAddress("localhost",9999));
	    //4.发送数据
		client.send(packet);
		//5.释放资源
		client.close();
		
		
	}
}
