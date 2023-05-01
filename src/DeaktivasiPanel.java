import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DeaktivasiPanel extends JPanel implements ActionListener {
    private final JComboBox<Integer> opsiAkun;
    private final JTextArea statusText;
    private final JButton aktivasiButton;
    private final JButton deaktivasiButton;
    private List<RegisteredCustomer> listAkun = new ArrayList<>();

    public DeaktivasiPanel() {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Aktivasi/Deaktivasi Akun");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(500,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);


        // Bagian Pilih Akun
        // Label Pilih Akun
        JLabel pilihAkunLabel = new JLabel("Pilih Akun");
        pilihAkunLabel.setForeground(Color.BLACK);
        pilihAkunLabel.setFont(new Font(pilihAkunLabel.getFont().getName(), pilihAkunLabel.getFont().getStyle(), 15));
        pilihAkunLabel.setPreferredSize(new Dimension(300,20));
        // Label ID
        JLabel idLabel = new JLabel("ID ");
        idLabel.setForeground(Color.BLACK);
        idLabel.setOpaque(false);
        idLabel.setFont(new Font(pilihAkunLabel.getFont().getName(), pilihAkunLabel.getFont().getStyle(), 15));
        // Opsi Akun
        /* ----------------------- DUMMY ----------------------- */
        UnregisteredCustomer a = new UnregisteredCustomer();
        UnregisteredCustomer b = new UnregisteredCustomer();
        UnregisteredCustomer c = new UnregisteredCustomer();
        a.pesan(1, 10);
        b.pesan(1, 10);
        c.pesan(1, 10);
        RegisteredCustomer d = a.daftarMember("Kiki", "082848950");
        RegisteredCustomer e = b.daftarVIP("Kaka", "084637020");
        listAkun.add(d);
        listAkun.add(e);
        /* ----------------------------------------------------- */
        Integer[] opsi = {d.getId(), e.getId()};
        opsiAkun = new JComboBox<>(opsi);
        opsiAkun.addActionListener(this);
        opsiAkun.setFocusable(false);
        opsiAkun.addActionListener(this);
        // Sub-Panel Akun
        JPanel subPanelAkun = new JPanel();
        subPanelAkun.setPreferredSize(new Dimension(300,30));
        subPanelAkun.setOpaque(false);
        subPanelAkun.setLayout(new BorderLayout(10,0));
        subPanelAkun.add(idLabel, BorderLayout.WEST);
        subPanelAkun.add(opsiAkun, BorderLayout.CENTER);
        // Panel Akun
        JPanel panelAkun = new JPanel();
        panelAkun.setOpaque(false);
        panelAkun.setBackground(Color.gray);
        panelAkun.setLayout(new BorderLayout(0,10));
        panelAkun.add(pilihAkunLabel, BorderLayout.NORTH);
        panelAkun.add(subPanelAkun, BorderLayout.SOUTH);


        // Bagian Text Status (Aktif/Tidak Aktif)
        // Label
        JLabel statusLabel = new JLabel("Status Keaktifan");
        statusLabel.setFont(new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle(), 15));
        statusLabel.setPreferredSize(new Dimension(300,20));
        // Text
        statusText = new JTextArea("");
        statusText.setBorder(BorderFactory.createEmptyBorder(7, 7,7,7));
        statusText.setEditable(false);
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(100,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(statusText, BorderLayout.CENTER);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(statusLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);


        // Bagian Aktivasi/Deaktivasi
        // Tombol Aktivasi
        aktivasiButton = new JButton("Aktivasi");
        aktivasiButton.setFocusable(false);
        aktivasiButton.addActionListener(this);
        aktivasiButton.setPreferredSize(new Dimension(100, 35));
        // Tombol Deaktivasi
        deaktivasiButton = new JButton("Deaktivasi");
        deaktivasiButton.setFocusable(false);
        deaktivasiButton.addActionListener(this);
        deaktivasiButton.setPreferredSize(new Dimension(100, 35));
        // Sub-Panel 2
        JPanel subPanel2 = new JPanel();
        subPanel2.setOpaque(false);
        subPanel2.setPreferredSize(new Dimension(300,30));
        subPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        subPanel2.add(aktivasiButton);
        subPanel2.add(deaktivasiButton);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(subPanel2, BorderLayout.SOUTH);


        // Field Panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.LIGHT_GRAY);
        fieldPanel.setPreferredSize(new Dimension(500,400));
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 45));
        fieldPanel.add(panelAkun);
        fieldPanel.add(panel1);
        fieldPanel.add(panel2);


        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setPreferredSize(new Dimension(800,800));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 85));
        centerPanel.add(fieldPanel);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndex  = opsiAkun.getSelectedIndex();
        if (e.getSource() == opsiAkun) {
            // To Do implement pilih akun
            // pilih akun meng-set status keaktifan sesuai akun
            if (listAkun.get(selectedIndex).isAktif()) {
                statusText.setText("Aktif");
                aktivasiButton.setEnabled(false);
                deaktivasiButton.setEnabled(true);
            }
            else {
                statusText.setText("Tidak Aktif");
                aktivasiButton.setEnabled(true);
                deaktivasiButton.setEnabled(false);
            }
        }
        else if (e.getSource() == aktivasiButton) {
            aktivasiButton.setEnabled(false);
            deaktivasiButton.setEnabled(true);
            statusText.setText("Aktif");
            // To DO implement set status akun true ke database
            listAkun.get(selectedIndex).aktivasiAkun();
        }
        else if (e.getSource() == deaktivasiButton) {
            aktivasiButton.setEnabled(true);
            deaktivasiButton.setEnabled(false);
            statusText.setText("Tidak Aktif");
            // To DO implement set status akun false ke database
            listAkun.get(selectedIndex).deaktivasiAkun();
        }
    }
}
