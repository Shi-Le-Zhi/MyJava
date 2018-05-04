package Factory;

public class CorlorFactoryDemo extends AbstractFactory{
	
	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Corlor getCorlor(String corlor) {
		// TODO Auto-generated method stub
		if(corlor == null){
	         return null;
	      }        
	      if(corlor.equalsIgnoreCase("RED")){
	         return new Red();
	      } else if(corlor.equalsIgnoreCase("Yellow")){
	         return new Yellow();
	      }
		return null;
	}
}
