package Util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UserDefineClassLoader extends ClassLoader{
	private String root;
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		byte[] classData = loadClassData(name);
		if(classData == null) {
			throw new ClassNotFoundException();
		}else {
			return defineClass(name,classData,0,classData.length);
		}
	}
	private byte[] loadClassData(String className) {
		String filename = root + File.separatorChar + className.replace('.', File.pathSeparatorChar) +".class";
		InputStream is = null;
		BufferedInputStream bis = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(filename);
			bis = new BufferedInputStream(is);
			baos = new ByteArrayOutputStream();
			byte[] bytes = new byte[1024];
			int len = 0;
			try {
				while((len = bis.read(bytes))!=-1) {
					baos.write(bytes,0,len);
				}
				byte[] bufferbyte = baos.toByteArray();
				baos.close();
				bis.close();
				is.close();
				return bufferbyte;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				baos.close();
				bis.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		UserDefineClassLoader udcl = new UserDefineClassLoader();
		udcl.setRoot("E:\\idea");
		Class<?> testClass = null;
		try {
			testClass = udcl.loadClass("yan.Find");
			try {
				Object object = testClass.newInstance();
				System.out.println(object.getClass().getClassLoader());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
