package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Syn {
	public static AtomicInteger count = new AtomicInteger();
	
	public static void increment() {
        count.incrementAndGet();
}
	static void method(Thread thread){

        System.out.println("begin "+thread.getName());

        try{
        	
        Thread.sleep(2000);

        }catch(Exception ex){

        ex.printStackTrace();

        }

        System.out.println("end "+thread.getName());
        System.out.println(count.get());

    }
	
	//同步方式一：同步方法

    synchronized static void method1(Thread thread){//这个方法是同步的方法，每次只有一个线程可以进来

       System.out.println("begin "+thread.getName());
       
        try{
        //count++;
        Thread.sleep(2000);

        }catch(Exception ex){

         ex.printStackTrace();

        }

        System.out.println("end "+thread.getName());
        System.out.println(count);
       }
    
    //同步方式二：同步代码块

    static void method2(Thread thread){

        synchronized(Syn.class) {

        System.out.println("begin "+thread.getName());

        try{
        	//count++;
              Thread.sleep(2000);

            }catch(Exception ex){

              ex.printStackTrace();

            }

            System.out.println("end "+thread.getName());
            System.out.println(count);
        }

    }
    
  //同步方式三：使用同步对象锁

    private static Object _lock1=new Object();

    private static byte _lock2[]={};//据说，此锁更可提高性能。源于：锁的对象越小越好
    
    private static Integer _lock3 = 0;

    static void method3(Thread thread){

        synchronized(_lock3) {

        System.out.println("begin "+thread.getName());

        try{
        	//count++;
              Thread.sleep(2000);

            }catch(Exception ex){

              ex.printStackTrace();

            }

            System.out.println("end "+thread.getName());
            System.out.println(count);
        }

    }
    
    public static void main(String[] args){
        //启动3个线程，这里用了匿名类

       for(int i=0;i<3;i++){

             new Thread(){

                 public void run(){
                	 
                   //increment();	 

                   method(this);

                   //method1(this);

                   //method2(this);

                   //method3(this);

                 }

             }.start();

         }

     }
	
}
