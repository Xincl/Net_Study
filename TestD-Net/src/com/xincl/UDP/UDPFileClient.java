package com.xincl.UDP;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
 * 2.׼�����ݣ���һ��ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)                  �ļ����ϴ�
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPFileClient {
      public static void main(String[] args) throws Exception {
		System.out.println("���Ͷ�������");
		//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		//2.׼�����ݣ���һ��ת���ֽ�����
		InputStream is = new FileInputStream("./images/1.jpg");
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] datas = TestFileUtils2.fileToByteArray(is,os);
		//3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�(ip,�˿�
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		
		//5.�ͷ���Դ
		client.close();
		
	}
}
