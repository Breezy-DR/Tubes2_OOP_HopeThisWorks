package tubes2;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class KasirPanelNew extends JPanel implements ActionListener,Runnable {
    public static DefaultListModel model = new DefaultListModel();
    public static JList list = new JList(model);
    private Bill bill=new Bill();
    private JComboBox<String> opsiAkun;
    private JComboBox<String> opsiBarang;
    private JTextArea kuantitas;
    private JButton addBelanjaButton;
    private JButton saveBillButton;
    private JButton deleteBillButton;
    public KasirPanelNew(){
        // Judul
        JLabel title = new JLabel("Kasir");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 500, 100);

        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);

        JLabel textPilihCustomer=new JLabel("Pilih customer");
        List<String> custName=new ArrayList<>();
        custName.add("Guest");
        CustomerList customerList=DataStoreHub.readCustomer();
        for (Customer c :
                customerList.getCustomerList()) {
            if (c instanceof RegisteredCustomer) {
                RegisteredCustomer temp=(RegisteredCustomer) c;
                custName.add(temp.getNama());
            }
        }
        for (ElmtOfBill e :
                this.bill.getListBelanja()) {
            model.addElement("Nama Barang "+e.getNama());
        }
        String[] nama=custName.toArray(new String[custName.size()]);
        opsiAkun=new JComboBox<String>(nama);
        opsiAkun.addActionListener(this);
        opsiAkun.setFocusable(false);
        opsiAkun.addActionListener(this);

        // Bagian Pilih Akun
        // Label Pilih Akun
        JLabel pilihAkunLabel = new JLabel("Pilih Akun");
        pilihAkunLabel.setForeground(Color.BLACK);
        pilihAkunLabel.setFont(new Font(pilihAkunLabel.getFont().getName(), pilihAkunLabel.getFont().getStyle(), 15));
        pilihAkunLabel.setPreferredSize(new Dimension(300,10));
        JPanel listBillPanel=new JPanel();
        listBillPanel.setSize(new Dimension(300,10));
        listBillPanel.add(list);

        // Sub-Panel Akun
        JPanel subPanelAkun = new JPanel();
        subPanelAkun.setPreferredSize(new Dimension(300,10));
        subPanelAkun.setOpaque(false);
        subPanelAkun.setLayout(new BorderLayout(10,0));
        subPanelAkun.add(textPilihCustomer,BorderLayout.NORTH);
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
        JLabel namaLabel = new JLabel("kuantitas");
        namaLabel.setFont(new Font(namaLabel.getFont().getName(), namaLabel.getFont().getStyle(), 15));
        namaLabel.setPreferredSize(new Dimension(300,10));
        // Text
        kuantitas = new JTextArea();
        kuantitas.setBorder(BorderFactory.createEmptyBorder(7, 7,7,7));
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(300,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(kuantitas, BorderLayout.CENTER);
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
        nomorTeleponLabel.setPreferredSize(new Dimension(300,15));
        // Text
        JTextArea nomorTeleponText = new JTextArea();
        nomorTeleponText.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        // Sub-Panel 2
        JScrollPane scrollPane=new JScrollPane(list);
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(300, 60));
        subPanel2.setBackground(Color.gray);
        subPanel2.setLayout(new BorderLayout());
        subPanel2.add(scrollPane, BorderLayout.CENTER);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setOpaque(false);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
//        panel2.add(nomorTeleponLabel, BorderLayout.NORTH);
        panel2.add(subPanel2, BorderLayout.SOUTH);

        // Bagian Status (Member/VIP)
        // Label
        JLabel statusLabel = new JLabel("Pilih Akun");
        statusLabel.setFont(new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle(), 15));
        statusLabel.setPreferredSize(new Dimension(300,15));
        // Opsi
        String[] option = {"Member", "VIP"};
        JComboBox<String> status = new JComboBox<>(option);
        status.addActionListener(this);
        status.setFocusable(false);
        // Sub-Panel 3
        JPanel subPanel3 = new JPanel();
        subPanel3.setPreferredSize(new Dimension(100,30));
        subPanel3.setBackground(Color.gray);
        subPanel3.setLayout(new BorderLayout());
        subPanel3.add(opsiAkun, BorderLayout.CENTER);
        BarangList barangList=DataStoreHub.readBarang();
        List<String> barangName=new ArrayList<>();
        for (Barang b :
                barangList.getBarangList()) {
            barangName.add(b.getNamaBarang());
        }
        String[] namaBarang=barangName.toArray(new String[barangName.size()]);
        opsiBarang=new JComboBox<String>(namaBarang);
        opsiBarang.addActionListener(this);
        opsiBarang.setFocusable(false);
        opsiBarang.addActionListener(this);
        JLabel pilihBarangLabel = new JLabel("Pilih Barang");
        pilihBarangLabel.setFont(new Font(statusLabel.getFont().getName(), statusLabel.getFont().getStyle(), 15));
        pilihBarangLabel.setPreferredSize(new Dimension(300,15));
        JPanel subPanel33 = new JPanel();
        subPanel33.setPreferredSize(new Dimension(300,30));
        subPanel33.setBackground(Color.gray);
        subPanel33.setLayout(new BorderLayout());
        subPanel33.add(opsiBarang, BorderLayout.CENTER);
        JPanel panel33=new JPanel();
        panel33.setOpaque(false);
        panel33.setBackground(Color.gray);
        panel33.setLayout(new BorderLayout(0,10));
        panel33.add(pilihBarangLabel, BorderLayout.NORTH);
        panel33.add(subPanel33, BorderLayout.SOUTH);
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setOpaque(false);
        panel3.setBackground(Color.gray);
        panel3.setLayout(new BorderLayout(0,10));
        panel3.add(statusLabel, BorderLayout.NORTH);
        panel3.add(subPanel3, BorderLayout.SOUTH);

        addBelanjaButton = new JButton("Tambah Belanja");
        addBelanjaButton.setFocusable(false);
        addBelanjaButton.addActionListener(this);
        addBelanjaButton.setPreferredSize(new Dimension(300, 30));

        saveBillButton = new JButton("Checkout");
        saveBillButton.setFocusable(false);
        saveBillButton.addActionListener(this);
        saveBillButton.setPreferredSize(new Dimension(300, 30));

        deleteBillButton = new JButton("Hapus belanja");
        deleteBillButton.setFocusable(false);
        deleteBillButton.addActionListener(this);
        deleteBillButton.setPreferredSize(new Dimension(300, 30));

        JPanel fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.LIGHT_GRAY);
        fieldPanel.setPreferredSize(new Dimension(500,570));
        fieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 20));
