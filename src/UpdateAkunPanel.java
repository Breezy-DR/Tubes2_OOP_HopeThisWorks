import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateAkunPanel extends JPanel implements ActionListener {
    private final JTextArea namaText;
    private final JTextArea nomorTeleponText;
    private JComboBox status;
    private final JButton saveButton;

    public UpdateAkunPanel() {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Update Akun");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);


        // Bagian Nama
        // Label
        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setFont(new Font(namaLabel.getFont().getName(), namaLabel.getFont().getStyle(), 15));
        namaLabel.setPreferredSize(new Dimension(300,20));
        // Text
        namaText = new JTextArea("Irfan Bahdim");
        namaText.setBorder(BorderFactory.createEmptyBorder(7, 7,7,7));
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(300,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(namaText, BorderLayout.CENTER);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        panel1.setBounds(100, 50, 300, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(namaLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);


        // Bagian Nomor Telepon
        // Label
        JLabel nomorTeleponLabel = new JLabel("Nomor Telepon");
        nomorTeleponLabel.setFont(new Font(namaLabel.getFont().getName(), namaLabel.getFont().getStyle(), 15));
        nomorTeleponLabel.setPreferredSize(new Dimension(300,20));
        // Text
        nomorTeleponText = new JTextArea("0812748302");
        nomorTeleponText.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        // Sub-Panel 2
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(300,30));
        subPanel2.setBackground(Color.gray);
        subPanel2.setLayout(new BorderLayout());
        subPanel2.add(nomorTeleponText, BorderLayout.CENTER);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setBounds(100, 50, 300, 65);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(nomorTeleponLabel, BorderLayout.NORTH);
        panel2.add(subPanel2, BorderLayout.SOUTH);


        // Bagian Status (Member/VIP)
        // Label
        JLabel statusLabel = new JLabel("Status");
        statusLabel.setFont(new Font(namaLabel.getFont().getName(), namaLabel.getFont().getStyle(), 15));
        statusLabel.setPreferredSize(new Dimension(300,20));
        // Opsi
        String[] option = {"Member", "VIP"};
        status = new JComboBox<>(option);
        status.addActionListener(this);
        status.setFocusable(false);
        // Sub-Panel 3
        JPanel subPanel3 = new JPanel();
        subPanel3.setPreferredSize(new Dimension(100,30));
        subPanel3.setBackground(Color.gray);
        subPanel3.setLayout(new BorderLayout());
        subPanel3.add(status, BorderLayout.CENTER);
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setBounds(100, 50, 300, 65);
        panel3.setBackground(Color.gray);
        panel3.setLayout(new BorderLayout(0,10));
        panel3.add(statusLabel, BorderLayout.NORTH);
        panel3.add(subPanel3, BorderLayout.SOUTH);

        // Bagian Save
        saveButton = new JButton("Save");
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setPreferredSize(new Dimension(75, 35));

        // Field Panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.LIGHT_GRAY);
        fieldPanel.setPreferredSize(new Dimension(450,450));
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 45));
        fieldPanel.add(panel1);
        fieldPanel.add(panel2);
        fieldPanel.add(panel3);
        fieldPanel.add(saveButton);


        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setPreferredSize(new Dimension(800,800));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 65));
        centerPanel.add(fieldPanel);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            // TO DO implement save field
        }
    }
}
