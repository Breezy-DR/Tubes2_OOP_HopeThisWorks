package tubes2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;

public class AddProductWindow implements ActionListener {

	private JFrame frame;
	private JButton pathButton;
	private JTextArea pathText;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductWindow window = new AddProductWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddProductWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Tambah Produk");
		frame.setBounds(100, 100, 661, 536);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 67, 271, 37);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel = new JLabel("Stok");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 29, 203, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNamaBarang = new JLabel("Nama Barang");
		lblNamaBarang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNamaBarang.setBounds(26, 144, 203, 37);
		frame.getContentPane().add(lblNamaBarang);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(26, 182, 271, 37);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblHargaBeli = new JLabel("Harga Beli");
		lblHargaBeli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHargaBeli.setBounds(26, 262, 203, 37);
		frame.getContentPane().add(lblHargaBeli);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(26, 300, 271, 37);
		frame.getContentPane().add(textArea_1_1);
		
		JLabel lblHargaJual = new JLabel("Harga Jual");
		lblHargaJual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHargaJual.setBounds(331, 29, 203, 37);
		frame.getContentPane().add(lblHargaJual);
		
		JTextArea textArea_1_2 = new JTextArea();
		textArea_1_2.setBounds(331, 67, 271, 37);
		frame.getContentPane().add(textArea_1_2);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKategori.setBounds(331, 144, 203, 37);
		frame.getContentPane().add(lblKategori);
		
		JTextArea textArea_1_2_1 = new JTextArea();
		textArea_1_2_1.setBounds(331, 182, 271, 37);
		frame.getContentPane().add(textArea_1_2_1);
		
		JLabel lblGambar = new JLabel("Gambar");
		lblGambar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGambar.setBounds(331, 262, 203, 37);
		frame.getContentPane().add(lblGambar);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(230, 387, 183, 61);
		frame.getContentPane().add(btnNewButton);
		
		pathButton = new JButton("Pilih Gambar");
		pathButton.setFocusable(false);
		pathButton.setBounds(331, 300, 77, 30);
		frame.getContentPane().add(pathButton);
		pathButton.addActionListener(this);
        pathButton.setFocusable(false);
		
		pathText = new JTextArea("                           ");
		pathText.setEditable(false);
		pathText.setBorder(BorderFactory.createLoweredBevelBorder());
		pathText.setBounds(404, 300, 198, 30);
		frame.getContentPane().add(pathText);
	}
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pathButton) {
            JFileChooser path = new JFileChooser();
            path.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
            path.showOpenDialog(null);
            File folderPath = new File(path.getSelectedFile().getAbsolutePath());
            pathText.setText(folderPath.toString());
            System.out.println(folderPath);
        }
	}

}
