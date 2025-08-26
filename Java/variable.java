public class variable {
    static int c=30; // static global variable 
    int d=40; // non static global variable
    public static void main(String [] args){
        // variablename= value
        int a = 10;
            System.out.println(a);
            final double pii=3.14;  //final variable can not be modified , if we try to change it will give error
            System.out.println(pii);
            //classname objname = new classname();
            // for static obj is not needed  but for non static obj is needed
            System.out.println(c);
            variable obj = new variable();
            System.out.println(obj.d);
            m1(args);
    }
    public static void m1(String [] args)
    {
        int b = 20; // local variable cant access outside this method
        System.out.println(b);
    }
}
//we can run the code with out the main method but it will compile but not run, run time error wil come
//java is a compiling language , if we have a error in code it will not run, where as in python it will run but error line will be shown
// types of variable - local, global,final variables
// local - within a method
// global - outside a method
// final - constant value , can not be changed, data types are premitive (int,char,double) and non premitive 
// three types of variables - local, global, final in single program