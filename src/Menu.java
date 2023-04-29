import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JFrame implements MenuListener {
    private final JMenu halamanUtama;
    private final JMenu halamanSetting;
    private final JMenu halamanGudang;
    private final JMenu halamanRegistrasi;
    private final JMenu halamanKasir;
    private final JMenu halamanRiwayat;
    private final JTabbedPane tab;
    private JPopupMenu popUpMenu;
    private JMenuItem delete;

    public Menu() {
        // Icon
        ImageIcon icon = new ImageIcon("src/logo.png");


        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        halamanUtama = new JMenu("Halaman Utama");
        halamanSetting = new JMenu("Setting");
        halamanGudang = new JMenu("Gudang");
        halamanRegistrasi = new JMenu("Registrasi");
        halamanKasir = new JMenu("Kasir");
        halamanRiwayat = new JMenu("Riwayat");
        halamanUtama.addMenuListener(this);
        halamanSetting.addMenuListener(this);
        halamanGudang.addMenuListener(this);
        halamanRegistrasi.addMenuListener(this);
        halamanKasir.addMenuListener(this);
        halamanRiwayat.addMenuListener(this);
        menuBar.add(halamanUtama);
        menuBar.add(halamanSetting);
        menuBar.add(halamanGudang);
        menuBar.add(halamanRegistrasi);
        menuBar.add(halamanKasir);
        menuBar.add(halamanRiwayat);


        // Tabbed Pane
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
    public void menuSelected(MenuEvent e) {
        if (e.getSource() == halamanUtama) {
            tab.add("Halaman Utama", new MainPanel());
        }
        else if (e.getSource() == halamanSetting) {
            tab.add("Setting", new SettingPanel());
        }
        else if (e.getSource() == halamanGudang) {
            // TO DO implement panel gudang
            tab.add("Gudang", new SettingPanel());
        }
        else if (e.getSource() == halamanRegistrasi) {
            // TO DO implement panel registrasi
            tab.add("Registrasi", new SettingPanel());
        }
        else if (e.getSource() == halamanKasir) {
            // TO DO implement panel kasir
            tab.add("Kasir", new SettingPanel());
        }
        else if (e.getSource() == halamanRiwayat) {
            // TO DO implement panel riwayat
            tab.add("Riwayat", new SettingPanel());
        }
    }

    @Override
    public void menuDeselected(MenuEvent e) {}

    @Override
    public void menuCanceled(MenuEvent e) {}
}