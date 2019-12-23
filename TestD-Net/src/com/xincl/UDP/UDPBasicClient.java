package com.xincl.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端
 * 1.使用DatagramSocket，指定端口，接受和发送创建发送端
 * 2.准备数据，将一定转成字节数组           基本数据类型
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPBasicClient {
      public static void main(String[] args) throws Exception {
		System.out.println("发送端启动中");
		//1.使用DatagramSocket，指定端口，接受和发送创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2.准备数据，将一定转成字节数组
		ByteArrayOutputStream bes = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bes));
		//操作数据类型+数据
		dos.writeUTF("编码xincl 最棒");
		dos.writeInt(10);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = bes.toByteArray();
		//3.封装成DatagramPacket包裹，需要指定目的地(ip,端口
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.发送包裹send(DatagramPacket p)
		client.send(packet);
		
		//5.释放资源
		client.close();
		
	}
}
