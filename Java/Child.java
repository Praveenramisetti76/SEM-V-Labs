public class Child extends Parent{
    int a=900;
    string name= "guest";
    Child(int b)
    {
        this.b=b;
    }
    void displayDetails()
    {
        int a =800;
        System.out.println("value of local variable" +a);
        System.out.println("value of instance variable a in current class is " +this.a);
        System.out.println("value of instance variable a in parent class is "+ super.a);
    }
}
