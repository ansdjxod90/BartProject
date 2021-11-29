package AccountBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame{

    JPanel currentPanel, loginPanel, registerPanel, infoPanel, inputPanel, searchPanel;
    JButton loginBtn, registerBtn, infoBtn, inputBtn, searchBtn;
    JTextField idField, dateField, memoField, incomeField, outcomeField, debitOrCashField;
    JLabel loginLabel, idLabel, pwLabel;
    JPasswordField pwField;


    public static void main(String[] args) {
        new App();
    }

    public App(){

        loginPanel = new JPanel();
        loginLabel = new JLabel("Login");
        idLabel = new JLabel("Username");
        idField = new JTextField();
        pwLabel = new JLabel("Password");
        pwField = new JPasswordField();
        loginBtn = new JButton("로그인");
        registerBtn = new JButton("회원가입");

        loginPanel.setLayout(null);

        loginLabel.setFont(new Font("Arial", Font.BOLD, 40));
        loginLabel.setForeground(Color.BLUE);
        idLabel.setFont(new Font("Arial", Font.PLAIN,15));
        pwLabel.setFont(new Font("Arial", Font.PLAIN,15));

//        idLabel.setBounds(350,370,100,30);
//        idField.setBounds(400,370,150,30);
//        pwLabel.setBounds(350,400,100,30);
//        pwField.setBounds(400,400,150,30);
//        loginBtn.setBounds(340,440,100,30);
//        registerBtn.setBounds(450,440,100,30);


        loginLabel.setBounds(290,130,150,70);
        idLabel.setBounds(290,200,150,40);
        idField.setBounds(290,240,150,40);
        pwLabel.setBounds(290,280,150,40);
        pwField.setBounds(290,320,150,40);
        loginBtn.setBounds(290,370,150,30);
        registerBtn.setBounds(290,405,150,30);

        loginPanel.add(loginLabel);
        loginPanel.add(idLabel);
        loginPanel.add(idField);
        loginPanel.add(pwLabel);
        loginPanel.add(pwField);
        loginPanel.add(loginBtn);
        loginPanel.add(registerBtn);

        add(loginPanel);

        //JOptionPane.showMessageDialog(null,"메시지입니다.");
        setSize(700,700);
        setTitle("가계부");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
