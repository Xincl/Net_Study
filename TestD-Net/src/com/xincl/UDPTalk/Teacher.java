package com.xincl.UDPTalk;
/**
 * teacher �ͻ���
 * ������̣߳�ģ�����϶�ν���
 * @author xincl
 *
 */
public class Teacher {
      public static void main(String[] args) {
    	System.out.println("-------��ʦ�ͻ���--------");
		new Thread(new TalkReceive(8888,"ѧ��˵")).start(); // ���ն�
		
		new Thread(new TalkSend(6666,"localhost",9999)).start();  //�������Ͷ�
	}
}
