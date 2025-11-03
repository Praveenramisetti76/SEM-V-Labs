class Student extends Thread{
    Lab lab;
    Strinig name;
    Student(Lab lab,String name)
    {
        this.lab=lab;
        this.name=name;
    }
    public void run()
    {
        lab.usecomputer(name);
    }
}