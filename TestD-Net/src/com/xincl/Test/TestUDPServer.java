package com.xincl.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն�
 * 1.��DatagramSocket��ָ���˿ڣ��������ն�
 * 2.׼��һ��byte���飬��װ��һ��DatagramPacket��������
 * 3.����ʽ����
 * 4.��������
 *    getLength()
 *    getData()
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class TestUDPServer {
      public static void main(String[] args) throws Exception {
    	System.out.println("���ն�������");
    	//�������ն�
		DatagramSocket server = new DatagramSocket(9999);
		//׼�����ݣ��������
		byte[] b = new byte[1000*60];
		DatagramPacket packet = new DatagramPacket(b,0,b.length);
		//��������
		server.receive(packet);
		//��������
		byte[] datas = packet.getData();//��ȡ����
		int len = packet.getLength();   //��ȡ����
		System.out.println(new String(datas,0,len));
		//�ͷ���Դ
		server.close();

		
	}
}
