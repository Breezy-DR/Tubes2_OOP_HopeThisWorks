package plugin;

import tubes2.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PluginSistem2 extends SystemPlugin implements ActionListener {
    private JCheckBox optionDiscount;
    private JCheckBox optionTax;
    private JCheckBox optionServiceCharge;

    @Override
    public JPanel createPluginPanel() {
        // Bagian Mata Uang
        // Label
        JLabel formatLabel = new JLabel("Extra Fee");
        formatLabel.setForeground(Color.WHITE);
        formatLabel.setFont(new Font(formatLabel.getFont().getName(), formatLabel.getFont().getStyle(), 15));
        formatLabel.setPreferredSize(new Dimension(500,20));
        // Tombol
        optionDiscount = new JCheckBox("Discount");
        optionTax = new JCheckBox("Tax");
        optionServiceCharge = new JCheckBox("Service Charge");
        optionDiscount.setOpaque(false);
        optionTax.setOpaque(false);
        optionServiceCharge.setOpaque(false);
        optionDiscount.setFocusable(false);
        optionTax.setFocusable(false);
        optionServiceCharge.setFocusable(false);
        optionDiscount.addActionListener(this);
        optionTax.addActionListener(this);
        optionServiceCharge.addActionListener(this);
        optionDiscount.setSelected(true);
        // Sub-panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(100,30));
        subPanel1.setBackground(Color.lightGray);
        subPanel1.setLayout(new FlowLayout());
        subPanel1.add(optionDiscount);
        subPanel1.add(optionTax);
        subPanel1.add(optionServiceCharge);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(500,50));
        panel1.setBounds(100, 190, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(formatLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);

        return panel1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == optionDiscount) {
            System.out.println("Diskon");
        }
        else if (e.getSource() == optionTax) {
            System.out.println("Pajak");
        }
        else if (e.getSource() == optionServiceCharge) {
            System.out.println("Service charge");
        }
    }
}
