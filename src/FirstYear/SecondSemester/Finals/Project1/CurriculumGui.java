package FirstYear.SecondSemester.Finals.Project1;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class CurriculumGui extends JFrame {
    private JPanel menuPanel, comboBoxPanel, comboBoxPanel2, comboBoxPanel3, comboBoxPanel4;

    private JPanel savePanel, savePanel2;
    private JButton saveButton, saveButton2;

    private JTable courseTable;
    private DefaultTableModel model;

    private JComboBox<String> oneDropdown, twoDropdown, threeDropdown, fourDropdown, fiveDropdown, sixDropdown, sevenDropdown, eightDropdown;

    private static CurriculumManagement curriculum = new CurriculumManagement();


    private static final Font font1 = new Font("Arial", Font.BOLD, 20);
    private static final Font font2 = new Font("Times New Roman", Font.BOLD, 15);

    public static void main(String[] args) {
        new CurriculumGui().CurriculumGUI();
    }

    public void CurriculumGUI() {
        curriculum.fillCurriculum();

        courseTable = new JTable();

        setTitle("Curriculum Monitoring");
        setSize(400, 400);
        setResizable(false);


        menuPanel = new JPanel();
        setMenuPanel();


        add(menuPanel, BorderLayout.NORTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setMenuPanel() {
        menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints menuLayout = new GridBagConstraints();
        menuLayout.gridx = 0;
        menuLayout.gridy = 0;
        menuLayout.anchor = GridBagConstraints.CENTER;

        JLabel menuHeadLabel = new JLabel("<html><div style='text-align: center;'>Personal Checklist Monitoring App</div></html>");
        menuHeadLabel.setFont(font1);
        menuPanel.add(menuHeadLabel, menuLayout);


        menuLayout.gridy = 1;
        menuLayout.insets = new Insets(10, 10, 10, 10);
        JLabel menuChoiceLabel = new JLabel("<html><br>1. Show subjects for each school term<br><br>" +
                "2. Show subjects with grades for each term<br><br>" +
                "3. Enter grades for subjects recently finished<br><br>" +
                "4. Edit a course<br><br>" +
                "5. Calculate GPA<br><br>" +
                "6. Reset<br><br>" +
                "7. Save and Quit<br><br></html>");
        menuChoiceLabel.setFont(font2);
        menuPanel.add(menuChoiceLabel, menuLayout);

        //textField
        menuLayout.gridy = 2;
        menuLayout.fill = GridBagConstraints.HORIZONTAL;
        JTextField textField = new JTextField();
        textField.setFont(font2);
        menuPanel.add(textField, menuLayout);

        textField.addActionListener(e -> {
            String input = textField.getText();
            if (input.matches("\\d{1,5}")) {
                int number = Integer.parseInt(input);
                if (number > 7) {
                    JOptionPane.showMessageDialog(this, "The number must be from 1 to 5");
                } else {
                    switch (number) {
                        case 1:
                            choiceOne();
                            break;
                        case 2:
                            choiceTwo();
                            break;
                        case 3:
                            choiceThree();
                            break;
                        case 4:
                            choiceFour();
                            break;
                        case 5:
                            calculateGPA();
                            break;
                        case 6:
                            curriculum.reset();
                            JOptionPane.showMessageDialog(null, "The Curriculum has been reset", "Reset", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 7:
                            curriculum.saveCurriculum();
                            System.exit(0);
                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "You entered a valid Integer", "Error", JOptionPane.ERROR_MESSAGE);
            }
            textField.setText("");
        });
    }



    //-----------------------------------------------CHOICE ONE---------------------------------------------------------

    private void choiceOne() {
        JFrame choiceOneFrame = new JFrame("Curriculum");
        choiceOneFrame.setSize(1000, 500);

        comboBoxPanel = new JPanel();
        comboBoxPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        setComboBoxPanel();

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));

        fillTable();

        choiceOneFrame.add(comboBoxPanel, BorderLayout.NORTH);
        choiceOneFrame.add(scrollPane);
        choiceOneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceOneFrame.setVisible(true);
    }

    private void fillTable() {

        twoDropdown.addActionListener(e -> fillTable());


        ArrayList<Course> list = curriculum.getCurriculum();
        ArrayList<Course> filtered = new ArrayList<>();

        String selectedYear = (String) oneDropdown.getSelectedItem();
        String selectedSemester = (String) twoDropdown.getSelectedItem();

        byte yearToInt = 0;

        switch (Objects.requireNonNull(selectedYear)) {
            case "1st Year" -> yearToInt = 1;
            case "2nd Year" -> yearToInt = 2;
            case "3rd Year" -> yearToInt = 3;
            case "4th Year" -> yearToInt = 4;
        }

        for (Course course : list)
            if (course.getYear() == yearToInt && course.getTerm().equals(selectedSemester)) filtered.add(course);

        String[] column = new String[]{"Course No.", "Course Title", "Units"};
        String[][] data = new String[filtered.size()][3];

        for (int i = 0; i < filtered.size(); i++) {
            Course course = filtered.get(i);
            data[i][0] = course.getCourseNumber();
            data[i][1] = course.getDescriptiveTitle();
            data[i][2] = "" + course.getUnits();
        }

        courseTable.setModel(new DefaultTableModel(data, column));
        courseTable.setEnabled(false);

        TableColumnModel columnModel = courseTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(2).setPreferredWidth(40);
        filtered.clear();
    }

    private void setComboBoxPanel() {

        String[] option1 = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] option2 = {"First Semester", "Second Semester", "Short Semester"};

        oneDropdown = new JComboBox<>(option1);
        oneDropdown.setPreferredSize(new Dimension(150, 40));
        oneDropdown.setFont(font2);

        twoDropdown = new JComboBox<>(option2);
        twoDropdown.setPreferredSize(new Dimension(150, 40));
        twoDropdown.setFont(font2);

        oneDropdown.addActionListener(e -> {
            String selected = (String) oneDropdown.getSelectedItem();
            if (selected.equals("4th Year")) {
                String[] newOption = {"First Semester", "Second Semester"};
                twoDropdown.setModel(new DefaultComboBoxModel<>(newOption));
                fillTable();

            } else if (selected.equals("1st Year") || selected.equals("2nd Year") || selected.equals("3rd Year")) {
                twoDropdown.setModel(new DefaultComboBoxModel<>(option2));
                fillTable();
            }
        });

        comboBoxPanel.add(oneDropdown);
        comboBoxPanel.add(twoDropdown);

    }






    //-----------------------------------------------CHOICE TWO---------------------------------------------------------
    private void choiceTwo() {
        JFrame choiceTwoFrame = new JFrame("Curriculum");
        choiceTwoFrame.setSize(1000, 500);

        comboBoxPanel2 = new JPanel();
        comboBoxPanel2.setBorder(new EmptyBorder(20, 0, 0, 0));
        setComboBoxPanel2();

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));


        fillTable2();

        choiceTwoFrame.add(comboBoxPanel2, BorderLayout.NORTH);
        choiceTwoFrame.add(scrollPane);
        choiceTwoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceTwoFrame.setVisible(true);
    }


    private void setComboBoxPanel2() {

        String[] option1 = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] option2 = {"First Semester", "Second Semester", "Short Semester"};

        threeDropdown = new JComboBox<>(option1);
        threeDropdown.setPreferredSize(new Dimension(150, 40));
        threeDropdown.setFont(font2);

        fourDropdown = new JComboBox<>(option2);
        fourDropdown.setPreferredSize(new Dimension(150, 40));
        fourDropdown.setFont(font2);

        threeDropdown.addActionListener(e -> {
            String selected = (String) threeDropdown.getSelectedItem();
            if (selected.equals("4th Year")) {
                String[] newOption = {"First Semester", "Second Semester"};
                fourDropdown.setModel(new DefaultComboBoxModel<>(newOption));
                fillTable2();

            } else if (selected.equals("1st Year") || selected.equals("2nd Year") || selected.equals("3rd Year")) {
                fourDropdown.setModel(new DefaultComboBoxModel<>(option2));
                fillTable2();
            }
        });

        comboBoxPanel2.add(threeDropdown);
        comboBoxPanel2.add(fourDropdown);

    }

    private void fillTable2() {

        fourDropdown.addActionListener(e -> fillTable2());


        ArrayList<Course> list = curriculum.getCurriculum();
        ArrayList<Course> filtered = new ArrayList<>();

        String selectedYear = (String) threeDropdown.getSelectedItem();
        String selectedSemester = (String) fourDropdown.getSelectedItem();

        byte yearToInt = 0;

        switch (Objects.requireNonNull(selectedYear)) {
            case "1st Year" -> yearToInt = 1;
            case "2nd Year" -> yearToInt = 2;
            case "3rd Year" -> yearToInt = 3;
            case "4th Year" -> yearToInt = 4;
        }

        for (Course course : list)
            if (course.getYear() == yearToInt && course.getTerm().equals(selectedSemester)) filtered.add(course);

        String[] column = new String[]{"Course No.", "Course Title", "Units","Grade"};
        String[][] data = new String[filtered.size()][4];

        for (int i = 0; i < filtered.size(); i++) {
            Course course = filtered.get(i);
            data[i][0] = course.getCourseNumber();
            data[i][1] = course.getDescriptiveTitle();
            data[i][2] = "" + course.getUnits();
            data[i][3] = "" + course.getGrade();
            if (data[i][3].equals("0")){
                data[i][3] = "Not Yet Taken";
            }
        }

        courseTable.setModel(new DefaultTableModel(data, column));
        courseTable.setEnabled(false);

        TableColumnModel columnModel = courseTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(2).setPreferredWidth(40);
        filtered.clear();
    }








    //----------------------------------------------CHOICE THREE--------------------------------------------------------
    private void choiceThree(){
        JFrame choiceThreeFrame = new JFrame("Curriculum");
        choiceThreeFrame.setSize(1000, 500);

        comboBoxPanel3 = new JPanel();
        comboBoxPanel3.setBorder(new EmptyBorder(20, 0, 0, 0));
        setComboBoxPanel3();

        JLabel enterLabel = new JLabel("Press 'Enter' after each grade input and Click 'Save' per term to save.");
        enterLabel.setFont(font2);

        JPanel enterLabelPanel = new JPanel();
        enterLabelPanel.add(enterLabel);

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));

        fillTable3();

        savePanel = new JPanel();
        setSavePanel(savePanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(enterLabelPanel);
        centerPanel.add(scrollPane);

        choiceThreeFrame.setLayout(new BorderLayout());
        choiceThreeFrame.add(comboBoxPanel3, BorderLayout.NORTH);
        choiceThreeFrame.add(centerPanel, BorderLayout.CENTER);
        choiceThreeFrame.add(savePanel, BorderLayout.SOUTH);
        choiceThreeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceThreeFrame.setVisible(true);
    }

    private void setComboBoxPanel3() {

        String[] option1 = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] option2 = {"First Semester", "Second Semester", "Short Semester"};

        fiveDropdown = new JComboBox<>(option1);
        fiveDropdown.setPreferredSize(new Dimension(150, 40));
        fiveDropdown.setFont(font2);

        sixDropdown = new JComboBox<>(option2);
        sixDropdown.setPreferredSize(new Dimension(150, 40));
        sixDropdown.setFont(font2);

        fiveDropdown.addActionListener(e -> {
            String selected = (String) fiveDropdown.getSelectedItem();
            if (selected.equals("4th Year")) {
                String[] newOption = {"First Semester", "Second Semester"};
                sixDropdown.setModel(new DefaultComboBoxModel<>(newOption));
                fillTable3();

            } else if (selected.equals("1st Year") || selected.equals("2nd Year") || selected.equals("3rd Year")) {
                sixDropdown.setModel(new DefaultComboBoxModel<>(option2));
                fillTable3();
            }
        });

        comboBoxPanel3.add(fiveDropdown);
        comboBoxPanel3.add(sixDropdown);

    }

    private void fillTable3() {

        sixDropdown.addActionListener(e -> fillTable3());

        ArrayList<Course> list = curriculum.getCurriculum();
        ArrayList<Course> filtered = new ArrayList<>();

        String selectedYear = (String) fiveDropdown.getSelectedItem();
        String selectedSemester = (String) sixDropdown.getSelectedItem();

        byte yearToInt = 0;

        switch (Objects.requireNonNull(selectedYear)) {
            case "1st Year" -> yearToInt = 1;
            case "2nd Year" -> yearToInt = 2;
            case "3rd Year" -> yearToInt = 3;
            case "4th Year" -> yearToInt = 4;
        }

        for (Course course : list)
            if (course.getYear() == yearToInt && course.getTerm().equals(selectedSemester)) filtered.add(course);

        String[] column = new String[]{"Course No.", "Course Title", "Units","Grade"};
        String[][] data = new String[filtered.size()][4];

        for (int i = 0; i < filtered.size(); i++) {
            Course course = filtered.get(i);
            data[i][0] = course.getCourseNumber();
            data[i][1] = course.getDescriptiveTitle();
            data[i][2] = "" + course.getUnits();
            data[i][3] = "" + course.getGrade();
            if (data[i][3].equals("0")){
                data[i][3] = "Not Yet Taken";
            }
        }

        // allow only grade column to be edited
        model = new DefaultTableModel(data, column) {
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };

        courseTable.setModel(model);
        courseTable.setEnabled(true);

        TableColumnModel columnModel = courseTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(2).setPreferredWidth(40);
        filtered.clear();
    }

    private void setSavePanel(JPanel panel) {
        saveButton = new JButton("Save");
        saveButton.addActionListener(e ->
                saveGrades(courseTable));
        panel.add(saveButton);
    }


    private void saveGrades(JTable courseTable) {
        int rowCount = courseTable.getRowCount();

        ArrayList<Byte> grades = new ArrayList<>(10);

        for (int i = 0; i < rowCount; i++) {
            Object value = courseTable.getValueAt(i, 3);
            if (value.toString().isEmpty() || value.toString().equalsIgnoreCase("Not Yet Taken")){
                grades.add((byte) 0);
            } else {
                try {
                    byte grade = Byte.parseByte(value.toString());
                    grades.add(grade);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid grade value at row " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        int year = getYear((String) fiveDropdown.getSelectedItem());
        String term = (String) sixDropdown.getSelectedItem();
        try {
            curriculum.editGrade(grades, year, term);
        } catch (ValueOutOfRangeException e) {
            JOptionPane.showMessageDialog(null, "Grade should be between 65 and 99.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        curriculum.saveCurriculum();
        JOptionPane.showMessageDialog(null, "Grades saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }







    //----------------------------------------------CHOICE FOUR--------------------------------------------------------
    private void choiceFour(){
        JFrame choiceFourFrame = new JFrame("Curriculum");
        choiceFourFrame.setSize(1000, 500);

        comboBoxPanel4 = new JPanel();
        comboBoxPanel4.setBorder(new EmptyBorder(20, 0, 0, 0));
        setComboBoxPanel4();

        JLabel enterLabel = new JLabel("Press 'Enter' after input and click 'Save' per term to save.");
        enterLabel.setFont(font2);

        JPanel enterLabelPanel = new JPanel();
        enterLabelPanel.add(enterLabel);

        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(new EmptyBorder(20, 20, 20, 20));


        fillTable4();

        savePanel2 = new JPanel();
        setSavePanel2(savePanel2);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(enterLabelPanel);
        centerPanel.add(scrollPane);

        choiceFourFrame.setLayout(new BorderLayout());
        choiceFourFrame.add(comboBoxPanel4, BorderLayout.NORTH);
        choiceFourFrame.add(centerPanel, BorderLayout.CENTER);
        choiceFourFrame.add(savePanel2, BorderLayout.SOUTH);
        choiceFourFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        choiceFourFrame.setVisible(true);
    }

    private void setComboBoxPanel4() {

        String[] option1 = {"1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] option2 = {"First Semester", "Second Semester", "Short Semester"};

        sevenDropdown = new JComboBox<>(option1);
        sevenDropdown.setPreferredSize(new Dimension(150, 40));
        sevenDropdown.setFont(font2);

        eightDropdown = new JComboBox<>(option2);
        eightDropdown.setPreferredSize(new Dimension(150, 40));
        eightDropdown.setFont(font2);

        sevenDropdown.addActionListener(e -> {
            String selected = (String) sevenDropdown.getSelectedItem();
            if (selected.equals("4th Year")) {
                String[] newOption = {"First Semester", "Second Semester"};
                eightDropdown.setModel(new DefaultComboBoxModel<>(newOption));
                fillTable4();

            } else if (selected.equals("1st Year") || selected.equals("2nd Year") || selected.equals("3rd Year")) {
                eightDropdown.setModel(new DefaultComboBoxModel<>(option2));
                fillTable4();
            }
        });

        comboBoxPanel4.add(sevenDropdown);
        comboBoxPanel4.add(eightDropdown);

    }

    private void fillTable4() {

        eightDropdown.addActionListener(e -> fillTable4());


        ArrayList<Course> list = curriculum.getCurriculum();
        ArrayList<Course> filtered = new ArrayList<>();

        String selectedYear = (String) sevenDropdown.getSelectedItem();
        String selectedSemester = (String) eightDropdown.getSelectedItem();

        byte yearToInt = 0;

        switch (Objects.requireNonNull(selectedYear)) {
            case "1st Year" -> yearToInt = 1;
            case "2nd Year" -> yearToInt = 2;
            case "3rd Year" -> yearToInt = 3;
            case "4th Year" -> yearToInt = 4;
        }

        for (Course course : list)
            if (course.getYear() == yearToInt && course.getTerm().equals(selectedSemester)) filtered.add(course);

        String[] column = new String[]{"Course No.", "Course Title", "Units"};
        String[][] data = new String[filtered.size()][3];

        for (int i = 0; i < filtered.size(); i++) {
            Course course = filtered.get(i);
            data[i][0] = course.getCourseNumber();
            data[i][1] = course.getDescriptiveTitle();
            data[i][2] = "" + course.getUnits();
        }


        // allow only grade column to be edited
        model = new DefaultTableModel(data, column) {
            public boolean isCellEditable(int row, int column) {
                return column == 0 || column == 1 || column == 2;
            }
        };

        courseTable.setModel(model);
        courseTable.setEnabled(true);

        TableColumnModel columnModel = courseTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(700);
        columnModel.getColumn(2).setPreferredWidth(40);
    }

    private void setSavePanel2(JPanel panel) {
        saveButton2 = new JButton("Save");
        saveButton2.addActionListener(e ->
        {
            try {
                saveCourse(courseTable);
            } catch (ValueOutOfRangeException ex) {
                throw new RuntimeException(ex);
            }
        });


        panel.add(saveButton2);
    }



    private void saveCourse(JTable table) throws ValueOutOfRangeException {
        int rowCount = table.getRowCount();
        ArrayList<String[]> courseDetails = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            String[] details = new String[3];
            for (int j = 0; j < 3; j++) {
                // 0 (course no), 1 (course title), 2 (units)
                String value = (String) table.getValueAt(i, j);
                if (value.isEmpty()) {
                    // show a JOptionPane with a message of "fill up all the rows" instead and return
                    JOptionPane.showMessageDialog(null, "You must fill up all the content of the row", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else {
                    details[j] = value.toString();
                }
            }
            courseDetails.add(details);
        }

        int year = getYear((String) sevenDropdown.getSelectedItem());
        String semester = (String) eightDropdown.getSelectedItem();

        try {
            curriculum.editCourse(courseDetails, year, semester);
        } catch (ValueOutOfRangeException e){
            JOptionPane.showMessageDialog(null, "Units must be from 1 to 6 only", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null, "Changes saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private int getYear(String selectedItem) {
        return switch (selectedItem){
            case "1st Year" -> 1;
            case "2nd Year" -> 2;
            case "3rd Year" -> 3;
            default -> 4;
        };
    }





    //----------------------------------------------CHOICE FIVE--------------------------------------------------------
    private void calculateGPA() {
        JOptionPane.showMessageDialog(null, "Your GPA is " + curriculum.calculateGPA(),  "", JOptionPane.INFORMATION_MESSAGE);
    }

}




