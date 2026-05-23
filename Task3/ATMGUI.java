import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//================ Bank Account =================
class BankAccount {

    private double balance;

    public BankAccount(double balance){
        this.balance=balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public boolean withdraw(double amount){

        if(amount<=balance){

            balance-=amount;
            return true;
        }

        return false;
    }

    public double checkBalance(){

        return balance;
    }
}



//================ ATM GUI =================
public class ATMGUI extends JFrame
implements ActionListener{


    JLabel titleLabel;
    JLabel welcomeLabel;
    JLabel amountLabel;

    JTextField amountField;

    JPasswordField pinField;

    JTextArea displayArea;


    JButton loginButton;

    JButton depositButton;
    JButton withdrawButton;
    JButton balanceButton;
    JButton clearButton;
    JButton modifyPinButton;
    JButton exitButton;


    JPanel screenPanel;
    JPanel loginPanel;


    String atmPin="4321";


    BankAccount account=
            new BankAccount(25000);



    ATMGUI(){

        setTitle(
                "Smart Banking ATM");

        setExtendedState(
                JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        setLayout(null);

        getContentPane().setBackground(
                new Color(5,15,45));



        Dimension screen=
                Toolkit.getDefaultToolkit()
                        .getScreenSize();



        int panelWidth=500;
        int panelHeight=320;


        int x=
                (screen.width-panelWidth)/2;

        int y=
                (screen.height-panelHeight)/2
                        -20;



        //============== TITLE ==============

        titleLabel=
                new JLabel(
                        "SMART BANK ATM",
                        SwingConstants.CENTER);

        titleLabel.setBounds(
                x-100,
                30,
                panelWidth+200,
                60);

        titleLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        50));

        titleLabel.setForeground(
                new Color(
                        0,255,200));

        add(titleLabel);



        //============== WELCOME ==============

        welcomeLabel=
                new JLabel(
                        "Welcome to Secure Digital Banking",
                        SwingConstants.CENTER);

        welcomeLabel.setBounds(
                x-100,
                90,
                panelWidth+200,
                35);

        welcomeLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        20));

        welcomeLabel.setForeground(
                Color.WHITE);

        add(
                welcomeLabel);




        //============== LOGIN PANEL ==============

        loginPanel=
                new JPanel();

        loginPanel.setLayout(
                null);

        loginPanel.setBounds(
                x,
                170,
                500,
                250);

        loginPanel.setBackground(
                new Color(
                        30,41,59));

        loginPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                0,255,200),
                        3));

        add(loginPanel);



        JLabel loginTitle=
                new JLabel(
                        "ATM LOGIN",
                        SwingConstants.CENTER);

        loginTitle.setBounds(
                0,
                20,
                500,
                40);

        loginTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        28));

        loginTitle.setForeground(
                new Color(
                        0,255,200));

        loginPanel.add(
                loginTitle);




        JLabel pinLabel=
                new JLabel(
                        "Enter PIN :");

        pinLabel.setBounds(
                70,
                95,
                150,
                30);

        pinLabel.setForeground(
                Color.WHITE);

        pinLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        loginPanel.add(
                pinLabel);



        pinField=
                new JPasswordField();

        pinField.setBounds(
                220,
                95,
                180,
                35);

        pinField.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        loginPanel.add(
                pinField);




        loginButton=
                new JButton(
                        "LOGIN");

        loginButton.setBounds(
                170,
                160,
                150,
                40);

        styleButton(
                loginButton);

        loginPanel.add(
                loginButton);



        //============== ATM PANEL ==============

        screenPanel=
                new JPanel();

        screenPanel.setLayout(
                null);

        screenPanel.setBounds(
                x,
                y,
                panelWidth,
                panelHeight);

        screenPanel.setBackground(
                new Color(
                        30,41,59));

        screenPanel.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                0,255,200),
                        3));

        add(screenPanel);



        JLabel heading=
                new JLabel(
                        "ATM SERVICES",
                        SwingConstants.CENTER);

        heading.setBounds(
                0,
                15,
                500,
                30);

        heading.setForeground(
                new Color(
                        0,255,200));

        heading.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24));

        screenPanel.add(
                heading);



        amountLabel=
                new JLabel(
                        "Enter Amount:");

        amountLabel.setBounds(
                40,
                80,
                150,
                30);

        amountLabel.setForeground(
                Color.WHITE);

        amountLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        screenPanel.add(
                amountLabel);



        amountField=
                new JTextField();

        amountField.setBounds(
                220,
                80,
                200,
                35);

        amountField.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18));

        screenPanel.add(
                amountField);



        depositButton=
                new JButton(
                        "DEPOSIT");

        depositButton.setBounds(
                40,140,180,45);

        styleButton(
                depositButton);

        screenPanel.add(
                depositButton);



        withdrawButton=
                new JButton(
                        "WITHDRAW");

        withdrawButton.setBounds(
                280,140,180,45);

        styleButton(
                withdrawButton);

        screenPanel.add(
                withdrawButton);



        balanceButton=
                new JButton(
                        "CHECK BALANCE");

        balanceButton.setBounds(
                40,
                205,
                180,
                45);

        styleButton(
                balanceButton);

        balanceButton.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14));

        screenPanel.add(
                balanceButton);



        clearButton=
                new JButton(
                        "CLEAR");

        clearButton.setBounds(
                280,
                205,
                180,
                45);

        styleButton(
                clearButton);

        screenPanel.add(
                clearButton);



        modifyPinButton=
                new JButton(
                        "MODIFY PIN");

        modifyPinButton.setBounds(
                160,
                260,
                180,
                40);

        styleButton(
                modifyPinButton);

        screenPanel.add(
                modifyPinButton);



        displayArea=
                new JTextArea();

        displayArea.setBounds(
                40,
                310,
                420,
                35);

        displayArea.setEditable(
                false);

        screenPanel.add(
                displayArea);



        exitButton=
                new JButton(
                        "EXIT");

        exitButton.setBounds(
                (screen.width/2)-60,
                y+400,
                120,
                45);

        exitButton.setBackground(
                Color.RED);

        exitButton.setForeground(
                Color.WHITE);

        add(
                exitButton);



        screenPanel.setVisible(false);

        exitButton.setVisible(false);



        loginButton.addActionListener(this);

        depositButton.addActionListener(this);

        withdrawButton.addActionListener(this);

        balanceButton.addActionListener(this);

        clearButton.addActionListener(this);

        modifyPinButton.addActionListener(this);

        exitButton.addActionListener(this);


        setVisible(true);

    }



    public void styleButton(
            JButton button){

        button.setBackground(
                new Color(
                        0,102,204));

        button.setForeground(
                Color.WHITE);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16));
    }



    public void actionPerformed(
            ActionEvent e){

        try{


            if(e.getSource()
                    ==loginButton){

                String enteredPin=
                        new String(
                                pinField.getPassword());

                if(enteredPin.equals(
                        atmPin)){

                    loginPanel.setVisible(
                            false);

                    screenPanel.setVisible(
                            true);

                    exitButton.setVisible(
                            true);

                }

                else{

                    JOptionPane.showMessageDialog(
                            this,
                            "Wrong PIN");
                }
            }



            else if(
                    e.getSource()
                    ==depositButton){

                double amount=
                        Double.parseDouble(
                                amountField.getText());

                account.deposit(
                        amount);

                displayArea.setText(
                        "Deposited ₹"
                        +amount);
            }



            else if(
                    e.getSource()
                    ==withdrawButton){

                double amount=
                        Double.parseDouble(
                                amountField.getText());

                if(account.withdraw(
                        amount)){

                    displayArea.setText(
                            "Withdrawn ₹"
                            +amount);

                }

                else{

                    displayArea.setText(
                            "Insufficient Balance");
                }
            }



            else if(
                    e.getSource()
                    ==balanceButton){

                displayArea.setText(
                        "Balance ₹"
                        +account.checkBalance());
            }



            else if(
                    e.getSource()
                    ==modifyPinButton){

                String newPin=
                        JOptionPane.showInputDialog(
                                this,
                                "Enter New PIN");

                if(newPin!=null
                        && newPin.length()==4){

                    atmPin=newPin;

                    JOptionPane.showMessageDialog(
                            this,
                            "PIN Updated");

                }
            }



            else if(
                    e.getSource()
                    ==clearButton){

                amountField.setText("");

                displayArea.setText("");
            }



            else if(
                    e.getSource()
                    ==exitButton){

                System.exit(0);
            }


        }catch(Exception ex){

            displayArea.setText(
                    "Enter Valid Input");
        }
    }



    public static void main(
            String args[]){

        new ATMGUI();
    }

}