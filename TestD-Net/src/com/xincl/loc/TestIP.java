package com.xincl.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ����IP 
 * @author xincl
 *
 */
public class TestIP {
      public static void main(String[] args) throws UnknownHostException {
    	//��InetAddress����һ���¶��󣬱����ĵ�ַ 
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//��ȡIP��ַ
		System.out.println(addr.getHostName());//��ȡ���������
		
		//���������õ� InetAddress����
		addr = InetAddress.getByName("www.baidu.com");//��������
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		
		//����IP�õ� InetAddress����
		addr = InetAddress.getByName("14.215.177.38");//��������
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());//��ҪȨ�޲�����ʾ����
		
		
		
		
	}
}
