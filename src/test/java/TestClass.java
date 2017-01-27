import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DmitryGribkov on 27.01.2017.
 */

public class TestClass {


    @Before
    public void init() {

    }

    @Test
    public void testNet(){
        Assert.assertTrue(Net.IsReachable("173.194.32.162"));
        Assert.assertTrue(!Net.IsReachable("1.194.32.162"));
    }
    @Test
    public void testNetCorrectAddress(){


        boolean bl = Net.isCorrectAddress("173.194.32.162");
        boolean bl2 = Net.isCorrectAddress("173.194111.32.162");
        boolean bl3 = Net.isCorrectAddress("XX  xX XX");

        Assert.assertTrue(bl);
        Assert.assertTrue(!bl2);
        Assert.assertTrue(!bl3);

    }


    @Test
    public void testDeltaAddress(){


        Net.deltaAddress("173.195.31.162", "173.195.32.165");

    }








}
