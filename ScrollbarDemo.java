import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ScrollbarDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scrollbar Demo");
        JScrollPane scrollPane = new JScrollPane();

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                JOptionPane.showMessageDialog(frame, "Scrollbar Value: " + scrollBar.getValue());
            }
        });

        scrollPane.setVerticalScrollBar(scrollBar);

        frame.setLayout(null);
        scrollPane.setBounds(20, 20, 300, 200);
        frame.add(scrollPane);

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
