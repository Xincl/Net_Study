package com.xincl.UDP;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 封装流的操作，封装释放系统资源操作
 * 第二版，在JDK１.７之后，新增了一个关闭，释放系统资源的方法
 * 即为　　try...with...source
 * 在try（）括号内声明流
 * @author xincl
 *
 */
public class TestFileUtils2 {
     public static void testCopyFile(InputStream is,OutputStream os) {
 		try {
 			byte[] b = new byte[1024];
 			int len = -1;
 			while((len=is.read(b))!=-1) {
 				os.write(b,0,len);
 				os.flush();
 			}
 			
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}finally {
 			close(is,os);
 		}
     }

     public static byte[] fileToByteArray(InputStream is,ByteArrayOutputStream os) {
     	//1.创建源
//     	  byte[] dest = null;
     	  
         //2.选择流
 		try {
 			//3.
 			  byte[] car = new byte[1024*100];   
 			  int len = -1;               
 	    	  while((len=is.read(car))!=-1) { 
 	    		  os.write(car,0,len);
 	    	  }
 	    	  os.flush();
 	    	  return os.toByteArray();
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}finally {
 			closeable();
 		}
 		return null;
       }

     public static void ByteArrayToFile(InputStream is,OutputStream os) {
   	  try {
			byte[] bes = new byte[1024*100];
			int len = -1;
			while((len=is.read(bes))!=-1) {
				os.write(bes,0,len);
			}
			os.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeable();
		}
     }
     
     public static void close(InputStream is,OutputStream os) {
  			if(os!=null) {   //先打开后关闭,分别关闭
  				try {
  					os.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
  			if(is!=null) {   //先打开后关闭,分别关闭
  				try {
  					is.close();
  				} catch (IOException e) {
  					e.printStackTrace();
  				}
  			}
     }

     //或者close的写法可以这样写
     public static void closeable(Closeable... ios){
    	 for(Closeable io:ios) {
    			 try {
    			if(io!=null) {
					io.close();
    			}
				} catch (IOException e) {
					e.printStackTrace();
				}
    		 }
     }
}


