package tubes2;

import javax.swing.*;
import java.awt.*;

public class BasePlugin {
    private String name;
    protected JPanel mainPanel;

    public String getName() {
        return name;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel createBlankPage() {
        return new BlankPage("Plugin 1");
    }

    public JPanel createPluginPanel() {
        this.mainPanel = createBlankPage();
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

        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
    }
}
