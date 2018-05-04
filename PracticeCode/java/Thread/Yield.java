package Thread;

class Run  extends Thread{
    @Override
    public void run() {
        long beginTime=System.currentTimeMillis();
        int count=0;
        for (int i=0;i<50000000;i++){
            count=count+(i+1);
            //yield方法会让线程再次进入就绪状态，并不能控制交出去的CPU的时间
            Thread.yield();
        }
        long endTime=System.currentTimeMillis();
        System.out.println("用时："+(endTime-beginTime)+" 毫秒！");
    }
}
 
public class Yield {
    public static void main(String[] args) {
        Run t= new Run();
        t.start();
    }
}