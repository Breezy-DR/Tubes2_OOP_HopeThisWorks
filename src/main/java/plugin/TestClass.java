package plugin;

import tubes2.BasePlugin;
import javax.swing.*;
import java.util.Random;
import java.util.Vector;

public class TestClass extends BasePlugin {
    /*
     * This is an example of a class reference that will be resolved
     * at load time.
     */
    Vector v = new Vector();
    /** This is our start function */
    @Override
    public JPanel createPluginPanel() {
        /* This reference will be resolved at run time. */
        Random r;
        System.out.println("Running the Test class, option was");
        System.out.println("Now initializing a Random object.");
        r = new Random();
        for (int i = 0; i < 5; i++) {
            v.addElement(r.nextInt());
        }
        /* This reference should get the cached copy of random. */
        r = new Random();
        System.out.println("A series of 5 random numbers: ");
        for (int i = 0; i < v.size(); i++) {
            Integer z = (Integer)v.elementAt(i);
            System.out.println(i+": "+z);
        }
        return new JPanel();
    }
} 