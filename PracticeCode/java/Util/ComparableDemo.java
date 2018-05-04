package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparableDemo{
	
	public static void main(String[] args) {
		List<Student> s = new ArrayList<Student>();
		ComparableDemo cd = new ComparableDemo();
		Student s1 = cd.new Student(13,"sd");
		Student s2 = cd.new Student(11,"sd");
		Student s3 = cd.new Student(17,"sd");
		s.add(s1);
		s.add(s2);
		s.add(s3);
		Collections.sort(s);
		Collections.binarySearch(s, cd.new Student(13,"sd"));
		for(int i=0;i<s.size();i++) {
			System.out.println(s.get(i).toString());
		}
		
	}
	
	class Student implements Comparable<Student>{
		private int age;
		private String name;
		
		public Student(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return this.name + " " +this.age;
		}

		public int compareTo(Student s) {
			// TODO Auto-generated method stub
		 int num = this.age - s.age;
         int num1 = (num == 0 ? this.name.compareTo(s.name) : num);
         return num1;
		}
		
	}
	
}
