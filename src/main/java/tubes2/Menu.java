package tubes2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements ActionListener {
    private final JTabbedPane tab;
    private JPopupMenu popUpMenu;
    private JMenuItem delete;
    private final JMenuItem bukaHalamanUtama;
    private final JMenuItem bukaHalamanSetting;
    private final JMenuItem bukaHalamanGudang;
    private final JMenuItem bukaHalamanKasir;
    private final JMenuItem bukaHalamanRiwayat;
    private final JMenuItem bukaHalamanPendaftaran;
    private final JMenuItem bukaHalamanUpdate;
    private final JMenuItem bukaHalamanStatusAkun;


    public Menu() {
        // Icon
        ImageIcon icon = new ImageIcon("src/logo.png");


        // Menu bar
        // Menu bar utama
        JMenuBar menuBar = new JMenuBar();
        JMenu halamanUtama = new JMenu("Halaman Utama");
        JMenu halamanSetting = new JMenu("Setting");
        JMenu halamanGudang = new JMenu("Gudang");
        JMenu halamanAkun = new JMenu("Akun");
        JMenu halamanKasir = new JMenu("Kasir");
        JMenu halamanRiwayat = new JMenu("Riwayat");
        menuBar.add(halamanUtama);
        menuBar.add(halamanSetting);
        menuBar.add(halamanGudang);
        menuBar.add(halamanAkun);
        menuBar.add(halamanKasir);
        menuBar.add(halamanRiwayat);
        // Halaman Utama
        bukaHalamanUtama = new JMenuItem("New");
        bukaHalamanUtama.addActionListener(this);
        halamanUtama.add(bukaHalamanUtama);
        // Setting
        bukaHalamanSetting = new JMenuItem("New");
        bukaHalamanSetting.addActionListener(this);
        halamanSetting.add(bukaHalamanSetting);
        // Gudang
        bukaHalamanGudang = new JMenuItem("New");
        bukaHalamanGudang.addActionListener(this);
        halamanGudang.add(bukaHalamanGudang);
        // Akun
        bukaHalamanPendaftaran = new JMenuItem("Daftar");
        bukaHalamanUpdate = new JMenuItem("Update");
        bukaHalamanStatusAkun = new JMenuItem("Aktivasi/Deaktivasi");
        bukaHalamanPendaftaran.addActionListener(this);
        bukaHalamanUpdate.addActionListener(this);
        bukaHalamanStatusAkun.addActionListener(this);
        halamanAkun.add(bukaHalamanPendaftaran);
        halamanAkun.add(bukaHalamanUpdate);
        halamanAkun.add(bukaHalamanStatusAkun);
        // Kasir
        bukaHalamanKasir = new JMenuItem("New");
        bukaHalamanKasir.addActionListener(this);
        halamanKasir.add(bukaHalamanKasir);
        // Riwayat

        bukaHalamanRiwayat = new JMenuItem("New");
        bukaHalamanRiwayat.addActionListener(this);
        halamanRiwayat.add(bukaHalamanRiwayat);


        // Tab
        tab = new JTabbedPane();
        tab.setPreferredSize(new Dimension(800, 800));
        tab.setFocusable(false);
        tab.add("Halaman Utama", new MainPanel());
        tab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    int index = tab.getSelectedIndex();
                    popUpMenu = new JPopupMenu();

                    delete = new JMenuItem("Delete");
                    delete.addActionListener(e1 -> tab.remove(index));
                    popUpMenu.add(delete);
                    popUpMenu.show(tab, e.getX() + 5, e.getY() + 5);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


        // Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 800));
        setTitle("Point of Sales");
        setIconImage(icon.getImage());
        setJMenuBar(menuBar);
        add(tab);
        setVisible(true);
        pack();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bukaHalamanUtama) {
            tab.add("Halaman Utama", new MainPanel());
        }
        else if (e.getSource() == bukaHalamanSetting) {
            tab.add("Setting", new SettingPanel());
        }
        else if (e.getSource() == bukaHalamanPendaftaran) {
            // TO DO implement panel pendaftaran
            tab.add("Daftar Akun", new RegistrasiPanel());
        }
        else if (e.getSource() == bukaHalamanUpdate) {
            // TO DO implement panel update
            tab.add("Update Akun", new UpdateAkunPanel());
        }
        else if (e.getSource() == bukaHalamanStatusAkun) {
            // TO DO implement panel aktivasi/deaktivasi
            tab.add("Aktivasi/Deaktivasi Akun", new DeaktivasiPanel());
        }
        else if (e.getSource() == bukaHalamanGudang) {
            // TO DO implement panel gudang
            tab.add("Gudang", new GudangPanel());
        }
        else if (e.getSource() == bukaHalamanKasir) {
            // TO DO implement panel kasir
        	
        }
        else if (e.getSource() == bukaHalamanRiwayat) {
            // TO DO implement panel riwayat
        }
    }
}