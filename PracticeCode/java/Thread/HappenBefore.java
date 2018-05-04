package Thread;

public class HappenBefore{
	private static int value = 0;  

	public synchronized int get(){  
	    return value;  
	}  
	public synchronized void set(int value){  
	    this.value = value;  
	}
	
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
//				try {
//					TimeUnit.SECONDS.sleep(3);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				System.out.println(new HappenBefore().get());
			}
			 
		 }).start();
		
		 new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				new HappenBefore().set(3);
			}
			 
		 }).start();
		 	 
	}
	
	
}
