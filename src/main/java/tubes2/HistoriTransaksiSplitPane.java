package tubes2;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

import java.awt.*;

import java.util.List;


public class HistoriTransaksiSplitPane extends JPanel implements ListSelectionListener {
    private JTable table;
    private JList<Integer> list;
    private JSplitPane splitPane;
    private Integer[] priceList;
    private int customerID;
    private final CustomerList listCustomer = DataStoreHub.readCustomer();

    
    /**
	 * Initialize the contents of the frame.
	 */
	public HistoriTransaksiSplitPane(int CustomerID) {
        // Create the list of price and put it in a scroll pane
        int sizeOfHistoriTransaksi = listCustomer.getCustomerByID(CustomerID).getHistoriTransaksi().size();
        this.customerID = CustomerID;
        priceList = new Integer[sizeOfHistoriTransaksi];
        for(int i = 0; i < sizeOfHistoriTransaksi; i++) {
            priceList[i] = listCustomer.getCustomerByID(CustomerID).getHistoriTransaksi().get(i).getTotalTransaksi();
        }
        list = new JList<Integer>(priceList);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane listScrollPane = new JScrollPane(list);

        // Create the table and put it in a scroll pane
        table = new JTable(new MyTableModel(listCustomer.getCustomerByID(CustomerID).getHistoriTransaksi().get(0).getlistBelanja()));
        // table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        // table.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(table);

        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listScrollPane, tableScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        listScrollPane.setMinimumSize(minimumSize);
        tableScrollPane.setMinimumSize(minimumSize);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(400, 200));
        updateTable(priceList[list.getSelectedIndex()]);

    }

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"Barang",
                                        "Jumlah Barang",
                                        "Harga"};
        private int sizeOfListBelanja;
        private Object[][] data;

        public MyTableModel(List<ElmtOfBill> listBelanja) {
            sizeOfListBelanja = listBelanja.size();
            data = new Object[sizeOfListBelanja][3]; 
            for(int i = 0; i < sizeOfListBelanja; i++) {
                data[i][0] = listBelanja.get(i).getNama();
                data[i][1] = listBelanja.get(i).getJumlah();
                data[i][2] = listBelanja.get(i).getHargaTotal();
            }
        }
    
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }

    //Listens to the list
    public void valueChanged(ListSelectionEvent e) {
        JList<Integer> list = (JList<Integer>)e.getSource();
        updateTable(list.getSelectedIndex());
    }
    
    //Set new table
    protected void updateTable (int index) {
        table = new JTable(new MyTableModel(listCustomer.getCustomerByID(customerID).getHistoriTransaksi().get(index).getlistBelanja()));
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

    /**
	 * Create the application.
	 */
	private static void createAndShowGUI(int CustomerID) {
        // Create and set up the window 
        JFrame frame = new JFrame("Histori Transaksi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        HistoriTransaksiSplitPane historiTransaksiWindowOld = new HistoriTransaksiSplitPane(CustomerID);
		frame.getContentPane().add(historiTransaksiWindowOld.getSplitPane());
	}

    /**
	 * Launch the application.
	 */
	public static void main(int CustomerID) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI(CustomerID);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
