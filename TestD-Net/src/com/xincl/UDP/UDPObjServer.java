package com.xincl.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * ע�⣺�˿ڲ����ظ�ʹ�ã����ܳ��ֳ�ͻ
 * ���ն�
 * 1.ʹ��DatagramSocket��ָ���˿ڣ����ܺͷ��ʹ������ն�
 * 2.׼�������������װ��DatagramPacket����
 * 3.����ʽ���ܰ��������ݰ���             ��ԭ���������������ͣ�����
 * 4.��������
 *  byte[] getData();
 *         getLength();
 * 5.�ͷ���Դ
 * @author xincl
 *
 */
public class UDPObjServer {
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
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		
		String msg = ois.readUTF();
		int i = ois.readInt();
		boolean flag = ois.readBoolean();
		char c = ois.readChar();
		
		System.out.println("���������˳������� "+msg+" "+i+" "+flag+" "+c+" "+len);
		//��ȡ-->��з����л�
		Object object1 = ois.readObject();
		Object object2 = ois.readObject();
		Object object3 = ois.readObject();
		
		//�������ת��
		if(object1 instanceof String) {
			String obj = (String)object1;
			System.out.println(obj);
		}
		if(object2 instanceof Date) {
			Date objdate = (Date)object2;
			System.out.println(objdate);
		}
		if(object3 instanceof Employee) {
			Employee objemp = (Employee)object3;
			System.out.println(objemp.getName()+"--->"+objemp.getSalary());
		}
    	
		//5.�ͷ���Դ
    	server.close();
    	
    	
    	
    	
    	
    	
	}
}
