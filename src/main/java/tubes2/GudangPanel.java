package tubes2;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GudangPanel extends JPanel implements ActionListener {
    private String selectedOption;
    
    public static DefaultListModel model = new DefaultListModel();
    public static JList list = new JList(model);

    public GudangPanel() {
    	
    	// Inisialisasi/retrieve data from datastore
    	BarangList listofBarang = DataStoreHub.readBarang();
    	for (int i = 1; i < listofBarang.getBarangList().size(); i++)
    	      model.addElement("ID: " + listofBarang.getBarang(i).getIDBarang()
    	    		  + ". Nama barang:" + listofBarang.getBarang(i).getNamaBarang() +
    	    		  ", Stok: " + listofBarang.getBarang(i).getStok() +
    	    		  ", Harga jual: " + listofBarang.getBarang(i).getHargaJual());

        // Judul
        JLabel title = new JLabel("Gudang");
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
        
        JButton payButton = new JButton("Tambah product");
        payButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AddProductWindow add = new AddProductWindow();
        		add.main();
        	}
        });
        payButton.setFont(new Font(payButton.getFont().getName(), payButton.getFont().getStyle(), 15));
        
        JButton btnUbahProduct = new JButton("Ubah product");
        btnUbahProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnUbahProduct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		UpdateProductWindow update = new UpdateProductWindow();
        		update.main();
        	}
        });
                
        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        JLabel textDaftarProduk = new JLabel("Daftar Produk");
        textDaftarProduk.setForeground(new Color(255, 255, 255));
        textDaftarProduk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        
        JScrollPane scrollPane = new JScrollPane(list);
        list.setBackground(Color.LIGHT_GRAY);
        
        
        
        
        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(41)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnUbahProduct, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
        			.addGap(23))
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(53)
        			.addComponent(textDaftarProduk, GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(40)
        			.addComponent(textDaftarProduk, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnUbahProduct, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        					.addGap(134)))
        			.addContainerGap(156, Short.MAX_VALUE))
        );
        centerPanel.setLayout(gl_centerPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(selectedOption);
    
    }
    
    public static void addProduct(String namabarang, int stok, int hargajual) {
    	BarangList listofBarang = DataStoreHub.readBarang();
    	int sizelist = listofBarang.getBarangList().size();
    	int index;
    	if (sizelist == 0) {
    		index = 1;
    	} else {
    		index = sizelist;
    	}
    	String addition = "ID: " + index + ". Nama barang:" + namabarang + ", Stok: " + stok + ", Harga jual: " + hargajual;
    	model.addElement(addition);
    }
    public static void updateProduct(int index, String namabarang, int stok, int hargajual) {
    	String update = "ID: " + index + ". Nama barang:" + namabarang + ", Stok: " + stok + ", Harga jual: " + hargajual;
    	model.setElementAt(update, index - 1);
    }
}