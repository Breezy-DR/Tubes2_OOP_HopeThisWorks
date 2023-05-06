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
        ButtonGroup optionGroup = new ButtonGroup();
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBounds(100, 190, 500, 65);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        // Panel 3
        JPanel panel3 = new JPanel();
        panel3.setBounds(100,330, 500, 160);
        panel3.setBackground(Color.gray);
        panel3.setLayout(new BorderLayout(0,15));


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
        
        JButton btnSaveBill = new JButton("Save bill");
        btnSaveBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        JButton btnSaveBill_1 = new JButton("Save Bill");
        btnSaveBill_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        
        
        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addGroup(gl_centerPanel.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_centerPanel.createSequentialGroup()
        							.addContainerGap()
        							.addComponent(btnSaveBill, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))
        						.addGroup(gl_centerPanel.createSequentialGroup()
        							.addGap(53)
        							.addComponent(textDaftarProduk, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        							.addGap(316)))
        					.addGap(22)
        					.addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addContainerGap(538, Short.MAX_VALUE)
        					.addComponent(btnSaveBill_1, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addGap(40)
        					.addComponent(textDaftarProduk, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addGap(54)
        					.addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        			.addGap(433)
        			.addComponent(btnSaveBill_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
        			.addGap(66)
        			.addComponent(btnSaveBill, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        			.addGap(30))
        );
        centerPanel.setLayout(gl_centerPanel);
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(selectedOption);
    
    }
}
