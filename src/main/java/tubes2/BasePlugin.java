package tubes2;

import javax.swing.*;
import java.awt.*;

public abstract class BasePlugin {
    private static int pluginCount = 0;
    private String name;
    protected JPanel mainPanel;

    public BasePlugin() {
        this.pluginCount++;
    }

    public static int getPluginCount() {
        return pluginCount;
    }

    public String getName() {
        return name;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JPanel createBlankPage(String pageTitle) {
        return new BlankPage(pageTitle);
    }

    public abstract JPanel createPluginPanel();
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
