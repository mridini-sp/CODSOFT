import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculatorGUI extends JFrame implements ActionListener {

    JTextField[] marksField = new JTextField[5];

    JLabel totalValue, averageValue,
            percentageValue, gradeValue;

    JButton calculateBtn, resetBtn;

    public StudentGradeCalculatorGUI() {

        setTitle("Student Grade Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // HEADER

        JPanel header = new JPanel();

        header.setBackground(
                new Color(35,45,85));

        header.setPreferredSize(
                new Dimension(100,80));

        JLabel title =
                new JLabel(
                        "STUDENT GRADE CALCULATOR");

        title.setForeground(
                Color.WHITE);

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32));

        header.add(title);

        add(header,
                BorderLayout.NORTH);

        // CENTER AREA

        JPanel center =
                new JPanel(
                        new GridBagLayout());

        center.setBackground(
                new Color(
                        235,
                        240,
                        248));

        JPanel dashboard =
                new JPanel();

        dashboard.setPreferredSize(
                new Dimension(
                        950,
                        650));

        dashboard.setBackground(
                Color.WHITE);

        dashboard.setLayout(
                new BorderLayout(
                        30,
                        30));

        dashboard.setBorder(
                BorderFactory
                        .createEmptyBorder(
                                30,
                                30,
                                30,
                                30));

        // INPUT SECTION

        JPanel inputPanel =
                new JPanel(
                        new GridLayout(
                                5,
                                2,
                                20,
                                20));

        inputPanel.setBackground(
                Color.WHITE);

        Font font =
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16);

        for(int i=0;i<5;i++){

            JLabel label =
                    new JLabel(
                            "Subject "
                            +(i+1)
                            +" Marks");

            label.setFont(font);

            marksField[i] =
                    new JTextField();

            marksField[i].setFont(
                    new Font(
                            "Arial",
                            Font.PLAIN,
                            16));

            inputPanel.add(label);

            inputPanel.add(
                    marksField[i]);
        }

        // RESULT CARDS

        JPanel cards =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                20,
                                20));

        cards.setBackground(
                Color.WHITE);

        cards.add(
                createCard(
                        "TOTAL"));

        cards.add(
                createCard(
                        "AVERAGE"));

        cards.add(
                createCard(
                        "PERCENTAGE"));

        cards.add(
                createCard(
                        "GRADE"));

        // BUTTONS

        JPanel buttons =
                new JPanel();

        buttons.setBackground(
                Color.WHITE);

        calculateBtn =
                new JButton(
                        "Calculate");

        resetBtn =
                new JButton(
                        "Reset");

        calculateBtn.setBackground(
                new Color(
                        0,
                        110,
                        220));

        resetBtn.setBackground(
                new Color(
                        220,
                        70,
                        70));

        calculateBtn.setForeground(
                Color.WHITE);

        resetBtn.setForeground(
                Color.WHITE);

        calculateBtn.setFont(font);

        resetBtn.setFont(font);

        calculateBtn.setFocusPainted(
                false);

        resetBtn.setFocusPainted(
                false);

        calculateBtn.addActionListener(this);

        resetBtn.addActionListener(this);

        buttons.add(calculateBtn);

        buttons.add(
                Box.createHorizontalStrut(
                        30));

        buttons.add(resetBtn);

        dashboard.add(
                inputPanel,
                BorderLayout.NORTH);

        dashboard.add(
                cards,
                BorderLayout.CENTER);

        dashboard.add(
                buttons,
                BorderLayout.SOUTH);

        center.add(dashboard);

        add(center,
                BorderLayout.CENTER);

        setVisible(true);
    }

    JPanel createCard(String title){

        JPanel card =
                new JPanel();

        card.setLayout(
                new BorderLayout());

        card.setBackground(
                new Color(
                        245,
                        248,
                        252));

        card.setBorder(
                BorderFactory
                        .createLineBorder(
                                new Color(
                                        210,
                                        210,
                                        220),
                                2));

        JLabel heading =
                new JLabel(
                        title,
                        SwingConstants.CENTER);

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16));

        JLabel value =
                new JLabel(
                        "-",
                        SwingConstants.CENTER);

        value.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28));

        if(title.equals("TOTAL"))
            totalValue=value;

        if(title.equals("AVERAGE"))
            averageValue=value;

        if(title.equals("PERCENTAGE"))
            percentageValue=value;

        if(title.equals("GRADE"))
            gradeValue=value;

        card.add(
                heading,
                BorderLayout.NORTH);

        card.add(
                value,
                BorderLayout.CENTER);

        return card;
    }

    @Override
    public void actionPerformed(
            ActionEvent e){

        if(e.getSource()==calculateBtn){

            try{

                int total=0;

                for(int i=0;i<5;i++){

                    int marks=
                            Integer.parseInt(
                                    marksField[i]
                                            .getText());

                    if(marks<0 || marks>100){

                        JOptionPane.showMessageDialog(
                                this,
                                "Marks should be between 0 and 100");

                        return;
                    }

                    total += marks;
                }

                double average =
                        total/5.0;

                double percentage =
                        (total/500.0)*100;

                String grade;

                if(percentage>=90)
                    grade="A+";

                else if(percentage>=75)
                    grade="A";

                else if(percentage>=60)
                    grade="B";

                else if(percentage>=50)
                    grade="C";

                else
                    grade="Fail";

                totalValue.setText(
                        String.valueOf(
                                total));

                averageValue.setText(
                        String.format(
                                "%.2f",
                                average));

                percentageValue.setText(
                        String.format(
                                "%.1f%%",
                                percentage));

                gradeValue.setText(
                        grade);

            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        "Enter valid numbers!");

            }
        }

        if(e.getSource()==resetBtn){

            for(JTextField field:
                    marksField)

                field.setText("");

            totalValue.setText("-");
            averageValue.setText("-");
            percentageValue.setText("-");
            gradeValue.setText("-");
        }
    }

    public static void main(String args[]){

        new StudentGradeCalculatorGUI();

    }
}