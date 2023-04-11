import java.util.Scanner;
import java.util.HashMap;


public class B1_2 {

    static Scanner input;
    static  HashMap<String,Double> variables;

    static void setVariable(String name,Double value){
        variables.put(name, value);
    }

    static Double getVariable(String name){
        return variables.get(name);
    }

    static Double operation(String n1,String op,String n2){
        Double v1,v2;
        v1=value(n1);
        v2=value(n2);
        switch (op) {
            case "*":return v1*v2;
              
            case "+":return v1+v2;
               
            case "-":return v1-v2;
               
            case "/":return v1/v2;
               
            default:
                return 0.0;
        }
    }

    static Double value(String token){
        if (Character.isLetter(token.charAt(0))) {
            return getVariable(token);
        }else{
            return Double.valueOf(token);
        }
    }



    static Double expression(String[] tokens,int index){


        switch (tokens.length - index) {//atribuiçao
            case 1: return value(tokens[index]);
            case 3: return operation(tokens[index],tokens[index+1],tokens[index+2]);
            default: return 0.0;
        }
    }



    static Double instrution(String line){
        String[] tokens;
        tokens=line.split(" +");

        if (tokens.length >= 3 && tokens[1].equals("=")) {//atribuiçao
            setVariable(tokens[0],expression(tokens,2));
            return getVariable(tokens[0]);
        }else{//expression
            return expression(tokens,0);
        }
    }

    static void calculator(){
        String line;


        try {
            for(;;){
                line= input.nextLine();
                System.out.println(instrution(line)); 
                
            }
            
        } catch (Exception e) {
            System.exit(0);
        }


    }
    public static void main(String[] args) {
       input=new Scanner(System.in);
       variables= new HashMap<String, Double>();
       calculator();

    }
}