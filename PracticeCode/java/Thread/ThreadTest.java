package Thread;
//Thread对象调用run()方法只会调用主线程的run()方法，而 不会 创建新的线程(id没有变)。
//run()方法并不会阻塞新线程的建立
public class ThreadTest {
    public static void main(String[] args)  {
//        System.out.println("主线程ID:"+Thread.currentThread().getId());
//        MyThread thread1 = new MyThread("thread1");
//        thread1.start();
//        MyThread thread2 = new MyThread("thread2");
//        thread2.run();
//        MyThread thread3 = new MyThread("thread3");
//        thread3.start();
//        thread3.run();
    	  System.out.println("主线程ID:"+Thread.currentThread().getId());
    	  Thread newThread = new Thread(new MyThread("thread1"));
    	  newThread.start();
    	  newThread.run();
    }
}
 
//class MyThread extends Thread{
//    private String name;
// 
//    public MyThread(String name){
//        this.name = name;
//    }
// 
//    @Override
//    public void run() {
//        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
//    }
//}

class MyThread implements Runnable{
    private String name;
 
    public MyThread(String name){
        this.name = name;
    }
 
    public void run() {
        System.out.println("name:"+name+" 子线程ID:"+Thread.currentThread().getId());
    }
}