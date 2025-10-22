class Thread1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Thread 1: "+i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
    public static void main(String arg[]){
        Thread1 t1=new Thread1();
        t1.setName("theread a");
        t1.start();
    }
}