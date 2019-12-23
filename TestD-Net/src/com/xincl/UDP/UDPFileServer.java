package com.xincl.UDP;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 注意：端口不能重复使用，可能出现冲突
 * 接收端
 * 1.使用DatagramSocket，指定端口，接受和发送创建接收端
 * 2.准备容器，将其封装成DatagramPacket包裹
 * 3.阻塞式接受包裹（数据包）                         文件的下载
 * 4.分析数据
 *  byte[] getData(); 
 *         getLength();
 * 5.释放资源
 * @author xincl
 *
 */
public class UDPFileServer {
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
    	
		//字节数组到文件
		InputStream is = new ByteArrayInputStream(datas);
		OutputStream os = new FileOutputStream("./images/2.jpg",true);
		TestFileUtils2.ByteArrayToFile(is, os);
 	    System.out.println(len);
		//5.释放资源
    	server.close();
    	
	}
}
