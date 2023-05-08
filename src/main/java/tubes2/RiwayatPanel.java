package tubes2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiwayatPanel extends JPanel implements ActionListener {
    private final JComboBox<Integer> opsiAkun;
    private final JButton tampilkanRiwayatButton;
    private final JButton printButton;
    private final CustomerList listCustomer = DataStoreHub.readCustomer();

    public RiwayatPanel() {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Riwayat");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 150, 100);

        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100,100));
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
        Integer[] opsi = new Integer[0];
        if (listCustomer != null) {
            int sizeOfListCustomer = listCustomer.getCustomerList().size();
            opsi = new Integer[sizeOfListCustomer];
            for(int i = 0; i < sizeOfListCustomer; i++) {
                opsi[i] =  listCustomer.getCustomerList().get(i).getId();
            }
        }
        
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

        // Bagian Cari Riwayat
        // Tombol Cari Riwayat
        tampilkanRiwayatButton = new JButton("Tampilkan Riwayat");
        tampilkanRiwayatButton.setFocusable(false);
        tampilkanRiwayatButton.addActionListener(this);
        tampilkanRiwayatButton.setPreferredSize(new Dimension(175, 35));
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setOpaque(false);
        subPanel1.setPreferredSize(new Dimension(300,30));
        subPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        subPanel1.add(tampilkanRiwayatButton);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setOpaque(false);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(subPanel1, BorderLayout.SOUTH);

        // Field Panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.LIGHT_GRAY);
        fieldPanel.setPreferredSize(new Dimension(500,300));
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 45));
        fieldPanel.add(panelAkun);
        fieldPanel.add(panel1);

        // Bagian print
        // Label
        JLabel printLabel = new JLabel("Print Laporan Penjualan");
        printLabel.setForeground(Color.WHITE);
        printLabel.setFont(new Font(printLabel.getFont().getName(), printLabel.getFont().getStyle(), 15));
        printLabel.setPreferredSize(new Dimension(300,20));
        printLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Tombol
        printButton = new JButton("Print");
        printButton.addActionListener(this);
        printButton.setFocusable(false);
        // Sub-panel 3
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(100,35));
        subPanel2.setBackground(Color.LIGHT_GRAY);
        subPanel2.setLayout(new FlowLayout());
        subPanel2.add(printButton);
        subPanel2.setOpaque(false);
        // Panel 3
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(500, 300));
        panel2.setBounds(100,330, 500, 160);
        panel2.setBackground(Color.GRAY);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 25));
        panel2.add(printLabel);
        panel2.add(subPanel2);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 75));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.add(fieldPanel);
        centerPanel.add(panel2);

        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedID  = opsiAkun.getItemAt(opsiAkun.getSelectedIndex());
        if (e.getSource() == tampilkanRiwayatButton) {
            HistoriTransaksiList.main(selectedID);
        }
        else if(e.getSource() == printButton) {
            try {
                PDFPrinter.printLaporanPenjualan(listCustomer, "src/main/java/tubes2/data", "Laporan Penjualan.pdf");
                JFrame messageFrame = new JFrame("Message");
                messageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JOptionPane.showMessageDialog(messageFrame, "Laporan Penjualan.pdf berhasil diprint pada folder src/main/java/tubes2/data.");
                    }
                });
            }
            catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
}