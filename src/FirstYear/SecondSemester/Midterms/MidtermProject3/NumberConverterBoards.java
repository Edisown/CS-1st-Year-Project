package FirstYear.SecondSemester.Midterms.MidtermProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NumberConverterBoards extends JFrame {
    private JPanel numberPanel;
    private JPanel buttonPanel;
    private JPanel hyperLinkPanel;

    private ActionListener buttonsHandler;

    private JButton convertButton, clearButton, exitButton;
    private JTextField binaryTF, decimalTF, octalTF, hexadecimalTF;


    private JLabel problemDisplayer;

    public static void main(String[] args) {
        new NumberConverterBoards();
    }

    public NumberConverterBoards() {
        setTitle("My Nigga Converter");
        setSize(1200, 600);
        setResizable(false);

        JLabel textArea = new JLabel();
        textArea.setText("This application helps you convert a decimal number to binary, octal and hexadecimal. Please enter the decimal number in the field provided. Then, press the convert key.");
        JPanel headPanel = new JPanel();
        headPanel.add(textArea);

        numberPanel = new JPanel();
        setNumberPanel(numberPanel);

        buttonPanel = new JPanel();
        setButtonPanel(buttonPanel);

        hyperLinkPanel = new JPanel();
        setHyperLinkPanel(hyperLinkPanel);

        problemDisplayer = new JLabel("");
        problemDisplayer.setFont(new Font("Arial", Font.ITALIC, 20));
        JPanel reminderPanel = new JPanel();
        reminderPanel.add(problemDisplayer);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(headPanel);
        getContentPane().add(numberPanel);
        
        getContentPane().add(reminderPanel);
        getContentPane().add(buttonPanel);
        getContentPane().add(hyperLinkPanel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setNumberPanel(JPanel panel) {
        //---------------------------------------------DECIMAL-----------------------------------------------------------
        JLabel decimalLabel = new JLabel("Decimal Number:");
        decimalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        decimalTF = new JTextField(20);
        decimalTF.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel decimalPanel = new JPanel(new GridBagLayout());
        GridBagConstraints numberSystemLayout = new GridBagConstraints();
        numberSystemLayout.anchor = GridBagConstraints.WEST;
        numberSystemLayout.gridx = 0;
        numberSystemLayout.gridy = 0;
        decimalPanel.add(decimalLabel, numberSystemLayout);
        numberSystemLayout.gridy++;
        decimalPanel.add(decimalTF, numberSystemLayout);

        //---------------------------------------------BINARY-----------------------------------------------------------
        JLabel binaryLabel = new JLabel("Binary Number:");
        binaryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        binaryTF = new JTextField(20);
        binaryTF.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel binaryPanel = new JPanel(new GridBagLayout());
        numberSystemLayout = new GridBagConstraints();
        numberSystemLayout.anchor = GridBagConstraints.WEST;
        numberSystemLayout.gridx = 0;
        numberSystemLayout.gridy = 0;
        binaryPanel.add(binaryLabel, numberSystemLayout);
        numberSystemLayout.gridy++;
        binaryPanel.add(binaryTF, numberSystemLayout);

        //----------------------------------------------OCTAL-----------------------------------------------------------
        JLabel octalLabel = new JLabel("Octal Number:");
        octalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        octalTF = new JTextField(20);
        octalTF.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel octalPanel = new JPanel(new GridBagLayout());
        numberSystemLayout = new GridBagConstraints();
        numberSystemLayout.anchor = GridBagConstraints.WEST;
        numberSystemLayout.gridx = 0;
        numberSystemLayout.gridy = 0;
        octalPanel.add(octalLabel, numberSystemLayout);
        numberSystemLayout.gridy++;
        octalPanel.add(octalTF, numberSystemLayout);

        //--------------------------------------------HEXADECIMAL-------------------------------------------------------
        JLabel hexadecimalLabel = new JLabel("Hexadecimal Number:");
        hexadecimalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        hexadecimalTF = new JTextField(20);
        hexadecimalTF.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel hexadecimalPanel = new JPanel(new GridBagLayout());
        numberSystemLayout = new GridBagConstraints();
        numberSystemLayout.anchor = GridBagConstraints.WEST;
        numberSystemLayout.gridx = 0;
        numberSystemLayout.gridy = 0;
        hexadecimalPanel.add(hexadecimalLabel, numberSystemLayout);
        numberSystemLayout.gridy++;
        hexadecimalPanel.add(hexadecimalTF, numberSystemLayout);

        //---------------------------------------------Layout-----------------------------------------------------------
        panel.setLayout(new GridLayout(0, 1));
        panel.add(decimalPanel);
        panel.add(binaryPanel);
        panel.add(octalPanel);
        panel.add(hexadecimalPanel);
    }

    public void setButtonPanel(JPanel panel) {
        convertButton = new JButton("Convert");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");
        buttonsHandler = new ButtonsHandler();
        convertButton.addActionListener(buttonsHandler);
        clearButton.addActionListener(buttonsHandler);
        exitButton.addActionListener(buttonsHandler);

        panel.add(convertButton);
        panel.add(clearButton);
        panel.add(exitButton);
    }

    public void setHyperLinkPanel(JPanel panel){
        JLabel label1 = new JLabel("<html>Want to learn more about Number Systems?</html>");
        JLabel label2 = new JLabel("<html><a href='https://www.reddit.com/media?url=https%3A%2F%2Fpreview.redd.it%2Fmhu8sgbo6bu11.jpg%3Fauto%3Dwebp%26s%3De3074a6be6072c20a4562b4cf60a0c905b0caed8'>Click here</a></html>");
        //TRUE LINK https://medium.com/coderscorner/number-systems-decimal-binary-octal-and-hexadecimal-5e567e55ab28
        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new java.net.URI("https://www.reddit.com/media?url=https%3A%2F%2Fpreview.redd.it%2Fmhu8sgbo6bu11.jpg%3Fauto%3Dwebp%26s%3De3074a6be6072c20a4562b4cf60a0c905b0caed8"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        panel.add(label1);
        panel.add(label2);
    }
    private class ButtonsHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == exitButton)
                System.exit(0);
            if (e.getSource()== clearButton){
                clearInputs();
            }
            if (e.getSource()== convertButton)
                try{
                    if (!decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertDecimal();
                    } else if (decimalTF.getText().isEmpty() && !binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertBinary();
                    } else if (decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && !octalTF.getText().isEmpty() && hexadecimalTF.getText().isEmpty()){
                        convertOctal();
                    } else if (decimalTF.getText().isEmpty() && binaryTF.getText().isEmpty() && octalTF.getText().isEmpty() && !hexadecimalTF.getText().isEmpty()){
                        convertHexadecimal();
                    }else {
                        problemDisplayer.setText("Please enter a value on exactly one number system to convert.");
                        return;
                    }

                    problemDisplayer.setText("");

                } catch (NumberFormatException x ){
                    problemDisplayer.setText("One of the numbers does not follow the format of a number.");
                } catch (Exception e2){
                    problemDisplayer.setText("The input does not follow the format of the Number System");
                }
        }

        private void convertDecimal() {
            EquivalentNumbers number = new EquivalentNumbers();
            number.setDecimalNumber(Float.parseFloat(decimalTF.getText()));
            binaryTF.setText(number.getBinaryString());
            octalTF.setText(number.getOctalString());
            hexadecimalTF.setText(number.getHexadecimalString());
        }

        private void convertBinary() throws Exception {
            EquivalentNumbers number = new EquivalentNumbers();
            number.setBinaryNumber(binaryTF.getText());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
            octalTF.setText(number.getOctalString());
            hexadecimalTF.setText(number.getHexadecimalString());
        }

        private void convertOctal() throws Exception {
            EquivalentNumbers number = new EquivalentNumbers();
            number.setOctalNumber(octalTF.getText());
            binaryTF.setText(number.getBinaryString());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
            hexadecimalTF.setText(number.getHexadecimalString());
        }

        private void convertHexadecimal() throws Exception {
            EquivalentNumbers number = new EquivalentNumbers();
            number.setHexadecimalString(hexadecimalTF.getText());
            binaryTF.setText(number.getBinaryString());
            octalTF.setText(number.getOctalString());
            decimalTF.setText(String.valueOf(number.getDecimalNumber()));
        }
    }

    private void clearInputs() {
        decimalTF.setText("");
        binaryTF.setText("");
        octalTF.setText("");
        hexadecimalTF.setText("");
        problemDisplayer.setText("");
    }
    
}



