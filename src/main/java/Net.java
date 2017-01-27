import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */
public class Net {


    private static final String ipv4Pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";


    public static void main (String[] args){
        System.out.println("Enter the range of ip ");

        System.out.println("Enter first ip ");
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());

        System.out.println("Enter second ip ");
        Scanner sc2 = new Scanner(System.in);
        System.out.println(sc2.next());




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
