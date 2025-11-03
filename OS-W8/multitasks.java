// multiple thread multiple task
import java.io.*;
class Task1 extends Thread{
    public void run()
    {
        for(int i=1;i<=5;i++){
            System.out.println("Task 1: "+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class Task2 extends Thread{
    public void run()
    {
        for(int i=1;i<=5;i++){
            System.out.println("Task 2: "+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
class Task3 extends Thread{
    public void run()
    {
        for(int i=1;i<=5;i++){
            System.out.println("Task 3: "+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
public class multitasks {
    public static void main(String arg[]){
        Task1 t1=new Task1();
        Task2 t2=new Task2();
        Task3 t3=new Task3();
        t1.start();
        t2.start();
        t3.start();
    }
}