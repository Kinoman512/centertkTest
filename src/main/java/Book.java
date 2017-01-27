import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */
public class Book {

    static  HashMap<String ,List<String>> data = new HashMap<>();


    static {
         List<String> list1 = new ArrayList<>();
        list1.add( "+8 800 2000 500");
        list1.add( "+8 800 200 600");

         data.put("Иванов И.И.",list1);

        List<String> list2 = new ArrayList<>();
        list2.add("+8 800 2000 700");
        data.put("Петров П.П.",list2);


        List<String> list3 = new ArrayList<>();
        list3.add( "+8 800 2000 800");
        list3.add( "+8 800 2000 900");
        list3.add( "+8 800 2000 000");

         data.put("Сидоров С.С.",list3);
    }


    public static void main (String[] args) {


            System.out.println("Enter name ");
            Scanner sc = new Scanner(System.in);


            String name = sc.nextLine();

            printNumbersByName(name);



    }

    public static void printNumbersByName(String name){

        List<String> list = data.get(name);

        if(list == null){
            System.out.println("There are no numbers for "+ name);
        }else{
            System.out.println("Numbers of " + name);
            for(String e : list){
                System.out.println( e);
            }
        }
    }




    }
