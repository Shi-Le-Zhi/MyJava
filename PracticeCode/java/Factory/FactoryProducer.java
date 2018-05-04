package Factory;

public class FactoryProducer {
	   public static AbstractFactory getFactory(String choice){
	      if(choice.equalsIgnoreCase("SHAPE")){
	         return new ShapeFactoryDemo();
	      } else if(choice.equalsIgnoreCase("CORLOR")){
	         return new CorlorFactoryDemo();
	      }
	      return null;
	   }
	}
