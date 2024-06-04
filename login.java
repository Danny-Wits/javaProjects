import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login implements ActionListener {
    private JFrame window;
    private JPanel containerH, containerC;
    private JLabel title, nameText;
    private JTextField nameInput;
    private JButton submit;

    login() {
        // !Window Setup
        // This code snippet is creating a new JFrame window for a login screen. It sets
        // the window to be
        // visible, focusable, and sets its size and title. The window will be displayed
        // at position (10, 10)
        // with a width of 500 pixels and a height of 500 pixels. The title of the
        // window will be set to "Data
        // Manager".
        window = new JFrame();
        window.setFocusable(true);
        window.setBounds(10, 10, 1000, 600);
        window.setLayout(new BorderLayout());
        window.setTitle("Data Manager");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // !Border Setup
        // The code snippet you provided is creating a JPanel named `container`, adding
        // a JLabel with the
        // text "WELCOME" to it, setting the font of the JLabel to be a Monospace font
        // with a size of 40,
        // and then adding the container to the JFrame window at the BorderLayout.NORTH
        // position.
        containerH = new JPanel();
        containerH.setVisible(true);
        title = new JLabel("WELCOME");
        title.setFont(new Font("Monospace", 0, 40));
        containerH.add(title);
        window.add(containerH, BorderLayout.NORTH);

        // Setting containers
        containerC = new JPanel();
        containerC.setFocusable(true);
        containerC.setVisible(true);
        containerC.setLayout(new GridLayout(20, 2));

        // setting inputs
        nameText = new JLabel("Name:");
        containerC.add(nameText);
        nameInput = new JTextField();
        containerC.add(nameInput);

        // setting buttons
        submit = new JButton();
        submit.setText("Click To Submit");
        submit.addActionListener(this);
        containerC.add(submit);

        window.add(containerC, BorderLayout.CENTER);
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println(nameInput.getText());
    }
}
