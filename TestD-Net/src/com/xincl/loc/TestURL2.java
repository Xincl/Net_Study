package com.xincl.loc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 测试URL的使用,绕过服务器权限，直接模仿浏览器连接
 * @author xincl
 *
 */
public class TestURL2 {
     public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.dianping.com");
		//下载资源
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("GET");//还有一种POST的方法，基于协议不同使用不同的方式
		conn.setRequestProperty("User-Agent","Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.87 Mobile Safari/537.36");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String s = null;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}

		
	}
}
