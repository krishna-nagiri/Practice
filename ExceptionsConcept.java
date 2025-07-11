/*  Exceptions 
 *      -> Exceptions are run-time errors,that should be handled to avoid abnormal execution of our application.
 *      -> Exception are handled in many ways using try{} and Catch{} blocks.
 *      -> Here MyCustomException was a user defined exception, every user defined exception must extend Exception or
 *          RunTimeException class.
 *      -> And if that exception happens that must be handled by the method or class it is calling.
 *      -> "throws" keyword is used to intimate the method which is calling current method, that this current method will throw 
 *          this specific error, make sure you handle it.
 */

class MyCustomException extends RuntimeException{
    public MyCustomException(String str){
        super(str);
    }
}
class A
{
    public void show() throws ClassNotFoundException{
        System.out.println(Class.forName("Recursion"));
    }
}
public class ExceptionsConcept {
    public static void main(String[] args) {
        int num1 = 29;
        int num2 = 0;
        try{
            num2 = 24/num1;
            if(num2 == 0){
                throw new MyCustomException("The Result was not allowed to be zero");
            }
        }catch(ArithmeticException e){
            System.out.println("Arithmetic Exception - " +e.getLocalizedMessage());
        }
        catch(MyCustomException e){
            System.out.println("Arithmetic Exception - "+e.getLocalizedMessage());
        }
        A a_obj = new A();
        try{
            a_obj.show();
        }catch(ClassNotFoundException e){
            System.out.println("Class Not found :  - "+e.getMessage());
           // e.printStackTrace();
        }   
        System.out.println(num2+"\nBye");
        
    }
}
