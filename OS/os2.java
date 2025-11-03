import java.io.*;
class Thread1 extends Thread{
    public void run()
    {
       try {
           for(int i=0;i<10;i++)
           {
               if(i%2==0) System.out.println("even number "+i);
           }
       }catch(Exception e){
           System.out.println(e);
       }
    }
     static class Thread2 extends Thread{
        public void run()
        {
           try {
               for(int i=0;i<10;i++)
               {
                   if(i%2!=0) System.out.println("odd number "+i);
               }
           }catch(Exception e){
               System.out.println(e);
           }
        }
    }
    public static void main(String arg[]){
        System.out.println("thread1 working");
        Thread1 t1=new Thread1();
        t1.setName("even thread");
        t1.start();
         System.out.println("thread2 working");
        Thread2 t2=new Thread2();
        t2.setName("odd thread");
        t2.start();
    }
}