package com.xincl.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
/**
 * ���Ͷ�
 * 1.��DatagramSocket ָ���˿ڴ������Ͷ�
 * 2.׼��byte[]�����������ݴ����һ���ֽ�����
 * 3.��װ��һ��DatagramPacket����
 * 4.��������  send
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class TestUDPClient {
     public static void main(String[] args) throws Exception {
    	System.out.println("���Ͷ�������");
    	//1.����DatagramSocketָ���˿ڴ������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		//2.׼�����ݣ�ת�����ֽ�����
	    String s = "hello ������xincl��С��";
	    byte[] b = s.getBytes();
	    //3.���ֽ���������һ��DatagramPacket����
	    DatagramPacket packet = new DatagramPacket(b,0,b.length,new InetSocketAddress("localhost",9999));
	    //4.��������
		client.send(packet);
		//5.�ͷ���Դ
		client.close();
		
		
	}
}
