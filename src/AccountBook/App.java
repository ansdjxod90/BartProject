package AccountBook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        setSize(700,700);
        setTitle("가계부");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<String>> arr = new ArrayList<>();
                String id = idField.getText();
                String pw = pwField.getText();
                String msg = "";

                try {
                    arr = loginRead();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"오류가 발생했습니다.");
                    ex.printStackTrace();
                }

                if(id.equals("") || pw.equals("")){
                    JOptionPane.showMessageDialog(null,"공백은 입력할 수 없습니다.");
                }else if(arr.isEmpty()){
                    JOptionPane.showMessageDialog(null,"정보가 존재하지 않습니다.");
                }else if(arr.size() != 0){
                    for(int i = 0; i < arr.size(); i++){
                        System.out.println(arr.get(i));
                        if (!arr.get(i).get(0).equals(id)) {
                            msg = "등록되지 않은 ID입니다.";
                        }else if (arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                            msg = "비밀번호가 일치하지 않습니다.";
                        }else if (arr.get(i).get(0).equals(id) && arr.get(i).get(1).equals(pw)) {
                            msg = "로그인 성공했습니다. 환영합니다, " + id + "님.";
                            loginPanel.setVisible(false);
                        }
                    }
                    JOptionPane.showMessageDialog(null,msg);
                }

            }
        });

    }

    public void loginWrite(List<String> loginArr) throws IOException {

        String directory = "data\\register.csv";

        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < loginArr.size(); i++){
            bw.write(loginArr.get(i));
            if(i<loginArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

    }

    public java.util.List<java.util.List<String>> loginRead() throws IOException {

        java.util.List<java.util.List<String>> arrs = new ArrayList<>();
        java.util.List<String> arr = new ArrayList<>();
        List<String> personal;
        String directory = "data\\register.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            String line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            personal = Arrays.asList(arr.get(i).split(","));
            arrs.add(personal);
        }


        return arrs;
    }

    public void makeDataFile() throws IOException {

        String directory = "data\\accountbook.csv";
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        bw.flush();
        bw.close();

    }

    public void dataWrite(List<String> dataArr) throws IOException {

        String directory = "data\\accountbook.csv";
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(directory), Charset.forName("MS949"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        for(int i = 0; i < dataArr.size(); i++){
            bw.write(dataArr.get(i));
            if(i<dataArr.size()-1){
                bw.write(",");
            }
        }
        bw.newLine();

        bw.flush();
        bw.close();

        System.out.println("저장이 완료되었습니다.");
    }

    public List<List<String>> dataRead() throws IOException{

        List<List<String>> arrs = new ArrayList<>();
        List<String> arr = new ArrayList<>();
        List<String> data;
        String line = "";
        String directory = "data\\accountbook.csv";
        ArrayList<String> pi = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(directory), Charset.forName("MS949"));

        while(true){
            line = br.readLine();
            arr.add(line);
            if(line == null) break;
        }

        for(int i = 0; i < arr.size()-1; i++){
            data = Arrays.asList(arr.get(i).split(","));
            arrs.add(data);
        }

        return arrs;
    }


}
