import javax.swing.*;

/**
 * Created by Sean on 17/12/2016.
 */
public class Frontend {
    private JList list1;
    private JList list2;
    private JPanel Container;
    private JPanel Container1;
    private JLabel Country;
    private JPanel Container2;
    private JLabel Country1;
    private JPanel Container3;
    private JPanel Container4;
    private JPanel Container5;
    private JPanel Container6;
    private JPanel Container7;
    private JPanel Container8;
    private JLabel Currency;
    private JLabel currency1;
    private JLabel ConversionRate;
    private JLabel Time;
    private JLabel Time1;
    private JLabel TimeDifferences;
    private JLabel DigitalClock;
    private JLabel DigitalClock1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frontend");
        frame.setContentPane(new Frontend().Container);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

