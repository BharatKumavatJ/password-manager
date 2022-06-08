
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PasswordManager implements ActionListener{

    JFrame frame;
    JFrame frame2;
    Container conn1,conn2;
    JLabel lAcc,lPass;
    JTextArea encryptPasswdArea, genePassArea, searchPassArea;
    JButton PassGeneBtn,PassEncryptBtn, PassStoreBtn, PassUpdateBtn,  PassSearchBtn, AccAddBtn, PassDeleteBtn, AccVerifyBtn;
    JTextField tAcc,tPass;
    @Override
    public void actionPerformed(ActionEvent e) { }

    
    //Frame settings
    public static void FrameGUI(JFrame frame){
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
    }

    //container settings
    public static void ContainerGUI(Container conn){
        conn.setVisible(true);
        conn.setBackground(Color.getHSBColor(20.4f, 10.5f, 12.9f));
        conn.setLayout(null);
    }


    // buttons settings
    public void GUIButtonsSetting(JButton btn){
        btn.setBackground(Color.LIGHT_GRAY);
        btn.setForeground(Color.BLACK);
        Font fn = new Font("Arial", Font.PLAIN, 15);
        btn.setFont(fn);
        Cursor crs = new Cursor(Cursor.HAND_CURSOR);
        btn.setCursor(crs);
    }

    //GUI of Store password
    public void StoringGUI()
    {
        frame2 = new JFrame("Store your passwords");
        frame2.setBounds(1400, 700, 600, 500);
        frame2.setSize(500,400);
        FrameGUI(frame2);
        conn2 = frame2.getContentPane();
        ContainerGUI(conn2);
        Font fn = new Font("Arial", Font.BOLD, 20);

        //Account textFiled and label
        lAcc = new JLabel("ENTER ACCOUNT NAME");
        lAcc.setBounds(100, 23, 480, 50);
        lAcc.setFont(fn);
        conn2.add(lAcc);

        tAcc = new JTextField();
        tAcc.setBounds(100,70,300,80);
        tAcc.setFont(fn);
        tAcc.setForeground(Color.DARK_GRAY);
        conn2.add(tAcc);

        //Account password textField and label
        lPass = new JLabel("ENTER ACCOUNT PASSWORD");
        lPass.setBounds(100, 160, 480, 50);
        lPass.setFont(fn);
        conn2.add(lPass);

        tPass = new JTextField();
        tPass.setBounds(100,200,300,80);
        tPass.setFont(fn);
        tPass.setForeground(Color.DARK_GRAY);
        conn2.add(tPass);

        AccAddBtn = new JButton("STORE");
        AccAddBtn.setBounds(170, 290, 150, 50);
        conn2.add(AccAddBtn);
        GUIButtonsSetting(AccAddBtn);
    }
    //GUI of update password
    public void UpdateGUI()
    {
        frame2 = new JFrame("Update your passwords");
        frame2.setBounds(1400, 700, 600, 500);
        frame2.setSize(500,400);
        FrameGUI(frame2);
        conn2 = frame2.getContentPane();
        ContainerGUI(conn2);
        Font fn = new Font("Arial", Font.BOLD, 20);

        //Account textFiled and label
        lAcc = new JLabel("ENTER ACCOUNT NAME");
        lAcc.setBounds(100, 23, 480, 50);
        lAcc.setFont(fn);
        conn2.add(lAcc);

        tAcc = new JTextField();
        tAcc.setBounds(100,70,300,80);
        tAcc.setFont(fn);
        tAcc.setForeground(Color.DARK_GRAY);
        conn2.add(tAcc);

        //Account password textField and label
        lPass = new JLabel("ENTER NEW PASSWORD");
        lPass.setBounds(100, 160, 480, 50);
        lPass.setFont(fn);
        conn2.add(lPass);   

        tPass = new JTextField();
        tPass.setBounds(100,200,300,80);
        tPass.setFont(fn);
        tPass.setForeground(Color.DARK_GRAY);
        conn2.add(tPass);

        AccAddBtn = new JButton("Update");
        AccAddBtn.setBounds(170, 290, 150, 50);
        conn2.add(AccAddBtn);
        GUIButtonsSetting(AccAddBtn);
    }


    public void VarificationGUI()
    {
        frame2 = new JFrame("Account Varification");
        frame2.setBounds(1400, 300, 1200, 200);
        frame2.setSize(500,400);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        conn2 = frame2.getContentPane();
        ContainerGUI(conn2);
        Font fn = new Font("Arial", Font.BOLD, 20);

       
        //Account password textField and label
        lPass = new JLabel("ENTER PASSWORD MANAGER PASSWORD");
        lPass.setBounds(50, 30, 1000, 30);
        lPass.setFont(fn);
        conn2.add(lPass);

        tPass = new JTextField();
        tPass.setBounds(80,75,300,50);
        tPass.setFont(fn);
        tPass.setForeground(Color.DARK_GRAY);
        conn2.add(tPass);

        AccVerifyBtn = new JButton("VERIFY");
        AccVerifyBtn.setBounds(150, 200, 150, 50);
        conn2.add(AccVerifyBtn);
        GUIButtonsSetting(AccVerifyBtn);
        FrameGUI(frame2);
    }
    public void textArea(String Pass,JTextArea TA){
        TA.setText(Pass);
        Font fn = new Font("Arial", Font.BOLD, 20);
        TA.setWrapStyleWord(true);
        TA.setLineWrap(true);
        TA.setCaretPosition(0);
        TA.setEditable(false);
        TA.setFont(fn);

    }

    PasswordManager()
    {
        
        try{
                      
            String password = JOptionPane.showInputDialog("Enter password");
            if (!password.isBlank()) {
                PasswordAuthenticaton passauth = new PasswordAuthenticaton();
                boolean isvalid = passauth.check(password);
                if(isvalid) {
                   
                    proceed();
                }
                else JOptionPane.showMessageDialog(conn1, "INVALID PASSWORD");
            }
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(conn1,ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);
            }

    }

    public void proceed() {

        frame = new JFrame("Password Manager");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/icon.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(580,630);
        // FrameGUI(frame);

        conn1 = frame.getContentPane();
        ContainerGUI(conn1);

        
    
    
    //----------------------------------------------------------------------------------------------------------------------
    
            //storing password 
            PassStoreBtn = new JButton("STORE PASSWORD");
            PassStoreBtn.setBounds(160, 80, 220, 70);
            conn1.add(PassStoreBtn);
            GUIButtonsSetting(PassStoreBtn);
            //Store password action
            PassStoreBtn.addActionListener(e -> {
                if(PassStoreBtn ==e.getSource())
                {
                    try{
                        StoringGUI();
                        // action on the Store btn
                        AccAddBtn.addActionListener(e4 -> {
                            if (AccAddBtn == e4.getSource()) {
                                String account_name = tAcc.getText();
                                String acc_pass = tPass.getText();
                                if (account_name.isEmpty() || acc_pass.isEmpty()) {
                                    JOptionPane.showMessageDialog(conn2,"unable to store your password!","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                   
                                    PasswordStore passstore = new PasswordStore();
                                    String isstored = passstore.store(account_name,acc_pass);
                                    JOptionPane.showMessageDialog(conn2, isstored);
                                    tAcc.setText(null);
                                    tPass.setText(null);
                                }
                            }
                          }
                        );
                    }
               catch(Exception ex) {JOptionPane.showMessageDialog(conn2,ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);}
                }
            }
            );
        //---------------------------------------------------------------------------------------------------------------------
          // updating password

            PassUpdateBtn = new JButton("Update PASSWORD");
            PassUpdateBtn.setBounds(160, 180, 220, 70);
            conn1.add(PassUpdateBtn);
            GUIButtonsSetting(PassUpdateBtn);
            //Store password action
            PassUpdateBtn.addActionListener(e -> {
                if(PassUpdateBtn ==e.getSource())
                {
                    try{
                        UpdateGUI();
                        // action on the Store btn
                        AccAddBtn.addActionListener(e4 -> {
                            if (AccAddBtn == e4.getSource()) {
                                String account_name = tAcc.getText();
                                String acc_pass = tPass.getText();
                                if (account_name.isEmpty() && acc_pass.isEmpty()) {
                                    JOptionPane.showMessageDialog(conn2,"unable to update your password!","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                   
                                    PasswordUpdate passupdate = new PasswordUpdate();
                                    String isupdated;
                                    try {
                                        isupdated = passupdate.update(account_name,acc_pass);
                                        JOptionPane.showMessageDialog(conn2, isupdated);
                                        tAcc.setText(null);
                                        tPass.setText(null);
                                    } catch (IOException e1) {
                             
                                        e1.printStackTrace();
                                    }
                                    
                                   
                                }
                            }
                          }
                        );
                    }
               catch(Exception ex) {JOptionPane.showMessageDialog(conn2,ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);}
                }
            }
            );

         
    //----------------------------------------------------------------------------------------------------------------------
            //searching password
            PassSearchBtn = new JButton("SEARCH PASSWORD");
            GUIButtonsSetting(PassSearchBtn);
            PassSearchBtn.setBounds(160, 280, 220, 70);
            conn1.add(PassSearchBtn);
            PassSearchBtn.addActionListener(e ->{
                if (PassSearchBtn ==e.getSource()){
                    try{
                      
                        String acc_name = JOptionPane.showInputDialog("Enter your Account Name");
                        if (!acc_name.isBlank()) {
                            SearchPassword searchpass = new  SearchPassword();
                            String pass = searchpass.search(acc_name);
                            if(pass!=null) {
                                searchPassArea = new JTextArea(4,5);
                                textArea(String.valueOf(pass), searchPassArea);
                                JOptionPane.showMessageDialog(conn1, new JScrollPane(searchPassArea), "your password", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else JOptionPane.showMessageDialog(conn1, "Account not Found!");
                        }
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(conn1,ex.getMessage(),"EXIT",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            );
    //----------------------------------------------------------------------------------------------------------------------
            // deleting password
            PassDeleteBtn = new JButton("DELETE PASSWORD");
            GUIButtonsSetting(PassDeleteBtn);
            PassDeleteBtn.setBounds(160, 380, 220, 70);
            conn1.add(PassDeleteBtn);
            PassDeleteBtn.addActionListener(e -> {
                if (PassDeleteBtn == e.getSource()) {
                    try {
                        String acc_name = JOptionPane.showInputDialog("Enter the Account Name");
                        if (!acc_name.isBlank()) {
                            PassWordDelete passdel = new PassWordDelete();
                            String delmessage = passdel.delete(acc_name);
                         
                                JOptionPane.showMessageDialog(conn1, delmessage);
                        }
                        else JOptionPane.showMessageDialog(conn1, "Account not found!", "INFO", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(conn1, ex.getMessage(), "EXIT", JOptionPane.ERROR_MESSAGE);
                    }
                }
    
            }
            );
            FrameGUI(frame);
    
        }
    
    // main method
    public static void main(String[] args) {
        //loading screen class
        new SplashScreen();
        try {
            new PasswordManager();
        }catch (Exception ex) { 
            ex.printStackTrace();
        }
    }

        
    }
    