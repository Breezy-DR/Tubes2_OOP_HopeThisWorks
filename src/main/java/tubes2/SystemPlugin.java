package tubes2;

import javax.swing.*;

public abstract class SystemPlugin {
    private static int pluginSystemCount = 0;
    public SystemPlugin() {
        this.pluginSystemCount++;
    }

    public static int getPluginSystemCount() {
        return pluginSystemCount;
    }

    public abstract JPanel createPluginPanel();
}
