package Util;
//双锁机制：线程安全并且性能较高，对于getInstance()方法使用频繁的程序可以使用这个。
//volatile:告诉编译器后方变量随时可能改变，不要优化（不要去读取寄存器里面的备份，而去取原值的值）
public class SingletonDemo2 {
	private volatile static SingletonDemo2 instance;
	private SingletonDemo2(){}
	public static SingletonDemo2 getInstance() {
		if(instance == null) {
			synchronized(SingletonDemo2.class) {
				if(instance == null) {
					instance = new SingletonDemo2();
				}
			}
		}
		return instance;
	}
	
}
