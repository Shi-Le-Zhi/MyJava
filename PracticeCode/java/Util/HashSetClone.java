package Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HashSetClone {
	public static void main(String[] args) {
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		Object flag2 = m.put(1, 1);
		System.out.println(flag2);
		Set<Integer> s = new HashSet<Integer>();
		boolean flag = s.add(1);
		System.out.println(flag);
		s.add(2);
		s.add(3);
		Set<Integer> s2 = null;
		//一次转换构造器代替clone方法是个不错的选择。
		s2 = new HashSet<Integer>(s);
		s2.remove(2);
		for(Object i:s2) {
			System.out.println(i);
		}
	}
}
