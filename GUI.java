import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

class GUI {
    static JButton auto1;
    static JButton auto2;
    static Thread t;

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

        JButton first = new JButton("First");
        first.setBounds(54, 96, 90, 26);
        first.setFocusPainted(false);
        first.setBackground(Color.decode("#dedede"));
        panel.add(first);

        JButton second = new JButton("Second");
        second.setBounds(153, 96, 90, 26);
        second.setFocusPainted(false);
        second.setBackground(Color.decode("#dedede"));
        panel.add(second);

        JButton third = new JButton("Third");
        third.setBounds(252, 96, 90, 26);
        third.setFocusPainted(false);
        third.setBackground(Color.decode("#dedede"));
        panel.add(third);

        JButton fourth = new JButton("Fourth");
        fourth.setBounds(351, 96, 90, 26);
        fourth.setFocusPainted(false);
        fourth.setBackground(Color.decode("#dedede"));
        panel.add(fourth);

        JButton fifth = new JButton("Fifth");
        fifth.setBounds(104, 130, 90, 26);
        fifth.setFocusPainted(false);
        fifth.setBackground(Color.decode("#dedede"));
        panel.add(fifth);

        JButton sixth = new JButton("Sixth");
        sixth.setBounds(203, 130, 90, 26);
        sixth.setFocusPainted(false);
        sixth.setBackground(Color.decode("#dedede"));
        panel.add(sixth);

        JButton advis = new JButton("Advisory");
        advis.setBounds(302, 130, 90, 26);
        advis.setFocusPainted(false);
        advis.setBackground(Color.decode("#dedede"));
        panel.add(advis);

        auto1 = new JButton("Auto Open 1");
        auto1.setBounds(193, 192, 110, 29);
        auto1.setFocusPainted(false);
        auto1.setBackground(Color.decode("#dedede"));
        panel.add(auto1);

        auto2 = new JButton("Auto Open 2");
        auto2.setBounds(193, 229, 110, 29);
        auto2.setFocusPainted(false);
        auto2.setBackground(Color.decode("#dedede"));
        panel.add(auto2);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(208, 266, 80, 29);
        cancel.setFocusPainted(false);
        cancel.setBackground(Color.decode("#dedede"));
        panel.add(cancel);

        // add listeners for all of the buttons added
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
