package Thread;

import java.util.concurrent.TimeUnit;
//boolean类型的变量本身就是原子类型的，加入同步锁不是为了互斥访问，而是为了通信效果，即进入同步区的线程可以看同一锁保护下的所有修改效果，即保证一个线程写入的值对另一个线程是可见的。
//可以通过将stopRequested变量声明为volatile来代替锁。必须满足：对数据的操作是原子的。（若变量执行i++操作，那么不能用volatile来代替锁）
public class StopThread {
	private static volatile boolean stopRequested;
	private static int count = 0;
	//同步写方法
//	private static synchronized void requestStop() {
//		stopRequested = true;
//	}
//	//同步读方法
//	private static synchronized boolean stopRequested() {
//		return stopRequested;
//	}
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Thread backgroundThread = new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				//while(!stopRequested) {
					
					count++;
				//}
			}
		});
		
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		//requestStop();
		count++;
		//stopRequested = true;
		System.out.println(count);
		
	}
}
