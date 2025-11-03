public class Employee {
    int id;
    String name;
    float salary;
    static String companyName;

    Employee(){
        System.out.println("Constructor called");
    }
    Employee(int id, String name, float salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
        System.out.println("parametrized constructor");
    }

    void display(){
        System.out.println(id + " " + name + " " + salary);
    }
    public static void main(String[] args){
        Employee e1 = new Employee();
        Employee e2 = new Employee(45, "chandu", 79500f);
        e1.display();
        e2.display();
    }
}
// class : A class is a blue print or a template for creating objects and for defining components
// syntax to define a class:
// class ClassName {
// 	// attributes
// 	// methods
// 	// class
// 	// constructor
// 	// instance blocks
// 	// static blocks
// }

// Object : An object is an instance of class, we can perform operations on a class using object
// we can create multiple objects for a class
// syntax for creating a object:
// ClassName objectName = new ClassName();