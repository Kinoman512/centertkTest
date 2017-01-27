import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */
public class Net {


    public static final String ipv4Pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private static int[] n1;
    private static int[] n2;
    private static int[] temp = new int[4];


    public static void main (String[] args){

        String firstIp = "";
        String secondIp = "";

        System.out.println("Enter the range of ip ");

        while(true){
            System.out.println("Enter first ip ");
            Scanner sc = new Scanner(System.in);
            String ip = sc.next();

            boolean bl = isCorrectAddress(ip);
           if( bl){
               break;

           }else{
               System.out.println("The ip " + ip + " isn't correct!");
           }
            firstIp = ip;
        }

        while(true){
            System.out.println("Enter second ip ");
            Scanner sc = new Scanner(System.in);
            String ip = sc.next();

            boolean bl = isCorrectAddress(ip);
            if( bl){
                break;

            }else{
                System.out.println("The ip " + ip + " isn't correct!");
            }
            secondIp = ip;
        }



        Scanner sc2 = new Scanner(System.in);
        System.out.println(sc2.next());




    }

    public static boolean deltaAddress(String ip, String ip2){


        String strs1[] = ip.split("\\.");
        String strs2[] = ip2.split("\\.");

        n1 = Arrays.asList(strs1).stream().mapToInt(Integer::parseInt).toArray();
        n2 = Arrays.asList(strs2).stream().mapToInt(Integer::parseInt).toArray();

        walkNode(0,true);






        return false;
    }

    public static void walkNode(int j, boolean start){


        if(j== 4){
            //print
            String ip = "" + temp[0] + "."+ temp[1]  + "." +temp[2]  + "." + temp[3];
            System.out.println(ip);
            return;
        }

        for(int i = 0; i <= 255; i++){

            if(start){
                i = n1[j];
            }

            if(j> 1 &&  n1[j-1] == n2[j-1] ){
                if(i<n1[j]){
                    continue;
                }


            }

            if( n1[j] == n2[j] && i <n1[j] ){
                i = n1[j];
            }

            temp[j] = i;
            walkNode(j + 1, start);
            start = false;

            //check y1 + y2 + y3 + y4

            if(j> 1 &&  temp[j-1] == n2[j-1] ){
                if(i>=n2[j]){
                    break;
                }
            }
            if( n1[j] == n2[j] ){
                    break;
            }
        }

    }


    public static boolean isCorrectAddress(String ipString){

        Pattern pattern = Pattern.compile(ipv4Pattern);
        Matcher matcher = pattern.matcher(ipString);
        if (matcher.find()) {
            return true;
        } else{
            return false;
        }
    }

    public static boolean IsReachable(String ip){


        final InetAddress host;
        try {
            host = InetAddress.getByName(ip);
            boolean isReached = host.isReachable(1000);
            System.out.println("host " + ip +" = " + isReached );

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

}
