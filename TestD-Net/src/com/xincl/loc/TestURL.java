package com.xincl.loc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ≤‚ ‘URLµƒ π”√
 * @author xincl
 *
 */
public class TestURL {
     public static void main(String[] args) throws Exception {
		URL url = new URL("https://www.dianping.com");
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String s = null;
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}

		
	}
}
