package Factory;

public class FactoryDemo {
	public static Shape getShape(String shape) {
		if(shape == null) return null;
		else if(shape.equalsIgnoreCase("circle")) return new Circle();
		else if(shape.equalsIgnoreCase("rectangle")) return new Rectangle();
		else return null;
	}
}
