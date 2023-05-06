package tubes2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrasiPanel extends JPanel implements ActionListener{
    private final JTextArea namaText;
    private final JTextArea nomorTeleponText;
    private final JComboBox<Integer> opsiAkun;
    private final JButton saveButton;
    private final JComboBox<String> status;
    private final JSONDataStore dataStore = new JSONDataStore();

    private final CustomerList customers = dataStore.readCustomer();

    public RegistrasiPanel(){
        // Judul
        JLabel title = new JLabel("Daftar Akun");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);

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
        idLabel.setFont(new Font(idLabel.getFont().getName(), idLabel.getFont().getStyle(), 15));

        Integer[] opsi = new Integer[0];
        if(customers!=null){

            int count = 0;
            for(int i = 0; i < customers.getCustomerList().size(); i++){
                // Hanya unregistered customer yang pernah transaksi minimal sekali yang ditampilkan
                if(customers.getCustomerList().get(i) instanceof UnregisteredCustomer && customers.getCustomerList().get(i).getHistoriTransaksi().size() >= 1){
                    count++;
                }
            }

            opsi = new Integer[count];
            count = 0;
            for(int i = 0; i < customers.getCustomerList().size(); i++){
                // Hanya unregistered customer yang pernah transaksi minimal sekali yang ditampilkan
                if(customers.getCustomerList().get(i) instanceof UnregisteredCustomer && customers.getCustomerList().get(i).getHistoriTransaksi().size() >= 1){
                    opsi[count] = customers.getCustomerList().get(i).getId();
                    count++;
                }
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

        // Bagian Nama
        // Label
        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setFont(new Font(namaLabel.getFont().getName(), namaLabel.getFont().getStyle(), 15));
        namaLabel.setPreferredSize(new Dimension(300,20));
        // Text
        namaText = new JTextArea();
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
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(namaLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);

        // Bagian Nomor Telepon
        // Label
        JLabel nomorTeleponLabel = new JLabel("Nomor Telepon");
        nomorTeleponLabel.setFont(new Font(nomorTeleponLabel.getFont().getName(), nomorTeleponLabel.getFont().getStyle(), 15));
        nomorTeleponLabel.setPreferredSize(new Dimension(300,20));
        // Text
        nomorTeleponText = new JTextArea();
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
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(nomorTeleponLabel, BorderLayout.NORTH);
        panel2.add(subPanel2, BorderLayout.SOUTH);

        // Bagian Status (Member/VIP)
        // Label
        JLabel statusLabel = new JLabel("Status Membership");
        statusLabel.setFont(new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle(), 15));
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
        panel3.setBackground(Color.gray);
        panel3.setLayout(new BorderLayout(0,10));
        panel3.add(statusLabel, BorderLayout.NORTH);
        panel3.add(subPanel3, BorderLayout.SOUTH);

        // Bagian Save
        saveButton = new JButton("Daftar");
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);
        saveButton.setPreferredSize(new Dimension(75, 35));

        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.LIGHT_GRAY);
        fieldPanel.setPreferredSize(new Dimension(500,500));
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 45));
        fieldPanel.add(panelAkun);
        fieldPanel.add(panel1);
        fieldPanel.add(panel2);
        fieldPanel.add(panel3);
        fieldPanel.add(saveButton);



        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.GRAY);
        centerPanel.setPreferredSize(new Dimension(800,800));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 30));
        centerPanel.add(fieldPanel);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        /* ----------------------- DUMMY ----------------------- */
        //UnregisteredCustomer a = new UnregisteredCustomer();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedID  = opsiAkun.getItemAt(opsiAkun.getSelectedIndex());
        if (e.getSource() == saveButton) {
            // TO DO implement save field
            RegisteredCustomer member = new RegisteredCustomer(namaText.getText(), nomorTeleponText.getText(), dataStore.getCustomer(selectedID).getHistoriTransaksi().get(0));
            if(status.getSelectedIndex()==0){
                member.setMember();
            }else{
                member.setVIP();
            }
            customers.addCustomer(member);
            customers.getCustomerList().remove(customers.getCustomerByID(selectedID));
            dataStore.writeCustomer(customers);
        }
    }
}
