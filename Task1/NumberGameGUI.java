import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class NumberGameGUI extends JFrame implements ActionListener {

    private JTextField inputField;
    private JLabel titleLabel, messageLabel, attemptsLabel, scoreLabel;
    private JButton guessButton, resetButton;

    private int number, attempts, maxAttempts = 5, score = 0;

    public NumberGameGUI() {

        setTitle("Number Guessing Game");

        // Full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background color
        getContentPane().setBackground(new Color(230, 240, 250));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1,15,15));
        panel.setBackground(Color.WHITE);

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(
                        new Color(80,120,200),3),
                BorderFactory.createEmptyBorder(
                        30,40,30,40)));

        // Title
        titleLabel = new JLabel("NUMBER GUESSING GAME");
        titleLabel.setFont(new Font("Segoe UI",Font.BOLD,28));
        titleLabel.setForeground(new Color(0,70,140));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        messageLabel = new JLabel(
                "Guess a number between 1 and 100");
        messageLabel.setFont(
                new Font("Arial",Font.PLAIN,18));
        messageLabel.setHorizontalAlignment(
                JLabel.CENTER);

        inputField = new JTextField();
        inputField.setFont(
                new Font("Arial",Font.PLAIN,18));

        guessButton = new JButton("Guess");
        resetButton = new JButton("Play Again");

        // Button Styling
        guessButton.setBackground(
                new Color(0,102,204));
        guessButton.setForeground(Color.WHITE);

        resetButton.setBackground(
                new Color(0,153,76));
        resetButton.setForeground(Color.WHITE);

        guessButton.setFont(
                new Font("Segoe UI",Font.BOLD,16));
        resetButton.setFont(
                new Font("Segoe UI",Font.BOLD,16));

        guessButton.setFocusPainted(false);
        resetButton.setFocusPainted(false);

        attemptsLabel = new JLabel(
                "Attempts Left: "+maxAttempts);
        scoreLabel = new JLabel(
                "Score: "+score);

        attemptsLabel.setHorizontalAlignment(
                JLabel.CENTER);
        scoreLabel.setHorizontalAlignment(
                JLabel.CENTER);

        attemptsLabel.setFont(
                new Font("Arial",Font.BOLD,16));
        scoreLabel.setFont(
                new Font("Arial",Font.BOLD,16));

        JPanel buttonPanel=new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);

        panel.add(titleLabel);
        panel.add(messageLabel);
        panel.add(inputField);
        panel.add(buttonPanel);
        panel.add(attemptsLabel);
        panel.add(scoreLabel);

        guessButton.addActionListener(this);
        resetButton.addActionListener(this);

        gbc.gridx=0;
        gbc.gridy=0;

        add(panel,gbc);

        generateNumber();

        setVisible(true);
    }

    private void generateNumber() {

        Random rand = new Random();

        number = rand.nextInt(100)+1;

        attempts = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==guessButton){

            try{

                int guess=
                        Integer.parseInt(
                                inputField.getText());

                attempts++;

                if(guess==number){

                    messageLabel.setText(
                            "✔ Correct! You guessed it!");

                    messageLabel.setForeground(
                            new Color(0,153,0));

                    score++;

                    scoreLabel.setText(
                            "Score: "+score);

                    guessButton.setEnabled(false);
                }

                else if(guess<number){

                    messageLabel.setText(
                            "Too Low!");

                    messageLabel.setForeground(
                            Color.ORANGE);
                }

                else{

                    messageLabel.setText(
                            "Too High!");

                    messageLabel.setForeground(
                            Color.RED);
                }

                attemptsLabel.setText(
                        "Attempts Left: "
                                +(maxAttempts-attempts));

                if(attempts>=maxAttempts
                        && guess!=number){

                    messageLabel.setText(
                            "Game Over! Number was "
                                    +number);

                    messageLabel.setForeground(
                            Color.RED);

                    guessButton.setEnabled(false);
                }

            }

            catch(NumberFormatException ex){

                messageLabel.setText(
                        "Enter valid number!");

                messageLabel.setForeground(
                        Color.RED);
            }

        }

        if(e.getSource()==resetButton){

            generateNumber();

            inputField.setText("");

            messageLabel.setText(
                    "Guess a number between 1 and 100");

            messageLabel.setForeground(
                    Color.BLACK);

            attemptsLabel.setText(
                    "Attempts Left: "
                            +maxAttempts);

            guessButton.setEnabled(true);

        }

    }

    public static void main(String[] args) {

        new NumberGameGUI();

    }
}