import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Checkbox Demo");
        JCheckBox checkBox = new JCheckBox("Enable Feature");

        JButton button = new JButton("Submit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Feature Enabled");
                } else {
                    JOptionPane.showMessageDialog(frame, "Feature Disabled");
                }
            }
        });

        frame.setLayout(null);
        checkBox.setBounds(20, 20, 150, 25);
        button.setBounds(180, 20, 120, 25);

        frame.add(checkBox);
        frame.add(button);

        frame.setSize(350, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
