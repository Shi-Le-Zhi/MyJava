package Thread;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//①实现Callable接口 ②获取future对象 ③调用get方法获得返回结果  ④结合线程池接口ExecutorService
public class ReturnThread {
	public static void main(String[] args) {
		Date date1 = new Date();
		int nThreads = 5;
		//创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);//工厂
		//创建多个有返回值的任务
		List<Future> taskList = new ArrayList<Future>();
		for(int i=0; i<nThreads; i++) {
			Callable c = new MyCallable("task" + i);
			//线程池的submit方法返回一个future对象，接收一个Callable类型对象
			Future f = threadPool.submit(c);
			taskList.add(f);
		}
		//关闭线程池
		threadPool.shutdown();
		for(Future future: taskList) {
			try {
				System.out.println(">>>" + future.get().toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" 
     + (date2.getTime() - date1.getTime()) + "毫秒】");
	}
	
}

class MyCallable implements Callable<Object>{
	private String taskNum;  
	MyCallable(String taskNum) {  
	   this.taskNum = taskNum;  
	} 
	public Object call() throws Exception {
		// TODO Auto-generated method stub
	   System.out.println(">>>" + taskNum + "任务启动");  
	   Date dateTmp1 = new Date();  
	   Thread.sleep(1000);  
	   Date dateTmp2 = new Date();  
	   long time = dateTmp2.getTime() - dateTmp1.getTime();  
	   System.out.println(">>>" + taskNum + "任务终止");  
	   return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
		
	}
}