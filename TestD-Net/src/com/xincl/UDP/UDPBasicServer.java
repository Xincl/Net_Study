package com.xincl.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ע�⣺�˿ڲ����ظ�ʹ�ã����ܳ��ֳ�ͻ
 * ���ն�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
 * 2.׼�������������װ��DatagramPacket����            
 * 3.����ʽ���ܰ��������ݰ���           ��ԭΪ������������
 * 4.��������
 *  byte[] getData();
 *         getLength();
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPBasicServer {
    public static void main(String[] args) throws Exception {
    	System.out.println("���ն�������");
    	
    	//1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
    	DatagramSocket server = new DatagramSocket(9999);
    	
    	//2.
    	byte[] b = new byte[1024*60];
    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
    	
    	//3.����ʽ���ܰ��������ݰ���
    	server.receive(packet);
    	
    	//4.��������
    	byte[] datas = packet.getData();
    	int len = packet.getLength();
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String msg = dis.readUTF();
		int i = dis.readInt();
		boolean flag = dis.readBoolean();
		char c = dis.readChar();
		
		System.out.println("���������˳������� "+msg+" "+i+" "+flag+" "+c+" "+len);
    	
		//5.�ͷ���Դ
    	server.close();
    	
    	
    	
    	
    	
    	
	}
}
