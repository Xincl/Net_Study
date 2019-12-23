package com.xincl.UDPTalk;
/**
 * teacher 客户端
 * 加入多线程，模拟线上多次交流
 * @author xincl
 *
 */
public class Teacher {
      public static void main(String[] args) {
    	System.out.println("-------老师客户端--------");
		new Thread(new TalkReceive(8888,"学生说")).start(); // 接收端
		
		new Thread(new TalkSend(6666,"localhost",9999)).start();  //创建发送端
	}
}
