import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Choice Demo");
        ChoiceDemo choice = new choice();

        choice.add("Option 1");
        choice.add("Option 2");
        choice.add("Option 3");

        JButton button = new JButton("Show Selection");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Selected Option: " + choice.getSelectedItem());
            }
        });

        frame.setLayout(null);
        choice.setBounds(20, 20, 150, 25);
        button.setBounds(180, 20, 150, 25);

        frame.add(choice);
        frame.add(button);

        frame.setSize(350, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
