package Util;
//懒汉模式，只有在getInstance方法被调用时实例才被创建。再getInsatnce()不被频繁调用的程序中使用才不会太多的影响性能
public class SingletonDemo {
	private static int count = 0;
	private static SingletonDemo instance; 
	//private static SingletonDemo instance= new SingletonDemo();饿汉模式，在jvm装载类时便已经创建了一个实例对象，优点是不用再考虑线程是否安全，
	//缺点是若不是getInstance()方法导致的类装在，就会造成资源浪费。
    private SingletonDemo (){}  
  
    public static synchronized SingletonDemo getInstance() { 
    count++;
    if (instance == null) {  
        instance = new SingletonDemo();  
    }  
    return instance;  
    }
    
    public void printMessage() {
    	System.out.println("hello world");
    }
    public static int getCount() {
    	return count;
    }
    
    public static void main(String[] args) {
    	SingletonDemo s = getInstance();
    	s.printMessage();
    	System.out.println(s.getCount());
    	
    }
}
