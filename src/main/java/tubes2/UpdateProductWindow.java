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
import java.awt.FlowLayout;


public class UpdateProductWindow implements ActionListener {

	private JFrame frame;
	private JButton pathButton;
	private JButton submit;
	private JTextArea pathText;
	private JTextArea stoktext;
	private JTextArea namatext;
	private JTextArea hargabelitext;
	private JTextArea hargajualtext;
	private JTextArea kategoritext;
	private String gambartext;

	private int index;
	private int stok;
	private String NamaBarang;
	private int hargabeli;
	private int hargajual;
	private String kategori;
	private String gambar;
	private JLabel lblUbahDiNomor;
	private JTextArea ubahtext;


	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProductWindow window = new UpdateProductWindow();
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
	
	public UpdateProductWindow() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Update Produk");
		frame.setBounds(100, 100, 661, 536);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		stoktext = new JTextArea();
		stoktext.setBounds(26, 67, 271, 37);
		frame.getContentPane().add(stoktext);
		
		JLabel lblNewLabel = new JLabel("Stok");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 29, 203, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNamaBarang = new JLabel("Nama Barang");
		lblNamaBarang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNamaBarang.setBounds(26, 144, 203, 37);
		frame.getContentPane().add(lblNamaBarang);
		
		namatext = new JTextArea();
		namatext.setBounds(26, 182, 271, 37);
		frame.getContentPane().add(namatext);
		
		JLabel lblHargaBeli = new JLabel("Harga Beli");
		lblHargaBeli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHargaBeli.setBounds(26, 262, 203, 37);
		frame.getContentPane().add(lblHargaBeli);
		
		hargabelitext = new JTextArea();
		hargabelitext.setBounds(26, 300, 271, 37);
		frame.getContentPane().add(hargabelitext);
		
		JLabel lblHargaJual = new JLabel("Harga Jual");
		lblHargaJual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHargaJual.setBounds(331, 29, 203, 37);
		frame.getContentPane().add(lblHargaJual);
		
		hargajualtext = new JTextArea();
		hargajualtext.setBounds(331, 67, 271, 37);
		frame.getContentPane().add(hargajualtext);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKategori.setBounds(331, 144, 203, 37);
		frame.getContentPane().add(lblKategori);
		
		kategoritext = new JTextArea();
		kategoritext.setBounds(331, 182, 271, 37);
		frame.getContentPane().add(kategoritext);
		
		JLabel lblGambar = new JLabel("Gambar");
		lblGambar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGambar.setBounds(331, 262, 203, 37);
		frame.getContentPane().add(lblGambar);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.addActionListener(this);
		submit.setBounds(419, 386, 183, 61);
		frame.getContentPane().add(submit);
		
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
		
		lblUbahDiNomor = new JLabel("Ubah di ID...");
		lblUbahDiNomor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUbahDiNomor.setBounds(26, 372, 203, 37);
		frame.getContentPane().add(lblUbahDiNomor);
		
		ubahtext = new JTextArea();
		ubahtext.setBounds(26, 410, 271, 37);
		frame.getContentPane().add(ubahtext);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pathButton) {
            JFileChooser path = new JFileChooser();
            path.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
            path.showOpenDialog(null);
            File folderPath = new File(path.getSelectedFile().getAbsolutePath());
            pathText.setText(folderPath.toString());
            gambartext = folderPath.toString();
            System.out.println(folderPath);
        }
		if (e.getSource() == submit) {
			index = Integer.parseInt(ubahtext.getText());
        	stok = Integer.parseInt(stoktext.getText());
        	NamaBarang = namatext.getText();
        	hargabeli = Integer.parseInt(hargabelitext.getText());
        	hargajual = Integer.parseInt(hargajualtext.getText());
        	kategori = kategoritext.getText();
        	gambar = gambartext;
        	GudangPanel.updateProduct(index, NamaBarang, stok, hargajual);
        	DataStoreHub.updateBarang(
					new Barang(index,
							stok,NamaBarang,hargabeli,hargajual,kategori,gambar));
       }


	}

}
