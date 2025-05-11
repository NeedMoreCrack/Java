package poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Set;

public class Register extends JFrame{
    JLabel errorInfo = new JLabel();

    Register(Login login){
        initJFrame();
        registerPage(login);
//        showMouseXY();
    }

    public void registerPage(Login login){
        //Top bar icon
        ImageIcon i = new ImageIcon("src/poker/image/images.png");
        this.setIconImage(i.getImage());

        //Left text
        JLabel account = new JLabel("Account:");
        JLabel password = new JLabel("Password:");
        JLabel confirmPassword = new JLabel("Confirm password:");
        account.setBounds(120,150,75,25);
        password.setBounds(110,200,75,25);
        confirmPassword.setBounds(63,250,120,25);

        //right input
        JTextField accountEnter = new JTextField();
        JPasswordField passwordEnter = new JPasswordField();
        JPasswordField confirmPasswordEnter = new JPasswordField();
        accountEnter.setBounds(200,150,150,25);
        passwordEnter.setBounds(200,200,150,25);
        confirmPasswordEnter.setBounds(200,250,150,25);

        //Button
        JButton backToLoginPageButton = new JButton("back to login page");
        JButton registerButton = new JButton("Register");
        backToLoginPageButton.setBounds(155,400,150,35);
        registerButton.setBounds(180,320,100,35);

        //Button Action
/*        registerButton.addActionListener(e -> showError(checkRegister(accountEnter.getText(),passwordEnter.getPassword(),confirmPasswordEnter.getPassword(),login.userInfoArr)));
        backToLoginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                login.setVisible(true);
            }
        });*/

        //add to JFrame
        this.getContentPane();
        this.add(errorInfo);
        this.add(account);
        this.add(password);
        this.add(confirmPasswordEnter);
        this.add(accountEnter);
        this.add(passwordEnter);
        this.add(confirmPassword);
        this.add(backToLoginPageButton);
        this.add(registerButton);
    }

    public void initJFrame(){
        this.setSize(500,500);
        this.setTitle("Register");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
        this.setVisible(true);
    }

/*
    public int checkRegister(String account,char[] password,char[] confirmPassword,Set<Map<String,Map<String,String>>> userInfoArr){
        Set<Map.Entry<String, String>> entries = userInfoArr.entrySet();
        String pw = new String(password);
        String pw2 = new String(confirmPassword);
        if(userInfoArr.isEmpty()){
            if(pw.equals(pw2)){
                userInfoArr.put(account,pw);
            }else {
                return 1;
            }
        }else {
            for (Map.Entry<String, String> entry : entries) {
                String key = entry.getKey();//get account
                if (account.equals(key)) {
                    return -1;
                } else if (!pw.equals(pw2)) {
                    return 1;
                } else{
                    userInfoArr.put(account,pw);
                }
            }
        }
        return 0;
    }
*/

    public void showError(int errorNum){
        //Show error
        if(errorNum == -1) {
            showErrorOrSuccess("Account already exist");
        } else if (errorNum == 1){
            showErrorOrSuccess("Confirm password not same");
        } else if (errorNum == 0) {
            showErrorOrSuccess("Success");
        }
    }

    public void showErrorOrSuccess(String errorText){
        errorInfo.setText("");
        errorInfo.setText(errorText);
        errorInfo.setBounds(80,50,350,50);
        errorInfo.setFont(new Font(null, Font.BOLD,24));
        errorInfo.setHorizontalAlignment(JLabel.CENTER);
    }

    public void showMouseXY(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }
}
