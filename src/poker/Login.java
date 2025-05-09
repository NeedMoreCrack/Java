package poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Login extends JFrame {
    Map<String,String> userInfoArr = new HashMap<>();
    JLabel errorInfo = new JLabel();
    JLabel captchaShow = new JLabel();
    String captchaReturnText = "";

    Login(){
//        userInfoArr.put("abc","123");//Test user
        captcha();
        initJFrame();
        loginPage();
        this.setVisible(true);
//        showMouseXY();
    };

    public void captcha(){
        captchaShow.setBounds(240,300,100,35);
        captchaShow.setFont(new Font(null, Font.BOLD,24));
        StringBuilder eng = new StringBuilder();
        StringBuilder num = new StringBuilder();
        Random r = new Random();
        StringBuilder captcha = new StringBuilder();
        for(char i=65;i<91;i++){
            eng.append(i);
        }
        for(char i=97;i<123;i++){
            eng.append(i);
        }
        for (int i = 0; i < 10; i++) {
            num.append(i);
        }
        while(captcha.length() < 5){
            if(captcha.length() < 4){
                captcha.append(eng.charAt(r.nextInt(52)));
            }else{
                captcha.append(num.charAt(r.nextInt(10)));
            }
        }
        captchaShow.setText("");
        captchaReturnText = captcha.toString();
        captchaShow.setText(captchaReturnText);
        this.add(captchaShow);
    }

    public void checkLogin(String account,char[] password,String captcha,String captchaText,Map<String,String> userInfoArr){
        Set<Map.Entry<String, String>> entries = userInfoArr.entrySet();
        String getPassword = new String(password);
        if (!captcha.equals(captchaText)) {
            showError(1);
        } else {
            if(entries.isEmpty()){
                showError(-1);
            }else{
                for (Map.Entry<String, String> entry : entries) {
                    System.out.println("enter for");
                    String key = entry.getKey();
                    String value = entry.getValue();
                    System.out.println(key+"="+value);
                    getPassword = new String(password);
                    if (!account.equals(key) || !getPassword.equals(value)) {
                        showError(2);
                    }else{
                        showError(0);
                        javax.swing.Timer timer = new javax.swing.Timer(1500,e -> {
                            new Game(Login.this);
                            setVisible(false);
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
            }
        }
    }

    public void showError(int errorNum){
        //Show error
        if(errorNum == -1) {
            showErrorOrSuccess("Account does not exist");
        } else if (errorNum == 1){
            showErrorOrSuccess("Error captcha");
        } else if (errorNum == 2) {
            showErrorOrSuccess("Account or password error");
        } else if (errorNum == 0) {
            showErrorOrSuccess("Success");
        }
    }

    public void showErrorOrSuccess(String errorText){
        errorInfo.setText("");
        errorInfo.setText(errorText);
        errorInfo.setBounds(70,50,350,50);
        errorInfo.setFont(new Font(null, Font.BOLD,24));
        errorInfo.setHorizontalAlignment(JLabel.CENTER);
    }

    public void loginPage(){
        //Top bar icon
        ImageIcon i = new ImageIcon("src/poker/image/images.png");
        this.setIconImage(i.getImage());

        //Left text
        JLabel account = new JLabel("Account:");
        JLabel password = new JLabel("Password:");
        JLabel captcha = new JLabel("Captcha:");
        account.setBounds(120,150,75,25);
        password.setBounds(110,200,75,25);
        captcha.setBounds(120,250,75,25);

        //right input
        JTextField accountEnter = new JTextField("");
        JPasswordField passwordEnter = new JPasswordField("");
        JTextField captchaEnter = new JTextField("");
        accountEnter.setBounds(200,150,150,25);
        passwordEnter.setBounds(200,200,150,25);
        captchaEnter.setBounds(200,250,150,25);

        //Button
        JButton refreshCaptcha = new JButton("refresh");
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        refreshCaptcha.setBounds(110,300,85,35);
        loginButton.setBounds(110,370,100,35);
        registerButton.setBounds(250,370,100,35);

        //Button action
        refreshCaptcha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                captcha();
            }
        });
        loginButton.addActionListener(e->checkLogin(
            accountEnter.getText().trim().isEmpty()  ? "" : accountEnter.getText(),
            passwordEnter.getPassword(),
            captchaEnter.getText().trim().isEmpty() ? "" : captchaEnter.getText(),
            captchaReturnText,
            userInfoArr
        ));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                accountEnter.setText("");
                passwordEnter.setText("");
                captchaEnter.setText("");
                new Register(Login.this);
            }
        });

        //add to JFrame
        this.getContentPane();
        this.add(errorInfo);
        this.add(account);
        this.add(password);
        this.add(captchaEnter);
        this.add(captcha);
        this.add(accountEnter);
        this.add(passwordEnter);
        this.add(refreshCaptcha);
        this.add(loginButton);
        this.add(registerButton);
    }

    public void initJFrame(){
        this.setSize(500,500);
        this.setTitle("Login");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
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