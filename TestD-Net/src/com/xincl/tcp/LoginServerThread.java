package com.xincl.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������  ʵ��˫����,ʵ�ֶ��̣߳���һ���������ж���ͻ��˽��в���
 * 1.��ServerSocket �����������ˣ�ָ���˿�
 * 2.��Server  ����ʽ�ȴ�accept����
 * 3.����������IO��
 * 4.�ͷ���Դ
 * @author xincl
 *
 */
public class LoginServerThread {
      public static void main(String[] args) throws IOException {
    	System.out.println("------��������-------");
		ServerSocket server = new ServerSocket(8888);
		boolean flag = true;
		while(flag) {
			Socket s = server.accept();
			System.out.println("��һ���ͻ����Ѿ�����");
			new Thread(new Channel(s)).start();
		}
		server.close();
	}
      static class Channel implements Runnable{
        private Socket s;
        private DataInputStream dis;
        private DataOutputStream dos;
		public Channel(Socket s) {
			this.s = s;
			try {
				//����
				dis = new DataInputStream(s.getInputStream());
				//���
				dos = new DataOutputStream(s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				release();
			}
		}

		//��������
		private String receive() {
			String data = "";
			try {
				data = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return data;
		}
    	  
		//���ؿͻ�������
		private void send(String msg) { 
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//�ͷ���Դ
		private void release() {
			try {
				if(dos!=null) {
					dos.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
			    if(s!=null) {
                     s.close();
			    }
				} catch (IOException e) {
					e.printStackTrace();
				}
			try {
				if(dis!=null) {
					dis.close();
				}
				} catch (IOException e) {
					e.printStackTrace();
					}
				}
		
		@Override
		public void run() {
//			receive();
			String data = receive();

			String uname = "";
			String upsw = "";
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
			if((uname.equals("xincl")) && (upsw.equals("xinclandxiaoluo"))) {
				send("��½�ɹ�����ӭ����");
			}else {
				send("��½ʧ�ܣ��û������������");
			}
			release();	
		}
	
		
      }
      
      
}
