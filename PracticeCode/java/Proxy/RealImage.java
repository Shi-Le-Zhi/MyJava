package Proxy;

public class RealImage implements Image{
	private String fileName;

   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying " + fileName);
	}
	private void loadFromDisk(String fileName){
	      System.out.println("Loading " + fileName);
	   }

}
