package Util;

public enum Enum {
	RED("红色", 1),GREEN("绿色", 2),YELLOW("黄色", 4);
	private String name;  
    private int index;
    private Enum(String name, int index) {
    	this.name = name;
    	this.index = index;
    }
    
    public static String getName(int index) {
    	for(Enum e : Enum.values()) {
    		if(e.getIndex() == index)
    			return e.getName();
    	}
    	return null;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
    
	public static void main(String[] args) {
		System.out.println(Enum.getName(1));
		
	}
    
}
