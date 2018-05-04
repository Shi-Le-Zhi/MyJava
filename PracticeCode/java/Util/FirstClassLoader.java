package Util;

import yan.Find;

public class FirstClassLoader {
	public static void main(String[] args) {
		java.lang.ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(loader.toString());
		System.out.println(loader.getParent());
		System.out.println(loader.getParent().getParent());
		
		java.lang.ClassLoader loader2 = Find.class.getClassLoader();
		System.out.println(loader2);
	}

}
