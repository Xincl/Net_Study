package com.xincl.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ���
 * 1.��Socket�����ͻ��ˣ�ָ���˿ںͷ�������Ŀ��IP�Ͷ˿�
 * 2.����IO��
 * 3.�ͷ���Դ
 * @author xincl
 *
 */
public class Client {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------�ͻ���-------");
		Socket client = new Socket("localhost",8888);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		String s = "hello";
		dos.writeUTF(s);
        
		dos.close();
		client.close();
	}
}
