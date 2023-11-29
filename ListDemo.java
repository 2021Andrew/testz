import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("List Demo");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);

        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        JButton button = new JButton("Show Selection");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Selected Item: " + list.getSelectedValue());
            }
        });

        frame.setLayout(null);
        list.setBounds(20, 20, 150, 100);
        button.setBounds(180, 20, 150, 25);

        frame.add(list);
        frame.add(button);

        frame.setSize(350, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
