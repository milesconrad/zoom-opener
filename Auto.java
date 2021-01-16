import java.util.Date;
import java.text.SimpleDateFormat;

class Auto implements Runnable {
    public void run() {

        Sleep s = new Sleep();
        Links f = new Links();
        GUI set = new GUI();
        SimpleDateFormat timef = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dayf = new SimpleDateFormat("E");

        while (!Thread.currentThread().isInterrupted()) {
            set.setAuto("Running...");
            Date now = new Date();
            String time = timef.format(now);
            String day = dayf.format(now);
            if (day.equals("Mon")) {
                if (time.equals("08:42:30")) {
                    f.first();
                    s.lp(3000);
                }
                if (time.equals("09:29:30")) {
                    f.second();
                    s.lp(3000);
                }
                if (time.equals("10:14:30")) {
                    f.third();
                    s.lp(3000);
                }
                if (time.equals("11:14:30")) {
                    f.fourth();
                    s.lp(3000);
                }
                if (time.equals("11:59:30")) {
                    f.fifth();
                    s.lp(3000);
                }
                if (time.equals("12:44:30")) {
                    f.sixth();
                    s.lp(3000);
                }
            }
            if (day.equals("Tue") || day.equals("Thu")) {
                if (time.equals("08:42:30")) {
                    f.first();
                    s.lp(3000);
                }
                if (time.equals("10:04:30")) {
                    f.second();
                    s.lp(3000);
                }
                if (time.equals("11:44:30")) {
                    f.third();
                    s.lp(3000);
                }
            }
            if (day.equals("Wed") || day.equals("Fri")) {
                if (time.equals("08:42:30")) {
                    f.fourth();
                    s.lp(3000);
                }
                if (time.equals("10:04:30")) {
                    f.fifth();
                    s.lp(3000);
                }
                if (time.equals("11:44:30")) {
                    f.sixth();
                    s.lp(3000);
                }
            }
            if (day.equals("Fri")) {
                if (time.equals("07:52:30")) {
                    f.advis();
                    s.lp(3000);
                }
            }
            s.lp(500);
        }
        set.setAuto("Auto Open");
    }   
}
