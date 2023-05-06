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
import javax.swing.JComboBox;

public class AddCustomerWindow implements ActionListener {

	private JFrame frame;
	private String[] listOfCustomers;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerWindow window = new AddCustomerWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AddCustomerWindow() {
		initialize();
	}
	
	public void setListOfCustomers(String[] listOfCustomers) {
		
	}


	/**
	 * Create the frame.
	 */
	public void initialize() {
		frame = new JFrame("Tambah Customer");
		frame.setBounds(100, 100, 554, 330);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNamaCustomer = new JLabel("Nama Customer");
		lblNamaCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNamaCustomer.setBounds(23, 43, 203, 37);
		frame.getContentPane().add(lblNamaCustomer);
		
		JLabel lblkosongkanJikaCustomer = new JLabel("(Kosongkan jika customer bukan member atau VIP)");
		lblkosongkanJikaCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblkosongkanJikaCustomer.setBounds(23, 75, 415, 37);
		frame.getContentPane().add(lblkosongkanJikaCustomer);
		
		JComboBox comboBox = new JComboBox(listOfCustomers);
		comboBox.setEditable(true);
		comboBox.setBounds(23, 118, 415, 22);
		comboBox.addActionListener(this);
		frame.getContentPane().add(comboBox);
	}
	
	public void actionPerformed(ActionEvent e) {
        
    }


}
