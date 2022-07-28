package utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Delay {

    public static void sec(int min, int max) {
        Random rn = new Random();
        sec(rn.nextInt(max) + min);
    }

    public static void sec(int amount) {
        try {
            TimeUnit.SECONDS.sleep(amount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
