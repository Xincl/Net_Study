package com.xincl.UDPTalk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���ն�
 * @author xincl
 *
 */
public class TalkReceive implements Runnable{
    private DatagramSocket receiver;
    private String name;
    
	public TalkReceive(int port,String name) {
		this.name = name;
		try {
			receiver = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
	    	byte[] b = new byte[1024*60];
	    	DatagramPacket packet = new DatagramPacket(b,0,b.length);
	    	
	    	//3.����ʽ���ܰ��������ݰ���
	    	try {
				receiver.receive(packet);
				//4.��������
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String s = new String(datas,0,len);
				System.out.println(name+": "+s);
				if(s.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	}
     		//5.�ͷ���Դ
	    	receiver.close();
	}

}
