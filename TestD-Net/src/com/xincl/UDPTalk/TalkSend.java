package com.xincl.UDPTalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * @author xincl
 *
 */
public class TalkSend implements Runnable{
    private DatagramSocket sender;
    private BufferedReader br;
    private String toIP;
    private int toPort;
    
	public TalkSend(int port,String toIP,int toPort) {
		this.toIP = toIP;
		this.toPort = toPort;
		try {
			sender = new DatagramSocket(port);
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(true) {
		    String s;
			try {
				s = br.readLine();
				byte[] b = s.getBytes();
				//3.封装成DatagramPacket包裹，需要指定目的地(ip,端口
				DatagramPacket packet = new DatagramPacket(b,0,b.length,new InetSocketAddress(this.toIP,this.toPort));
				//4.发送包裹send(DatagramPacket p)
				sender.send(packet);
				if(s.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		sender.close();
	}
}
