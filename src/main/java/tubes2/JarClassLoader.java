package tubes2;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class JarClassLoader extends ClassLoader {
    // Mengembalikan class pertama dari file jar
    public static Class<?> loadJar(String path) {
        try {
            return loadJarFile(path).get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Mengambalikan semua nama class dari file jar
    private static ArrayList<String> getClassNamesFromJar(String path) throws Exception {
        JarInputStream jarFile = new JarInputStream(new FileInputStream(path));
        ArrayList<String> classNames = new ArrayList<>();
        try {
            JarEntry jar;
            while (true) {
                jar = jarFile.getNextJarEntry();
                if (jar == null) {
                    break;
                }
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


    // Mengembalikan List yang berisi class-class pada file jar
    private static ArrayList<Class> loadJarFile(String filePath) throws Exception {
        ArrayList<Class> availableClasses = new ArrayList<>();
        ArrayList<String> classNames = getClassNamesFromJar(filePath);
        File f = new File(filePath);


        URLClassLoader classLoader = new URLClassLoader(new URL[]{f.toURI().toURL()});
        for (String className : classNames) {
            try {
                Class cc = classLoader.loadClass("plugin."+className);
                availableClasses.add(cc);
            } catch (ClassNotFoundException e) {
            }
        }
        return availableClasses;
    }
}