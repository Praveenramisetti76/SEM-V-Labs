class Counter {
    int count=0;
    void increment()
    {
        count++;
    }
}
class MyThread extends Thread {
    Counter c;
    MyThread(Counter c)
    {
        this.c=c;
    }
    public void run(){
        for (int i=0;i<100;i++)
        {
            c.increment();
        }
    }
    public static void main(String args[]) throws InterruptedException
    {
        Counter obj=new Counter();
        MyThread t1 = new MyThread(obj);
        MyThread t2 = new MyThread(obj);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("final count without scychronization is " +obj);
        System.out.println("final count without scychronization is " +obj.count);
    }
}
/// without scynonization--------------