import java.util.concurrent.Semaphore;
//
class Lab{
    Semaphore computers = new Semaphore(2);
    void usecomputer(String studentName)
    {
        System.out.println(studentName +" is waiting to use a computer...");
        computers.acquire();
        System.out.println(studentName + "got a computer!");
        Thread.sleep(2000);
        System.out.println(studentName +" is done using the computer");
        computers.release();
    }
    catch{
        
    }
}