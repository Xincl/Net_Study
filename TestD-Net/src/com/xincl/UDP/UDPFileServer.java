package com.xincl.UDP;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ע�⣺�˿ڲ����ظ�ʹ�ã����ܳ��ֳ�ͻ
 * ���ն�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
 * 2.׼�������������װ��DatagramPacket����
 * 3.����ʽ���ܰ��������ݰ���                         �ļ�������
 * 4.��������
 *  byte[] getData(); 
 *         getLength();
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPFileServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("���ն�������");
    	
    	//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.׼�������������װ��DatagramPacket����
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.����ʽ���ܰ��������ݰ���
    	server.receive(packet);
    	
    	//4.��������
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
    	
		//�ֽ����鵽�ļ�
		InputStream is = new ByteArrayInputStream(datas);
		OutputStream os = new FileOutputStream("./images/2.jpg",true);
		TestFileUtils2.ByteArrayToFile(is, os);
 	    System.out.println(len);
		//5.�ͷ���Դ
    	server.close();
    	
	}
}
