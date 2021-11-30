package AccountBook;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App extends JFrame{

    JPanel loginPanel, registerPanel, infoPanel, southPanel, inputPanel, searchPanel;
    JButton loginBtn, registerBtn, registerSubmitBtn, registerCancelBtn, searchBtn, resetBtn, infoBtn, inputBtn;
    JTextField idField, registerIdField, searchField, dateField, memoField, incomeField, outcomeField, debitOrCashField;
    JLabel loginLabel, idLabel, pwLabel, registerLabel, registerIdLabel, registerPwLabel, registerPwConfirmLabel, registerPwCheck;
    JPasswordField pwField, registerPwField, registerPwConfirmField;
    JComboBox searchYearCombo, searchMonthCombo, searchDayCombo;
    JTable table;

    private TableRowSorter<TableModel> rowSorter;

    UserData ud;
    AccountData ad;

    LocalDate currentDate;

    int thisYear;
    int thisMonth;
    int thisDays;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });

    }

    public void setLoginPanel(){

        loginPanel = new JPanel();
        loginLabel = new JLabel("로그인");
        idLabel = new JLabel("Username");
        idField = new JTextField();
        pwLabel = new JLabel("Password");
        pwField = new JPasswordField();
        loginBtn = new JButton("로그인");
        registerBtn = new JButton("회원가입");

        loginPanel.setLayout(null);

        loginLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
        loginLabel.setForeground(new Color(55,29,30));
        idLabel.setFont(new Font("Arial", Font.PLAIN,15));
        idLabel.setForeground(new Color(55,29,30));
        pwLabel.setFont(new Font("Arial", Font.PLAIN,15));
        pwLabel.setForeground(new Color(55,29,30));
        loginBtn.setBackground(new Color(55,29,30));
        loginBtn.setForeground(new Color(250, 225, 0));
        loginBtn.setFont(new Font("맑은 고딕", Font.PLAIN,15));
        registerBtn.setBackground(new Color(55,29,30));
        registerBtn.setForeground(new Color(250, 225, 0));
        registerBtn.setFont(new Font("맑은 고딕", Font.PLAIN,15));
        loginPanel.setBackground(new Color(250, 225, 0));

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

        loginPanel.setBounds(0,0,700,700);
    }

    public void setRegisterPanel(){

        registerPanel = new JPanel();
        registerLabel = new JLabel("회원가입");
        registerIdLabel = new JLabel("사용하실 Username을 입력하세요.");
        registerPwLabel = new JLabel("사용하실 비밀번호를 입력해주세요.");
        registerPwConfirmLabel = new JLabel("비밀번호를 다시 한번 입력해주세요.");
        registerPwCheck = new JLabel("");
        registerIdField = new JTextField();
        registerPwField = new JPasswordField();
        registerPwConfirmField = new JPasswordField();
        registerSubmitBtn = new JButton("제출");
        registerCancelBtn = new JButton("뒤로");

        registerPanel.setLayout(null);

        registerPanel.setBackground(new Color(250, 225, 0));
        registerLabel.setFont(new Font("맑은 고딕", Font.BOLD, 45));
        registerLabel.setForeground(new Color(55,29,30));
        registerIdLabel.setFont(new Font("맑은 고딕", Font.BOLD,15));
        registerIdLabel.setForeground(new Color(55,29,30));
        registerPwLabel.setFont(new Font("맑은 고딕", Font.BOLD,15));
        registerPwLabel.setForeground(new Color(55,29,30));
        registerPwConfirmLabel.setFont(new Font("맑은 고딕", Font.BOLD,15));
        registerPwConfirmLabel.setForeground(new Color(55,29,30));
        registerPwCheck.setFont(new Font("맑은 고딕", Font.BOLD,15));
        registerPwCheck.setForeground(Color.RED);
        registerSubmitBtn.setBackground(new Color(55,29,30));
        registerSubmitBtn.setForeground(new Color(250, 225, 0));
        registerSubmitBtn.setFont(new Font("맑은 고딕", Font.PLAIN,15));
        registerCancelBtn.setBackground(new Color(55,29,30));
        registerCancelBtn.setForeground(new Color(250, 225, 0));
        registerCancelBtn.setFont(new Font("맑은 고딕", Font.PLAIN,15));

        registerLabel.setBounds(250,130,250,70);
        registerIdLabel.setBounds(220,200,250,40);
        registerIdField.setBounds(220,240,250,40);
        registerPwLabel.setBounds(220,280,250,40);
        registerPwField.setBounds(220,320,250,40);
        registerPwConfirmLabel.setBounds(220,360,250,40);
        registerPwConfirmField.setBounds(220,400,250,40);
        registerPwCheck.setBounds(220,440,250,30);
        registerSubmitBtn.setBounds(220,470,250,30);
        registerCancelBtn.setBounds(220,505,250,30);

        registerPanel.add(registerLabel);
        registerPanel.add(registerIdLabel);
        registerPanel.add(registerIdField);
        registerPanel.add(registerPwLabel);
        registerPanel.add(registerPwField);
        registerPanel.add(registerPwConfirmLabel);
        registerPanel.add(registerPwConfirmField);
        registerPanel.add(registerPwCheck);
        registerPanel.add(registerSubmitBtn);
        registerPanel.add(registerCancelBtn);

        registerPanel.setBounds(0,0,700,700);
    }


    public void setInfoPanel(){

        infoPanel = new JPanel();
        JPanel northPanel = new JPanel();

        infoPanel.setLayout(new GridLayout(2,1));
        northPanel.setBackground(new Color(250, 225, 0));


        String[] headers = {"순번","날짜","메모","수입","지출","현금/카드"};

        DefaultTableModel dtm = new DefaultTableModel(headers, 0);

        table = new JTable(dtm);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setPreferredScrollableViewportSize(new Dimension(670,330));
        table.setRowHeight(30);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("맑은 고딕", Font.PLAIN,14));
        northPanel.add(new JScrollPane(table));

        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(55,29,30));
        header.setForeground(new Color(250, 225, 0));
        header.setFont(new Font("맑은 고딕", Font.BOLD,15));

        addRecord();
        setSouthPanel();

        infoPanel.setBounds(0,0,700,700);
        infoPanel.add(northPanel);
        infoPanel.add(southPanel);
    }

    public void setSouthPanel(){

        southPanel = new JPanel();
        southPanel.setLayout(null);
        southPanel.setBackground(new Color(250, 225, 0));
        southPanel.setPreferredSize(new Dimension(690,300));

        searchBtn = new JButton("검색");
        searchBtn.setBounds(520,20,80,40);
        searchBtn.setBackground(new Color(55,29,30));
        searchBtn.setForeground(new Color(250, 225, 0));
        searchBtn.setFont(new Font("맑은 고딕", Font.BOLD,15));

        resetBtn = new JButton("초기화");
        resetBtn.setBounds(600,20,80,40);
        resetBtn.setBackground(new Color(55,29,30));
        resetBtn.setForeground(new Color(250, 225, 0));
        resetBtn.setFont(new Font("맑은 고딕", Font.BOLD,15));

        searchField = new JTextField();
        searchField.setBounds(170, 20, 350, 40);

        setSearchYearCombo();
        searchMonthCombo = new JComboBox();
        searchYearCombo.setBounds(20,20,70,40);
        searchMonthCombo.setBounds(90,20,70,40);

        southPanel.add(searchYearCombo);
        southPanel.add(searchMonthCombo);
        southPanel.add(searchField);
        southPanel.add(searchBtn);
        southPanel.add(resetBtn);

    }

    public void setSearchYearCombo(){

        currentDate = LocalDate.now();
        thisYear = currentDate.getYear();
        List<String> list = new ArrayList<>();

        for(int i = 1900; i <= thisYear; i++){
            list.add(Integer.toString(i));
        }
        searchYearCombo = new JComboBox(list.toArray(new String[list.size()]));

    }

    public void setSearchMonthCombo(int lastMonth){

        currentDate = LocalDate.now();
        List<String> list = new ArrayList<>();

        for(int i = 1; i <= lastMonth; i++){
            list.add(Integer.toString(i));
        }
        searchMonthCombo = new JComboBox(list.toArray(new String[list.size()]));

        searchMonthCombo.setBounds(90,20,70,40);
        southPanel.add(searchMonthCombo);
        //searchMonthCombo.setVisible(false);
        System.out.println(lastMonth);
    }


    public void setSearchDayCombo(String month, int day){
        currentDate = LocalDate.now();
        thisDays = currentDate.getDayOfMonth();
        int num = 0;
        List<String> list = new ArrayList<>();

        if(month.equals("1") || month.equals("3") || month.equals("5") || month.equals("7") || month.equals("8") || month.equals("10") || month.equals("12")){
        }

        for(int i = 1; i <= thisDays; i++){
            list.add(Integer.toString(i));
        }

        searchDayCombo = new JComboBox(list.toArray(new String[list.size()]));
    }



    public void addRecord(){
        DefaultTableModel model=(DefaultTableModel)table.getModel();

        ad = new AccountData();
        List<List<String>> list = new ArrayList<>();
        infoPanel = new JPanel();

        try {
            list = ad.dataRead();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"파일 읽기 오류가 발생했습니다.");
        }
        String[] str = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            model.addRow(list.get(i).toArray(str));
        }
    }

    public App(){

        ud = new UserData();
        ad = new AccountData();

        setLoginPanel();
        setRegisterPanel();
        setInfoPanel();

        add(loginPanel);
        add(registerPanel);
        add(infoPanel);

        registerPanel.setVisible(false);
        loginPanel.setVisible(false);
        //infoPanel.setVisible(false);

        setResizable(false);
        setSize(700,700);
        setTitle("가계부");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        registerPwConfirmField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(!registerPwField.getText().equals(registerPwConfirmField.getText())){
                    registerPwCheck.setForeground(Color.RED);
                    registerPwCheck.setText("비밀번호가 일치하지 않습니다.");
                }else if(registerPwField.getText().equals(registerPwConfirmField.getText())){
                    registerPwCheck.setForeground(new Color(55,29,30));
                    registerPwCheck.setText("비밀번호가 일치합니다.");
                }
            }
        });

        registerPwConfirmField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if(registerPwField.getText().equals(registerPwConfirmField.getText())){
                    registerPwCheck.setForeground(new Color(55,29,30));
                    registerPwCheck.setText("비밀번호가 일치합니다.");
                }else if(!registerPwField.getText().equals(registerPwConfirmField.getText())){
                    registerPwCheck.setForeground(Color.RED);
                    registerPwCheck.setText("비밀번호가 일치하지 않습니다.");
                }
            }
        });

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<String>> arr = new ArrayList<>();
                String id = idField.getText();
                String pw = pwField.getText();
                String msg = "";

                try {
                    arr = ud.loginRead();
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
                        if (!arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                            msg = "사용자 정보가 존재하지 않습니다.";
                        }else if (arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                            msg = "비밀번호가 일치하지 않습니다.";
                        }else if (arr.get(i).get(0).equals(id) && arr.get(i).get(1).equals(pw)) {
                            msg = "로그인 성공했습니다. 환영합니다, " + id + "님.";
                            loginPanel.setVisible(false);
                            infoPanel.setVisible(true);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(null,msg);
                }
            }
        });

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginPanel.setVisible(false);
                registerPanel.setVisible(true);
            }
        });

        registerSubmitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<List<String>> arr = new ArrayList<>();
                List<String> list = new ArrayList<>();
                String id = registerIdField.getText();
                String pw = registerPwField.getText();
                String pwCheck = registerPwConfirmField.getText();
                String msg = "";
                boolean flag = false;

                try {
                    arr = ud.loginRead();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"오류가 발생했습니다.");
                }

                if(id.equals("")){
                    JOptionPane.showMessageDialog(null,"Username을 입력해주십시오.");
                    flag = false;
                }else if(pw.equals("") || pwCheck.equals("")){
                    JOptionPane.showMessageDialog(null,"비밀번호를 입력해주십시오.");
                    flag = false;
                }else if(!pwCheck.equals(pw)){
                    JOptionPane.showMessageDialog(null,"비밀번호가 동일하지 않습니다.");
                    flag = false;
                }else{
                    for(int i = 0; i < arr.size(); i++){
                        if(arr.get(i).get(0).equals(id)){
                            msg = "이미 존재하는 아이디입니다.";
                            flag = false;
                            break;
                        }else{
                            msg = "가입이 완료되었습니다, " + id + "님.";
                            flag = true;
                        }
                    }
                    JOptionPane.showMessageDialog(null,msg);
                }

                if(flag){
                    list.add(id);
                    list.add(pw);
                    try {
                        ud.loginWrite(list);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"에러가 발생하였습니다");
                        ex.printStackTrace();
                    }
                    registerPanel.setVisible(false);
                    loginPanel.setVisible(true);
                }

            }
        });

        registerCancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPanel.setVisible(false);
                loginPanel.setVisible(true);
            }
        });



        searchYearCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int lastMonth = 0;
                currentDate = LocalDate.now();
                String year = (String)searchYearCombo.getSelectedItem();

                if(year.equals(Integer.toString(currentDate.getYear()))){
                    lastMonth = currentDate.getMonthValue();
                }else{
                    lastMonth = 12;
                }

                setSearchMonthCombo(lastMonth);
            }
        });

        searchMonthCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDate = LocalDate.now();
                String month = (String)searchMonthCombo.getSelectedItem();
                int day = 0;
                setSearchDayCombo(month, currentDate.getDayOfMonth());
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }



}
