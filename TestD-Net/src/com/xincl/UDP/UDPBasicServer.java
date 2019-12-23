package com.xincl.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 注意：端口不能重复使用，可能出现冲突
 * 接收端
 * 1.使用DatagramSocket，指定端口，接受和发送创建接收端
 * 2.准备容器，将其封装成DatagramPacket包裹            
 * 3.阻塞式接受包裹（数据包）           还原为基本数据类型
 * 4.分析数据
 *  byte[] getData();
 *         getLength();
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPBasicServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("接收端启动中");
    	
    	//1.使用DatagramSocket，指定端口，接受和发送创建接收端
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.阻塞式接受包裹（数据包）
    	server.receive(packet);
    	
    	//4.分析数据
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int i = dis.readInt();
		boolean flag = dis.readBoolean();
		char c = dis.readChar();
		
		System.out.println("按照输入的顺序输出： "+msg+" "+i+" "+flag+" "+c+" "+len);
    	
		//5.释放资源
    	server.close();
    	
    	
    	
    	
    	
    	
	}
}
