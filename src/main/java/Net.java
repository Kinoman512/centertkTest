import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */
public class Net {

    public static boolean IsReachable(String ip){


        final InetAddress host;
        try {
            host = InetAddress.getByName(ip);
            boolean isReached = host.isReachable(1000);
            System.out.println("host.isReachable(1000) = " + isReached );

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

}
