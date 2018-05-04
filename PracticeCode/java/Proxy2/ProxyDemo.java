package Proxy2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProxyDemo {
    public static void main(String[] args) {
        LogHandler logHandler  = new LogHandler(); 
        
        IHello helloProxy = 
                (IHello) logHandler.bind(new HelloSpeaker()); 
        helloProxy.hello("Justin");
        
    }
}


