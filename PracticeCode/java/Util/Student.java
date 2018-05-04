package Util;

public class Student implements Comparable<Student> {

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int compareTo(Student s) {
        int num = this.age - s.age;
        int num1 = (num == 0 ? this.name.compareTo(s.name) : num);
        return num1;
    }
}
