import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;


public class B1_4 {



    static HashMap<String,Integer> loadFile(String filename){
        FileInputStream file=null;
        Scanner input;
        HashMap<String,Integer> dic= new HashMap<String,Integer>();
        try {
            file = new FileInputStream(filename);
        } catch (Exception e) {
            System.err.println("empty args");
            System.exit(1);
        }

        input= new Scanner(file);
        while (input.hasNext()) {
            Integer value;
            String name;
            value=input.nextInt();
            input.next();
            name=input.next();
            try {
                dic.put(name, value);
            } catch (Exception e) {
                System.err.println("empty args");
                System.exit(1);
            }

        }
        input.close();
        return dic;
    }

    static void parseInput(HashMap<String,Integer> dic){
        Scanner input = new Scanner(System.in);
        Integer value;

        while (input.hasNext()) {
            String token = input.next();
            value=dic.get(token);
            if (value==null) {
                System.out.print(token);
            }else{
                System.out.print(value);
            }
            System.out.println();
        }
        input.close();
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("empty args");
            System.exit(1);
        }
 
        
        parseInput(loadFile(args[0]));

    }
}