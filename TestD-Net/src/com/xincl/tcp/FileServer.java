package com.xincl.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������  ʵ��˫����
 * 1.��ServerSocket �����������ˣ�ָ���˿�
 * 2.��Server  ����ʽ�ȴ�accept����
 * 3.����������IO��
 * 4.�ͷ���Դ
 * @author xincl
 *
 */
public class FileServer {
      public static void main(String[] args) throws IOException {
    	System.out.println("------��������-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("��һ���ͻ����Ѿ�����");
 
		//�ļ��Ŀ��� ����
		InputStream is = new BufferedInputStream(s.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("./images/3.jpg"));
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b))!=-1) {
			os.write(b, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		server.close();
	}
}
