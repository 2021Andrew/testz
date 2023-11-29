import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutDemo extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JPanel flowPanel, borderPanel, gridPanel, cardPanel;
    private CardLayout cardLayout;

    public LayoutDemo() {
        setTitle("Layout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createFlowPanel();
        createBorderPanel();
        createGridPanel();
        createCardPanel();

        mainPanel.add(flowPanel, BorderLayout.NORTH);
        mainPanel.add(borderPanel, BorderLayout.SOUTH);
        mainPanel.add(gridPanel, BorderLayout.CENTER);
        mainPanel.add(cardPanel, BorderLayout.EAST);

        add(mainPanel);
    }

    private void createFlowPanel() {
        flowPanel = new JPanel(new FlowLayout());
        flowPanel.setBackground(Color.lightGray);
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));
    }

    private void createBorderPanel() {
        borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBackground(Color.lightGray);
        borderPanel.add(new JButton("North Button"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South Button"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("West Button"), BorderLayout.WEST);
        borderPanel.add(new JButton("East Button"), BorderLayout.EAST);
        borderPanel.add(new JButton("Center Button"), BorderLayout.CENTER);
    }

    private void createGridPanel() {
        gridPanel = new JPanel(new GridLayout(2, 2));
        gridPanel.setBackground(Color.lightGray);
        gridPanel.add(new JButton("Button 1"));
        gridPanel.add(new JButton("Button 2"));
        gridPanel.add(new JButton("Button 3"));
        gridPanel.add(new JButton("Button 4"));
    }

    private void createCardPanel() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Color.lightGray);

        for (int i = 1; i <= 3; i++) {
            JPanel card = new JPanel();
            card.setBackground(Color.getHSBColor(i * 0.1f, 0.7f, 0.7f));
            card.add(new JLabel("Card " + i));
            cardPanel.add(card, "Card " + i);
        }

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(this);
        cardPanel.add(nextButton, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cardLayout.next(cardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LayoutDemo layoutDemo = new LayoutDemo();
            layoutDemo.setVisible(true);
        });
    }
}

