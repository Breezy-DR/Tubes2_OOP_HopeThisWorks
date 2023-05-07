package tubes2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class KasirPanel extends JPanel implements ActionListener {
    private String selectedOption;
    private JList list;

    private DefaultListModel model;

	public KasirPanel() {
		// Bagian Atas
        // Judul
    	// Bagian Atas
        // Judul
        JLabel title = new JLabel("Kasir");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 150, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);

        // Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setBackground(Color.GRAY);
        
                
        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        JButton customerButton = new JButton("Tambah customer");
        customerButton.setFont(new Font(customerButton.getFont().getName(), customerButton.getFont().getStyle(), 15));
        customerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddCustomerWindow add = new AddCustomerWindow();
        		add.main();
        	}
        });
        
        JLabel textDaftarProduk = new JLabel("Daftar Pembelian");
        textDaftarProduk.setForeground(new Color(255, 255, 255));
        textDaftarProduk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        JButton btnSaveBill_1 = new JButton("Save Bill");
        btnSaveBill_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JButton btnTambahBarang = new JButton("Tambah barang");
        btnTambahBarang.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        model = new DefaultListModel();
        list = new JList(model);
        
        JScrollPane scrollPane = new JScrollPane(list);
        list.setBackground(Color.LIGHT_GRAY);
        
        
        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(53)
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addComponent(textDaftarProduk, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        					.addGap(338))
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(customerButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
        				.addGroup(Alignment.TRAILING, gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(btnSaveBill_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnTambahBarang, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(54)
        			.addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnTambahBarang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(252)
        			.addComponent(btnSaveBill_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        			.addGap(155))
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(40)
        			.addComponent(textDaftarProduk, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
        			.addGap(126))
        );
        centerPanel.setLayout(gl_centerPanel);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(selectedOption);
    
    }
}
