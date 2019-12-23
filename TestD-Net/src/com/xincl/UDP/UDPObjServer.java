package com.xincl.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 注意：端口不能重复使用，可能出现冲突
 * 接收端
 * 1.使用DatagramSocket，指定端口，接受和发送创建接收端
 * 2.准备容器，将其封装成DatagramPacket包裹
 * 3.阻塞式接受包裹（数据包）             还原成引用数据类类型（对象
 * 4.分析数据
 *  byte[] getData();
 *         getLength();
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPObjServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("接收端启动中");
    	
    	//1.使用DatagramSocket，指定端口，接受和发送创建接收端
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.准备容器，将其封装成DatagramPacket包裹
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.阻塞式接受包裹（数据包）
    	server.receive(packet);
    	
    	//4.分析数据
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		
		String msg = ois.readUTF();
		int i = ois.readInt();
		boolean flag = ois.readBoolean();
		char c = ois.readChar();
		
		System.out.println("按照输入的顺序输出： "+msg+" "+i+" "+flag+" "+c+" "+len);
		//读取-->这叫反序列化
		Object object1 = ois.readObject();
		Object object2 = ois.readObject();
		Object object3 = ois.readObject();
		
		//添加类型转换
		if(object1 instanceof String) {
			String obj = (String)object1;
			System.out.println(obj);
		}
		if(object2 instanceof Date) {
			Date objdate = (Date)object2;
			System.out.println(objdate);
		}
		if(object3 instanceof Employee) {
			Employee objemp = (Employee)object3;
			System.out.println(objemp.getName()+"--->"+objemp.getSalary());
		}
    	
		//5.释放资源
    	server.close();
    	
    	
    	
    	
    	
    	
	}
}
