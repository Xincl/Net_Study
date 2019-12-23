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
public class LoginClientThread {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------�ͻ���-------");
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	System.out.print("�������û�����");
    	String uname = br.readLine();
    	System.out.print("���������룺 ");
    	String upsw = br.readLine();
    	Socket client = new Socket("localhost",8888);
		Send s = new Send(client);
		Receive r = new Receive(client);
		s.send(uname,upsw);
		
		//��ȡ���������ص���Ϣ
		String str = r.receive();
		System.out.println(str);
		s.close(client);
		r.close(client);
				
		
	}
      static class Send{
    	  @SuppressWarnings("unused")
		private Socket client;
    	  private DataOutputStream dos;

		  public Send(Socket client) {
			this.client = client;
			 try {
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
    	  
    	  private void send(String uname,String upsw) {
    		  try {
				dos.writeUTF("uname="+uname+"&"+"upsw="+upsw);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	  }
    	  private void close(Socket client) {
    		  try {
				dos.close();
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	  }
      }
      
      static class Receive{
    	@SuppressWarnings("unused")
		private Socket client;  
    	private DataInputStream dis;
    	
  		public Receive(Socket client) {
			this.client = client;
			try {
				dis = new DataInputStream(client.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
				try {
					client.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

  	    private void close(Socket client) {
		  try {
			dis.close();
			client.close();
		  } catch (IOException e) {  	
			e.printStackTrace();
		  }
	   }
		private String receive() {
			String str = null;	
			try {
				str = dis.readUTF();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
      }
      
}
