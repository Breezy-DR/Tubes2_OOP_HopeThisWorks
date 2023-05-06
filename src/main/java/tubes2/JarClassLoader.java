package tubes2;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class JarClassLoader extends ClassLoader {
    public Class<?> loadJar(String path) {
        try {
            return loadJarFile(path).get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<String> getClassNamesFromJar(String path) throws Exception {
        JarInputStream jarFile = new JarInputStream(new FileInputStream(path));
        ArrayList<String> classNames = new ArrayList<>();
        try {
            JarEntry jar;

            //Iterate through the contents of the jar file
            while (true) {
                jar = jarFile.getNextJarEntry();
                if (jar == null) {
                    break;
                }
                //Pick file that has the extension of .class
                if ((jar.getName().endsWith(".class"))) {
                    String className = jar.getName().replaceAll("/", "\\.");
                    String myClass = className.substring(0, className.lastIndexOf('.'));
                    classNames.add(myClass);
                }
            }
        } catch (Exception e) {
            throw new Exception("Error while getting class names from jar", e);
        }
        return classNames;
    }


    // get an arraylist of all the loaded classes in a jar file
    private ArrayList<Class> loadJarFile(String filePath) throws Exception {
        ArrayList<Class> availableClasses = new ArrayList<>();
        ArrayList<String> classNames = getClassNamesFromJar(filePath);
        File f = new File(filePath);


        URLClassLoader classLoader = new URLClassLoader(new URL[]{f.toURI().toURL()});
        for (String className : classNames) {
            try {
                Class cc = loadClass("plugin."+className);
                availableClasses.add(cc);
            } catch (ClassNotFoundException e) {
            }
        }
        return availableClasses;
    }
}