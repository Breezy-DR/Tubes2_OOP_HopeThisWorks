package tubes2;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.FlowLayout;
import javax.swing.JScrollPane;

public class AddKasir {
	private JFrame frame;
	private String gambartext;
	public static DefaultListModel model1 = new DefaultListModel();
    public static JList list = new JList(model1);

	private int index;
	private JLabel lblUbahDiNomor;


	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddKasir window = new AddKasir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public AddKasir() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Tambah Barang Kasir");
		frame.setBounds(100, 100, 470, 458);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblUbahDiNomor = new JLabel("Tambah barang...");
		lblUbahDiNomor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUbahDiNomor.setBounds(128, 36, 203, 37);
		frame.getContentPane().add(lblUbahDiNomor);
		
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(42, 98, 370, 245);
		frame.getContentPane().add(scrollPane);
		list.setBackground(Color.LIGHT_GRAY);
		
		JButton submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.setBounds(280, 354, 132, 46);
		frame.getContentPane().add(submit);
		
		JLabel lblStok = new JLabel("Stok:");
		lblStok.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStok.setBounds(40, 361, 62, 37);
		frame.getContentPane().add(lblStok);
		
		JTextArea ubahtext = new JTextArea();
		ubahtext.setBounds(81, 354, 118, 46);
		frame.getContentPane().add(ubahtext);
		
		BarangList listofBarang = DataStoreHub.readBarang();
        for (Barang b :
                listofBarang.getBarangList()) {
            model1.addElement("ID: " + b.getIDBarang()+". Nama barang: " +b.getNamaBarang());
        }
        


	}
	
	public void actionPerformed(ActionEvent e) {
		


	}
}
