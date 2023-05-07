package tubes2;

import java.awt.*;
import javax.swing.*;

public class HistoriTransaksiList {
    private final CustomerList listCustomer = DataStoreHub.readCustomer();
    JScrollPane listScrollPane;

    /**
	 * Initialize the contents of the frame.
	 */
	public HistoriTransaksiList(int customerID) {
        // Create the list of total transaksi and put it in a scroll pane
        // Count number of fixed bill of one customer
        int sizeOfHistoriTransaksi = listCustomer.getCustomerByID(customerID).getHistoriTransaksi().size();
        int numOfFixedBill = 0;
        for(int i = 0; i < sizeOfHistoriTransaksi; i++) {
            numOfFixedBill = numOfFixedBill + listCustomer.getCustomerByID(customerID).getHistoriTransaksi().get(i).getlistBelanja().size();
        }

        // Find number of element of HistoriTransaksiList
        int numOfTransaksiListElmt = sizeOfHistoriTransaksi + numOfFixedBill + sizeOfHistoriTransaksi - 1;

        // Create and Initialize HistoriTransaksiList
        Object[] historiTransaksi = new Object[numOfTransaksiListElmt];
        int currTransaksi = 0;
        int currElmt = 0;
        while(currTransaksi < sizeOfHistoriTransaksi) {
            historiTransaksi[currElmt] = "Transaksi " + (currTransaksi + 1);
            currElmt = currElmt + 1;
            for(int i = 0; i < listCustomer.getCustomerByID(customerID).getHistoriTransaksi().get(currTransaksi).getlistBelanja().size(); i ++) {
                historiTransaksi[currElmt] = listCustomer.getCustomerByID(customerID).getHistoriTransaksi().get(currTransaksi).getlistBelanja().get(i).getHargaTotal();
                currElmt = currElmt + 1;
            }
            if (currTransaksi < sizeOfHistoriTransaksi - 1) {
                historiTransaksi[currElmt] = "";
                currElmt = currElmt + 1;
            }
            currTransaksi = currTransaksi + 1;
        }
        JList<Object> list = new JList<Object>(historiTransaksi);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        listScrollPane = new JScrollPane(list);

        // Provide a preferred size for the scroll pane
        listScrollPane.setPreferredSize(new Dimension(350,400));
    }

     /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI(int customerID) {

        //Create and set up the window.
        JFrame frame = new JFrame("Histori Transaksi");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        HistoriTransaksiList historiTransaksiList = new HistoriTransaksiList(customerID);
        frame.getContentPane().add(historiTransaksiList.listScrollPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(int customerID) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(customerID);
            }
        });
    }
}
