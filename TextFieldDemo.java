import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Demo");
        JTextField textField = new JTextField();
        JButton button = new JButton("Show Text");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Entered Text: " + textField.getText());
            }
        });

        frame.setLayout(null);
        textField.setBounds(20, 20, 150, 25);
        button.setBounds(180, 20, 120, 25);

        frame.add(textField);
        frame.add(button);

        frame.setSize(350, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
