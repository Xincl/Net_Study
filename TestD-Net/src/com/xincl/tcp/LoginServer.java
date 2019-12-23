package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
public class LoginServer {
      public static void main(String[] args) throws IOException {
    	System.out.println("------��������-------");
		ServerSocket server = new ServerSocket(8888);
		
		Socket s = server.accept();
		System.out.println("��һ���ͻ����Ѿ�����");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		String data = dis.readUTF();
		String uname = "";
		String upsw = "";
//		System.out.println(data);
		String[] datas = data.split("&");
		for(String info:datas) {
			String[] userInfo = info.split("=");
			if(userInfo[0].equals("uname")) {
				System.out.println("����û���Ϊ�� "+userInfo[1]);
				uname = userInfo[1];
			}else {
				System.out.println("�������Ϊ�� "+userInfo[1]);
				upsw = userInfo[1];
			}
		}
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				
		if((uname.equals("xincl")) && (upsw.equals("xinclandxiaoluo"))) {
			
			dos.writeUTF("��½�ɹ�����ӭ����");
			dos.flush();
		}else {
			dos.writeUTF("��½ʧ�ܣ��������");
			dos.flush();
		}
		dos.flush();
		dis.close();
		s.close();
		server.close();
	}
}
