package com.xincl.loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 测试IP 
 * @author xincl
 *
 */
public class TestIP {
      public static void main(String[] args) throws UnknownHostException {
    	//用InetAddress创建一个新对象，本机的地址 
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());//获取IP地址
		System.out.println(addr.getHostName());//获取计算机名字
		
		//根据域名得到 InetAddress对象
		addr = InetAddress.getByName("www.baidu.com");//根据域名
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		
		//根据IP得到 InetAddress对象
		addr = InetAddress.getByName("14.215.177.38");//根据域名
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());//需要权限才能显示出来
		
		
		
		
	}
}
