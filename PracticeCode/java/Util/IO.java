package Util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.io.FileUtils;

//注意源文件的编码格式
//如果是图片，只能通过字节流方式读写；字节流的好处是可以改变编码格式
public class IO {
	//字节流读取
	//read方法从流中读取一个字节，并返回字节的Int表示方法。因此不可读取汉字
	//read(byte[] b)从流中读取一定量的字节，并存储在字节数组中，返回读取字节数；若b的长度为0，则不读取字节，返回0；若到达流末尾，则返回-1；读取的字节数最多等于数组的长度；
	public static void FileInputTest(File file1,File file2) {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		int len = 0;
		try {
			fos = new FileOutputStream(file2);
			fis = new FileInputStream(file1);
			byte[] bytes = new byte[9];//超出数组长度了该怎么解决
			StringBuffer buffer = new StringBuffer();
			try {
				while((len = fis.read(bytes))!=-1) {
					
					buffer.append(new String(bytes,0,len,"gbk"));
					fos.write(bytes,0,len);
				}
				System.out.println(buffer);
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//优化
	public static void FileInputTest2(File file1,File file2) {
		ByteArrayInputStream bais = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file2);
			fis = new FileInputStream(file1);
			//BufferedInputStream可以将数据流读到缓冲区，提高读写效率
			bis = new BufferedInputStream(fis);
			int len = 0;
			byte[] bytes = new byte[9];
			//捕获内存区域内的数据，并转化为字节数组；可根据数据的大小调整字节数组的大小
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				while((len = fis.read(bytes))!=-1) {
					//当byte数组满了，则会进入一次循环；当读完最后一部分(未填满byte数组)，返回最后一部分字节的个数；之后会返回文件文件末尾，即-1
					//System.out.println(len);
					//往输出流中写入数据,write(bytes)会有错误
					baos.write(bytes,0,len);
					//从流中再写入文件，内容会覆盖之前的文件内容
					fos.write(bytes,0,len);
				}
				byte[] buffer = baos.toByteArray(); 
				System.out.println(new String(buffer));
				baos.close();
				bis.close();
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//字符流读取(读取文件时最好都建立一个缓冲区，方便高效读写)
	//FileInputStream + InputStreamReader = FileReader,需要注意的是如果要想修改编码格式，只能借助前一种方式，即在新建InputStreamReader的时候指定;BufferedReader是装饰器，读取文件是是readLine()方法，要保留换行符就必须加上换行符
	public static void FileReaderTest(File file) {
//		FileInputStream inputStream = null;
//		InputStreamReader isr = null;
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		StringBuffer buffer = new StringBuffer();
		//char[] c = new char[100];
		try {
			//inputStream = new FileInputStream(file);
//			try {
//				isr = new InputStreamReader(inputStream,"gbk");
//			} catch (UnsupportedEncodingException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			try {
				while((line = br.readLine()) != null) {
					buffer.append(new String(line+"\n"));
				}
				System.out.println(buffer);
				br.close();
				fr.close();
				//isr.close();
				//inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//通过文件工具类来读取文件，方便快捷，注意注入依赖的版本
	public static void FileUtilsTest(File file) {
		try {
			List<String> strs = FileUtils.readLines(file,"utf-8");
			//可以将换行符也读出来
			for(String s:strs) {
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void main(String[] args) {
		String path1 = "C:\\Users\\Yan\\eclipse-workspace\\yan\\src\\test\\resources\\test.txt";
		String path2 = "C:\\Users\\Yan\\eclipse-workspace\\yan\\src\\test\\resources\\test2.txt";
		File file1 = new File(path1);
		File file2 = new File(path2);
		//FileInputTest(file1,file2);
		//FileInputTest2(file1,file2);
		//FileReaderTest(file1);
		FileUtilsTest(file1);
	}
}
