package com.xincl.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class LoginClient {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------�ͻ���-------");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("�������û�����");
    	String uname = br.readLine();
    	System.out.print("���������룺 ");
    	String upsw = br.readLine();
		Socket client = new Socket("localhost",8888);
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("uname="+uname+"&"+"upsw="+upsw);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
        dos.flush();
		dos.close();
		client.close();
	}
}
