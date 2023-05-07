package tubes2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TambahPluginDialog {
    public static String openJarFile() {
        JFileChooser path = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jar", "jar", "JAR");
        path.setFileFilter(filter);
        path.setFileSelectionMode( JFileChooser.FILES_ONLY);
        path.showOpenDialog(null);
        return path.getSelectedFile().getAbsolutePath();
    }
}