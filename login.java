import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login implements ActionListener {
    private JFrame window;
    private JPanel containerH, containerC;
    private JLabel title, nameText, passwordText;
    private JTextField nameInput, passwordInput;
    private JButton submit;
    private ArrayList<User>users=new ArrayList<>();
    private final String PATH ="list";

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
        containerC.setLayout(new GridLayout(10, 2));

        // setting inputs
        // Name
        nameText = new JLabel("Name:");
        containerC.add(nameText);
        nameInput = new JTextField();
        containerC.add(nameInput);

        // Password
        passwordText = new JLabel("password:");
        containerC.add(passwordText);
        passwordInput = new JTextField();
        containerC.add(passwordInput);

        // setting buttons
        submit = new JButton();
        submit.setText("Click To Submit");
        submit.addActionListener(this);
        containerC.add(submit);
       
        window.add(containerC, BorderLayout.CENTER);
        window.setVisible(true);
        //loading saved files
        load();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        User newUser=new User(nameInput.getText(), passwordInput.getText());
        //Name Check 
        boolean flag=false;
        User found=null;
        for (User u : users) {
           if(newUser.matchName(u)){
            show("User Found");
            flag = true;
            found=u;
            break;
           }
        }
        if (flag){
        //Password Check
        if (newUser.matchPassword(found)) {
            new intract(newUser.getName());
            window.dispose();
            return;
        }else{
            show("Password does not Match!");
         }
        }else{
            users.add(newUser);
            save();
        }
       
    }
    void load(){
         //loading Users
         File f= new File(PATH);
         if(f.exists()){
         //loading from storage
         try{
         FileInputStream fIn = new FileInputStream(PATH);
         ObjectInputStream oIN = new ObjectInputStream(fIn);
         users=(ArrayList<User>)oIN.readObject();
         oIN.close();
         fIn.close();
         }catch(Exception ex){
             System.err.println("x");
             ex.printStackTrace();
         }finally{
             for (User u : users) {
                 System.out.println(u.getName());
             }
         }
         }
    }
    void show(String x){
        JOptionPane.showMessageDialog(window,x,"INFO",JOptionPane.INFORMATION_MESSAGE);
    }
    void save(){
       //Saving User
       try{
       FileOutputStream fOut = new FileOutputStream(PATH);
       ObjectOutputStream oOut = new ObjectOutputStream(fOut);
        oOut.writeObject(users);
        oOut.close();
        fOut.close();
       }catch(Exception ex){
        System.err.println("yy");
           ex.printStackTrace();
       }  
    }

}
