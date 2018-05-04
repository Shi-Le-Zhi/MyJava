package Thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
	private static BlockingQueue blockingQueue;
	private ArrayBlockingQueue<Integer> BLOCKINGQUEUE;
	private int queueSize = 10;

	private BlockingQueue() {
		// TODO Auto-generated constructor stub
	}
	
	public static BlockingQueue getBlockingQueue() {
		if(blockingQueue == null) {
			blockingQueue = new BlockingQueue();
		}
		return blockingQueue;
	}
	
	public ArrayBlockingQueue<Integer> getQueue(){
		if(BLOCKINGQUEUE == null) {
			BLOCKINGQUEUE = new ArrayBlockingQueue<Integer>(queueSize);
		}
		return BLOCKINGQUEUE;
	}
	public static void main(String[] args) {
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					Integer temp = new Random().nextInt(35);
					BlockingQueue.getBlockingQueue().getQueue().offer(temp);
					System.out.println("生产者生产了一个产品"+temp);
				}
			}
			
		}).start();
		
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					Integer temp = BlockingQueue.getBlockingQueue().getQueue().poll();
					System.out.println("消费者消费了一个产品"+temp);
				}
			}
			
		}).start();
	}
	
}
