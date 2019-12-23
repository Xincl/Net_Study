package com.xincl.UDPTalk;
/**
 * student 客户端
 * 加入多线程，模拟线上多次交流
 * @author xincl
 *
 */
public class Student {
      public static void main(String[] args) {
    	System.out.println("-------学生客户端--------");
		new Thread(new TalkSend(7777,"localhost",8888)).start();;  //创建发送端
		
		new Thread(new TalkReceive(9999,"老师")).start();  //创建接收端
		
	}
}
