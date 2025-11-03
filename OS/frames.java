import java.awt.*;
class Thread1 extends Frame implements Runnable{
    Textfield t1;
    Button b1;
    Thread1(){
        setSize(400,400);
        setVisible(true);
        setLayout(new FlowLayout());
        t1=new Textfield(20);
        b1=new Button("submit");
        add(t1);
        add(b1);
    }
    public void run()
    {
       try{
         for(int i=0;i<5;i++)
        {
            Thread.sleep(2000);
            t1.setText(""+i);
        }
    }
        catch (Exception e){
            
        }
    }
    public static void main(String a[])
    {
        Thread1 t1=new Thread1();
        Thread th = new Thread();
        th.start();
    }
}