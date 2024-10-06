package FirstYear.SecondSemester.Midterms.MidtermProject2;

import javax.swing.*;
import java.awt.*;


public class Tester extends JFrame {
    private JPanel title;
    private JPanel buttonPanel;
    private JPanel headPanel;
    private JButton square;
    private JButton triangle;
    private JButton circle;
    private JButton rectangle;

    public Tester(){
        setTitle("Edibro GUI");
        setSize(700,500);

        headPanel = new JPanel();
        JLabel textArea = new JLabel();
        textArea.setText("Shape Calculator");
        headPanel.add(textArea);

        JComboBox<String> areaPerimeter;
        JComboBox<String> shapes;

        JPanel cardPanel;
        CardLayout cardLayout;

        //Container
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1));
        pane.add(headPanel);
        setVisible(true);
    }
}
