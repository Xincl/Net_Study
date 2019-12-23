package com.xincl.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
 * 2.׼�����ݣ���һ��ת���ֽ�����           ������������
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPBasicClient {
      public static void main(String[] args) throws Exception {
		System.out.println("���Ͷ�������");
		//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		//2.׼�����ݣ���һ��ת���ֽ�����
		ByteArrayOutputStream bes = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bes));
		//������������+����
		dos.writeUTF("����xincl ���");
		dos.writeInt(10);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas = bes.toByteArray();
		//3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�(ip,�˿�
		DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		
		//5.�ͷ���Դ
		client.close();
		
	}
}
