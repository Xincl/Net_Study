package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������
 * 1.��ServerSocket �����������ˣ�ָ���˿�
 * 2.��Server  ����ʽ�ȴ�accept����
 * 3.����������IO��
 * 4.�ͷ���Դ
 * @author xincl
 *
 */
public class Server {
      public static void main(String[] args) throws IOException {
    	System.out.println("------��������-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("��һ���ͻ����Ѿ�����");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		
		dis.close();
		s.close();
		server.close();
	}
}
