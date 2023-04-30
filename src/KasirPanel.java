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
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(500,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 50, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(subPanel1, BorderLayout.SOUTH);
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
        
        JButton payButton = new JButton("Tambah produk");
        payButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        payButton.setFont(new Font(payButton.getFont().getName(), payButton.getFont().getStyle(), 15));
        
                
        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        JButton customerButton = new JButton("Tambah customer");
        customerButton.setFont(new Font(customerButton.getFont().getName(), customerButton.getFont().getStyle(), 15));
        
        JLabel textDaftarProduk = new JLabel("Daftar Produk");
        textDaftarProduk.setForeground(new Color(255, 255, 255));
        textDaftarProduk.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        
        GroupLayout gl_centerPanel = new GroupLayout(centerPanel);
        gl_centerPanel.setHorizontalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addContainerGap(53, Short.MAX_VALUE)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
        				.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
        			.addGap(26))
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(53)
        			.addComponent(textDaftarProduk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_centerPanel.setVerticalGroup(
        	gl_centerPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_centerPanel.createSequentialGroup()
        			.addGap(40)
        			.addComponent(textDaftarProduk, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addGroup(gl_centerPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addGap(15)
        					.addComponent(payButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
        					.addGap(74)
        					.addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_centerPanel.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(600, Short.MAX_VALUE))
        );
        centerPanel.setLayout(gl_centerPanel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(selectedOption);
    
    }
}