//        fieldPanel.add(panelAkun);
//        fieldPanel.add(panel1);
        fieldPanel.add(panel3);
        fieldPanel.add(panel33);
        fieldPanel.add(panel1);
//        fieldPanel.add(saveButton);
        fieldPanel.add(panel2);
        fieldPanel.add(addBelanjaButton);
        fieldPanel.add(saveBillButton);
        fieldPanel.add(deleteBillButton);



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
//        JPanel subsubPanel=new JPanel();
//        subsubPanel.setPreferredSize(new Dimension(100,60));
//        subsubPanel.setOpaque(false);
//        subsubPanel.setLayout(new BorderLayout(0,10));
//        subsubPanel.add(textPilihCustomer,BorderLayout.NORTH);
//        subsubPanel.add(opsiAkun,BorderLayout.SOUTH);
////        JPanel subSubPanel=new JPanel();
//        JPanel subPanel=new JPanel();
////        subPanel.setPreferredSize(new Dimension(150,300));
//        subPanel.setOpaque(false);
//        subsubPanel.setLayout(new BorderLayout());
//        subPanel.add(subsubPanel,BorderLayout.CENTER);
//
//
//        setPreferredSize(new Dimension(800,800));
//        setLayout(new BorderLayout());
//        add(topPanel,BorderLayout.NORTH);
//        add(subPanel,BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(addBelanjaButton)){
            System.out.println("added");
            String namaBarang=(String) opsiBarang.getSelectedItem();
            Integer jumlahBarang=Integer.parseInt(kuantitas.getText());
            ElmtOfBill newBill=new ElmtOfBill(namaBarang,jumlahBarang);
            BarangList barangList= DataStoreHub.readBarang();
            Barang target=new Barang(-1,-1,"target",-1,-1,"target","target");
            for (Barang b :
                    barangList.getBarangList()) {
                if (b.getNamaBarang().equals(namaBarang)){
                    target=b;
                }
            }
            model.addElement("nama Barang: "+namaBarang+"jumlah: "+jumlahBarang+"\n harga: "+jumlahBarang*target.getHargaJual());
            bill.tambahBarang(namaBarang,jumlahBarang,jumlahBarang*target.getHargaJual());
        } else if (actionEvent.getSource().equals(saveBillButton)){
            System.out.println("saved");
            FixedBill newFixedBill=new FixedBill(bill);
            BarangList barangList=DataStoreHub.readBarang();
            for (ElmtOfBill e :
                    newFixedBill.getlistBelanja()) {
                for (Barang b :
                        barangList.getBarangList()) {
                    if (e.getNama().equals(b.getNamaBarang())){
                        b.addStok(-e.getJumlah());
                        DataStoreHub.updateBarang(b);
                    }
                }
            }
            CustomerList customerList=DataStoreHub.readCustomer();
            String selectedAccount=(String) opsiAkun.getSelectedItem();
            List<FixedBill> fixedBillList=new ArrayList<>();
            fixedBillList.add(newFixedBill);
            if (selectedAccount.equals("Guest")){
                Customer c= new UnregisteredCustomer(fixedBillList);
                DataStoreHub.addCustomer(c);
            } else {
                Customer target;
                for (Customer customer:
                     customerList.getCustomerList()) {
                    if (customer instanceof RegisteredCustomer){
                        RegisteredCustomer temp=(RegisteredCustomer) customer;
                        if (selectedAccount.equals(temp.getNama())){
                            target=temp;
                            target.addHistoriTransaksi(newFixedBill);
                            DataStoreHub.updateCustomer(target);
                            break;
                        }
                    }
                }
            }
        } else if (actionEvent.getSource().equals(deleteBillButton)){
            model.removeAllElements();
            bill.clearBill();
        }
    }

    public void refreshList(){
        model.removeAllElements();
        for (ElmtOfBill e :
                bill.getListBelanja()) {
            model.addElement("nama barang: "+e.getNama()+"jumlah: "+e.getJumlah());
        }
    }

    @Override
    public void run() {

    }
}
