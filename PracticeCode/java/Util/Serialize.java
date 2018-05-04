package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//当我在外部类中调用一个一个内部类时（内部类实现了Serializable接口），会报出NotSerializableException的错误。所以，当在外部类里面新建一个内部类对象时，
//此外部类也必须实现Serializable接口

 class Serialize implements Serializable{  
   
   public static void main(String[] args) throws Exception{  
	      // create a Serialize object  
	 Student st = (new Serialize()).new Student("jason");  
  
     // serialize the st to jason.se file  
     ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("jason.se"));  
     oos.writeObject(st);  
     oos.close();  
  
     // deserialize the object from jason.se  
     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("jason.se"));  
     Student jason = (Student) ois.readObject();  
     ois.close(); 
   } 
   
   public class Student implements Serializable{
	   private transient String name; 
	 //当然这个值可以自己指定, 也可以通过JDK提供的serializer来查看其默认的hashcode值.  
	   private static final long serialVersionUID = -4333316296251054416L; 
	   public Student(String name){  
	      this.name = name;  
	   }  
	   public String getName(){  
	      return name;  
	   }
	   private void writeObject(ObjectOutputStream oos) throws IOException {  
		      oos.defaultWriteObject();  
		      // 可以执行其他的操作, 比如对反列化的文件进行加密等等  
	   }  
		  
	   private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {  
	      ois.defaultReadObject();  
	      //可以调用其他方法来进行额外的初始化操作  
	   }
   }
}    