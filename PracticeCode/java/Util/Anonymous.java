package Util;
import Factory.Shape;;
//匿名内部类
public class Anonymous {
	public static void main() {
		 Shape s = new Shape() {

			public void printMessage() {
				// TODO Auto-generated method stub
				System.out.println("I'm anonymous class");
			}
			 
		 };
		 s.printMessage();
	}
}
