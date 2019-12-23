package com.xincl.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���,ʵ��˫����
 * 1.��Socket�����ͻ��ˣ�ָ���˿ںͷ�������Ŀ��IP�Ͷ˿�
 * 2.����IO��
 * 3.�ͷ���Դ
 * @author xincl
 *
 */
public class FileClient {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------�ͻ���-------");
		Socket client = new Socket("localhost",8888);
        //�ļ��Ŀ��� �ϴ�
		InputStream is = new BufferedInputStream(new FileInputStream("./images/1.jpg"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b))!=-1) {
			os.write(b, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		client.close();
	}
}
