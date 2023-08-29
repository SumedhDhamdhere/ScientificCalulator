package scientific;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ScientificCalculator extends JFrame {
    private JTextField displayField;
    private double num1, num2, result;
    private String operator = ""; // Initialize the operator field

    public ScientificCalculator() {
        setTitle("Scientific Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayField = new JTextField();
        displayField.setFont(new Font("Arial", Font.PLAIN, 24));
        displayField.setEditable(false);
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayField, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "^", "pi", "e", "log",
                "sqrt", "sin", "cos", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                displayField.setText(displayField.getText() + command);
            } else if ("+-*/".contains(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    operator = command;
                    displayField.setText("");
                }
            } else if ("^".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    operator = "^";  // Set the operator to ^
                    displayField.setText("");
                }
            } else if (command.equals("=")) {
                if (!displayField.getText().isEmpty()) {
                    num2 = Double.parseDouble(displayField.getText());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        case "^":
                            result = Math.pow(num1, num2); // Raise to power
                            break;
                    }
                    displayField.setText(String.valueOf(result));
                }
            } else if ("sqrt".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    result = Math.sqrt(num1);
                    displayField.setText(String.valueOf(result));
                }
            } else if ("sin".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    result = Math.sin(num1);
                    displayField.setText(String.valueOf(result));
                }
            } else if ("cos".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    result = Math.cos(num1);
                    displayField.setText(String.valueOf(result));
                }
            } else if ("tan".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    result = Math.tan(num1);
                    displayField.setText(String.valueOf(result));
                }
            } else if ("pi".equals(command)) {
                num1 = Math.PI;
                displayField.setText(String.valueOf(num1));
            } else if ("e".equals(command)) {
                num1 = Math.E;
                displayField.setText(String.valueOf(num1));
            } else if ("log".equals(command)) {
                if (!displayField.getText().isEmpty()) {
                    num1 = Double.parseDouble(displayField.getText());
                    result = Math.log10(num1);
                    displayField.setText(String.valueOf(result));
                }}}}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScientificCalculator calculator = new ScientificCalculator();
            calculator.setVisible(true);
        });
    }}
