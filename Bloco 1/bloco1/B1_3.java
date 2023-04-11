import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;


public class B1_3 {

    static Scanner input;
    static  HashMap<String,Double> variables;


 

    static void calculator(){
        
        Stack<Double> stack = new Stack<Double>();
        Scanner input=new Scanner(System.in);
        Double a,b,result=0.0;
        //System.out.print(input.nextLine());

        try {

            while (input.hasNextLine()) {
                System.out.println(stack);
                if(input.hasNextDouble()){
                    //
                    stack.push(input.nextDouble());
                }
                else{
                    String token = input.next();
                    if(token.length()!=1){
                        continue;
                    }
                    switch (token) {
                        case "+":
                            b=stack.pop();
                            a=stack.pop();
                            result=b+a;
                            break;
                        case "-":
                             b=stack.pop();
                             a=stack.pop();
                            result=b-a;
                            break;
                        case "*":
                             b=stack.pop();
                             a=stack.pop();
                             result=b*a;
                             break;
                        case "/":
                             b=stack.pop();
                             a=stack.pop();
                             result=a/b;
                            break;
                    
                        default:
                            break;
                    }
                    stack.push(result);
                }
            }
            
        } catch (Exception e) {
            System.exit(0);
        }

        

    }
    public static void main(String[] args) {
       
       calculator();

    }
}