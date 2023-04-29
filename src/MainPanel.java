import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Halaman Utama");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);


        // Logo
        JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("src/logo.png");
        Image newimg = icon.getImage().getScaledInstance(240, 240,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newimg);
        logo.setIcon(newImageIcon);


        // Text Nama dan NIM
        JTextArea namaNIM = new JTextArea();
        namaNIM.setText("""
                1. Muhammad Equilibrie Fajria - 13521047
                2. M. Farrel Danendra Rachim - 13521048
                3. Fazel Ginanda - 13521098
                4. Haidar Hamda - 13521105
                5. Edia Zaki Naufal Ilman - 13521141""");
        namaNIM.setFont(new Font(namaNIM.getFont().getName(), namaNIM.getFont().getStyle(), 25));
        namaNIM.setEditable(false);
        namaNIM.setBackground(Color.LIGHT_GRAY);
        namaNIM.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));


        // Sub-Panel
        JPanel subPanel = new JPanel();
        subPanel.setOpaque(false);
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        subPanel.setPreferredSize(new Dimension(1000, 500));
        subPanel.add(logo);
        subPanel.add(namaNIM);


        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setPreferredSize(new Dimension(800,800));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 65));
        centerPanel.add(new ClockPanel());
        centerPanel.add(subPanel);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}
