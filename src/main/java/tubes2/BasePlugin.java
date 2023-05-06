package tubes2;

import javax.swing.*;
import java.awt.*;

public class BasePlugin {
    private String name;
    private JPanel mainPanel;
    public BasePlugin() {
        mainPanel = new BlankPage("Plugin");
    }

    public JPanel createPluginPanel() {
        return mainPanel;
    }

}

class BlankPage extends JPanel {
    public BlankPage(String pageTitle) {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel(pageTitle);
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);


        // Sub-Panel
        JPanel subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        subPanel.setPreferredSize(new Dimension(1000, 500));


        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setPreferredSize(new Dimension(800,800));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 65));
        centerPanel.add(subPanel);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}
