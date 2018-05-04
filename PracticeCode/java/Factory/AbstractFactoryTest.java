package Factory;

public class AbstractFactoryTest {
	public static void main(String[] args) {
		AbstractFactory ShapeFactory = FactoryProducer.getFactory("shape");
		Circle circle = (Circle) ShapeFactory.getShape("circle");
		circle.printMessage();
		AbstractFactory CorlorFactory = FactoryProducer.getFactory("corlor");
		Red red = (Red) CorlorFactory.getCorlor("red");
		red.printCorlor();
	}
}
