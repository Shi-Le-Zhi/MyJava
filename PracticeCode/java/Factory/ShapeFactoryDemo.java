package Factory;
//以后不管扩展多少个子类我都不需要修改这个工厂类的代码。
public class ShapeFactoryDemo extends AbstractFactory{
//	public static <T> T getClass(Class<? extends T> clazz) {
//        T obj = null;
//        try {
//            obj = (T) Class.forName(clazz.getName()).newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return obj;
//    }
	@Override
	Corlor getCorlor(String corlor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		if(shape == null){
	         return null;
	      }        
	      if(shape.equalsIgnoreCase("CIRCLE")){
	         return new Circle();
	      } else if(shape.equalsIgnoreCase("RECTANGLE")){
	         return new Rectangle();
	      }
		return null;
	}
}
