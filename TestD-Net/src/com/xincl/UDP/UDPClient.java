package com.xincl.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
 * 2.׼�����ݣ���һ��ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPClient {
      public static void main(String[] args) throws Exception {
		System.out.println("���Ͷ�������");
		//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		//2.׼�����ݣ���һ��ת���ֽ�����
		String s = "xincl ���";
		byte[] b = s.getBytes();
		//3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�(ip,�˿�
		DatagramPacket packet = new DatagramPacket(b,0,b.length,new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		
		//5.�ͷ���Դ
		client.close();
		
	}
}
