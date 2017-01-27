import org.junit.Before;
import org.junit.Test;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */

public class testClass {


    @Before
    public void init() {

    }

    @Test
    public void testNet(){
        Net.IsReachable("173.194.32.162");
        Net.IsReachable("1.194.32.162");
    }
}
