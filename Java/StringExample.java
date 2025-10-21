public class StringExample {
public static void main(String[] args)
{
String str= new String("hello");
// // string is immutable so we have two class they are string builder and string buffer
// // string builder is not thread safe and string buffer is thread safe 
    System.out.println(str.length());
    System.out.println(str.toUpperCase());
    StringBuffer sb = new StringBuffer("Hello");
    System.out.println("original string buffer" +sb);
    sb.append(" world");
    System.out.println("modified string buffer" +sb);
    sb.insert(6, "java");
    System.out.println("after insertion " +sb);
    sb.replace(6, 10, "python");
    System.out.println("after replacement " +sb);
    sb.reverse();
    System.out.println("reversed string : "+ sb);

}
}