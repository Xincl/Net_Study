package com.xincl.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端,实现双向交流
 * 1.用Socket创建客户端，指定端口和服务器的目标IP和端口
 * 2.操作IO流
 * 3.释放资源
 * @author xincl
 *
 */
public class FileClient {
      public static void main(String[] args) throws UnknownHostException, IOException {
    	System.out.println("------客户端-------");
		Socket client = new Socket("localhost",8888);
        //文件的拷贝 上传
		InputStream is = new BufferedInputStream(new FileInputStream("./images/1.jpg"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len=is.read(b))!=-1) {
			os.write(b, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		client.close();
	}
}
