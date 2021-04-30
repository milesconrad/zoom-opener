import java.util.Date;
import java.text.SimpleDateFormat;

class AutoOpener1 implements Runnable {
    public void run() {

        Sleeper sleep = new Sleeper();
        Opener open = new Opener();
        GUI gui = new GUI();
        SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dayformat = new SimpleDateFormat("E");

        // while the thread isn't interrupted, check if the time and day matches with the
        // class schedule
        while (!Thread.currentThread().isInterrupted()) {
            
            //get date and time
            gui.setAuto1("Running...");
            Date now = new Date();
            String time = timeformat.format(now);
            String day = dayformat.format(now);

            if (day.equals("Mon") || day.equals("Wed") || day.equals("Fri")) {
                if (time.equals("07:52:30")) {
                    open.first();
                    sleep.wait(3f);
                }
                if (time.equals("09:24:30")) {
                    open.second();
                    sleep.wait(3f);
                }
                if (time.equals("10:54:30")) {
                    open.third();
                    sleep.wait(3f);
                }
            }

            if (day.equals("Tue") || day.equals("Thu")) {
                if (time.equals("07:52:30")) {
                    open.fourth();
                    sleep.wait(3f);
                }
                if (time.equals("09:24:30")) {
                    open.fifth();
                    sleep.wait(3f);
                }
                if (time.equals("10:54:30")) {
                    open.sixth();
                    sleep.wait(3f);
                }
            }
            
            if (day.equals("Mon")) {
                if (time.equals("12:59:30")) {
                    open.advisory();
                    sleep.wait(3f);
                }
            }
            sleep.wait(0.5f);
        }
        gui.setAuto1("Auto Open");
    }   
}