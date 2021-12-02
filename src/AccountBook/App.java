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

    private JPanel loginPanel, registerPanel, infoPanel, southPanel;
    private JButton loginBtn, registerBtn, registerSubmitBtn, registerCancelBtn, searchBtn, resetBtn, logoutBtn, inputBtn, deleteBtn;
    private JTextField idField, registerIdField, searchField, dateField, memoField, incomeField, outcomeField;
    private JLabel registerPwCheck;
    private JPasswordField pwField, registerPwField, registerPwConfirmField;
    private JComboBox searchYearCombo, searchMonthCombo, searchDayCombo, inputYearCombo, inputMonthCombo, inputDayCombo, debitOrCashCombo;
    private JTable table;

    private TableRowSorter<TableModel> rowSorter;

    UserData ud;
    AccountData ad;

    LocalDate currentDate;

    private int thisYear;
    private int thisMonth;
    private int thisDays;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);

    }

    public void setLoginPanel(){

        loginPanel = new JPanel();
        JLabel loginLabel = new JLabel("로그인");
        JLabel idLabel = new JLabel("Username");
        idField = new JTextField();
        JLabel pwLabel = new JLabel("Password");
        pwField = new JPasswordField();
        loginBtn = new JButton("로그인");
        registerBtn = new JButton("회원가입");

        ImageIcon icon = new ImageIcon("image/Bart.png");
        Image im = icon.getImage();
        Image im2 = im.getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);
        JLabel img = new JLabel(icon2);
        img.setIcon(icon2);
        img.setBounds(5,130,300,400);

        ImageIcon icon3 = new ImageIcon("image/Bart2.png");
        Image im3 = icon3.getImage();
        Image im4 = im3.getScaledInstance(240,280,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(im4);
        JLabel img2 = new JLabel(icon4);
        img2.setIcon(icon4);
        img2.setBounds(430,200,250,250);

        ImageIcon icon5 = new ImageIcon("image/Simpsons.png");
        Image im5 = icon5.getImage();
        Image im6 = im5.getScaledInstance(400,200,Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(im6);
        JLabel img3 = new JLabel(icon6);
        img3.setIcon(icon6);
        img3.setBounds(50,400,650,325);

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
        loginPanel.add(img);
        loginPanel.add(img2);
        loginPanel.add(img3);

        loginPanel.setBounds(0,0,700,700);
    }

    public void setRegisterPanel(){

        registerPanel = new JPanel();
        JLabel registerLabel = new JLabel("회원가입");
        JLabel registerIdLabel = new JLabel("사용하실 Username을 입력하세요.");
        JLabel registerPwLabel = new JLabel("사용하실 비밀번호를 입력해주세요.");
        JLabel registerPwConfirmLabel = new JLabel("비밀번호를 다시 한번 입력해주세요.");
        registerPwCheck = new JLabel("");
        registerIdField = new JTextField();
        registerPwField = new JPasswordField();
        registerPwConfirmField = new JPasswordField();
        registerSubmitBtn = new JButton("제출");
        registerCancelBtn = new JButton("뒤로");

        ImageIcon icon = new ImageIcon("image/Bart3.png");
        Image im = icon.getImage();
        Image im2 = im.getScaledInstance(130,200,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);
        JLabel img = new JLabel(icon2);
        img.setIcon(icon2);
        img.setBounds(5,230,200,200);

        ImageIcon icon3 = new ImageIcon("image/Bart4.png");
        Image im3 = icon3.getImage();
        Image im4 = im3.getScaledInstance(150,200,Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(im4);
        JLabel img2 = new JLabel(icon4);
        img2.setIcon(icon4);
        img2.setBounds(470,230,200,200);

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
        registerPanel.add(img);
        registerPanel.add(img2);

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


        resetBtn = new JButton("초기화");
        resetBtn.setBounds(600,20,80,40);
        resetBtn.setBackground(new Color(55,29,30));
        resetBtn.setForeground(new Color(250, 225, 0));
        resetBtn.setFont(new Font("맑은 고딕", Font.BOLD,15));

        inputBtn = new JButton("등록");
        inputBtn.setBounds(480, 200,90,40);
        inputBtn.setBackground(new Color(55,29,30));
        inputBtn.setForeground(new Color(200, 225, 0));

        logoutBtn = new JButton("로그아웃");
        logoutBtn.setBounds(30, 200,90,40);
        logoutBtn.setBackground(new Color(55,29,30));
        logoutBtn.setForeground(new Color(200, 225, 0));

        deleteBtn = new JButton("삭제");
        deleteBtn.setBounds(560, 200,90,40);
        deleteBtn.setBackground(new Color(55,29,30));
        deleteBtn.setForeground(new Color(200, 225, 0));

        searchField = new JTextField();
        searchField.setBounds(190, 20, 400, 40);

//        setSearchYearCombo();
//        searchMonthCombo = new JComboBox();
//        searchYearCombo.setBounds(20,20,70,40);
//        searchMonthCombo.setBounds(90,20,70,40);

        JLabel searchLabel = new JLabel("검색");
        JLabel dateLabel = new JLabel("날짜");
        JLabel memoLabel = new JLabel("메모");
        JLabel incomeLabel = new JLabel("수입");
        JLabel outcomeLabel = new JLabel("지출");
        JLabel debitOrCashLabel = new JLabel("현금/카드");

        searchLabel.setForeground(new Color(55,29,30));
        dateLabel.setForeground(new Color(55,29,30));
        memoLabel.setForeground(new Color(55,29,30));
        incomeLabel.setForeground(new Color(55,29,30));
        outcomeLabel.setForeground(new Color(55,29,30));
        debitOrCashLabel.setForeground(new Color(55,29,30));

        searchLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        memoLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        incomeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        outcomeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        debitOrCashLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        memoField = new JTextField();
        memoField.setBounds(300,100,140,35);
        incomeField = new JTextField();
        incomeField.setBounds(70,140,140,35);
        outcomeField = new JTextField();
        outcomeField.setBounds(300,140,140,35);

        searchLabel.setBounds(140,20,70,40);
        dateLabel.setBounds(20,100,60,30);
        memoLabel.setBounds(250,100,60,30);
        incomeLabel.setBounds(20,140,60,30);
        outcomeLabel.setBounds(250,140,60,30);
        debitOrCashLabel.setBounds(480,100,100,30);

        String[] str = {"현금","카드"};
        debitOrCashCombo = new JComboBox(str);
        debitOrCashCombo.setBounds(480,140,140,35);

        setInputYearCombo();
        setInputMonthCombo();
        setInputDayCombo();
        setInputCombo();

        inputYearCombo.setBounds(70,100,60,40);
        inputMonthCombo.setBounds(130,100,50,40);
        inputDayCombo.setBounds(180,100,50,40);

        ImageIcon icon = new ImageIcon("image/Simpsons2.png");
        Image im = icon.getImage();
        Image im2 = im.getScaledInstance(300,150,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(im2);
        JLabel img = new JLabel(icon2);
        img.setIcon(icon2);
        img.setBounds(150,180,300,150);

        southPanel.add(searchLabel);
        southPanel.add(dateLabel);
        southPanel.add(memoLabel);
        southPanel.add(memoField);
        southPanel.add(incomeLabel);
        southPanel.add(incomeField);
        southPanel.add(outcomeLabel);
        southPanel.add(outcomeField);
        southPanel.add(debitOrCashLabel);
        southPanel.add(debitOrCashCombo);
        southPanel.add(inputYearCombo);
        southPanel.add(inputMonthCombo);
        southPanel.add(inputDayCombo);
        southPanel.add(searchField);
        southPanel.add(resetBtn);
        southPanel.add(inputBtn);
        southPanel.add(logoutBtn);
        southPanel.add(deleteBtn);
        southPanel.add(img);

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

        List<String> list = new ArrayList<>();

        for(int i = 1; i <= lastMonth; i++){
            list.add(Integer.toString(i));
        }
        searchMonthCombo = new JComboBox(list.toArray(new String[list.size()]));

        searchMonthCombo.setBounds(90,20,70,40);
        southPanel.add(searchMonthCombo);
    }

    public void setInputYearCombo() {
        currentDate = LocalDate.now();
        thisYear = currentDate.getYear();
        List<String> list = new ArrayList<>();

        for(int i = 1900; i <= thisYear; i++){
            list.add(Integer.toString(i));
        }
        inputYearCombo = new JComboBox(list.toArray(new String[list.size()]));
    }

    public void setInputMonthCombo(){
        String[] month = new String[12];
        for(int i = 0; i < month.length; i++){
            month[i] = Integer.toString(i+1);
        }
        inputMonthCombo = new JComboBox(month);
    }

    public void setInputDayCombo(){
        String[] day = new String[31];
        for(int i = 0; i < day.length; i++){
            day[i] = Integer.toString(i+1);
        }
        inputDayCombo = new JComboBox(day);
    }

    public void addRecord(){
        clearTable();
        DefaultTableModel model=(DefaultTableModel)table.getModel();

        ad = new AccountData();
        List<List<String>> list = new ArrayList<>();

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

    public void recordDelete(int num){

        List<List<String>> list = new ArrayList<>();

        try {
            list = ad.dataRead();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"파일 읽기 오류가 발생했습니다.");
            e.printStackTrace();
        }

        list.remove(num);

        try {
            ad.dataRewrite(list);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"파일 쓰기 오류가 발생했습니다.");
            e.printStackTrace();
        }

        addRecord();
        JOptionPane.showMessageDialog(null,"삭제가 완료되었습니다.");
    }

    public void clearTable() {
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        dm.getDataVector().removeAllElements();
        revalidate();
    }

    public void resetField(){

        setInputCombo();
        memoField.setText("");
        incomeField.setText("");
        outcomeField.setText("");
        debitOrCashCombo.setSelectedIndex(0);
    }

    public void setInputCombo(){
        currentDate = LocalDate.now();
        thisYear = currentDate.getYear();
        thisMonth = currentDate.getMonthValue();
        thisDays = currentDate.getDayOfMonth();

        inputYearCombo.getModel().setSelectedItem(thisYear);
        inputMonthCombo.getModel().setSelectedItem(thisMonth);
        inputDayCombo.getModel().setSelectedItem(thisDays);
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
        infoPanel.setVisible(false);

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
                        if (!arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                            msg = "사용자 정보가 존재하지 않습니다.";
                        }else if (arr.get(i).get(0).equals(id) && !arr.get(i).get(1).equals(pw)) {
                            msg = "비밀번호가 일치하지 않습니다.";
                        }else if (arr.get(i).get(0).equals(id) && arr.get(i).get(1).equals(pw)) {
                            msg = "로그인 성공했습니다. 환영합니다, " + id + "님.";
                            loginPanel.setVisible(false);
                            infoPanel.setVisible(true);
                            idField.setText("");
                            pwField.setText("");
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
                UserData ud = new UserData();
                try {
                    ud.makeLoginFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
                            registerIdField.setText("");
                            registerPwField.setText("");
                            registerPwConfirmField.setText("");
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

//        searchYearCombo.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                int lastMonth = 0;
//                currentDate = LocalDate.now();
//                String year = (String)searchYearCombo.getSelectedItem();
//
//                if(year.equals(Integer.toString(currentDate.getYear()))){
//                    lastMonth = currentDate.getMonthValue();
//                }else{
//                    lastMonth = 12;
//                }
//                setSearchMonthCombo(lastMonth);
//            }
//        });


//        searchMonthCombo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                currentDate = LocalDate.now();
//                String month = (String)searchMonthCombo.getSelectedItem();
//                int day = 0;
//            }
//        });


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
                throw new UnsupportedOperationException("");
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
            }
        });

        inputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                List<String> list = new ArrayList<>();
                List<List<String>> arr = new ArrayList<>();
                int num;
                String number;

                try {
                    arr = ad.dataRead();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"읽기 오류가 발생했습니다.");
                    ex.printStackTrace();
                }
                if(arr.isEmpty()){
                    number = "1";
                }else{
                    num = Integer.parseInt(arr.get(arr.size()-1).get(0));
                    number = Integer.toString(num + 1);
                }


                String str = "";

                String year = String.valueOf(inputYearCombo.getSelectedItem());
                String month = String.valueOf(inputMonthCombo.getSelectedItem());
                String day = String.valueOf(inputDayCombo.getSelectedItem());
                if(Integer.parseInt(day) < 10){
                    str = "0";
                }
                String date = year + "-" + month + "-" + str + day;
                String memo = memoField.getText();
                String income = incomeField.getText();
                String outcome = outcomeField.getText();
                String debitOrCash = (String)debitOrCashCombo.getSelectedItem();

                if(date.equals("") || memo.equals("") || income.equals("") || outcome.equals("") || debitOrCash.equals("")){
                    JOptionPane.showMessageDialog(null,"공백이 있습니다. 모두 입력하여 주십시오.");
                }else{
                    list.add(number);
                    list.add(date);
                    list.add(memo);
                    list.add(income);
                    list.add(outcome);
                    list.add(debitOrCash);
                    try {
                        ad.dataWrite(list);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"쓰기 오류가 발생했습니다.");
                        resetField();
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,"등록이 완료되었습니다.");
                    resetField();
                    addRecord();
                }
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = table.getSelectedRow();

                if(num > 0){
                    int result = JOptionPane.showConfirmDialog(null, "기록을 삭제하시겠습니까?", "삭제", JOptionPane.OK_CANCEL_OPTION);
                    if(result == 0){
                        recordDelete(num);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"기록을 선택해주십시오.");
                }
            }
        });

        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPanel.setVisible(false);
                loginPanel.setVisible(true);
            }
        });

        incomeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
            }
        });

        outcomeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }
            }
        });

    }





}
