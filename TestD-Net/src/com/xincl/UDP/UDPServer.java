package com.xincl.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ע�⣺�˿ڲ����ظ�ʹ�ã����ܳ��ֳ�ͻ
 * ���ն�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
 * 2.׼�������������װ��DatagramPacket����
 * 3.����ʽ���ܰ��������ݰ���
 * 4.��������
 *  byte[] getData();
 *         getLength();
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPServer {
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
    	System.out.println(new String(datas,0,len));
    	
		//5.�ͷ���Դ
    	server.close();
    	
    	
    	
    	
    	
    	
	}
}
