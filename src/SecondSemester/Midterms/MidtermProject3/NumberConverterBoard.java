package FirstYear.SecondSemester.Midterms.MidtermProject3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Edison Malasan
 */
public class NumberConverterBoard extends JFrame {

    private JButton startButton;
    private JPanel startPanel;
    private JPanel startHeadPanel;

    private JPanel numberPanel;
    private JPanel buttonPanel;
    private JPanel hyperLinkPanel;
    private JPanel numberOptionPanel;
    private ActionListener buttonsHandler;

    private JButton convertButton, clearButton, exitButton;
    private JTextField binaryTF, decimalTF, octalTF, hexadecimalTF;
    private JComboBox<String> numberSystems;

    private JLabel problemDisplayer;

    private NumberConverterBoard converterBoard;

    public static void main(String[] args) {
        new NumberConverterBoard();
    }

    public NumberConverterBoard() {
        setTitle("EdibroSTART");
        setSize(400, 200); // Set initial size
        setResizable(false); // Set resizable to false
        getContentPane().setBackground(Color.LIGHT_GRAY);

        startHeadPanel = new JPanel();
        setStartHeadPanel();

        startPanel = new JPanel();
        setStartPanel(startPanel);

        add(startHeadPanel, BorderLayout.NORTH); // Add startHeadPanel to the top of the JFrame
        add(startPanel, BorderLayout.CENTER); // Add startPanel to the center of the JFrame

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setStartHeadPanel(){
        JLabel headLabel = new JLabel("Tired of Converting Number Systems Manually?" );
        headLabel.setVerticalAlignment(JLabel.CENTER);
        headLabel.setHorizontalAlignment(JLabel.CENTER);
        headLabel.setFont(new Font("Times New Roman", Font.BOLD,15));

        JLabel descriptionLabel = new JLabel("Then this application is for you!");
        descriptionLabel.setVerticalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));

        startHeadPanel = new JPanel(new GridLayout(2,1));
        startHeadPanel.add(headLabel);
        startHeadPanel.add(descriptionLabel);
        startHeadPanel.setBackground(Color.LIGHT_GRAY);
    }

    private void setStartPanel(JPanel panel) {
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        // Add startHeadPanel to the top (NORTH) of the startPanel
        panel.add(startHeadPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // Add the JButton to the center of the startPanel
        startButton = new JButton("START!");
        startButton.setBounds(150, 50, 100, 50); // Set button size
        buttonPanel.add(startButton);

        buttonPanel.setPreferredSize(new Dimension(100,50));

        // Go to the next JFrame
        startButton.addActionListener(new StartButtonListener());

        panel.add(buttonPanel, BorderLayout.CENTER);
    }

    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            openNumberConverterBoard();
            startHeadPanel.setVisible(false); // Hide the current frame
            startPanel.setVisible(false);
        }
    }

    private void openNumberConverterBoard() {
        setTitle("My Nigga Converter");
        setSize(1200, 600);
        setResizable(false);

        JLabel textArea = new JLabel();
        textArea.setText("This application helps you convert a decimal number to binary, octal and hexadecimal. Please enter the decimal number in the field provided. Then, press the convert key.");
        JPanel headPanel = new JPanel();
        headPanel.add(textArea);

        decimalTF = new JTextField();
        binaryTF = new JTextField();
        octalTF = new JTextField();
        hexadecimalTF = new JTextField();

        setNumberOptionPanel();

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
        getContentPane().add(numberOptionPanel);
        getContentPane().add(numberPanel);
        getContentPane().add(reminderPanel);
        getContentPane().add(buttonPanel);
        getContentPane().add(hyperLinkPanel);

        // set decimal to default option and disable the other number system text field
        numberSystems.setSelectedItem("Decimal");
        binaryTF.setEditable(false);
        octalTF.setEditable(false);
        hexadecimalTF.setEditable(false);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setNumberOptionPanel() {
        String[] option = {"Decimal", "Binary", "Octal", "Hexadecimal"};
        numberSystems = new JComboBox<>(option);
        numberSystems.addActionListener(new ComboBoxHandler());

        numberSystems.setPreferredSize(new Dimension(150, 40));
        numberSystems.setFont(new Font("Times New Roman", Font.BOLD, 20));

        numberOptionPanel = new JPanel();
        numberOptionPanel.add(numberSystems);
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

    private class ComboBoxHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> numberSystem = (JComboBox<String>) e.getSource();
            String selectedNumber = (String) numberSystem.getSelectedItem();

            if (selectedNumber == null) {
                return; // Handle null selection
            }

            clearInputs();

            switch (selectedNumber) {
                case "Decimal":
                    decimalTF.setEditable(true);
                    binaryTF.setEditable(false);
                    octalTF.setEditable(false);
                    hexadecimalTF.setEditable(false);
                    break;
                case "Binary":
                    decimalTF.setEditable(false);
                    binaryTF.setEditable(true);
                    octalTF.setEditable(false);
                    hexadecimalTF.setEditable(false);
                    break;
                case "Octal":
                    decimalTF.setEditable(false);
                    binaryTF.setEditable(false);
                    octalTF.setEditable(true);
                    hexadecimalTF.setEditable(false);
                    break;
                case "Hexadecimal":
                    decimalTF.setEditable(false);
                    binaryTF.setEditable(false);
                    octalTF.setEditable(false);
                    hexadecimalTF.setEditable(true);
                    break;
            }
        }
    }

    /**
     * ActionListener for Buttons
     * @author Jim Hendrix Bag-eo
     */
    private class ButtonsHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object buttonOption = e.getSource();
            String selectedNumber = (String) numberSystems.getSelectedItem();

            if (selectedNumber == null) {
                return;
            }

            if (buttonOption == clearButton) {
                clearInputs();
                decimalTF.setEditable(false);
                binaryTF.setEditable(false);
                octalTF.setEditable(false);
                hexadecimalTF.setEditable(false);
                numberSystems.setSelectedIndex(0);
            } else if (buttonOption == convertButton) {
                new EquivalentNumbers();
                try {
                    switch (selectedNumber) {
                        case "Decimal" -> convertDecimal();
                        case "Binary" -> convertBinary();
                        case "Octal" -> convertOctal();
                        case "Hexadecimal" -> convertHexadecimal();
                    }

                } catch (Exception ex) {
                    problemDisplayer.setText("The input does not follow the format of the Number System");
                }
            } else if (buttonOption == exitButton) {
                System.exit(0);
            }
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

    private void clearInputs() {
        decimalTF.setText("");
        binaryTF.setText("");
        octalTF.setText("");
        hexadecimalTF.setText("");
        problemDisplayer.setText("");
    }
}