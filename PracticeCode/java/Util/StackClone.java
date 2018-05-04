package Util;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackClone implements Cloneable{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	public StackClone() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	public Object pop() {
		if(size==0) throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null;//Eliminate obsolete reference
		return result;
	}
	private void ensureCapacity(){
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2*size + 1);
		}
	}
	//此时的clone方法是错的，因为类指向了可变的引用，即elements。克隆对象会与原对象同时指向同一块区域，那么就会造成修改原对象的灾难。
//	@Override
//	public StackClone clone() {
//		try {
//			return (StackClone) super.clone();
//		} catch (CloneNotSupportedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	//正确做法是通过构造函数来新建一个对象，并把值赋给新的对象
	@Override
	public StackClone clone() {
		try {
			StackClone result = (StackClone)super.clone();
			result.elements = elements.clone();//此克隆数组的类型不需要指定为Object,数组上的clone方法会返回和被克隆数组相同的类型。
			return result;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
