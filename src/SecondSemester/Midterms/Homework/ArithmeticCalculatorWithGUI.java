package FirstYear.SecondSemester.Midterms.Homework;

/**
 * Name: Malasan, Edison M.
 * Class Code and Schedule: 9322 A/B - (A)12:30 - 1:30 / (B)3:00 - 4:30
 * Date: 17/03/2024
 * Program that illustrates using Java classes for
 * rendering a Graphical User Interface (GUI)
 *
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ArithmeticCalculatorWithGUI extends JFrame {
    private JLabel firstL, secondL, resultL;
    private JTextField firstTF, secondTF, resultTF;
    private JButton addB,subtractB,multiplyB,divideB,clearB,exitB;
    private AddButtonHandler addHandler;
    private SubtractButtonHandler subtractHandler;
    private MultiplyButtonHandler multiplyHandler;
    private DivideButtonHandler divideHandler;
    private ClearButtonHandler clearHandler;
    private ExitButtonHandler ebHandler;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    public ArithmeticCalculatorWithGUI(){
        firstL = new JLabel("Enter the first number: ", SwingConstants.RIGHT);
        secondL = new JLabel("Enter the second number: " , SwingConstants.RIGHT);
        resultL = new JLabel("Result: " , SwingConstants.RIGHT);
        firstTF = new JTextField(10);
        firstTF.setFont(new Font("Arial", Font.BOLD, 20));
        secondTF = new JTextField(10);
        secondTF.setFont(new Font("Arial", Font.BOLD, 20));
        resultTF = new JTextField(10);
        resultTF.setFont(new Font("Arial", Font.BOLD, 20));
        resultTF.setEnabled(false);
        addB = new JButton("Add");
        addHandler = new AddButtonHandler();
        addB.addActionListener(addHandler);
        subtractB = new JButton("Subtract");

        subtractHandler = new SubtractButtonHandler();
        subtractB.addActionListener(subtractHandler);
        multiplyB = new JButton("Multiply");
        multiplyHandler = new MultiplyButtonHandler();
        multiplyB.addActionListener(multiplyHandler);
        divideB = new JButton("Divide");
        divideHandler = new DivideButtonHandler();
        divideB.addActionListener(divideHandler);
        clearB = new JButton("Clear");
        clearHandler = new ClearButtonHandler();
        clearB.addActionListener(clearHandler);
        exitB = new JButton("Exit");
        ebHandler = new ExitButtonHandler();
        exitB.addActionListener(ebHandler);
        setTitle("Arithmetic Calculator by Edison Malasan ");
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(6,2));
        pane.add(firstL);
        pane.add(firstTF);
        pane.add(secondL);
        pane.add(secondTF);
        pane.add(resultL);
        pane.add(resultTF);
        pane.add(addB);
        pane.add(subtractB);
        pane.add(multiplyB);
        pane.add(divideB);
        pane.add(clearB);
        pane.add(exitB);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    } // end of constructor

    private class AddButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double first=0, second=0, result=0;
            try {
                first = Double.parseDouble(firstTF.getText());
                second = Double.parseDouble(secondTF.getText());
            } catch (NumberFormatException x) {
                x.printStackTrace();
            } // end of catch
            result = first + second;
            resultTF.setText(""+result);
        }
    } // end of AddButtonHandler class

    private class SubtractButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double first, second, result;
            first = Double.parseDouble(firstTF.getText());
            second = Double.parseDouble(secondTF.getText());
            result = first - second;
            resultTF.setText(""+result);
        }
    } // end of SubtractButtonHandler class
    private class MultiplyButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double first, second, result;
            first = Double.parseDouble(firstTF.getText());
            second = Double.parseDouble(secondTF.getText());
            result = first * second;
            resultTF.setText(""+result);
        }
    } // end of MultiplyButtonHandler class
    private class ClearButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            firstTF.setText("");
            secondTF.setText("");
            resultTF.setText("");
        }
    } // end of ClearButtonHandler class

    private class DivideButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double first, second, result;
            first = Double.parseDouble(firstTF.getText());
            second = Double.parseDouble(secondTF.getText());
            result = first/second;
            resultTF.setText(""+result);
        }
    } // end of DivideButtonHandler class

    private class ExitButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    public static void main(String[] args){
        ArithmeticCalculatorWithGUI calculatorObject = new ArithmeticCalculatorWithGUI();
    }
} // end of ArithmeticCalculatorG class
