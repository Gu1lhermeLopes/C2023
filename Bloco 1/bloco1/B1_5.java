import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.ArrayList;

public class B1_5 {



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

    static ArrayList<Integer> parseInput(HashMap<String,Integer> dic){
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> lista= new ArrayList<Integer>();
        Integer value;
        Integer sum=0, acc=0;
        Character last ='s';

        while (input.hasNext()) {
            String token = input.next();
            value=dic.get(token);
            if (value==null) {
                //System.out.print(token);
                //break;
            }else{

                if (value==100 || value==1000 || value==1000000) {
                    acc*=value;
                    last='m';
                }else{
                    if (last=='m') {
                        sum+=acc;
                        acc=0;
                    }
                    acc+=value;
                    last='s';
                }
            }
            sum+=acc;
            System.out.println(sum);
        }
        System.out.println(sum);
        return lista;
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("empty args");
            System.exit(1);
        }
 
        
        ArrayList<Integer> a=parseInput(loadFile(args[0]));
        System.out.println(a);

    }
}