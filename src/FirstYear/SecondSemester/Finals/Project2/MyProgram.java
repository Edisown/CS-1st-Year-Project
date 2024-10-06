package FirstYear.SecondSemester.Finals.Project2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MyProgram extends JFrame {

    static MyProgramUtility myProgramUtility;

    static {
        try {
            myProgramUtility = new MyProgramUtility();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private JPanel searchCitizenPanel;

    private static final Font heading = new Font("Calibri", Font.BOLD, 20);
    private static final Font body = new Font("Calibri", Font.BOLD, 14);
    private JPanel menuPanel, displayCitizenPanel, displayCitizenTitlePanel, tableSortingToolsFirstPanel,
            tableSortingToolsSecondPanel, tableFilteringToolsFirstPanel, tableFilteringToolsSecondPanel, citizenStatisticsFirstPanel, citizenStatisticsSecondPanel;
    private JList<String> resultList;
    private JTextField searchBar;
    private JTable citizenTable, tableSortingToolsTable, tableFilteringToolsTable, citizenStatisticsTable;
    private JButton dctBtn, tstBtn, tbfBtn, clearButton, csBtn;
    private JButton backButtonTableSortingTools, backButtonDisplayCitizen, backButtonTableFilterTools, backButtonDisplayStatistics;
    private JLabel menuLabel1, tableFilteringToolsCounter;
    private JComboBox<String> nameOrAgeDropdown, ascendingOrDescendingInNameDropdown, ageRangeDropDown, residencyStatusDropdown, districtDropdown, genderDropdown, statistics;

    JScrollPane resultListJScrollPane;

    JFrame displayCitizenFrame, displayCitizensInSortedOrderFrame, displayFilteredCitizensFrame, displayCitizenStatisticsFrame;

    private DefaultListModel<String> listModel;

    public MyProgram() {
        setSize(500, 450);

        citizenTable = new JTable();

        menuPanel = new JPanel();
        setMenu();

        add(menuPanel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setMenu() {
        menuPanel.setLayout(new GridBagLayout());

        GridBagConstraints menuLayout = new GridBagConstraints();
        menuLayout.gridx = 0;
        menuLayout.gridy = 0;
        menuLayout.anchor = GridBagConstraints.CENTER;

        menuLayout.insets = new Insets(0, 0, 10, 0);
        JLabel title = new JLabel("District FirstYear.SecondSemester.Finals.Project2.Citizen Data Hub");
        title.setFont(heading);
        menuPanel.add(title, menuLayout);

        menuLayout.gridy = 1;
        menuLayout.anchor = GridBagConstraints.WEST;
        menuLabel1 = new JLabel("Search citizen name");
        menuPanel.add(menuLabel1, menuLayout);

        menuLayout.gridy = 2;
        menuLayout.fill = GridBagConstraints.HORIZONTAL;
        setSearchCitizen();
        menuPanel.add(searchCitizenPanel, menuLayout);


        menuLayout.gridy = 3;
        menuPanel.add(new JLabel());

        menuLayout.gridy = 4;

        dctBtn = new JButton("Display All Citizens");
        menuPanel.add(dctBtn, menuLayout);
        dctBtn.setSize(100, dctBtn.getHeight());

        menuLayout.gridy = 5;

        tstBtn = new JButton("Table Sorting Tools");
        tstBtn.setPreferredSize(new Dimension(tstBtn.getPreferredSize()));
        menuPanel.add(tstBtn, menuLayout);

        menuLayout.gridy = 6;

        tbfBtn = new JButton("Table Filter Tools");
        menuPanel.add(tbfBtn, menuLayout);

        menuLayout.gridy = 7;

        csBtn = new JButton("Citizens Statistics");
        csBtn.setPreferredSize(new Dimension(csBtn.getPreferredSize()));
        menuPanel.add(csBtn, menuLayout);

        // Add event listener to search field
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }
        });

        dctBtn.addActionListener(new ButtonHandler());
        tstBtn.addActionListener(new ButtonHandler());
        tbfBtn.addActionListener(new ButtonHandler());
        csBtn.addActionListener(new ButtonHandler());
    }



    private void setSearchCitizen() {
        searchCitizenPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchBar = new JTextField(20);
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);

        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Allow only single selection
        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = resultList.getSelectedIndex();
                if (selectedIndex != -1) { // Check if an item is selected
                    String selectedName = listModel.getElementAt(selectedIndex);
                    displayCitizenDetails(selectedName);
                }
            }
        });


        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ButtonHandler());

        searchPanel.add(searchBar, BorderLayout.CENTER);
        searchPanel.add(clearButton, BorderLayout.EAST);
        searchCitizenPanel.add(searchPanel, BorderLayout.NORTH);
        resultListJScrollPane = new JScrollPane(resultList);
    }

    private void displayCitizenDetails(String fullName) {
        // Retrieve FirstYear.SecondSemester.Finals.Project2.Citizen details from myProgramUtility based on the fullName
        // Update the citizenTable with the details of the selected FirstYear.SecondSemester.Finals.Project2.Citizen
        // Example:
        Citizen citizen = myProgramUtility.getCitizenByName(fullName);
        if (citizen != null) {
            listModel.clear();
            searchBar.setText(citizen.getFullName());
            listModel.addElement("Email: " + citizen.getEmail());
            listModel.addElement("Address: " + citizen.getAddress());
            listModel.addElement("Age: " + citizen.getAge());
            listModel.addElement("Residency Status: " + (citizen.isResident()? "Resident" : "Not Resident"));
            listModel.addElement("District: " + citizen.getDistrict());
            listModel.addElement("Gender: " + (citizen.getGender() == 'M'? "Male" : "Female"));
        }
    }

    private void search() {
        try {
            searchCitizenPanel.add(resultListJScrollPane, BorderLayout.CENTER);
            searchCitizenPanel.revalidate();
            searchCitizenPanel.repaint();
            listModel.clear();
            String query = searchBar.getText().toLowerCase();
            List<Citizen> citizens = myProgramUtility.searchCitizen(query);
            DefaultListCellRenderer renderer = new DefaultListCellRenderer();
            if (citizens.isEmpty()){
                listModel.addElement(query + " not found. ");
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                resultList.setCellRenderer(renderer);
                return;
            }
            for (Citizen citizen : citizens) {
                listModel.addElement(citizen.getFullName());
            }
            renderer.setHorizontalAlignment(SwingConstants.LEFT);
            resultList.setCellRenderer(renderer);
        } catch (IllegalArgumentException e) {
            listModel.clear();
            searchCitizenPanel.remove(resultListJScrollPane);
            searchCitizenPanel.revalidate();
            searchCitizenPanel.repaint();
        }
    }



    public static void main(String[] args) {
        new MyProgram();
    }


    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            try {
                switch (command) {
                    case "Clear" -> {
                        listModel.clear();
                        searchBar.setText("");
                    }
                    case "Display All Citizens" -> displayCitizenTable();
                    case "Table Sorting Tools" -> displayCitizensInSortedOrder();
                    case "Go Back" -> goBack();
                    case "Table Filter Tools" -> displayFilteredCitizens();
                    case "Citizens Statistics" -> displayCitizenStatistics();
                }
            } catch (IllegalArgumentException ex) {
                listModel.addElement("None");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }


        // ----------------------------------- DISPLAY ALL THE CITIZENS -----------------------------------

        private void displayCitizenTable() throws FileNotFoundException {
            displayCitizenFrame = new JFrame();
            displayCitizenFrame.setLayout(new BorderLayout());
            JScrollPane scrollPane = new JScrollPane(citizenTable);
            displayCitizenFrame.setSize(1000, 700);

            displayCitizenTitlePanel = new JPanel();
            constructDisplayCitizenTitlePanel();
            displayCitizenFrame.add(displayCitizenTitlePanel, BorderLayout.NORTH);

            displayCitizenPanel = new JPanel();
            displayCitizenFrame.add(displayCitizenPanel, BorderLayout.CENTER);

            fillCitizenTable();
            displayCitizenPanel.add(scrollPane);
            displayCitizenFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayCitizenFrame.setVisible(true);
        }

        private void constructDisplayCitizenTitlePanel() {
            backButtonDisplayCitizen = new JButton("Go Back");
            backButtonDisplayCitizen.addActionListener(new ButtonHandler());
            JLabel displayCitizenTableTitle = new JLabel("Display FirstYear.SecondSemester.Finals.Project2.Citizen Table");
            displayCitizenTableTitle.setFont(heading);
            displayCitizenTitlePanel.add(backButtonDisplayCitizen);
            displayCitizenTitlePanel.add(displayCitizenTableTitle);
        }


        private void fillCitizenTable() throws FileNotFoundException {
            List<Citizen> citizenList = myProgramUtility.getCitizens();

            String[] columnHeader = new String[]{"FirstYear.SecondSemester.Finals.Project2.Citizen Name", "Email", "Address", "Age", "Residency Status", "District #", "Gender"};
            String[][] data = new String[citizenList.size()][8];

            for (int i = 0; i < citizenList.size(); i++) {
                String residency;
                String gender;

                Citizen citizen = citizenList.get(i);

                if (citizen.isResident())
                    residency = "Resident";
                else
                    residency = "Non Resident";

                if (citizen.getGender() == 'F') {
                    gender = "Female";
                } else {
                    gender = "Male";
                }

                data[i][0] = citizen.getFullName();
                data[i][1] = citizen.getEmail();
                data[i][2] = citizen.getAddress();
                data[i][3] = String.valueOf(citizen.getAge());
                data[i][4] = residency;
                data[i][5] = String.valueOf(citizen.getDistrict());
                data[i][6] = gender;
            }

            citizenTable.setModel(new DefaultTableModel(data, columnHeader));
            citizenTable.setEnabled(false);

            // Set auto-resize mode to make columns fill the table's width
            citizenTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            // Set preferred column widths to widen the columns
            TableColumnModel columnModel = citizenTable.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                if (i == 0 || i == 4) {
                    columnModel.getColumn(i).setPreferredWidth(120);
                } else if (i == 1) {
                    columnModel.getColumn(i).setPreferredWidth(240);
                } else if (i == 2) {
                    columnModel.getColumn(i).setPreferredWidth(200);
                } else if (i == 3) {
                    columnModel.getColumn(i).setPreferredWidth(50);
                } else if (i == 5){
                    columnModel.getColumn(i).setPreferredWidth(70);
                }else {
                    columnModel.getColumn(i).setPreferredWidth(80);
                }
            }

            // Calculate the preferred width of the table
            int tableWidth = 0;
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                tableWidth += columnModel.getColumn(i).getPreferredWidth();
            }

            citizenTable.getTableHeader().setDefaultRenderer((table, value, isSelected, hasFocus, row, columnIdx) -> {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                renderer.setBackground(Color.LIGHT_GRAY); // Set header background color
                renderer.setForeground(Color.BLACK); // Set header text color
                if (value != null) { // Ensure that the value is not null
                    renderer.setText(value.toString()); // Set the text of the renderer to the value
                }
                return renderer;
            });

            for (int i = 0; i < citizenTable.getColumnCount(); i++) {
                citizenTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
            }

            citizenTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Add vertical lines between column headers
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setHeaderRenderer((table, value, isSelected, hasFocus, row, col) -> {
                    JLabel header = new JLabel(value.toString(), SwingConstants.CENTER);
                    header.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK), // Right border for each header except the last one
                            BorderFactory.createEmptyBorder(0, 5, 0, 5))); // Add padding
                    return header;
                });
            }


            // Create a JScrollPane and set its preferred viewport size
            JScrollPane scrollPane = new JScrollPane(citizenTable);
            scrollPane.setPreferredSize(new Dimension(tableWidth + 20, 600)); // Adjust the height as needed
            citizenTable.getTableHeader().setPreferredSize(new Dimension(citizenTable.getTableHeader().getWidth(), 30));


            // Add the JScrollPane to the displayCitizenPanel
            displayCitizenPanel.add(scrollPane);
        }





        // -------------------------------- GO BACK BUTTON ----------------------------------------

        private void goBack() {
            if (displayCitizenFrame != null && displayCitizenFrame.isActive()) {
                displayCitizenFrame.dispose();
            } else if (displayCitizensInSortedOrderFrame != null && displayCitizensInSortedOrderFrame.isActive()) {
                displayCitizensInSortedOrderFrame.dispose();
            } else if (displayFilteredCitizensFrame != null && displayFilteredCitizensFrame.isActive()){
                displayFilteredCitizensFrame.dispose();
            } else {
                displayCitizenStatisticsFrame.dispose();
            }
        }






        // ------------------------------ TABLE SORTING TOOLS ------------------------------------------

        private void displayCitizensInSortedOrder() {
            displayCitizensInSortedOrderFrame = new JFrame();
            displayCitizensInSortedOrderFrame.setSize(1000, 700);

            // Construct panels and fill the table
            tableSortingToolsFirstPanel = new JPanel();
            constructTableSortingToolsFirstPanel();
            tableSortingToolsSecondPanel = new JPanel();
            constructTableSortingToolsSecondPanel();
            tableSortingToolsTable = new JTable();
            fillTable();

            // Create a container panel for the second panel and the table
            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new BorderLayout());
            containerPanel.add(tableSortingToolsSecondPanel, BorderLayout.NORTH); // Add the second panel at the top
            containerPanel.add(new JScrollPane(tableSortingToolsTable), BorderLayout.CENTER); // Add the table below the second panel

            // Add panels and container panel to the frame using BorderLayout
            displayCitizensInSortedOrderFrame.add(tableSortingToolsFirstPanel, BorderLayout.NORTH);
            displayCitizensInSortedOrderFrame.add(containerPanel, BorderLayout.CENTER);

            displayCitizensInSortedOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayCitizensInSortedOrderFrame.setVisible(true);
        }

        private void constructTableSortingToolsFirstPanel() {
            backButtonTableSortingTools = new JButton("Go Back");
            backButtonTableSortingTools.addActionListener(new ButtonHandler());
            JLabel tableSortingToolsTitle = new JLabel("Table Sorting Tools");
            tableSortingToolsTitle.setFont(heading);
            tableSortingToolsFirstPanel.add(backButtonTableSortingTools);
            tableSortingToolsFirstPanel.add(tableSortingToolsTitle);
        }

        private void constructTableSortingToolsSecondPanel() {
            String[] choices1 = {"Name", "Age"};
            String[] choices2 = {"Ascending", "Descending"};

            nameOrAgeDropdown = new JComboBox<>(choices1);
            nameOrAgeDropdown.setPreferredSize(new Dimension(150, 40));
            nameOrAgeDropdown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            nameOrAgeDropdown.addMouseListener(new ComboBoxHoverListener(nameOrAgeDropdown)); // Add mouse listener
            nameOrAgeDropdown.addActionListener(e -> fillTable());

            ascendingOrDescendingInNameDropdown = new JComboBox<>(choices2);
            ascendingOrDescendingInNameDropdown.setPreferredSize(new Dimension(150, 40));
            ascendingOrDescendingInNameDropdown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            ascendingOrDescendingInNameDropdown.addMouseListener(new ComboBoxHoverListener(ascendingOrDescendingInNameDropdown)); // Add mouse listener
            ascendingOrDescendingInNameDropdown.addActionListener(e -> fillTable());

            tableSortingToolsSecondPanel.add(new JLabel("Sort By"));
            tableSortingToolsSecondPanel.add(nameOrAgeDropdown);
            tableSortingToolsSecondPanel.add(new JLabel("In"));
            tableSortingToolsSecondPanel.add(ascendingOrDescendingInNameDropdown);
            tableSortingToolsSecondPanel.add(new JLabel("Order"));
        }


        private void fillTable() {
            String selected1 = (String) nameOrAgeDropdown.getSelectedItem();
            String selected2 = (String) ascendingOrDescendingInNameDropdown.getSelectedItem();

            List<Citizen> citizens = new ArrayList<>(myProgramUtility.getCitizens());

            if (selected1.equals("Name") && selected2.equals("Ascending")) {
                Collections.sort(citizens);
            } else if (selected1.equals("Name") && selected2.equals("Descending")) {
                citizens.sort(Collections.reverseOrder());
            } else if (selected1.equals("Age") && selected2.equals("Ascending")) {
                citizens.sort(Comparator.comparingInt(Citizen::getAge));
            } else {
                citizens.sort(Comparator.comparingInt(Citizen::getAge).reversed());
            }

            String[] column = new String[]{"Name", "Email", "Address", "Age", "Resident", "District", "Gender"};
            String[][] data = new String[citizens.size()][7];

            for (int i = 0; i < citizens.size(); i++) {
                Citizen citizen = citizens.get(i);
                data[i][0] = citizen.getFullName();
                data[i][1] = citizen.getEmail();
                data[i][2] = citizen.getAddress();
                data[i][3] = citizen.getAge() + "";
                data[i][4] = citizen.isResident() ? "Resident" : "Non - Resident";
                data[i][5] = citizen.getDistrict() + "";
                data[i][6] = citizen.getGender() == 'M' ? "Male" : "Female";
            }

            tableSortingToolsTable.setModel(new DefaultTableModel(data, column));
            tableSortingToolsTable.setEnabled(false);

            tableSortingToolsTable.getTableHeader().setDefaultRenderer((table, value, isSelected, hasFocus, row, columnIdx) -> {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                renderer.setBackground(Color.LIGHT_GRAY); // Set header background color
                renderer.setForeground(Color.BLACK); // Set header text color
                if (value != null) { // Ensure that the value is not null
                    renderer.setText(value.toString()); // Set the text of the renderer to the value
                }
                return renderer;
            });

            tableSortingToolsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Add vertical lines between column headers
            TableColumnModel columnModel = tableSortingToolsTable.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setHeaderRenderer((table, value, isSelected, hasFocus, row, col) -> {
                    JLabel header = new JLabel(value.toString(), SwingConstants.CENTER);
                    header.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK), // Right border for each header except the last one
                            BorderFactory.createEmptyBorder(0, 5, 0, 5))); // Add padding
                    return header;
                });
            }

            for (int i = 0; i < tableSortingToolsTable.getColumnCount(); i++) {
                tableSortingToolsTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
            }

            // Set the height of the header
            tableSortingToolsTable.getTableHeader().setPreferredSize(new Dimension(tableSortingToolsTable.getTableHeader().getWidth(), 30));

            columnModel.getColumn(0).setPreferredWidth(80);
            columnModel.getColumn(1).setPreferredWidth(240);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(30);
            columnModel.getColumn(4).setPreferredWidth(70);
            columnModel.getColumn(5).setPreferredWidth(30);
            columnModel.getColumn(6).setPreferredWidth(50);
        }

        // Custom renderer class for JComboBox
        class CustomComboBoxRenderer extends DefaultListCellRenderer {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setHorizontalAlignment(SwingConstants.CENTER); // Set text alignment to center
                setBackground(new Color(240, 240, 240)); // Set shaded background color
                return this;
            }
        }

        static class ComboBoxHoverListener extends MouseAdapter {
            private final JComboBox<?> comboBox;

            public ComboBoxHoverListener(JComboBox<?> comboBox) {
                this.comboBox = comboBox;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                int index = comboBox.getSelectedIndex();
                if (index >= 0) {
                    comboBox.setBackground(new Color(200, 200, 200)); // Set hover background color
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int index = comboBox.getSelectedIndex();
                if (index >= 0) {
                    comboBox.setBackground(new Color(240, 240, 240)); // Restore default background color
                }
            }
        }

        //-----------------------------------------------------------------------------------



        // -------------------------------- TABLE FILTERING TOOLS --------------------------------------
        private void displayFilteredCitizens() {
            // Create the frame
            displayFilteredCitizensFrame = new JFrame();
            displayFilteredCitizensFrame.setSize(1100, 700);

            // Create the main panel with BoxLayout along the Y-axis
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            // Initialize and add all sub-panels
            tableFilteringToolsFirstPanel = new JPanel(); // 1st Panel
            constructTableFilterFirstPanel();

            // Create a container panel for the second panel and the table
            JPanel containerPanel = new JPanel();
            containerPanel.setLayout(new BorderLayout());
            containerPanel.add(tableFilteringToolsFirstPanel, BorderLayout.NORTH); // Add the second panel at the top

            tableFilteringToolsSecondPanel = new JPanel(); // 2nd Panel
            constructTableFilterSecondPanel();
            containerPanel.add(tableFilteringToolsSecondPanel, BorderLayout.CENTER);
            mainPanel.add(containerPanel, BorderLayout.NORTH);

            tableFilteringToolsTable = new JTable(); // Third Panel
            constructTableFilterThirdPanel(); // the table itself
            mainPanel.add(new JScrollPane(tableFilteringToolsTable), BorderLayout.CENTER);

            tableFilteringToolsCounter = new JLabel();
            mainPanel.add(tableFilteringToolsCounter, BorderLayout.SOUTH);
            // Add the main panel to the frame
            displayFilteredCitizensFrame.add(mainPanel);


            // Set default close operation and make the frame visible
            displayFilteredCitizensFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayFilteredCitizensFrame.setVisible(true);
        }



        private void constructTableFilterFirstPanel() {
            backButtonTableFilterTools = new JButton("Go Back");
            backButtonTableFilterTools.addActionListener(new ButtonHandler());
            JLabel tableFilteringToolsTitle = new JLabel("Table Filtering Tools");
            tableFilteringToolsTitle.setFont(heading);
            tableFilteringToolsFirstPanel.add(backButtonTableFilterTools);
            tableFilteringToolsFirstPanel.add(tableFilteringToolsTitle);
        }

        private void constructTableFilterSecondPanel() {
            String[] ageRanges = {"Any", "Young Adults (18-30)", "Adults (31-59)", "Seniors (60 above)"};
            String[] residencyStatus = {"Any", "Resident", "Non - Resident"};
            String[] district = {"Any", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
            String[] gender = {"Any", "Male", "Female"};

            ageRangeDropDown = new JComboBox<>(ageRanges);
            ageRangeDropDown.setPreferredSize(new Dimension(150, 40));
            ageRangeDropDown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            ageRangeDropDown.addMouseListener(new ComboBoxHoverListener(ageRangeDropDown)); // Add mouse listener
            ageRangeDropDown.addActionListener(e -> constructTableFilterThirdPanel());

            residencyStatusDropdown = new JComboBox<>(residencyStatus);

            residencyStatusDropdown.setPreferredSize(new Dimension(150, 40));
            residencyStatusDropdown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            residencyStatusDropdown.addMouseListener(new ComboBoxHoverListener(residencyStatusDropdown)); // Add mouse listener
            residencyStatusDropdown.addActionListener(e -> constructTableFilterThirdPanel());

            districtDropdown = new JComboBox<>(district);
            districtDropdown.setPreferredSize(new Dimension(150, 40));
            districtDropdown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            districtDropdown.addMouseListener(new ComboBoxHoverListener(districtDropdown)); // Add mouse listener
            districtDropdown.addActionListener(e -> constructTableFilterThirdPanel());

            genderDropdown = new JComboBox<>(gender);
            genderDropdown.setPreferredSize(new Dimension(150, 40));
            genderDropdown.setRenderer(new CustomComboBoxRenderer()); // Set custom renderer
            genderDropdown.addMouseListener(new ComboBoxHoverListener(genderDropdown)); // Add mouse listener
            genderDropdown.addActionListener(e -> constructTableFilterThirdPanel());

            ageRangeDropDown.addItemListener(e -> updateTableAfterDropdownChange());
            residencyStatusDropdown.addItemListener(e -> updateTableAfterDropdownChange());
            districtDropdown.addItemListener(e -> updateTableAfterDropdownChange());
            genderDropdown.addItemListener(e -> updateTableAfterDropdownChange());

            tableFilteringToolsSecondPanel.add(new JLabel("Age"));
            tableFilteringToolsSecondPanel.add(ageRangeDropDown);
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(25, 100));
            tableFilteringToolsSecondPanel.add(label);
            tableFilteringToolsSecondPanel.add(new JLabel("Residency"));
            tableFilteringToolsSecondPanel.add(residencyStatusDropdown);
            JLabel label1 = new JLabel();
            label1.setPreferredSize(new Dimension(25, 100));
            tableFilteringToolsSecondPanel.add(label1);
            tableFilteringToolsSecondPanel.add(new JLabel("District"));
            tableFilteringToolsSecondPanel.add(districtDropdown);
            JLabel label2 = new JLabel();
            label2.setPreferredSize(new Dimension(25, 100));
            tableFilteringToolsSecondPanel.add(label2);
            tableFilteringToolsSecondPanel.add(new JLabel("Gender"));
            tableFilteringToolsSecondPanel.add(genderDropdown);
        }

        private void updateTableAfterDropdownChange() {
            SwingUtilities.invokeLater(this::constructTableFilterThirdPanel);
        }

        private void constructTableFilterThirdPanel() {
            String ageRange = (String) ageRangeDropDown.getSelectedItem();
            String residencyStatus = (String) residencyStatusDropdown.getSelectedItem();
            String district = (String) districtDropdown.getSelectedItem();
            String gender = (String) genderDropdown.getSelectedItem();

            List<Citizen> citizens = new ArrayList<>(myProgramUtility.getCitizens());
            citizens = filterCitizensThroughAgeRange(citizens, ageRange);
            citizens = filterCitizensThroughResidencyStatus(citizens, residencyStatus);
            citizens = filterCitizensThroughDistrict(citizens, district);
            citizens = filterCitizensThroughGender(citizens, gender);


            String[] column = new String[]{"Name", "Email", "Address", "Age", "Resident", "District", "Gender"};
            String[][] data = new String[citizens.size()][7];

            for (int i = 0; i < citizens.size(); i++) {
                Citizen citizen = citizens.get(i);
                data[i][0] = citizen.getFullName();
                data[i][1] = citizen.getEmail();
                data[i][2] = citizen.getAddress();
                data[i][3] = citizen.getAge() + "";
                data[i][4] = citizen.isResident() ? "Resident" : "Non - Resident";
                data[i][5] = citizen.getDistrict() + "";
                data[i][6] = citizen.getGender() == 'M' ? "Male" : "Female";
            }

            SwingUtilities.invokeLater(() -> {
                tableFilteringToolsCounter.setText("Count: " + data.length);
            });

            tableFilteringToolsTable.setModel(new DefaultTableModel(data, column));
            tableFilteringToolsTable.setEnabled(false);

            tableFilteringToolsTable.getTableHeader().setDefaultRenderer((table, value, isSelected, hasFocus, row, columnIdx) -> {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                renderer.setBackground(Color.LIGHT_GRAY); // Set header background color
                renderer.setForeground(Color.BLACK); // Set header text color
                if (value != null) { // Ensure that the value is not null
                    renderer.setText(value.toString()); // Set the text of the renderer to the value
                }
                return renderer;
            });

            tableFilteringToolsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Add vertical lines between column headers
            TableColumnModel columnModel = tableFilteringToolsTable.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setHeaderRenderer((table, value, isSelected, hasFocus, row, col) -> {
                    JLabel header = new JLabel(value.toString(), SwingConstants.CENTER);
                    header.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK), // Right border for each header except the last one
                            BorderFactory.createEmptyBorder(0, 5, 0, 5))); // Add padding
                    return header;
                });
            }

            for (int i = 0; i < tableFilteringToolsTable.getColumnCount(); i++) {
                tableFilteringToolsTable.getColumnModel().getColumn(i).setCellRenderer(new CustomTableCellRenderer());
            }

            // Set the height of the header
            tableFilteringToolsTable.getTableHeader().setPreferredSize(new Dimension(tableFilteringToolsTable.getTableHeader().getWidth(), 30));

            columnModel.getColumn(0).setPreferredWidth(80);
            columnModel.getColumn(1).setPreferredWidth(240);
            columnModel.getColumn(2).setPreferredWidth(200);
            columnModel.getColumn(3).setPreferredWidth(30);
            columnModel.getColumn(4).setPreferredWidth(70);
            columnModel.getColumn(5).setPreferredWidth(30);
            columnModel.getColumn(6).setPreferredWidth(50);
        }

        private List<Citizen> filterCitizensThroughAgeRange(List<Citizen> citizens, String ageRange) {
            switch (ageRange){
                case "Age Range", "Any" -> {
                    ageRangeDropDown.setSelectedItem("Age Range");
                    return citizens;
                }
                case "Young Adults (18-30)" -> {
                    return citizens.stream().filter(c -> c.getAge() >= 18 && c.getAge() < 31).collect(Collectors.toList());
                }
                case "Adults (31-59)" -> {
                    return citizens.stream().filter(c -> c.getAge() >= 31 && c.getAge() < 60).collect(Collectors.toList());
                }
                default -> {
                    return citizens.stream().filter(c -> c.getAge() >= 60).collect(Collectors.toList());
                }
            }
        }

        private List<Citizen> filterCitizensThroughResidencyStatus(List<Citizen> citizens, String residencyStatus) {
            switch (residencyStatus){
                case "Residency Status", "Any" -> {
                    residencyStatusDropdown.setSelectedItem("Residency Status");
                    return citizens;
                }
                case "Resident" -> {
                    return citizens.stream().filter(c -> c.isResident()).collect(Collectors.toList());
                }
                default -> {
                    return citizens.stream().filter(c -> !c.isResident()).collect(Collectors.toList());
                }
            }
        }

        private List<Citizen> filterCitizensThroughDistrict(List<Citizen> citizens, String district) {
            if (district.equals("District") || district.equals("Any")) {
                districtDropdown.setSelectedItem("District");
                return citizens;
            }
            int districtInt = Integer.parseInt(district);
            return citizens.stream().filter(c -> c.getDistrict() == districtInt).collect(Collectors.toList());
        }

        private List<Citizen> filterCitizensThroughGender(List<Citizen> citizens, String gender) {
            if (gender.equals("Gender") || gender.equals("Any")){
                genderDropdown.setSelectedItem("Gender");
                return citizens;
            }
            char g = gender.equals("Male") ? 'M' : 'F';
            return citizens.stream().filter(c -> c.getGender() == g).collect(Collectors.toList());
        }







        // ----------------------------- DISPLAY CITIZEN STATISTICS ---------------------------------------
        private void displayCitizenStatistics() {
            citizenStatisticsTable = new JTable();
            displayCitizenStatisticsFrame = new JFrame();
            displayCitizenStatisticsFrame.setSize(1000, 700);
            displayCitizenStatisticsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            constructCitizenStatisticsFirstPanel();
            constructCitizenStatisticsSecondPanel();
            displaySelectedStatistic();

            JPanel container = new JPanel(new BorderLayout());
            container.add(citizenStatisticsFirstPanel, BorderLayout.NORTH);
            container.add(citizenStatisticsSecondPanel, BorderLayout.CENTER);

            displayCitizenStatisticsFrame.add(container, BorderLayout.NORTH);
            displayCitizenStatisticsFrame.add(new JScrollPane(citizenStatisticsTable), BorderLayout.CENTER);

            displayCitizenStatisticsFrame.setVisible(true);
        }


        private void constructCitizenStatisticsSecondPanel() {
            String[] choices = {"Average Age of Citizens Per District", "Proportion Of Genders Per District", "Proportion Of Non-Resident And Resident Per District", "Number Of Emails Per Domain"};

            statistics = new JComboBox<>(choices);
            statistics.setPreferredSize(new Dimension(400, 40));
            statistics.setRenderer(new CustomComboBoxRenderer());
            statistics.addActionListener(e -> displaySelectedStatistic());

            citizenStatisticsSecondPanel = new JPanel();
            citizenStatisticsSecondPanel.add(new JLabel("Select Option: "));
            citizenStatisticsSecondPanel.add(statistics);
        }


        private void constructCitizenStatisticsFirstPanel() {
            backButtonDisplayStatistics = new JButton("Go Back");
            backButtonDisplayStatistics.addActionListener(new ButtonHandler());
            JLabel citizenStatisticsTitle = new JLabel("Citizens Statistics");
            citizenStatisticsTitle.setFont(heading);
            citizenStatisticsFirstPanel = new JPanel();
            citizenStatisticsFirstPanel.add(backButtonDisplayStatistics);
            citizenStatisticsFirstPanel.add(citizenStatisticsTitle);
        }


        private void displaySelectedStatistic() {
            String selectedStatistic = (String) statistics.getSelectedItem();
            if (selectedStatistic == null) return;
            switch (selectedStatistic) {
                case "Average Age of Citizens Per District":
                    displayCitizenStatisticsTable(myProgramUtility.getAverageAgeOfCitizensPerDistrict(), new String[]{"District", "Average Age"});
                    break;
                case "Proportion Of Genders Per District":
                    displayCitizenStatisticsTable2(myProgramUtility.getProportionOfGendersPerDistrict(), new String[]{"District", "Male", "Female", "Percentage of Male", "Percentage of Female"});
                    break;
                case "Proportion Of Non-Resident And Resident Per District":
                    displayCitizenStatisticsTable2(myProgramUtility.getProportionOfNonResidentAndResidentPerDistrict(), new String[]{"District", "Resident", "Non - Resident", "Percentage of Resident", "Percentage of Non-Resident"});
                    break;
                case "Number Of Emails Per Domain":
                    displayCitizenStatisticsTable1(myProgramUtility.getNumberOfEmailsPerDomain(), new String[]{"Domain", "Frequency"});
                    break;
                default:
                    break;
            }
        }


        private void displayCitizenStatisticsTable(Map<Integer, Integer> citizens, String[] columnHeader) {
            String[][] data = new String[citizens.size()][2];
            int index = 0;
            for (Map.Entry<Integer, Integer> entry : citizens.entrySet()) {
                data[index][0] = String.valueOf(entry.getKey()); // District
                data[index][1] = String.valueOf(entry.getValue()); // Average Age or other statistic
                index++;
            }
            displayTable(data, columnHeader);
        }

        private void displayCitizenStatisticsTable2(Map<Integer, Double[]> citizens, String[] columnHeader) {
            String[][] data = new String[citizens.size()][5]; // Increase the column count to accommodate percentages
            int index = 0;
            for (Map.Entry<Integer, Double[]> entry : citizens.entrySet()) {
                data[index][0] = String.valueOf(entry.getKey()); // District
                data[index][1] = String.valueOf(entry.getValue()[0]); // Male or Resident
                data[index][2] = String.valueOf(entry.getValue()[1]); // Female or Non - Resident

                // Add percentages
                data[index][3] = String.format("<html><font color='blue'>%.2f%%</font></html>", entry.getValue()[2]); // Percentage of residents
                data[index][4] = String.format("<html><font color='blue'>%.2f%%</font></html>", entry.getValue()[3]); // Percentage of non-residents

                index++;
            }

            // Adjust column headers accordingly
            displayTable(data, columnHeader);
        }


        private void displayCitizenStatisticsTable1(Map<String, Integer> domainCount, String[] columnHeader) {
            String[][] data = new String[domainCount.size()][2];
            int index = 0;
            for (Map.Entry<String, Integer> entry : domainCount.entrySet()) {
                data[index][0] = entry.getKey(); // Domain
                data[index][1] = String.valueOf(entry.getValue()); // Frequency
                index++;
            }
            displayTable(data, columnHeader);
        }

        private void displayTable(String[][] data, String[] columnHeader) {
            DefaultTableModel model = (DefaultTableModel) citizenStatisticsTable.getModel();
            model.setDataVector(data, columnHeader);
            citizenStatisticsTable.setEnabled(false);

            // Adjust column widths
            TableColumnModel columnModel = citizenStatisticsTable.getColumnModel();
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setPreferredWidth(120);
            }

            // Set custom renderer for specific columns
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setCellRenderer(new CustomTableCellRenderer());
            }

            // Repaint the table
            citizenStatisticsTable.revalidate();
            citizenStatisticsTable.repaint();

            // Set custom header renderer
            citizenStatisticsTable.getTableHeader().setDefaultRenderer((table, value, isSelected, hasFocus, row, columnIdx) -> {
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setHorizontalAlignment(SwingConstants.CENTER);
                renderer.setBackground(Color.LIGHT_GRAY); // Set header background color
                renderer.setForeground(Color.BLACK); // Set header text color
                if (value != null) { // Ensure that the value is not null
                    renderer.setText(value.toString()); // Set the text of the renderer to the value
                }
                return renderer;
            });

            citizenStatisticsTable.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // Add vertical lines between column headers
            for (int i = 0; i < columnModel.getColumnCount(); i++) {
                columnModel.getColumn(i).setHeaderRenderer((table, value, isSelected, hasFocus, row, col) -> {
                    JLabel header = new JLabel(value.toString(), SwingConstants.CENTER);
                    header.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK), // Right border for each header except the last one
                            BorderFactory.createEmptyBorder(0, 5, 0, 5))); // Add padding
                    return header;
                });
            }

            // Set the height of the header
            citizenStatisticsTable.getTableHeader().setPreferredSize(new Dimension(citizenStatisticsTable.getTableHeader().getWidth(), 30));
        }


        // Custom cell renderer for setting background color
        static class CustomTableCellRenderer extends DefaultTableCellRenderer {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                ((JLabel) component).setHorizontalAlignment(SwingConstants.CENTER);
                // Check if there are exactly 5 columns
                if (table.getColumnCount() == 5) {
                    if (column == 1 || column == 3) {
                        component.setBackground(Color.ORANGE);
                        component.setForeground(Color.BLACK);
                    } else if (column == 2 || column == 4) {
                        component.setBackground(Color.PINK);
                        component.setForeground(Color.BLACK);
                    }
                } else if (table.getColumnCount() == 7){
                    if (row % 2 == 0){
                        component.setBackground(Color.getHSBColor(100, 100, 240));
                        component.setForeground(Color.BLACK);
                    } else {
                        component.setBackground(Color.WHITE);
                        component.setForeground(Color.BLACK);
                    }
                }


                return component;
            }
        }


    } // end of the ButtonHandler class


} // end of the FirstYear.SecondSemester.Finals.Project2.MyProgram class
