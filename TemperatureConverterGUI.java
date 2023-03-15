import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;
    private JTextField celsiusTextField;
    private JTextField fahrenheitTextField;
    private JButton convertButton;

    public TemperatureConverterGUI() {
        super("Temperature Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        celsiusLabel = new JLabel("Celsius:");
        fahrenheitLabel = new JLabel("Fahrenheit:");
        celsiusTextField = new JTextField(10);
        fahrenheitTextField = new JTextField(10);
        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!celsiusTextField.getText().isEmpty()) {
                    double celsius = Double.parseDouble(celsiusTextField.getText());
                    double fahrenheit = (celsius * 1.8) + 32;
                    fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
                } else if (!fahrenheitTextField.getText().isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitTextField.getText());
                    double celsius = (fahrenheit - 32) / 1.8;
                    celsiusTextField.setText(String.format("%.2f", celsius));
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(celsiusLabel);
        panel.add(celsiusTextField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitTextField);
        panel.add(convertButton);

        add(panel);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TemperatureConverterGUI();
    }
}
