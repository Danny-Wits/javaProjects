import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class intract extends JFrame implements ActionListener {
    intract(String x){
        setFocusable(true);
        setBounds(10, 10, 1000, 600);
        setLayout(new FlowLayout());
        setTitle("Data Manager/"+x);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton back = new JButton();
        back.setText("BACK");
        back.addActionListener(this);
        add(back);
        JLabel l= new JLabel("Welcome "+x);
        add(l);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      new login();
      dispose();
      setVisible(false);
    }
}
