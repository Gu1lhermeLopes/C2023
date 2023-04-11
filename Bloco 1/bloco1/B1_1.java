import java.util.Scanner;

public class B1_1 {

    private static Scanner input;

    static String readToken(){
        String token=null;
        try {
            token=input.next();
        } catch (Exception e) {
            System.exit(0);
        }
        return token;
    }

    static String operation(){
        String token;
        for(;;){
            token=readToken();
            if (token.length()==1 && (token.charAt(0) =='+' || token.charAt(0) =='-'|| token.charAt(0) =='*'|| token.charAt(0) =='/')) {
                return token;
            }
            System.err.println("operation not valid");      
        }
    }



    static Double operand(){
        String token;
        Double value;
        for(;;){
            token=readToken();
            try {
                value=Double.valueOf(token);
            } catch (Exception e) {
                System.err.println("number not valid"); 
                continue;
            }
            return value;
        }
    }

    static void calculator(){
        Double n1, n2,result=(double) 0;
        String op;

        for(;;){
            n1=operand();
            op=operation();
            n2=operand();
            
            switch (op) {
                case "*":result=n1*n2;
                    break;
                case "+":result=n1+n2;
                    break;
                case "-":result=n1-n2;
                    break;
                case "/":result=n1/n2;
                    break;
                default:
                    break;
            }
            System.out.println(result);
            

        }

    }
    public static void main(String[] args) {
       input=new Scanner(System.in);
       calculator();

    }
}