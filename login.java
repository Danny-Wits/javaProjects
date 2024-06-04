import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class login {
login(){
    //!Window Setup
    // This code snippet is creating a new JFrame window for a login screen. It sets the window to be
    // visible, focusable, and sets its size and title. The window will be displayed at position (10, 10)
    // with a width of 500 pixels and a height of 500 pixels. The title of the window will be set to "Data
    // Manager".
    JFrame window= new JFrame();
    window.setVisible(true);
    window.setFocusable(true);
    window.setBounds(10, 10, 500,500);
    window.setLayout(new BorderLayout());
    window.setTitle("Data Manager");
    
    //!Border Setup
    // The code snippet you provided is creating a JPanel named `container`, adding a JLabel with the
    // text "WELCOME" to it, setting the font of the JLabel to be a Monospace font with a size of 40,
    // and then adding the container to the JFrame window at the BorderLayout.NORTH position.
    JPanel container =new JPanel();
    container.setVisible(true);
    JLabel title= new JLabel("WELCOME");
    title.setFont( new Font("Monospace", 0, 40));
    container.add(title);
    window.add(container,BorderLayout.NORTH);

    // JTextField
}
}
