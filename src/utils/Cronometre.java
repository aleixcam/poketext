package utils;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometre {

    private static long seg;
    private static TimerTask task = crono();
    private static Timer timer = new Timer();

    private static TimerTask crono() {
        TimerTask task
                = new TimerTask() {
                    public void run() {
                        seg++;
                    }
                };

        return task;
    }

    public static void start() {
        task = crono();
        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public static void pause() {
        task.cancel();
        timer.cancel();
    }

    public static void stop() {
        Cronometre.pause();
        seg = 0;
    }

    public static void restart() {
        Cronometre.stop();
        Cronometre.start();
    }

    public static long out() {
        return seg;
    }
}
