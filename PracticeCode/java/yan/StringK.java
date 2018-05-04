package yan;

import java.util.ArrayList;
import java.util.List;

public class StringK {

    public static String Words(String str,int k) {
    	if(k==0) return str;
    	int min = 100;
    	int index = -1;
    	for(int i=0;i<k+1;i++) {
    		if(min != (int)str.charAt(i)) {
    			min = Math.min(min, (int)str.charAt(i));
        		if(str.charAt(i)==(char)min) {
        			index = Math.max(index, i); 
        		}
    		}		
    	}
    	return str.charAt(index) + Words(str.substring(index+1),k-index);
    }
    
    public static String Words2(String str,int k) {
    	List list = new ArrayList();
    	for(int i=0;i<str.length()-1;i++) {
    		if(str.charAt(i+1)<=str.charAt(i)) {
    			list.add(i);
    		}
    	}
    	String temp = "";
		int start = 0;
    	if(list.size()>=k) {
    		
    		for(int i=0;i<k;i++) {
    			temp += str.substring(start,(Integer)list.get(i));
    			start = (Integer)list.get(i) + 1;
    		}
    		temp = temp + str.substring(start);
    		return temp;
    	}else {
    		for(int i=0;i<list.size();i++) {
    			temp += str.substring(start,(Integer)list.get(i));
    			start = (Integer)list.get(i) + 1;
    		}
    		temp = temp + str.substring(start);
    		temp = temp.substring(0,temp.length()-(k-list.size()));
    		return temp;
    	}
    }
    
    public static void main(String[] args) {
    	System.out.println(StringK.Words2("12435678",3));
    }
}
