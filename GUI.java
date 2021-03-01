import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

class GUI {
    static JButton auto;
    static Thread t;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Zoom Opener");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 313);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.setLayout(null);

        JLabel title = new JLabel("Automatic Zoom Opener");
        title.setBounds(248-112, 48-13, 224, 26);
        Font font = new Font("Arial", Font.BOLD, 18);
        title.setFont(font);
        panel.add(title);

        JButton first = new JButton("First");
        first.setBounds(99-45, 96, 90, 26);
        first.setFocusPainted(false);
        first.setBackground(Color.decode("#dedede"));
        panel.add(first);

        JButton second = new JButton("Second");
        second.setBounds(198-45, 96, 90, 26);
        second.setFocusPainted(false);
        second.setBackground(Color.decode("#dedede"));
        panel.add(second);

        JButton third = new JButton("Third");
        third.setBounds(297-45, 96, 90, 26);
        third.setFocusPainted(false);
        third.setBackground(Color.decode("#dedede"));
        panel.add(third);

        JButton fourth = new JButton("Fourth");
        fourth.setBounds(396-45, 96, 90, 26);
        fourth.setFocusPainted(false);
        fourth.setBackground(Color.decode("#dedede"));
        panel.add(fourth);

        JButton fifth = new JButton("Fifth");
        fifth.setBounds(149-45, 130, 90, 26);
        fifth.setFocusPainted(false);
        fifth.setBackground(Color.decode("#dedede"));
        panel.add(fifth);

        JButton sixth = new JButton("Sixth");
        sixth.setBounds(248-45, 130, 90, 26);
        sixth.setFocusPainted(false);
        sixth.setBackground(Color.decode("#dedede"));
        panel.add(sixth);

        JButton advis = new JButton("Advisory");
        advis.setBounds(347-45, 130, 90, 26);
        advis.setFocusPainted(false);
        advis.setBackground(Color.decode("#dedede"));
        panel.add(advis);

        auto = new JButton("Auto Open");
        auto.setBounds(248-55, 192, 110, 29);
        auto.setFocusPainted(false);
        auto.setBackground(Color.decode("#dedede"));
        panel.add(auto);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(248-40, 229, 80, 29);
        cancel.setFocusPainted(false);
        cancel.setBackground(Color.decode("#dedede"));
        panel.add(cancel);

        first.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.first();
            }
        });
        second.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.second();
            }
        });
        third.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.third();
            }
        });
        fourth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.fourth();
            }
        });
        fifth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.fifth();
            }
        });
        sixth.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.sixth();
            }
        });
        advis.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                Opener act = new Opener();
                act.advisory();
            }
        });
        auto.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                t = new Thread(new AutoOpener());
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

    public void setAuto(String title) {
        auto.setText(title);
    }

}
