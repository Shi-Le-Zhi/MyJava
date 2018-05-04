package Generic;

import java.lang.reflect.Field;

public class TypeErasureSample<T> {
	public static void main(String[] args) {
		GenericClass<String> type = new GenericClass<String>();
		type.v1 = "String value";
		
		// 反射设置v2的值为整型数
		try {
			Field v2 = GenericClass.class.getDeclaredField("v2");
			try {
				v2.set(type,1);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Field f : GenericClass.class.getDeclaredFields()) {

			System.out.println(f.getName() + ":" + f.getType());

			}
		
	}
	
}
