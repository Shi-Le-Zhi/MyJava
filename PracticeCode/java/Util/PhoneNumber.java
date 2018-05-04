package Util;
import java.util.Map;
import java.util.HashMap;
public class PhoneNumber {
	private  boolean areaCode;
	private  short prefix;
	private  short lineNumber;
	public PhoneNumber (boolean areaNumber,int prefix,int lineNumber) {
		this.areaCode = areaNumber;
		this.prefix = (short)prefix;
		this.lineNumber = (short)lineNumber;
	}
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof PhoneNumber)) return false;
		PhoneNumber pn = (PhoneNumber)o;
		return pn.lineNumber == lineNumber
				&& pn.prefix == prefix
				&& pn.areaCode == areaCode;
	}
	@Override
	public int hashCode() {
		int result = 0;
		result = 31*result + (areaCode?1:0);
		result = 31*result + prefix;
		result = 31*result + lineNumber;
		return result;
	}
	public static  <K, V> HashMap<K,V> newInstance(){
		return new HashMap<K,V>();
	}
	//注意：super.clone()将最终调用object.clone()方法，必须保证要克隆类的所有超类都有行为良好的clone()方法。
	//如果该类的每一个域都只是包含基本类型的值或者包含指向一个不可变对象的引用，那么clone()完全ok。
	@Override
	public PhoneNumber clone() {
		try {
			//注意此处返回的是PhoneNumber对象，而不是Object对象。得益于协变返回类型作为泛型，可以返回被覆盖方法的返回类型的子类，此处即是Object的子类。
			return (PhoneNumber)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Map<PhoneNumber,String> map = PhoneNumber.newInstance();
		map.put(new PhoneNumber(false, 867,5309),"Tony");
		System.out.println(map.get(new PhoneNumber(false, 867,5309)));
	}
}
