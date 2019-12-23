package com.xincl.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ע�⣺�˿ڲ����ظ�ʹ�ã����ܳ��ֳ�ͻ
 * ��ν���
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
public class UDPTalkServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("���ն�������");
    	
    	//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.׼�������������װ��DatagramPacket����
    	while(true) {
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.����ʽ���ܰ��������ݰ���
    	server.receive(packet);
    	
    	//4.��������
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
    	String s = new String(datas,0,len);
    	System.out.println(s);
    	if(s.equals("bye")) {
    		break;
    	}
		//5.�ͷ���Դ
    	
    	}
    	server.close();
    	
    	
    	
	}
}
