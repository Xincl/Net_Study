package com.xincl.UDPTalk;
/**
 * student �ͻ���
 * ������̣߳�ģ�����϶�ν���
 * @author xincl
 *
 */
public class Student {
      public static void main(String[] args) {
    	System.out.println("-------ѧ���ͻ���--------");
		new Thread(new TalkSend(7777,"localhost",8888)).start();;  //�������Ͷ�
		
		new Thread(new TalkReceive(9999,"��ʦ")).start();  //�������ն�
		
	}
}
