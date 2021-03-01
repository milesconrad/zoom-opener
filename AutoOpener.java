import java.util.Date;
import java.text.SimpleDateFormat;

class AutoOpener implements Runnable {
    public void run() {

        Sleeper sleep = new Sleeper();
        Opener open = new Opener();
        GUI gui = new GUI();
        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dayformat = new SimpleDateFormat("E");

        while (!Thread.currentThread().isInterrupted()) {
            gui.setAuto("Running...");
            Date now = new Date();
            String time = timeformat.format(now);
            String day = dayformat.format(now);
            if (day.equals("Mon")) {
                if (time.equals("07:52:30")) {
                    open.advisory();
                    sleep.wait(3f);
                }
                if (time.equals("08:42:30")) {
                    open.first();
                    sleep.wait(3f);
                }
                if (time.equals("09:29:30")) {
                    open.second();
                    sleep.wait(3f);
                }
                if (time.equals("10:14:30")) {
                    open.third();
                    sleep.wait(3f);
                }
                if (time.equals("11:14:30")) {
                    open.fourth();
                    sleep.wait(3f);
                }
                if (time.equals("11:59:30")) {
                    open.fifth();
                    sleep.wait(3f);
                }
                if (time.equals("12:44:30")) {
                    open.sixth();
                    sleep.wait(3f);
                }
            }
            if (day.equals("Tue") || day.equals("Thu")) {
                if (time.equals("08:42:30")) {
                    open.first();
                    sleep.wait(3f);
                }
                if (time.equals("10:04:30")) {
                    open.second();
                    sleep.wait(3f);
                }
                if (time.equals("11:24:30")) {
                    open.third();
                    sleep.wait(3f);
                }
            }
            if (day.equals("Wed") || day.equals("Fri")) {
                if (time.equals("08:42:30")) {
                    open.fourth();
                    sleep.wait(3f);
                }
                if (time.equals("10:04:30")) {
                    open.fifth();
                    sleep.wait(3f);
                }
                if (time.equals("11:24:30")) {
                    open.sixth();
                    sleep.wait(3f);
                }
            }
            sleep.wait(0.5f);
        }
        gui.setAuto("Auto Open");
    }   
}