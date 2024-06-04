import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class intract extends JFrame {
    intract(String x){
        setFocusable(true);
        setBounds(10, 10, 1000, 600);
        setLayout(new FlowLayout());
        setTitle("Data Manager/"+x);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l= new JLabel("Welcome "+x);
        add(l);
        setVisible(true);
    }
}
