package Homework;

import java.io.*;
import java.awt.Desktop;

public class CatalogUtil {

    public static void save (Catalog catalog)  throws IOException {
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))){
            oos.writeObject(catalog);
        }
    }
    public static Catalog load (String path) throws InvalidCatalogException, IOException, ClassNotFoundException {
        Catalog catalog = null;
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            catalog = (Catalog) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void view (Item item ) {
        try {
            File file = new File(item.getLocation());
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                desktop.open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}