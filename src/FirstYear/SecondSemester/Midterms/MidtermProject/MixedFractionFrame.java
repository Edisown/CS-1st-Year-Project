package FirstYear.SecondSemester.Midterms.MidtermProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MixedFractionFrame extends JFrame {
    private JTextField firstMixedFraction, secondMixedFraction;
    private JButton[] numberButtons;
    private JButton[] funcButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel numberPanel;
    private JLabel problemDisplayer;
    private JPanel headPanel;

    public MixedFractionFrame(){
        headPanel = new JPanel();
        JLabel textArea = new JLabel();
        textArea.setText("MIXED FRACTION CALCULATOR!!!");
        headPanel.add(textArea);
        numberPanel = new JPanel();
        setNumberPanel(numberPanel);
        problemDisplayer = new JLabel("");
        problemDisplayer.setFont(new Font("Arial,",Font.ITALIC,20));
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = equButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;

        funcButtons = new JButton[8];
        for (int i = 0; i < 8; i++) {
            funcButtons[i].addActionListener((ActionListener) this);
            funcButtons[i].setFont(new Font("Arial",Font.BOLD,20));
            funcButtons[i].setFocusable(false);
        }

        numberButtons = new JButton[10];
        for (int i = 1; i <= 9; i++) {
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].addActionListener((ActionListener) this);
           numberButtons[i].setFont(new Font("Arial",Font.BOLD,20));
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        numberPanel = new JPanel();
        numberPanel.setBounds(50,100,300,300);
        numberPanel.setLayout(new GridLayout(4,4,10,10));

        numberPanel.add(numberButtons[1]);
        numberPanel.add(numberButtons[2]);
        numberPanel.add(numberButtons[3]);
        numberPanel.add(addButton);
        numberPanel.add(numberButtons[4]);
        numberPanel.add(numberButtons[5]);
        numberPanel.add(numberButtons[6]);
        numberPanel.add(subButton);
        numberPanel.add(numberButtons[7]);
        numberPanel.add(numberButtons[8]);
        numberPanel.add(numberButtons[9]);
        numberPanel.add(mulButton);
        numberPanel.add(decButton);
        numberPanel.add(numberButtons[0]);
        numberPanel.add(equButton);
        numberPanel.add(divButton);

        setTitle("PRO(digy)GRAMMERS");
        setSize(420,550);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1));
        pane.add(headPanel);
        pane.add(numberPanel);
        pane.add(delButton);
        pane.add(clrButton);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void setNumberPanel(JPanel panel){
        JLabel firstNum = new JLabel("First Mixed Fraction: ");
        firstNum.setFont(new Font("Arial", Font.BOLD,20));
        JLabel secondNum = new JLabel("Second Mixed Fraction: ");
        secondNum.setFont(new Font("Arial", Font.BOLD,20));
        firstMixedFraction = new JTextField(20);
        firstMixedFraction.setFont(new Font("Arial",Font.BOLD,20));
        secondMixedFraction = new JTextField(20);
        secondMixedFraction.setFont(new Font("Arial",Font.BOLD,20));
        panel.setLayout(new GridLayout(2,2));
        panel.add(firstNum);
        panel.add(firstMixedFraction);
        panel.add(secondNum);
        panel.add(secondMixedFraction);

    }
    private class AddButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){

        }
    }
    public static void main(String[] args) {
        MixedFractionFrame calc = new MixedFractionFrame();
    }
}
