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

public class RemoveProductWindow implements ActionListener {
	private JFrame frame;
	private JButton submit;
	private String gambartext;

	private int index;
	private JLabel lblUbahDiNomor;
	private JTextArea ubahtext;


	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveProductWindow window = new RemoveProductWindow();
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
	
	public RemoveProductWindow() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Update Produk");
		frame.setBounds(100, 100, 471, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		submit = new JButton("Submit");
		submit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		submit.addActionListener(this);
		submit.setBounds(248, 143, 183, 61);
		frame.getContentPane().add(submit);
		
		lblUbahDiNomor = new JLabel("Delete di ID...");
		lblUbahDiNomor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUbahDiNomor.setBounds(25, 38, 203, 37);
		frame.getContentPane().add(lblUbahDiNomor);
		
		ubahtext = new JTextArea();
		ubahtext.setBounds(25, 76, 271, 37);
		frame.getContentPane().add(ubahtext);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			index = Integer.parseInt(ubahtext.getText());
        	DataStoreHub.deleteBarang(index);
        	GudangPanel.refreshList();
       }


	}

}
