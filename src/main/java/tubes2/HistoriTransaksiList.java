package tubes2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class HistoriTransaksiList {
    private final CustomerList listCustomer = DataStoreHub.readCustomer();
    JScrollPane listScrollPane;

    /**
	 * Initialize the contents of the frame.
	 */
	public HistoriTransaksiList(int customerID) {
        // Create the list of total transaksi and put it in a scroll pane
        Integer[] totalTransaksi = new Integer[listCustomer.getCustomerByID(customerID).getHistoriTransaksi().size()];
        for(int i = 0; i < listCustomer.getCustomerByID(customerID).getHistoriTransaksi().size(); i++) {
            totalTransaksi[i] = listCustomer.getCustomerByID(customerID).getHistoriTransaksi().get(i).getTotalTransaksi();
        }
        JList<Integer> list = new JList<Integer>(totalTransaksi);
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
