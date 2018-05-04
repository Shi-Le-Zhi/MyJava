package Factory;
//每次实例化一个子类的时候必须得创建一个工厂类，但是这个工厂类我其实是不需要的，会造成资源的浪费
public class FactoryTest {
	public static void main(String[] args) {
		FactoryDemo shapeFactory = new FactoryDemo();
		Shape circle = shapeFactory.getShape("circle");
		circle.printMessage();
		Shape rectangle = shapeFactory.getShape("rectangle");
		rectangle.printMessage();
		Shape circle2 = FactoryDemo.getShape("circle");
		circle2.printMessage();
	}
}

//反射机制获取jvm里的class类对象
//获取Class类的三种方法：
//①类名.class 如：Class c = Person.class;
//②对象.getClass() 如：Class c = person.getClass()
//③通过全类名    如：Class c = Class.forName("com.java.reflect.Person")

//public class FactoryTest {
//	public static void main(String[] args) {
//		Shape circle = (Circle)ShapeFactoryDemo.getClass(Circle.class);
//		circle.printMessage();
//		Shape rectangle = (Rectangle)ShapeFactoryDemo.getClass(Rectangle.class);
//		rectangle.printMessage();
//	}
//}

//new 与 newInstance的区别：newInstance虽然效率比new差，但是用于工厂模式的时候，不需要修改工厂代码，可扩展性高