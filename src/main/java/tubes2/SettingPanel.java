package tubes2;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SettingPanel extends JPanel implements ActionListener {
    private final JButton pathButton;
    private final JButton pluginButton;
    private final JRadioButton optionJSON;
    private final JRadioButton optionXML;
    private final JRadioButton optionOBJ;
    private final JTextArea pathText;
    private JPanel panel3;
    private JPanel centerPanel;

    public SettingPanel() {
        // Bagian Atas
        // Judul
        JLabel title = new JLabel("Setting");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(title.getFont().getName(), title.getFont().getStyle(), 35));
        title.setBounds(30, 0, 150, 100);
        // Panel Top
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(100,100));
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setLayout(null);
        topPanel.add(title);


        // Bagian path folder penyimpanan
        // Label
        JLabel pathLabel = new JLabel("Path folder penyimpanan file");
        pathLabel.setForeground(Color.WHITE);
        pathLabel.setFont(new Font(pathLabel.getFont().getName(), pathLabel.getFont().getStyle(), 15));
        pathLabel.setPreferredSize(new Dimension(500,20));
        // Tombol
        pathButton = new JButton("Pilih Path");
        pathButton.addActionListener(this);
        pathButton.setFocusable(false);
        // Text
        pathText = new JTextArea("                           ");
        pathText.setBorder(BorderFactory.createLoweredBevelBorder());
        pathText.setEditable(false);
        // Sub-Panel 1
        JPanel subPanel1 = new JPanel();
        subPanel1.setPreferredSize(new Dimension(500,30));
        subPanel1.setBackground(Color.gray);
        subPanel1.setLayout(new BorderLayout());
        subPanel1.add(pathButton, BorderLayout.WEST);
        subPanel1.add(pathText, BorderLayout.CENTER);
        // Panel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(100, 50, 500, 65);
        panel1.setBackground(Color.gray);
        panel1.setLayout(new BorderLayout(0,10));
        panel1.add(pathLabel, BorderLayout.NORTH);
        panel1.add(subPanel1, BorderLayout.SOUTH);


        // Bagian opsi format penyimpanan file
        // Label
        JLabel formatLabel = new JLabel("Format file");
        formatLabel.setForeground(Color.WHITE);
        formatLabel.setFont(new Font(formatLabel.getFont().getName(), formatLabel.getFont().getStyle(), 15));
        formatLabel.setPreferredSize(new Dimension(500,20));
        // Tombol
        optionJSON = new JRadioButton("JSON");
        optionXML = new JRadioButton("XML");
        optionOBJ = new JRadioButton("OBJ");
        optionJSON.setOpaque(false);
        optionXML.setOpaque(false);
        optionOBJ.setOpaque(false);
        optionJSON.setFocusable(false);
        optionXML.setFocusable(false);
        optionOBJ.setFocusable(false);
        optionJSON.addActionListener(this);
        optionXML.addActionListener(this);
        optionOBJ.addActionListener(this);
        optionJSON.setSelected(true);
        ButtonGroup optionGroup = new ButtonGroup();
        optionGroup.add(optionJSON);
        optionGroup.add(optionXML);
        optionGroup.add(optionOBJ);
        // Sub-panel 2
        JPanel subPanel2 = new JPanel();
        subPanel2.setPreferredSize(new Dimension(100,30));
        subPanel2.setBackground(Color.lightGray);
        subPanel2.setLayout(new FlowLayout());
        subPanel2.add(optionJSON);
        subPanel2.add(optionXML);
        subPanel2.add(optionOBJ);
        // Panel 2
        JPanel panel2 = new JPanel();
        panel2.setBounds(100, 190, 500, 65);
        panel2.setBackground(Color.gray);
        panel2.setLayout(new BorderLayout(0,10));
        panel2.add(formatLabel, BorderLayout.NORTH);
        panel2.add(subPanel2, BorderLayout.SOUTH);


        // Bagian plugin
        // Label
        JLabel pluginLabel = new JLabel("Plugin");
        pluginLabel.setForeground(Color.WHITE);
        pluginLabel.setFont(new Font(pluginLabel.getFont().getName(), pluginLabel.getFont().getStyle(), 15));
        pluginLabel.setPreferredSize(new Dimension(500,20));
        // Tombol
        pluginButton = new JButton("Tambah Plugin");
        pluginButton.addActionListener(this);
        pluginButton.setFocusable(false);
        // Sub-panel 3
        JPanel subPanel3 = new JPanel();
        subPanel3.setPreferredSize(new Dimension(100,35));
        subPanel3.setBackground(Color.LIGHT_GRAY);
        subPanel3.setLayout(new FlowLayout());
        subPanel3.add(pluginButton);
        subPanel3.setOpaque(false);
        // Panel 3
        panel3 = new JPanel();
        panel3.setBounds(100,330, 500, 160);
        panel3.setBackground(Color.GRAY);
        panel3.setLayout(new BorderLayout(0,15));
        panel3.add(pluginLabel, BorderLayout.NORTH);
        panel3.add(subPanel3, BorderLayout.SOUTH);


        // Center panel
        centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(100,100));
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 75));
        centerPanel.setBackground(Color.GRAY);
        centerPanel.add(panel1);
        centerPanel.add(panel2);
        centerPanel.add(panel3);


        // Main Panel
        setPreferredSize(new Dimension(800,800));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pathButton) {
            JFileChooser path = new JFileChooser();
            path.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
            path.showOpenDialog(null);
            File folderPath = new File(path.getSelectedFile().getAbsolutePath());
            pathText.setText(folderPath.toString());
            DataStoreHub.setFilePath(pathText.getText());
        }
        else if (e.getSource() == optionJSON) {
            DataStoreHub.setDataStore(new JSONDataStore());
        }
        else if (e.getSource() == optionXML) {
            DataStoreHub.setDataStore(new XMLDataStore());
        }
        else if (e.getSource() == optionOBJ) {
            DataStoreHub.setDataStore(new OBJDataStore());
        }
        else if (e.getSource() == pluginButton) {
            // Open jar file
            String path = TambahPluginDialog.openJarFile();

            // Load jar
            Object object;
            Object pluginInstance;
            try {
                object = JarClassLoader.loadJar(path);
                Class pluginClass = Class.forName(object.toString().substring(6));
                pluginInstance = pluginClass.newInstance();
                JPanel panelTrial = ((SystemPlugin) pluginInstance).createPluginPanel();
                panel3.add(panelTrial);
                revalidate();

//                centerPanel.add(panelTrial);
//                add(centerPanel, BorderLayout.CENTER);
            } catch (Exception l) {
                System.out.println("Caught exception : "+l);
            }
        }
    }
}