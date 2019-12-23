package com.xincl.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 发送端
 * 1.使用DatagramSocket，指定端口，接受和发送创建发送端
 * 2.准备数据，将一定转成字节数组                    引用类型（对象
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPObjClient {
      public static void main(String[] args) throws Exception {
		System.out.println("发送端启动中");
		//1.使用DatagramSocket，指定端口，接受和发送创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		//2.准备数据，将一定转成字节数组
		ByteArrayOutputStream bes = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(bes));
		//操作数据类型+数据
		oos.writeUTF("编码");
		oos.writeInt(10);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//写出-->这叫序列化
		oos.writeObject("我的故事都是关于你啊");
		oos.writeObject(new Date());
		Employee e = new Employee("xincl", 50000);
		oos.writeObject(e);
		oos.flush();
		byte[] datas = bes.toByteArray();
		//3.封装成DatagramPacket包裹，需要指定目的地(ip,端口
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.发送包裹send(DatagramPacket p)
		client.send(packet);
		
		//5.释放资源
		client.close();
		
	}
}
