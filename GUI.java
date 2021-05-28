import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class GUI {
    // these variables are declared here so the thread can be interrupted
    // and the button titles can be changed
    static JButton auto1;
    static JButton auto2;
    static Thread t;

    static JButton createButton(String title, int x, int y, int width, int height) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#dedede"));
        return button;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Zoom Opener");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setLayout(null);

        JLabel title = new JLabel("Automatic Zoom Opener");
        title.setBounds(136, 35, 224, 26);
        Font font = new Font("Arial", Font.BOLD, 18);
        title.setFont(font);
        panel.add(title);

        JButton[] buttons = {
            createButton("First", 54, 96, 90, 26),
            createButton("Second", 153, 96, 90, 26),
            createButton("Third", 252, 96, 90, 26),
            createButton("Fourth", 351, 96, 90, 26),
            createButton("Fifth", 104, 130, 90, 26),
            createButton("Sixth", 203, 130, 90, 26),
            createButton("Advisory", 302, 130, 90, 26)
        };

        Method[] methods = Opener.class.getMethods();
        Opener act = new Opener();
        for (int i = 0; i < 7; i++) {
            final int iClone = i;
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        methods[iClone].invoke(act);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            panel.add(buttons[i]);
        }

        // these buttons must be created manually because their methods are 
        // not stored in the Opener class
        auto1 = createButton("Auto Open 1", 193, 192, 110, 29);
        auto2 = createButton("Auto Open 2", 193, 229, 110, 29);
        JButton cancel = createButton("Cancel", 208, 266, 80, 29);

        panel.add(auto1);
        panel.add(auto2);
        panel.add(cancel);

        auto1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t = new Thread(new AutoOpener1());
                t.start();
            }
        });
        auto2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t = new Thread(new AutoOpener2());
                t.start();
            }
        });
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t.interrupt();
            }
        });
        frame.setVisible(true);
    }

    public void setAuto1(String title) {
        auto1.setText(title);
    }
    public void setAuto2(String title) {
        auto2.setText(title);
    }
}