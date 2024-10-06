/**
 Name of programmer: Malasan, Edison M.
 Class Code and Schedule: 9322 A/B - (A)12:30 - 1:30 / (B)3:00 - 4:30
 Date: 17/03/2024
 */
//5. Include the NumberConverterBoard class in the package called prog2.samcis
package FirstYear.SecondSemester.Finals.Exercises;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class NumberConverterBoard extends JFrame{
    private JPanel numberPanel;
    private JPanel buttonPanel;
    private JButton convertButton, clearButton, exitButton;
    private JTextField binaryTF, decimalTF, octalTF, hexadecimalTF;
    private EquivalentNumbers number;
    private JLabel problemDisplayer;
    private JPanel reminderPanel;
    private ButtonsHandler buttonsHandler;
    private JPanel headPanel;
    public static void main(String[] args){
        NumberConverterBoard board = new NumberConverterBoard();
    }

    public NumberConverterBoard(){
        setTitle("Number Converter");
        setSize(800,400);
        headPanel = new JPanel();
        JLabel textArea = new JLabel();
        textArea.setText("This application helps you convert a decimal number to binary, octal and hexadecimal." +
                "Please enter the decimal number in the field provided. Then, press the convert key.");
                headPanel.add(textArea);
        numberPanel = new JPanel();
        setNumberPanel(numberPanel);
        buttonPanel = new JPanel();
        setButtonPanel(buttonPanel);
        reminderPanel = new JPanel();
        problemDisplayer = new JLabel("");
        problemDisplayer.setFont(new Font("Arial", Font.ITALIC, 20));
        reminderPanel.add(problemDisplayer);
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1));
        pane.add(headPanel);
        pane.add(numberPanel);
        pane.add(reminderPanel);
        pane.add(buttonPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void setButtonPanel(JPanel panel){
        convertButton = new JButton("convert");
        clearButton = new JButton("clear");
        exitButton = new JButton("exit");
        buttonsHandler = new ButtonsHandler();
        convertButton.addActionListener(buttonsHandler);
        clearButton.addActionListener(buttonsHandler);
        exitButton.addActionListener(buttonsHandler);
        panel.add(convertButton);
        panel.add(clearButton);
        panel.add(exitButton);
        return;
    }
    public void setNumberPanel(JPanel panel){
        JLabel decimalLabel = new JLabel("Decimal Number: ");
        decimalLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel binaryLabel = new JLabel("Binary Number: ");
        binaryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel octalLabel = new JLabel("Octal Number:");
        octalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel hexadecimalLabel = new JLabel("Hexadecimal Number: ");
        hexadecimalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        decimalTF = new JTextField(20);
        decimalTF.setFont(new Font("Arial",Font.BOLD,20));
        binaryTF = new JTextField(20);
        binaryTF.setFont(new Font("Arial",Font.BOLD,20));
        octalTF = new JTextField(20);
        octalTF.setFont(new Font("Arial",Font.BOLD,20));
        hexadecimalTF = new JTextField(20);
        hexadecimalTF.setFont(new Font("Arial",Font.BOLD,20));
        panel.setLayout(new GridLayout(4,4));
        panel.add(decimalLabel);
        panel.add(decimalTF);
        panel.add(binaryLabel);
        panel.add(binaryTF);
        panel.add(octalLabel);
        panel.add(octalTF);
        panel.add(hexadecimalLabel);
        panel.add(hexadecimalTF);
        return;
    }

    private class ButtonsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exitButton)
                System.exit(0);
            if (e.getSource()== clearButton){
                decimalTF.setText("");
                binaryTF.setText("");
                octalTF.setText("");
                hexadecimalTF.setText("");
                problemDisplayer.setText("");
            }
            if (e.getSource()== convertButton)
                try{
                    if (decimalTF.getText().equals("")){
                        throw new Exception("No specified decimal number.");
                    }
                    else {
                        problemDisplayer.setText("");
                        number = new EquivalentNumbers();
                        number.setDecimalNumber(Double.parseDouble(decimalTF.getText()));
                        binaryTF.setText(String.format("%.4f", Double.parseDouble(number.getBinaryString())));
                        octalTF.setText(String.format("%.5f", Double.parseDouble(number.getOctalString())));
                        hexadecimalTF.setText(number.getHexadecimalString().toUpperCase());
                    }
                } catch (NumberFormatException x ){
                    problemDisplayer.setText("One of the numbers does not follow the format of a number.");
                } catch (Exception e2){
                    problemDisplayer.setText(e2.getMessage());
                }
        }
    }
}
